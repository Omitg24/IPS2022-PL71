--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

DROP TABLE Colegiado;
DROP TABLE Curso;
DROP TABLE Inscribe;
DROP TABLE InscripcionPericial;
DROP TABLE SolicitudPericial;
DROP TABLE Informes;

CREATE TABLE Colegiado (
    dniSol varchar(20) NOT NULL,
    nombreSol varchar(20) NOT NULL,
    apellidosSol varchar(40) NOT NULL,
    numeroColegiado varchar(20),
    localidadSol varchar(20) NOT NULL,
    telefonoSol varchar(20) NOT NULL,
    titulacionSol varchar(40) NOT NULL,    
    centroSol varchar(40) NOT NULL,    
    anioSol decimal(4, 0) NOT NULL,
   	ibanSol varchar(40) NOT NULL,
   	tipoSol varchar(40) NOT NULL,
   	estadoSol varchar(40) NOT NULL,
    estadoCuota varchar NOT NULL,
    estadoAsignacionPericial varchar NOT NULL,
    fechaColegiacion date,

    CONSTRAINT PK_COLEGIADO PRIMARY KEY (dniSol),
    CONSTRAINT CK_ESTADO_ASIGNACION_PERICIAL CHECK (estadoAsignacionPericial in ('Asignado','NA')),
    CONSTRAINT CK_ESTADO_INSCRIBE CHECK (estadoSol in ('Pendiente','Anulado','Activo')),
    CONSTRAINT CK_ESTADO_CUOTA_INSCRIBE CHECK (estadoCuota in ('Pagado','Emitido','Pendiente')),
    CONSTRAINT CK_TIPO_COLEGIADO CHECK (tipoSol in ('Colegiado', 'Pre-colegiado'))
);

CREATE TABLE Curso (
    tituloCurso varchar(40) NOT NULL,
    fechaCurso date NOT NULL,
    fechaInicioIns date,
    fechaFinIns date,
    precio decimal(10, 2) NOT NULL,
    estadoC varchar(20) NOT NULL,
    nPlazas decimal(4, 0) ,

    CONSTRAINT PK_CURSO PRIMARY KEY (tituloCurso,fechaCurso),
    CONSTRAINT CK_ESTADO_CURSO CHECK (estadoC in ('Planificado', 'Abierta', 'Cerrada', 'Cancelada')),
    CONSTRAINT CK_FECHA_CURSO CHECK (fechaInicioIns < fechaFinIns)
);

CREATE TABLE Inscribe (
    dniSol varchar(20),
    tituloCurso varchar(40),
    fecha date NOT NULL,
    estadoS varchar(20) NOT NULL,
    abonado decimal(10, 2) NOT NULL,
    incidencia varchar,

    CONSTRAINT PK_INSCRIBE PRIMARY KEY (dniSol, tituloCurso),
    CONSTRAINT FK_INSCRIBE_COLEGIADO FOREIGN KEY (dniSol) REFERENCES Colegiado (dniSol),
    CONSTRAINT FK_INSCRIBE_CURSO FOREIGN KEY (tituloCurso) REFERENCES Curso (tituloCurso),
    CONSTRAINT CK_ESTADO_INSCRIBE CHECK (estadoS in ('Pre-inscrito', 'Inscrito', 'Cancelado','Pendiente'))
);

CREATE TABLE InscripcionPericial (
    dniSol varchar(20),
    fechaInscripcion date NOT NULL,
    posicionLista decimal,
    estadoInscripcion varchar NOT NULL,

    CONSTRAINT PK_INSCRIPCION PRIMARY KEY (dniSol, fechaInscripcion),
    CONSTRAINT FK_INSCRIPCION_COLEGIADO FOREIGN KEY (dniSol) REFERENCES Colegiado (dniSol),
    CONSTRAINT CK_ESTADO_INSCRIPCION_PERICIAL CHECK (estadoInscripcion in ('No inscrito', 'Inscrito'))
);

CREATE TABLE SolicitudPericial (
    dni varchar(20) ,
    id varchar NOT NULL,
    estado varchar NOT NULL,

    CONSTRAINT PK_SOLICITUDPERICIAL PRIMARY KEY (dni,id),
    CONSTRAINT FK_INSCRIPCION_PERITO FOREIGN KEY (dni) REFERENCES Colegiado (dniSol),
    CONSTRAINT FK_INFORME_SOLICITUD FOREIGN KEY (id) REFERENCES Informes (id),
    CONSTRAINT CK_SOLICITUD_ESTADO CHECK (estado in ('Asignada', 'NA'))
);

CREATE TABLE Informes (
    id varchar
    nombre varchar NOT NULL,
    dni varchar(20) NOT NULL,
    correo varchar NOT NULL,
    telefono varchar,
    descripcion varchar NOT NULL,
    urgencia varchar NOT NULL,

    CONSTRAINT PK_INFORME PRIMARY KEY (id),
    CONSTRAINT CK_URGENCIA_INFORME CHECK (urgencia in ('Urgente', 'Normal'))
);

