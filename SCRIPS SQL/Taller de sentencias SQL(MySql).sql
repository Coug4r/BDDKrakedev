-- Crear tabla
create table estudiantes (
    id_estudiantes int not null auto_increment,
    nombres varchar(50),
    apellidos varchar(50),
    edad int,
    curso varchar(50),
    fechaRegistro date,
    correo varchar(100),
    constraint estudiantesPk primary key (id_estudiantes)
);

-- Inserts iniciales
insert into estudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro) values
(4, 'Ana', 'Torres', 16, 'Matemáticas', '2026-04-01'),
(5, 'Luis', 'Martinez', 19, 'Administración', '2026-05-15'),
(6, 'Sofia', 'Gomez', 15, 'Biología', '2026-06-20'),
(7, 'Pedro', 'Castillo', 23, 'Derecho', '2026-07-08'),
(8, 'Valeria', 'Mendoza', 18, 'Arquitectura', '2026-08-30'),
(9, 'Andres', 'Vargas', 14, 'Física', '2026-09-25'),
(10, 'Camila', 'Rojas', 21, 'Medicina', '2026-10-11');

-- Selects
select * from estudiantes;
select nombres, curso from estudiantes;
select * from estudiantes where edad between 18 and 25;
select * from estudiantes where curso = 'Matemáticas';
select * from estudiantes where fechaRegistro > '2026-03-01';
select * from estudiantes where fechaRegistro between '2026-01-01' and '2026-04-30';

-- Updates
update estudiantes set apellidos = 'garcía' where id_estudiantes = 1;
update estudiantes set curso = 'matemáticas aplicadas' where id_estudiantes = 4;
update estudiantes set edad = 18 where id_estudiantes = 2;
update estudiantes set curso = 'ingeniería de software' where id_estudiantes = 3;
update estudiantes set fechaRegistro = '2026-11-01' where id_estudiantes = 6;

-- Deletes
delete from estudiantes where id_estudiantes = 1;
delete from estudiantes where id_estudiantes = 4;
delete from estudiantes where id_estudiantes = 2;
delete from estudiantes where id_estudiantes = 3;
delete from estudiantes where id_estudiantes = 6;

-- Insert con nueva columna correo
insert into estudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro, correo) values
(1, 'juan', 'perez', 20, 'programacion', '2026-01-10', 'juan.perez@mail.com'),
(2, 'maria', 'lopez', 17, 'diseño gráfico', '2026-02-05', 'maria.lopez@mail.com'),
(3, 'carlos', 'ramirez', 22, 'ingeniería civil', '2026-03-12', 'carlos.ramirez@mail.com'),
(4, 'ana', 'torres', 16, 'matemáticas', '2026-04-01', 'ana.torres@mail.com'),
(5, 'luis', 'martinez', 19, 'administración', '2026-05-15', 'luis.martinez@mail.com');

-- Selects con correo
select * from estudiantes;
select * from estudiantes where curso = 'matemáticas';
select * from estudiantes where fechaRegistro > '2026-03-01';

-- Updates con correo
update estudiantes set correo = 'juan.actualizado@mail.com' where id_estudiantes = 1;
update estudiantes set curso = 'matemáticas aplicadas' where id_estudiantes = 4;
update estudiantes set edad = 18 where id_estudiantes = 2;
update estudiantes set curso = 'ingeniería de software' where id_estudiantes = 3;
update estudiantes set fechaRegistro = '2026-11-01' where id_estudiantes = 5;

-- Deletes con correo
delete from estudiantes where id_estudiantes = 1;
delete from estudiantes where id_estudiantes = 2;
delete from estudiantes where id_estudiantes = 3;
delete from estudiantes where id_estudiantes = 4;
delete from estudiantes where id_estudiantes = 5;

-- Consultas con fechas
select * from estudiantes where fechaRegistro > '2026-02-01';
select * from estudiantes where fechaRegistro < '2026-05-01';
select * from estudiantes where fechaRegistro between '2026-02-01' and '2026-04-30';
select * from estudiantes where fechaRegistro = '2026-03-15';
select * from estudiantes where curso = 'programacion' and fechaRegistro > '2026-01-01';
	