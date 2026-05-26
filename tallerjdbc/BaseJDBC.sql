CREATE TABLE vehiculos(
placa VARCHAR(10) PRIMARY KEY,
marca VARCHAR(50) NOT NULL,
modelo VARCHAR(50) NOT NULL,
anio INT NOT NULL,
precio DECIMAL NOT NULL,
color VARCHAR(30),
disponible BOOLEAN NOT NULL

);

INSERT INTO vehiculos (placa,marca,modelo,anio,precio,color,disponible)
VALUES (?,?,?,?,?,?,?)

select * from vehiculos

UPDATE vehiculos SET
marca = ?,
modelo = ?,
anio = ?,
precio = ?,
color = ?,
disponible = ?
WHERE placa = ?

