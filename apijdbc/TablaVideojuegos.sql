CREATE TABLE videojuegos(
codigo VARCHAR(10) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
plataforma VARCHAR(50) NOT NULL,
precio DECIMAL NOT NULL,
disponible BOOLEAN NOT NULL,
genero VARCHAR(50)
);

INSERT INTO videojuegos(codigo,nombre,plataforma,precio,disponible,genero) 
VALUES(?,?,?,?,?,?)

UPDATE videojuegos WHERE codigo=? SET
nombre=?,
plataforma=?,
precio=?,
disponible=?,
genero=?

DELETE FROM videojuegos WHERE codigo=?;

select * from videojuegos