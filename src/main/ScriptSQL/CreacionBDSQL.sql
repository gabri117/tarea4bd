CREATE TABLE profesor (
    codigo_profesor VARCHAR(10) PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL
);

CREATE TABLE catalogo_curso (
    codigo_curso VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(80) NOT NULL,
    creditos INT NOT NULL,
    codigo_prerrequisito VARCHAR(10),
    CONSTRAINT fk_prerrequisito FOREIGN KEY (codigo_prerrequisito) REFERENCES catalogo_curso(codigo_curso)
);

CREATE TABLE curso_programado (
    id_curso_programado SERIAL PRIMARY KEY,
    codigo_curso VARCHAR(10) NOT NULL,
    semestre INT NOT NULL,
    ciclo INT NOT NULL,
    codigo_profesor VARCHAR(10) NOT NULL,
    CONSTRAINT fk_curso FOREIGN KEY (codigo_curso) REFERENCES catalogo_curso(codigo_curso),
    CONSTRAINT fk_profesor FOREIGN KEY (codigo_profesor) REFERENCES profesor(codigo_profesor)
);

CREATE TABLE estudiante (
    carnet VARCHAR(15) PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    fecha_nacimiento DATE NOT NULL
);

CREATE TABLE inscripcion (
    carnet VARCHAR(15) NOT NULL,
    id_curso_programado INT NOT NULL,
    nota_final DECIMAL(4,2),
    fecha_evaluacion DATE,
    PRIMARY KEY (carnet, id_curso_programado),
    CONSTRAINT fk_inscripcion_estudiante FOREIGN KEY (carnet) REFERENCES estudiante(carnet),
    CONSTRAINT fk_inscripcion_curso FOREIGN KEY (id_curso_programado) REFERENCES curso_programado(id_curso_programado)
);
