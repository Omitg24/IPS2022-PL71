package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import coiipa.model.dto.ColegiadoDTO;

public class LotesUtil {

	/**
	 * Lee el fichero requests.csv para ser gestionado por secretaría
	 */
	public static List<ColegiadoDTO> getColegiadosFromRequestCsv(String filename){
		ArrayList<ColegiadoDTO> result = new ArrayList<ColegiadoDTO>();
		
		try {
			Path path = Paths.get(filename);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedReader reader = new BufferedReader(new FileReader(filename));			
			String line = reader.readLine();
			while (line != null) {
				String[] params = line.split(";");
				ColegiadoDTO col = new ColegiadoDTO(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8]);
				result.add(col);
				line = reader.readLine();
			}
			reader.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido leer");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
		
		return result;
	}
	
	/**
	 * Lee el fichero batch.csv para que no se repitan números de colegiado
	 */
	public static List<ColegiadoDTO> getColegiadosFromBatchCsv(String filename){
		ArrayList<ColegiadoDTO> result = new ArrayList<ColegiadoDTO>();
		
		try {
			Path path = Paths.get(filename);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedReader reader = new BufferedReader(new FileReader(filename));			
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				String[] params = line.split(";");
				if (params.length != 1) {
					ColegiadoDTO col = new ColegiadoDTO(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8], params[9], params[10]);
					result.add(col);
				}
				line = reader.readLine();
			}
			reader.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido leer");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
		
		return result;
	}
	
	/**
	 * Envía colegiados a un .csv para ser enviados al ministerio
	 */
	public static void sendToBatchFile(String filename, ColegiadoDTO dto, String numeroColegiado) {
		try {
			Path path = Paths.get(filename);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedWriter file = new BufferedWriter(new FileWriter(filename, true));			
			String line = String.format("\n%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s", 
										dto.getDniColegiado(),
										dto.getNombreColegiado(),
										dto.getApellidosColegiado(),
										dto.getLocalidadColegiado(),
										dto.getTelefonoColegiado(),
										dto.getTitulacionColegiado(),
										dto.getCentroColegiado(),
										dto.getAnioColegiado(),
										dto.getIbanColegiado(),
										numeroColegiado,
										"Pendiente");
			file.append(line);		
			file.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}
