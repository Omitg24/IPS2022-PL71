--Datos para carga inicial de la base de datos

--Borrar todos los datos de las tablas primero

delete from Inscribe;
delete from Colegiado;
delete from Curso;

insert into Colegiado (dniColegiado, nombreColegiado, apellidosColegiado, localidadColegiado, telefonoColegiado, titulacionColegiado, centroColegiado, anioColegiado, ibanColegiado, numeroColegiado, tipoColegiado, estadoColegiado, estadoCuota, estadoAsignacionPericial, fechaColegiacion) values
	('7348920547A' ,'manolo', 'sanchez rodriguez', 'madrid', '472381032', 'panadero', 'uniovi', 1986, '3412431434789', '2020-2306', 'Colegiado', 'Pendiente', 'Emitido', 'NA', '2020-9-13'),
	('6435634566K' ,'pablo', 'gonzalez martinez', 'asturias', '584022938', 'carnicero', 'fundacion minabo', 1983, '5342453352345', '2022-2598', 'Colegiado', 'Anulado', 'Pendiente', 'NA', '2021-6-16'),
	('4728129374H' ,'juan', 'garcia del monte quemao', 'cataluña', '544356789', 'bombero', 'grupo entuhuerto', 1991, '7653756537456', '2020-2359', 'Colegiado', 'Activo', 'Pagado', 'Asignado', '2022-1-3'),
	('1234312432J' ,'hernesto', 'alvarez alvarez', 'gallego', '549999789', 'ganadero', 'grupo entuhuerto', 1989, '6185993986753', '2019-2278', 'Pre-colegiado', 'Activo', 'Emitido', 'NA', '2019-12-29'),
	('4546574389B' ,'kazuya', 'mishima wins', 'japonés', '549566543', 'ingeniero', 'fundación topota', 1995, '5467892034987', '2020-2306', 'Pre-colegiado', 'Anulado', 'Pendiente', 'Asignado', '2021-8-23'),
	('9385783921W' ,'hermenegildo', 'gonzalez rose', 'canario', '546743453', 'bombero', 'unitoby', 1990, '6185993986753', '2018-2123', 'Pre-colegiado', 'Pendiente', 'Pagado', 'NA', '2022-3-2'),
	('2124678952G' ,'sol', 'bad guy', 'japonés', '654342645', 'camionero', 'gears sa', 1990, '3948579283019213', '2018-2125', 'Colegiado', 'Pendiente', 'Pagado', 'Asignado', '2021-2-8'),
	('2348597612B' ,'bruce', 'wayne batman', 'estadounidense', '634323654', 'superheroe', 'wayne enterprises', 1988, '7654674567456774', '2021-2449', 'Pre-colegiado', 'Activo', 'Emitido', 'NA', '2020-1-24'),
	('9876452397R' ,'geralt', 'de rivia', 'polaco', '967317211', 'policía', 'fundacion minabo', 1981, '2341236574982345', '2022-2564', 'Colegiado', 'Pendiente', 'Pagado', 'NA', '2021-3-3')
;

Insert into Curso (titulocurso,fechacurso,precio,fechainicioins,fechafinins,estadoc,nplazas) 
values 
('Desarrollo web','2022-11-26','104','2022-9-17','2023-11-3','Abierta','78'),
('Informática forense y auditoría','2023-1-20','97','2022-11-17','2023-3-1','Abierta','24')
;

Insert into Curso (titulocurso,fechacurso,precio,estadoc)
VALUES
('Desarrollo dispositivos moviles','2022-9-13','135','Planificado'),
('Desarrollo de robots','2022-13-17','90','Planificado'),
('Desarrollo videojuegos','2022-11-21','165','Planificado')
;

Insert into Inscribe (dniColegiado,tituloCurso,fechaCurso,fecha,estadoS,abonado,incidencia)
values
('7348920547A','Desarrollo dispositivos moviles','2022-6-4','2022-7-12','Inscrito','135','ninguna'),
('7348920547A','Desarrollo de robots','2022-2-3','2022-7-12','Inscrito','150','ninguna'),
('7348920547A','Desarrollo videojuegos','2022-2-19','2022-7-12','Inscrito','90','ninguna'),
('6435634566K','Desarrollo de robots','2022-13-17','2022-7-10','Pre-inscrito','150','ninguna'),
('6435634566K','Desarrollo videojuegos','2022-6-4','2022-7-12','Cancelado','90','ninguna')
;

Insert into InscripcionPericial(dniColegiado, fechaInscripcion, posicionLista, estadoInscripcion)
VALUES
('7348920547A', '2020-9-11', 1, 'Inscrito'),
('6435634566K', '2021-6-8', 2, 'Inscrito'),
('1234312432J', '2019-11-25', 4, 'No inscrito'),
('9385783921W', '2022-2-21', 6, 'Inscrito'),
('2348597612B', '2020-1-11', 8, 'No inscrito'),
('9876452397R', '2021-2-23', 9, 'Inscrito')
;

Insert into SolicitudPericial(dni, id, estado)
VALUES
('7348920547A', '53451213', 'NA'),
('6435634566K', '62345234', 'NA'),
('4728129374H', '42345234', 'Asignada'),
('1234312432J', '53551213', 'NA'),
('4546574389B', '57987513', 'Asignada'),
('9385783921W', '53251217', 'NA'),
('2124678952G', '53451213', 'Asignada'),
('2348597612B', '59951567', 'NA'),
('9876452397R', '23543563', 'NA')
;

Insert into Informes(dni, id, urgencia, nombre, correo, telefono, descripcion)
values
('7348920547A', '53451213', 'Normal', 'manolo','manoloelmejor@gmail.com', '644928301', 'esta bien'),
('4546574389B', '57987513', 'Normal', 'kazuya','kazuyamichimatekken@bandai.com', '666431212', 'esta moderadamente mal'),
('9385783921W', '53251217', 'Normal', 'hermenegildo','hermenegildoelguay@hotmail.com', '932893432', ''),
('2124678952G', '73423441', 'Urgente', 'sol','letsrock1223@gamil.com', '', ''),
('2348597612B', '59951567', 'Normal', 'bruce','soybatman999@hotmail.com', '', ''),
('9876452397R', '23543563', 'Urgente', 'geralt','gerardodelarivera@capcom.com', '844303989', 'no esta mal')
;
