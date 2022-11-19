--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

DROP TABLE Colegiado;
DROP TABLE Curso;
DROP TABLE Inscribe;
DROP TABLE InscripcionPericial;
DROP TABLE SolicitudPericial;
DROP TABLE Informes;
DROP TABLE SolicitudVisado;
DROP TABLE AsignaVisado;

CREATE TABLE Colegiado (
    dniColegiado varchar(20) NOT NULL,
    nombreColegiado varchar(20) NOT NULL,
    apellidosColegiado varchar(40) NOT NULL,
    numeroColegiado varchar(20),
    localidadColegiado varchar(20) NOT NULL,
    telefonoColegiado varchar(20) NOT NULL,
    titulacionColegiado varchar(40) NOT NULL,    
    centroColegiado varchar(40) NOT NULL,    
    anioColegiado decimal(4, 0) NOT NULL,
   	ibanColegiado varchar(40) NOT NULL,
   	tipoColegiado varchar(40) NOT NULL,
   	estadoColegiado varchar(40) NOT NULL,
    estadoCuota varchar NOT NULL,
    estadoAsignacionPericial varchar NOT NULL,
    fechaColegiacion date,

    CONSTRAINT PK_COLEGIADO PRIMARY KEY (dniColegiado),
    CONSTRAINT CK_ESTADO_ASIGNACION_PERICIAL CHECK (estadoAsignacionPericial in ('Asignado','NA')),
    CONSTRAINT CK_ESTADO_INSCRIBE CHECK (estadoColegiado in ('Pendiente','Anulado','Activo')),
    CONSTRAINT CK_ESTADO_CUOTA_INSCRIBE CHECK (estadoCuota in ('Pagado','Emitido','Pendiente')),
    CONSTRAINT CK_TIPO_COLEGIADO CHECK (tipoColegiado in ('Colegiado', 'Pre-colegiado'))
);

CREATE TABLE Curso (
    tituloCurso varchar(40) NOT NULL,
    fechaCurso date NOT NULL,
    fechaInicioIns date,
    fechaFinIns date,
    precio decimal(10, 2) NOT NULL,
    estadoC varchar(20) NOT NULL,
    nPlazas decimal(4, 0),
	cancelable boolean,
	porcentajeDevolucion decimal(2, 2),

    CONSTRAINT PK_CURSO PRIMARY KEY (tituloCurso,fechaCurso),
    CONSTRAINT CK_ESTADO_CURSO CHECK (estadoC in ('Planificado', 'Abierta', 'Cerrada', 'Cancelado')),
    CONSTRAINT CK_FECHA_CURSO CHECK (fechaInicioIns < fechaFinIns)
);

CREATE TABLE Inscribe (
    dniColegiado varchar(20),
    tituloCurso varchar(40),
    fechaCurso date NOT NULL,
    fecha date NOT NULL,
    estadoS varchar(20) NOT NULL,
    abonado decimal(10, 2),
    incidencia varchar,
	enEspera boolean,
	posicionEspera decimal,

    CONSTRAINT PK_INSCRIBE PRIMARY KEY (dniColegiado, tituloCurso, fechaCurso),
    CONSTRAINT FK_INSCRIBE_COLEGIADO FOREIGN KEY (dniColegiado) REFERENCES Colegiado (dniColegiado),
    CONSTRAINT FK_INSCRIBE_CURSO FOREIGN KEY (tituloCurso, fechaCurso) REFERENCES Curso (tituloCurso, fechaCurso),
    CONSTRAINT CK_ESTADO_INSCRIBE CHECK (estadoS in ('Pre-inscrito', 'Inscrito', 'Cancelado','Pendiente'))
);

CREATE TABLE InscripcionPericial (
    dniColegiado varchar(20),
    fechaInscripcion date NOT NULL,
    posicionLista decimal,
    estadoInscripcion varchar NOT NULL,

    CONSTRAINT PK_INSCRIPCION PRIMARY KEY (dniColegiado, fechaInscripcion),
    CONSTRAINT FK_INSCRIPCION_COLEGIADO FOREIGN KEY (dniColegiado) REFERENCES Colegiado (dniColegiado),
    CONSTRAINT CK_ESTADO_INSCRIPCION_PERICIAL CHECK (estadoInscripcion in ('No inscrito', 'Inscrito'))
);

CREATE TABLE SolicitudPericial (
    dni varchar(20) ,
    id varchar NOT NULL,
    fecha TIMESTAMP,
    estado varchar NOT NULL,
	motivoAnulacion varchar,

    CONSTRAINT PK_SOLICITUDPERICIAL PRIMARY KEY (dni,id),
    CONSTRAINT FK_INSCRIPCION_PERITO FOREIGN KEY (dni) REFERENCES Colegiado (dniColegiado),
    CONSTRAINT FK_INFORME_SOLICITUD FOREIGN KEY (id) REFERENCES Informes (id),
    CONSTRAINT CK_SOLICITUD_ESTADO CHECK (estado in ('Asignada', 'NA','Realizada','Anulada'))
);

CREATE TABLE Informes (
    id varchar,
    nombre varchar NOT NULL,
    dni varchar(20) NOT NULL,
    correo varchar NOT NULL,
    telefono varchar,
    descripcion varchar NOT NULL,
    urgencia varchar NOT NULL,

    CONSTRAINT PK_INFORME PRIMARY KEY (id),
    CONSTRAINT CK_URGENCIA_INFORME CHECK (urgencia in ('Urgente', 'Normal'))
);

CREATE TABLE SolicitudVisado (
	id varchar,
	dni varchar(20),
	nombre varchar,
	apellidos varchar,
	descripcion varchar NOT NULL,
	
	CONSTRAINT PK_SOLICITUD_VISADO PRIMARY KEY(id, dni),
	CONSTRAINT FK_SOLICITUD_VISADO_INFORMES FOREIGN KEY (id) REFERENCES Informes(id),
	CONSTRAINT FK_SOLICITUD_VISADO_COLEGIADO FOREIGN KEY (dni) REFERENCES Colegiado(dni),
);

CREATE TABLE AsignaVisado (
	id varchar,
	dniVisado varchar(20),
	dniVisador varchar,
	estadoVisado varchar,
	fecha date,
	
	CONSTRAINT PK_ASIGNA_VISADO PRIMARY KEY(id, dniVisado, dniVisador),
	CONSTRAINT FK_ASIGNA_VISADO_SOLICITUD_VISADO FOREIGN KEY (dniVisado, id) REFERENCES SolicitudVisado(dni, id),
	CONSTRAINT FK_ASIGNA_VISADO_COLEGIADO FOREIGN KEY (dniVisador) REFERENCES Colegiado(dni),
	CONSTRAINT CK_ESTADO_ASIGNACION CHECK (estadoVisado in ('Aceptado', 'Rechazado'))
);

