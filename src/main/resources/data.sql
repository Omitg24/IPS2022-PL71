--Datos para carga inicial de la base de datos

--Borrar todos los datos de las tablas primero

delete from Inscribe;
delete from Colegiado;
delete from Curso;

insert into Colegiado (dnisol, nombresol, apellidossol, localidadsol, telefonosol, titulacionsol, centrosol, anioSol, ibansol, numeroColegiado, tipoSol, estadoSol) values
	('7348920547A' ,'manolo', 'sanchez rodriguez', 'madrid', '472381032', 'panadero', 'uniovi', 1986, '3412431434789', '327894312',"Colegiado","Pendiente"),
	('6435634566K' ,'pablo', 'gonzalez martinez', 'asturias', '584022938', 'carnicero', 'fundacion minabo', 1983, '5342453352345', '465326453', "Colegiado", "Pendiente")
;

Insert into curso (titulocurso,fechacurso,precio,fechainicioins,fechafinins,estadoc,nplazas) 
values 
('Desarrollo dispositivos moviles','2022-9-13','135','2022-9-13','2023-10-10','Planificado','19'),
('Desarrollo de robots','2022-13-17','90','2022-9-13','2023-10-10','Planificado','2'),
('Desarrollo videojuegos','2022-11-21','165','2022-9-13','2023-10-10','Planificado','100'),
('Desarrollo web','2022-11-26','104','2022-9-17','2023-11-3','Abierta','78'),
('Informática forense y auditoría','2023-1-20','97','2022-11-17','2023-3-1','Abierta','24');


Insert into Inscribe (DNIsol,titulocurso,fecha,estados,abonado)
values
('7348920547A','Desarrollo dispositivos moviles','2022-7-12','Inscrito','135'),
('7348920547A','Desarrollo de robots','2022-7-12','Inscrito','150'),
('7348920547A','Desarrollo videojuegos','2022-7-12','Inscrito','90'),
('6435634566K','Desarrollo de robots','2022-7-12','Pre-inscrito','150'),
('6435634566K','Desarrollo videojuegos','2022-7-12','Cancelado','90');
