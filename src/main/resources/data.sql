--Datos para carga inicial de la base de datos

--Borrar todos los datos de las tablas primero

delete from Inscribe;
delete from Colegiado;
delete from Curso;

insert into Colegiado (dniColegiado, nombreColegiado, apellidosColegiado, localidadColegiado, telefonoColegiado, titulacionColegiado, centroColegiado, anioColegiado, ibanColegiado, numeroColegiado, tipoColegiado, estadoColegiado, estadoCuota, estadoAsignacionPericial, fechaColegiacion) values
	('7348920547A' ,'Manolo', 'Sanchez Rodriguez', 'Vallecas', '472381032', 'Panadero', 'Uniovi', 1986, '3412431434789', '2020-2306', 'Colegiado', 'Pendiente', 'Emitido', 'NA', '2020-9-13'),
	('6435634566K' ,'Pablo', 'Gonzalez Martinez', 'Langreo', '584022938', 'Carnicero', 'Fundacion Minabo', 1983, '5342453352345', '2022-2598', 'Colegiado', 'Anulado', 'Pendiente', 'NA', '2021-6-16'),
	('4728129374H' ,'Juan', 'Garcia del Monte Quemao', 'La Palma', '544356789', 'Bombero', 'Grupo Entuhuerto', 1991, '7653756537456', '2020-2359', 'Colegiado', 'Activo', 'Pagado', 'Asignado', '2022-1-3'),
	('1234312432J' ,'Hernesto', 'Alvarez Alvarez', 'Rias Baixas', '549999789', 'Ganadero', 'Grupo Entuhuerto', 1989, '6185993986753', '2019-2278', 'Pre-colegiado', 'Activo', 'Emitido', 'NA', '2019-12-29'),
	('4546574389B' ,'Kazuya', 'Mishima Wins', 'Kyoto', '549566543', 'Ingeniero', 'Fundación Topota', 1995, '5467892034987', '2020-2306', 'Pre-colegiado', 'Anulado', 'Pendiente', 'Asignado', '2021-8-23'),
	('9385783921W' ,'Hermenegildo', 'Gonzalez Rose', 'Terrasa', '546743453', 'Bombero', 'Unitoby', 1990, '6185993986753', '2018-2123', 'Pre-colegiado', 'Pendiente', 'Pagado', 'NA', '2022-3-2'),
	('2124678952G' ,'Sol', 'Bad Guy', 'Shibuya', '654342645', 'Camionero', 'Gears SA', 1990, '3948579283019213', '2018-2125', 'Colegiado', 'Pendiente', 'Pagado', 'Asignado', '2021-2-8'),
	('2348597612B' ,'Bruce', 'Wayne Batman', 'Gotham', '634323654', 'Caballerro Oscuro', 'Wayne Enterprises', 1988, '7654674567456774', '2021-2449', 'Pre-colegiado', 'Activo', 'Emitido', 'NA', '2020-1-24'),
	('9876452397R' ,'Geralt', 'de Rivia', 'Cracovia', '967317211', 'Brujo', 'Fundacion Minabo', 1981, '2341236574982345', '2022-2564', 'Colegiado', 'Pendiente', 'Pagado', 'NA', '2021-3-3'),
	('6245624354T' ,'Tony', 'Stark', 'Manhattan', '932849182', 'Superhéroe', 'Stark Industries', 1968, '4899918200186755', '2022-2571', 'Colegiado', 'Pendiente', 'Pagado', 'NA', '2020-2-3'),
	('2341512341L' ,'Kratos', 'Fantasma de Esparta', 'Esparta', '932849182', 'Asesino de dioses', 'Sony', 1995, '1999811277564738', '2022-2570', 'Colegiado', 'Pendiente', 'Emitido', 'NA', '2019-1-8')
;

Insert into Curso (titulocurso,fechacurso,precio,fechainicioins,fechafinins,estadoc,nplazas) 
values 
('Desarrollo web','2022-11-26','500','2022-9-17','2023-11-3','Abierta','78'),
('Informática forense y auditoría','2023-1-20','250','2022-11-17','2023-3-1','Abierta','24'),
('Desarrollo de aplicaciones moviles','2022-09-13','135','2022-06-20','2022-08-20','Abierta', '60'),
('Desarrollo de robots','2022-06-17','90','2022-05-01','2022-06-15','Abierta', '70'),
('Desarrollo de robots','2022-07-13','80','2022-05-01','2022-06-15','Abierta', '90'),
('Desarrollo de videojuegos','2022-11-21','165','2022-09-30','2022-11-01','Abierta', '150'),
('Desarrollo de videojuegos','2022-06-11','170','2022-04-30','2022-06-01','Abierta', '20'),
('Desarrollo de bases de datos', '2022-12-04', '70','2022-11-15','2022-12-01', 'Abierta', '30')
;

Insert into Curso (titulocurso,fechacurso,precio,estadoc)
VALUES
('Desarrollo de sistemas inteligentes', '2022-12-31', '1000', 'Planificado')
;

