CREATE TABLE IF NOT EXISTS titulacion(
    id bigint auto_increment primary key,
    titulo varchar(25));


CREATE TABLE IF NOT EXISTS alumno(
    id bigint auto_increment primary key,
    nombre varchar(25),
    edad bigint,
    titulacion bigint,
    FOREIGN KEY (titulacion) REFERENCES titulacion(id));






