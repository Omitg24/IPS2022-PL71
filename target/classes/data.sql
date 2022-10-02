--Datos para carga inicial de la base de datos

--Borrar todos los datos de las tablas primero

delete from Solicitud;
delete from Solicitante;
delete from Curso;

insert into Solicitante (dnisol, nombresol, apellidossol, localidadsol, telefonosol, titulacionsol, centrosol, anosol, ibansol, idsol) values
	('7348920547A' ,'manolo', 'sanchez rodriguez', 'madrid', '472381032', 'panadero', 'uniovi', 1986, '3412431434789', '327894312'),
	('6435634566K' ,'pablo', 'gonzalez martinez', 'asturias', '584022938', 'carnicero', 'fundacion minabo', 1983, '5342453352345', '465326453')
;