Insert into Inscribe (dniColegiado,tituloCurso,fechaCurso,fecha,estadoS,incidencia, enEspera, posicionEspera)
values
('7348920547A','Desarrollo de aplicaciones moviles','2022-09-13','2022-05-14','Inscrito','ninguna', false, 0),
('4728129374H','Desarrollo de aplicaciones moviles','2022-09-13','2022-01-24','Pre-inscrito','ninguna', false, 0),
('2348597612B','Desarrollo de aplicaciones moviles','2022-09-13','2022-03-24','Inscrito','ninguna', false, 0),
('9876452397R','Desarrollo de aplicaciones moviles','2022-09-13','2022-08-08','Pre-inscrito','ninguna', false, 0),
('2341512341L','Desarrollo de aplicaciones moviles','2022-09-13','2022-08-08','Pendiente','ninguna', true, 1),
('7348920547A','Desarrollo de robots','2022-06-17','2022-01-31','Inscrito','ninguna', false, 0),
('6435634566K','Desarrollo de robots','2022-06-17','2022-11-09','Pre-inscrito','ninguna', false, 0),
('2348597612B','Desarrollo de robots','2022-06-17','2022-05-15','Pre-inscrito','ninguna', false, 0),
('9876452397R','Desarrollo de robots','2022-06-17','2022-09-08','Pre-inscrito','ninguna', false, 0),
('9876452397R','Desarrollo de robots','2022-07-13','2022-09-02','Pendiente','ninguna', true, 2),
('6245624354T','Desarrollo de robots','2022-07-13','2022-09-02','Pendiente','ninguna', true, 1),
('2348597612B','Desarrollo de videojuegos','2022-11-21','2022-08-21','Pre-inscrito','ninguna', false, 0),
('6435634566K','Desarrollo de videojuegos','2022-11-21','2022-03-17','Pendiente','ninguna', true, 1),
('7348920547A','Desarrollo de videojuegos','2022-11-21','2022-02-03','Inscrito','ninguna', false, 0),
('2348597612B','Desarrollo de videojuegos','2022-06-11','2022-11-24','Pendiente','ninguna', true, 1),
('4546574389B','Desarrollo de videojuegos','2022-06-11','2022-07-10','Pendiente','ninguna', true, 2),
('2341512341L','Desarrollo de videojuegos','2022-06-11','2022-07-10','Pendiente','ninguna', true, 3),
('7348920547A','Desarrollo de bases de datos','2022-12-04','2022-04-23','Pre-inscrito','ninguna', false, 0),
('6435634566K','Desarrollo de bases de datos','2022-12-04','2022-09-11','Pre-inscrito','ninguna', false, 0),
('4728129374H','Desarrollo de bases de datos','2022-12-04','2022-11-12','Pre-inscrito','ninguna', false, 0),
('1234312432J','Desarrollo de bases de datos','2022-12-04','2022-03-25','Pre-inscrito','ninguna', false, 0),
('4546574389B','Desarrollo de bases de datos','2022-12-04','2022-02-28','Pendiente','ninguna', true, 1),
('9385783921W','Desarrollo de bases de datos','2022-12-04','2022-10-30','Pendiente','ninguna', true, 2),
('2124678952G','Desarrollo de bases de datos','2022-12-04','2022-10-11','Pendiente','ninguna', true, 3),
('2348597612B','Desarrollo de bases de datos','2022-12-04','2022-11-11','Pendiente','ninguna', true, 5),
('9876452397R','Desarrollo de bases de datos','2022-12-04','2022-10-12','Pendiente','ninguna', true, 4)
;

Insert into InscripcionPericial(dniColegiado, fechaInscripcion, posicionLista, estadoInscripcion)
VALUES
('7348920547A', '2020-9-11', 1, 'Inscrito'),
('6435634566K', '2021-6-8', 2, 'Inscrito'),
('1234312432J', '2019-11-25', 4, 'No inscrito'),
('9385783921W', '2022-2-21', 3, 'Inscrito'),
('2348597612B', '2020-1-11', 8, 'No inscrito'),
('9876452397R', '2021-2-23', 4, 'Inscrito')
;

Insert into SolicitudPericial(dni, id,fecha, estado)
VALUES
('9385783921W', '42345234', "1669400529998", 'Asignada'),
('9876452397R', '57987513', "1669100529998", 'Asignada'),
('6435634566K', '53451213', "1668400529998", 'Asignada')
;

Insert into Informes(dni, id, urgencia, nombre, correo, telefono, descripcion)
values
('7348920547A', '53451213', 'Normal', 'Manolo','manoloelmejor@gmail.com', '644928301', 'Esta bien'),
('4546574389B', '57987513', 'Normal', 'Kazuya','kazuyamichimatekken@bandai.com', '666431212', 'Esta moderadamente mal'),
('9385783921W', '53251217', 'Normal', 'Hermenegildo','hermenegildoelguay@hotmail.com', '932893432', ''),
('2124678952G', '73423441', 'Urgente', 'Sol','letsrock1223@gamil.com', '', ''),
('2348597612B', '59951567', 'Normal', 'Bruce','soybatman1939@gotham.com', '', ''),
('9876452397R', '23543563', 'Urgente', 'Geralt','gerardodelarivera@capcom.com', '844303989', 'No esta mal')
;
