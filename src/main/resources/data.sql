--Datos para carga inicial de la base de datos

--Borrar todos los datos de las tablas primero

delete from Inscribe;
delete from Colegiado;
delete from Curso;

insert into Colegiado (dniColegiado, nombreColegiado, apellidosColegiado, localidadColegiado, telefonoColegiado, titulacionColegiado, centroColegiado, anioColegiado, ibanColegiado, numeroColegiado, tipoColegiado, estadoColegiado, estadoCuota, estadoAsignacionPericial, fechaColegiacion) values
	('73489205A' ,'Manolo', 'Sanchez Rodriguez', 'Vallecas', '472381032', 'Panadero', 'Uniovi', 1986, '3412431434789', '2020-2306', 'Colegiado', 'Pendiente', 'Emitido', 'NA', '2020-9-13'),
	('64356345K' ,'Pablo', 'Gonzalez Martinez', 'Langreo', '584022938', 'Carnicero', 'Fundacion Minabo', 1983, '5342453352345', '2022-2598', 'Colegiado', 'Anulado', 'Pendiente', 'NA', '2021-6-16'),
	('47281293H' ,'Juan', 'Garcia del Monte Quemao', 'La Palma', '544356789', 'Bombero', 'Grupo Entuhuerto', 1991, '7653756537456', '2020-2359', 'Colegiado', 'Activo', 'Pagado', 'Asignado', '2022-1-3'),
	('12343124J' ,'Hernesto', 'Alvarez Alvarez', 'Rias Baixas', '549999789', 'Ganadero', 'Grupo Entuhuerto', 1989, '6185993986753', '2019-2278', 'Pre-colegiado', 'Activo', 'Emitido', 'NA', '2019-12-29'),
	('45465743B' ,'Kazuya', 'Mishima Wins', 'Kyoto', '549566543', 'Ingeniero', 'Fundación Topota', 1995, '5467892034987', '2020-2306', 'Pre-colegiado', 'Anulado', 'Pendiente', 'Asignado', '2021-8-23'),
	('93857839W' ,'Hermenegildo', 'Gonzalez Rose', 'Terrasa', '546743453', 'Bombero', 'Unitoby', 1990, '6185993986753', '2018-2123', 'Pre-colegiado', 'Pendiente', 'Pagado', 'NA', '2022-3-2'),
	('21246789G' ,'Sol', 'Bad Guy', 'Shibuya', '654342645', 'Camionero', 'Gears SA', 1990, '3948579283019213', '2018-2125', 'Colegiado', 'Pendiente', 'Pagado', 'Asignado', '2021-2-8'),
	('23485976B' ,'Bruce', 'Wayne Batman', 'Gotham', '634323654', 'Caballerro Oscuro', 'Wayne Enterprises', 1988, '7654674567456774', '2021-2449', 'Pre-colegiado', 'Activo', 'Emitido', 'NA', '2020-1-24'),
	('98764523R' ,'Geralt', 'de Rivia', 'Cracovia', '967317211', 'Brujo', 'Fundacion Minabo', 1981, '2341236574982345', '2022-2564', 'Colegiado', 'Pendiente', 'Pagado', 'NA', '2021-3-3'),
	('62456243T' ,'Tony', 'Stark', 'Manhattan', '932849182', 'Superhéroe', 'Stark Industries', 1968, '4899918200186755', '2022-2571', 'Colegiado', 'Pendiente', 'Pagado', 'NA', '2020-2-3'),
	('23415123L' ,'Kratos', 'Fantasma de Esparta', 'Esparta', '932849182', 'Asesino de dioses', 'Sony', 1995, '1999811277564738', '2022-2570', 'Colegiado', 'Pendiente', 'Emitido', 'NA', '2019-1-8')
;

Insert into Curso (titulocurso,fechacurso,precio,fechainicioins,fechafinins,estadoc,nplazas,cancelable, porcentajeDevolucion)
values
('Desarrollo de bases de datos', '2022-12-04', '70','2022-11-15','2022-12-01', 'Abierta', '40',true, 69); 

Insert into Curso (titulocurso,fechacurso,precio,fechainicioins,fechafinins,estadoc,nplazas) 
values 
('Desarrollo web','2022-11-26','500','2022-9-17','2023-11-3','Abierta','78'),
('Informática forense y auditoría','2023-1-20','250','2022-11-17','2023-3-1','Abierta','25'),
('Desarrollo de aplicaciones moviles','2022-09-13','135','2022-06-20','2022-08-20','Abierta', '60'),
('Desarrollo de robots','2022-06-17','90','2022-05-01','2022-06-15','Abierta', '0'),
('Desarrollo de robots','2022-07-13','80','2022-05-01','2022-06-15','Abierta', '90'),
('Desarrollo de videojuegos','2022-11-21','165','2022-09-30','2022-11-01','Abierta', '150'),
('Desarrollo de videojuegos','2022-06-11','170','2022-04-30','2022-06-01','Abierta', '20')
;

Insert into Curso (titulocurso,fechacurso,precio,estadoc)
VALUES
('Desarrollo de sistemas inteligentes', '2022-12-31', '1000', 'Planificado')
;

