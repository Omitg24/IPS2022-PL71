package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import inscritos.model.InscritoDTO;

/**
 * Utilidades varias con metodos generales de serializacion, conversion a csv y
 * conversion de fechas
 */
public class Util {
	/**
	 * Constante RECEIPTS_PATH
	 */
	private static final String RECEIPTS_PATH = "src/main/resources/files/receipts.csv";
	
	/**
	 * Constructor Util
	 */
	private Util() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Serializa una lista de objetos a formato json insertando saltos de linea
	 * entre cada elemento para facilitar la comparacion de resultados en las
	 * pruebas utilizando jackson-databind (opcionalmente permite obtene una
	 * representacion similar a csv).
	 * 
	 * @param pojoList Lista de objetos a serializar
	 * @param asArray  si es true codifica los diferentes campos del objeto como un
	 *                 array y elimina comillas para facilitar la comparacion, si es
	 *                 false devuelve el json completo
	 * @return el string que representa la lista serializada
	 */
	public static String serializeToJson(Class<?> pojoClass, List<?> pojoList, boolean asArray) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			if (asArray) {
				mapper.configOverride(pojoClass).setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.ARRAY));
				String value = mapper.writeValueAsString(pojoList);
				return value.replace("],", "],\n").replace("\"", ""); // con saltos de linea y sin comillas
				// otra alternativa es utilizar las clases especificas para csv que suministra
				// Jackson (jackson-dataformat-csv)
			} else {
				return mapper.writeValueAsString(pojoList).replaceAll("},", "},\n"); // con saltos de linea
			}
		} catch (JsonProcessingException e) {
			throw new ApplicationException(e);
		}
	}

	/**
	 * Convierte una lista de objetos a formato csv
	 * 
	 * @param pojoList Lista de objetos a serializar
	 * @param fields   campos de cada objeto a incluir en el csv
	 */
	public static String pojosToCsv(List<?> pojoList, String[] fields) {
		return pojosToCsv(pojoList, fields, false, ",", "", "", "");
	}

	/**
	 * Convierte una lista de objetos a formato csv con varios parametros para
	 * personalizar el aspecto
	 * 
	 * @param pojoList  Lista de objetos a serializar
	 * @param fields    campos de cada objeto a incluir en el csv
	 * @param headers   si es true incluye una primera fila con las cabeceras
	 * @param separator caracter que separa cada columna
	 * @param begin     caracter a incluir al principio de cada linea
	 * @param end       caracter a incluir al final de cada linea
	 * @param nullAs    Texto que se incluira cuando el valor es null
	 * @return el string que representa la lista serializada en csv
	 */
	public static String pojosToCsv(List<?> pojoList, String[] fields, boolean headers, String separator, String begin,
			String end, String nullAs) {
		StringBuilder sb = new StringBuilder();
		if (headers)
			addPojoLineToCsv(sb, null, fields, separator, begin, end, nullAs);
		for (int i = 0; i < pojoList.size(); i++) {
			try {
				// utiliza Apache commons BeanUtils para obtener los atributos del objeto en un
				// map
				Map<String, String> objectAsMap = BeanUtils.describe(pojoList.get(i));
				addPojoLineToCsv(sb, objectAsMap, fields, separator, begin, end, nullAs);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				throw new ApplicationException(e);
			}
		}
		return sb.toString();
	}

	/**
	 * Añade la linea del pojo a un csv
	 * 
	 * @param sb
	 * @param objectAsMap
	 * @param fields
	 * @param separator
	 * @param begin
	 * @param end
	 * @param nullAs
	 */
	private static void addPojoLineToCsv(StringBuilder sb, Map<String, String> objectAsMap, String[] fields,
			String separator, String begin, String end, String nullAs) {
		sb.append(begin);
		for (int j = 0; j < fields.length; j++) {
			String value;
			if (objectAsMap == null) // nombre del campo si no hay map
				value = fields[j];
			else // valor del campo o el especificado para null
				value = objectAsMap.get(fields[j]) == null ? nullAs : objectAsMap.get(fields[j]);
			sb.append((j == 0 ? "" : separator) + value);
		}
		sb.append(end + "\n");
	}

	/**
	 * Convierte un array bidimensional de strings a csv (usado para comparaciones
	 * del ui con AssertJ Swing)
	 */
	public static String arraysToCsv(String[][] arrays) {
		return arraysToCsv(arrays, null, ",", "", "");
	}

	/**
	 * Convierte un array bidimensional de strings a csv permitiendo parametrizacion
	 * (usado para comparaciones del ui con AssertJ Swing y JBehave)
	 */
	public static String arraysToCsv(String[][] arrays, String[] fields, String separator, String begin, String end) {
		StringBuilder sb = new StringBuilder();
		if (fields != null)
			addArrayLineToCsv(sb, fields, separator, begin, end);
		for (int i = 0; i < arrays.length; i++)
			addArrayLineToCsv(sb, arrays[i], separator, begin, end);
		return sb.toString();
	}

	/**
	 * Añade la linea de un array a un csv
	 * 
	 * @param sb
	 * @param array
	 * @param separator
	 * @param begin
	 * @param end
	 */
	private static void addArrayLineToCsv(StringBuilder sb, String[] array, String separator, String begin,
			String end) {
		sb.append(begin);
		for (int j = 0; j < array.length; j++)
			sb.append((j == 0 ? "" : separator) + array[j]);
		sb.append(end);
		sb.append("\n");
	}

	/**
	 * Convierte fecha repesentada como un string iso a fecha java (para conversion
	 * de entradas de tipo fecha)
	 */
	public static Date isoStringToDate(String isoDateString) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(isoDateString);
		} catch (ParseException e) {
			throw new ApplicationException("Formato ISO incorrecto para fecha: " + isoDateString);
		}
	}

	/**
	 * Convierte fecha java a un string formato iso (para display o uso en sql)
	 */
	public static String dateToIsoString(Date javaDate) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(javaDate);
	}

	/**
	 * Valida que los campos no sea null o estén vacíos
	 * 
	 * @param obj
	 * @param message
	 */
	public static void validateNotNull(String obj, String message) {
		if (obj == null || obj.isBlank()) {
			throw new ApplicationException(message);
		}
	}	
	
	/**
	 * Valida que los campos no sea null
	 * 
	 * @param obj
	 * @param message
	 */
	public static void validateNotNull(Object obj, String message) {
		if (obj == null) {
			throw new ApplicationException(message);
		}
	}

	/**
	 * Valida que los campos cumplan la condición
	 * 
	 * @param obj
	 * @param message
	 */
	public static void validateCondition(boolean condition, String message) {
		if (!condition) {
			throw new ApplicationException(message);
		}
	}
	
	/**
	 * Método saveReceiptToFile
	 * @param receiptLine
	 * @param date
	 * @param dni
	 * @param iban
	 * @param amount
	 */
	public static void saveReceiptToFile(String receiptLine, String date, String dni, String iban, int amount) {
		try {
			String filePath = RECEIPTS_PATH;
			Path path = Paths.get(filePath);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedWriter file = new BufferedWriter(new FileWriter(filePath, true));			
			String line = String.format("\n%s;%s;%s;%s;%d", 
										receiptLine,
										date,
										dni,
										iban,
										amount);
			file.append(line);		
			file.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
	
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	/**
	 * Método readFinanceFIles
	 * @param fileName
	 * @param listaPreinscritos
	 */
	public static boolean readFinanceFiles(String fileName, List<InscritoDTO> listaPreinscritos){		
		String linea;
	    String[] datosInscrito= null;	   
	    String filePath = "src/main/resources/files/finance_files/"+fileName+".csv";
	    try {
	    	   BufferedReader fichero = new BufferedReader(new FileReader(filePath));
	    		while (fichero.ready()) {
	    			linea = fichero.readLine();
	    			datosInscrito = linea.split(";");
	    			listaPreinscritos.add(new InscritoDTO(datosInscrito[0], datosInscrito[1],
	    							datosInscrito[2], datosInscrito[4], null, Double.valueOf(datosInscrito[3])));
	    		}
	    		fichero.close();
	    		return true;
	    }
	    catch (FileNotFoundException fnfe) {
	    	System.out.println("El archivo no se ha encontrado.");
	      	return false;
	    }
	    catch (IOException ioe) {
	    	new RuntimeException("Error de entrada/salida.");
	    	return false;
	    }
	}
}
