--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

DROP TABLE Solicitante;
DROP TABLE Curso;
DROP TABLE Solicitud;

CREATE TABLE Solicitante (
    dniSol varchar(20) NOT NULL,
    nombreSol varchar(20) NOT NULL,
    apellidosSol varchar(40) NOT NULL,
    idSol varchar(20),
    localidadSol varchar(20) NOT NULL,
    telefonoSol varchar(20) NOT NULL,
    titulacionSol varchar(40) NOT NULL,
    centroSol varchar(40) NOT NULL,
    añoSol decimal(4, 0) NOT NULL,
   	ibanSol varchar(40) NOT NULL,    

    CONSTRAINT PK_SOLICITANTE PRIMARY KEY (dniSol)
);

CREATE TABLE Curso (
    tituloCurso varchar(40) NOT NULL,
    fechaCurso date NOT NULL,
    fechaInicioIns date,
    fechaFinIns date,
    precio decimal(10, 2) NOT NULL,
    estadoC varchar(20) NOT NULL,
    nPlazas decimal(4, 0) NOT NULL,

    CONSTRAINT PK_CURSO PRIMARY KEY (tituloCurso),
    CONSTRAINT CK_ESTADO_CURSO CHECK (estadoC in ('Planificado', 'Abierta', 'Cerrada', 'Cancelada')),
    CONSTRAINT CK_FECHA_CURSO CHECK (fechaInicioIns < fechaFinIns)
);

CREATE TABLE Solicitud (
    dniSol varchar(20),
    tituloCurso varchar(40),
    fecha date NOT NULL,
    estadoS varchar(20) NOT NULL,
    abonado decimal(10, 2) NOT NULL,

    CONSTRAINT PK_SOLICITUD PRIMARY KEY (dniSol, tituloCurso),
    CONSTRAINT FK_SOLICITUD_SOLICITANTE FOREIGN KEY (dniSol) REFERENCES Solicitante (dniSol),
    CONSTRAINT FK_SOLICITUD_CURSO FOREIGN KEY (tituloCurso) REFERENCES Curso (tituloCurso),
    CONSTRAINT CK_ESTADO_SOLICITUD CHECK (estadoS in ('Pre-inscrito', 'Inscrito', 'Cancelado'))
);