Insert into Inscribe (dniColegiado,tituloCurso,fechaCurso,fecha,estadoS,incidencia, enEspera, posicionEspera)
values
('73489205A','Desarrollo de aplicaciones moviles','2022-09-13','2022-05-14','Inscrito','ninguna', false, 0),
('47281293H','Desarrollo de aplicaciones moviles','2022-09-13','2022-01-24','Pre-inscrito','ninguna', false, 0),
('23485976B','Desarrollo de aplicaciones moviles','2022-09-13','2022-03-24','Inscrito','ninguna', false, 0),
('98764523R','Desarrollo de aplicaciones moviles','2022-09-13','2022-08-08','Pre-inscrito','ninguna', false, 0),
('23415123L','Desarrollo de aplicaciones moviles','2022-09-13','2022-08-08','Pendiente','ninguna', false, 1),
('73489205A','Desarrollo de robots','2022-06-17','2022-01-31','Inscrito','ninguna', false, 0),
('64356345K','Desarrollo de robots','2022-06-17','2022-11-09','Pre-inscrito','ninguna', false, 0),
('23485976B','Desarrollo de robots','2022-06-17','2022-05-15','Pre-inscrito','ninguna', false, 0),
('98764523R','Desarrollo de robots','2022-06-17','2022-09-08','Pre-inscrito','ninguna', false, 0),
('98764523R','Desarrollo de robots','2022-07-13','2022-09-02','Pendiente','ninguna', true, 2),
('62456243T','Desarrollo de robots','2022-07-13','2022-09-02','Pendiente','ninguna', true, 1),
('23485976B','Desarrollo de videojuegos','2022-11-21','2022-08-21','Pre-inscrito','ninguna', false, 0),
('64356345K','Desarrollo de videojuegos','2022-11-21','2022-03-17','Pendiente','ninguna', true, 1),
('73489205A','Desarrollo de videojuegos','2022-11-21','2022-02-03','Inscrito','ninguna', false, 0),
('23485976B','Desarrollo de videojuegos','2022-06-11','2022-11-24','Pendiente','ninguna', true, 1),
('45465743B','Desarrollo de videojuegos','2022-06-11','2022-07-10','Pendiente','ninguna', true, 2),
('23415123L','Desarrollo de videojuegos','2022-06-11','2022-07-10','Pendiente','ninguna', true, 3),
('73489205A','Desarrollo de bases de datos','2022-12-04','2022-04-23','Pre-inscrito','ninguna', false, 0),
('64356345K','Desarrollo de bases de datos','2022-12-04','2022-11-28','Pre-inscrito','ninguna', false, 0),
('47281293H','Desarrollo de bases de datos','2022-12-04','2022-11-12','Pre-inscrito','ninguna', false, 0),
('12343124J','Desarrollo de bases de datos','2022-12-04','2022-03-25','Pre-inscrito','ninguna', false, 0),
('45465743B','Desarrollo de bases de datos','2022-12-04','2022-02-28','Pendiente','ninguna', true, 1),
('93857839W','Desarrollo de bases de datos','2022-12-04','2022-10-30','Pendiente','ninguna', true, 2),
('21246789G','Desarrollo de bases de datos','2022-12-04','2022-10-11','Pendiente','ninguna', true, 3),
('23485976B','Desarrollo de bases de datos','2022-12-04','2022-11-11','Pendiente','ninguna', true, 5),
('98764523R','Desarrollo de bases de datos','2022-12-04','2022-10-12','Pendiente','ninguna', true, 4)
;

Insert into InscripcionPericial(dniColegiado, fechaInscripcion, posicionLista, estadoInscripcion)
VALUES
('73489205A', '2020-09-11', 1, 'Inscrito'),
('64356345K', '2026-08-23', 2, 'Inscrito'),
('12343124J', '2019-11-25', 4, 'No inscrito'),
('93857839W', '2022-02-21', 3, 'Inscrito'),
('23485976B', '2020-01-11', 8, 'No inscrito'),
('98764523R', '2021-02-23', 4, 'Inscrito')
;

Insert into SolicitudPericial(dni, id,fecha, estado)
VALUES
('93857839W', '42345234', "1669400529998", 'Asignada'),
('98764523R', '57987513', "1661100529998", 'Asignada'),
('64356345K', '53451213', "1664400529998", 'Asignada'),
('23485976B', '53451213', "1662400529998", 'Anulada'),
('23415123L', '59951567', "1664400529998", 'Anulada'),
('12343124J', '23543563', "1666400529998", 'Realizada')
;

Insert into Informes(dni, id, urgencia, nombre, correo, telefono, descripcion)
values
('73489205A', '53451213', 'Normal', 'Manolo','manoloelmejor@gmail.com', '644928301', 'Esta bien'),
('45465743B', '57987513', 'Normal', 'Kazuya','kazuyamichimatekken@bandai.com', '666431212', 'Esta moderadamente mal'),
('93857839W', '53251217', 'Normal', 'Hermenegildo','hermenegildoelguay@hotmail.com', '932893432', ''),
('21246789G', '73423441', 'Urgente', 'Sol','letsrock1223@gamil.com', '', ''),
('23485976B', '59951567', 'Normal', 'Bruce','soybatman1939@gotham.com', '', ''),
('98764523R', '23543563', 'Urgente', 'Geralt','gerardodelarivera@capcom.com', '844303989', 'No esta mal')
;

Insert into SolicitudVisado(id, dni, nombre, apellidos, descripcion )
values
('cf4c7f82-6f4c-11ed-a1eb-0242ac120002','73489205A','Manolo', 'Sanchez Rodriguez','Visar último informe realizado'),
('e145cc0c-6f4c-11ed-a1eb-0242ac120002','64356345K','Pablo', 'Gonzalez Martinez','Visar último informe realizado' ),
('e8af6494-6f4c-11ed-a1eb-0242ac120002','93857839W', 'Hermenegildo', 'Gonzalez Rose','Visar último informe realizado'),
('f1d826aa-6f4c-11ed-a1eb-0242ac120002','98764523R', 'Geralt', 'de Rivia','Visar último informe realizado')
;

