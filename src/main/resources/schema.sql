--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

DROP TABLE Colegiado;
DROP TABLE Curso;
DROP TABLE Inscribe;

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

    CONSTRAINT PK_COLEGIADO PRIMARY KEY (dniSol),
    CONSTRAINT CK_ESTADO_INSCRIBE CHECK (estadoSol in ('Pendiente')),
    CONSTRAINT CK_TIPO_COLEGIADO CHECK (tipoSol in ('Colegiado', 'Pre-colegiado'))
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

CREATE TABLE Inscribe (
    dniSol varchar(20),
    tituloCurso varchar(40),
    fecha date NOT NULL,
    estadoS varchar(20) NOT NULL,
    abonado decimal(10, 2) NOT NULL,

    CONSTRAINT PK_INSCRIBE PRIMARY KEY (dniSol, tituloCurso),
    CONSTRAINT FK_INSCRIBE_COLEGIADO FOREIGN KEY (dniSol) REFERENCES Colegiado (dniSol),
    CONSTRAINT FK_INSCRIBE_CURSO FOREIGN KEY (tituloCurso) REFERENCES Curso (tituloCurso),
    CONSTRAINT CK_ESTADO_INSCRIBE CHECK (estadoS in ('Pre-inscrito', 'Inscrito', 'Cancelado'))
);