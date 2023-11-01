CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS persona (
id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
nombre varchar,
apellido varchar,
correo varchar,
rol char(1) DEFAULT 'E'
);

CREATE TABLE IF NOT EXISTS materia (
id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
nombre varchar,
creditos integer
);

CREATE TABLE IF NOT EXISTS curso (
id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
numero varchar,
fecha_inicio varchar,
fecha_fin varchar,
materia_id integer,
profesor_id integer,
estudiante_id integer,
FOREIGN KEY (materia_id) REFERENCES materia (id),
FOREIGN KEY (profesor_id) REFERENCES persona (id),
FOREIGN KEY (estudiante_id) REFERENCES persona (id)
);

CREATE TABLE IF NOT EXISTS nota (
id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
materia_id integer NOT NULL,
profesor_id integer NOT NULL,
estudiante_id integer NOT NULL,
observacion varchar,
valor numeric(3, 2),
porcentaje numeric(4,2)
);

CREATE VIEW estudiante AS
SELECT
id, nombre, apellido, correo
FROM persona
WHERE rol = 'E';

CREATE VIEW profesor AS
SELECT
id, nombre, apellido, correo
FROM persona
WHERE rol = 'P';
