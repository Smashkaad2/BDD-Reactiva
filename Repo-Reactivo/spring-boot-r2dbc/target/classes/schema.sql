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
FOREIGN KEY (materia_id) REFERENCES materia (id)
);
