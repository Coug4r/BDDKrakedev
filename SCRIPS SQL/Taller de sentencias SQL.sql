create table esudiantes(
	id_estudiantes int ,
	nombres varchar(50),
	apellidos varchar(50),
	edad int ,
	curso varchar(50),
	fechaRegistro varchar(10),
	constraint estudiantesPk primary key(id_estudiantes)
);

insert into esudiantes values
(4, 'Ana', 'Torres', 16, 'Matemáticas', '2026-04-01'),
(5, 'Luis', 'Martinez', 19, 'Administración', '2026-05-15'),
(6, 'Sofia', 'Gomez', 15, 'Biología', '2026-06-20'),
(7, 'Pedro', 'Castillo', 23, 'Derecho', '2026-07-08'),
(8, 'Valeria', 'Mendoza', 18, 'Arquitectura', '2026-08-30'),
(9, 'Andres', 'Vargas', 14, 'Física', '2026-09-25'),
(10, 'Camila', 'Rojas', 21, 'Medicina', '2026-10-11');


select * from esudiantes
select nombres,curso from esudiantes
select 	* from esudiantes 
where edad between 18 and 25
select 	* from esudiantes 
where curso = 'Matemáticas'
select 	* from esudiantes 
where fechaRegistro > '2026-03-01'
select 	* from esudiantes 
where fechaRegistro between '2026-01-01' and '2026-04-30'

update esudiantes set 
apellidos = 'garcía', 
curso = 'Prueba' 
where id_estudiantes = 1;

update esudiantes set curso = 'matemáticas aplicadas' where id_estudiantes = 4;
update esudiantes set edad = 18 where id_estudiantes = 2;
update esudiantes set curso = 'ingeniería de software' where id_estudiantes = 3;
update esudiantes set fechaRegistro = '2026-11-01' where id_estudiantes = 6;

delete from esudiantes where id_estudiantes = 1;
delete from esudiantes where id_estudiantes = 4;
delete from esudiantes where id_estudiantes = 2;
delete from esudiantes where id_estudiantes = 3;
delete from esudiantes where id_estudiantes = 6;

alter table esudiantes add column correo varchar(100);

insert into esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro, correo) values
(1, 'juan', 'perez', 20, 'programacion', '2026-01-10', 'juan.perez@mail.com'),
(2, 'maria', 'lopez', 17, 'diseño gráfico', '2026-02-05', 'maria.lopez@mail.com'),
(3, 'carlos', 'ramirez', 22, 'ingeniería civil', '2026-03-12', 'carlos.ramirez@mail.com'),
(4, 'ana', 'torres', 16, 'matemáticas', '2026-04-01', 'ana.torres@mail.com'),
(5, 'luis', 'martinez', 19, 'administración', '2026-05-15', 'luis.martinez@mail.com');

select * from esudiantes;

select * from esudiantes where curso = 'matemáticas';

select * from esudiantes where fechaRegistro > '2026-03-01';

update esudiantes set correo = 'juan.actualizado@mail.com' where id_estudiantes = 1;
update esudiantes set curso = 'matemáticas aplicadas' where id_estudiantes = 4;
update esudiantes set edad = 18 where id_estudiantes = 2;
update esudiantes set curso = 'ingeniería de software' where id_estudiantes = 3;
update esudiantes set fechaRegistro = '2026-11-01' where id_estudiantes = 5;

delete from esudiantes where id_estudiantes = 1;
delete from esudiantes where id_estudiantes = 2;
delete from esudiantes where id_estudiantes = 3;
delete from esudiantes where id_estudiantes = 4;
delete from esudiantes where id_estudiantes = 5;

select * from esudiantes where fechaRegistro > '2026-02-01';

select * from esudiantes where fechaRegistro < '2026-05-01';

select * from esudiantes where fechaRegistro between '2026-02-01' and '2026-04-30';

select * from esudiantes where fechaRegistro = '2026-03-15';

select * from esudiantes where curso = 'Programacion' and fechaRegistro > '2026-01-01';

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (1, 'Juan', 'Perez', 20, 'Programación', '2026-01-10');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (2, 'Maria', 'Lopez', 17, 'Diseño Gráfico', '2026-02-05');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (3, 'Carlos', 'Ramirez', 22, 'Ingeniería Civil', '2026-03-12');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (4, 'Ana', 'Torres', 16, 'Matemáticas', '2026-04-01');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (5, 'Luis', 'Martinez', 19, 'Administración', '2026-05-15');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (6, 'Sofia', 'Gomez', 15, 'Biología', '2026-06-20');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (7, 'Pedro', 'Castillo', 23, 'Derecho', '2026-07-08');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (8, 'Valeria', 'Mendoza', 18, 'Arquitectura', '2026-08-30');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (9, 'Andres', 'Vargas', 14, 'Física', '2026-09-25');

INSERT INTO esudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro)
VALUES (10, 'Camila', 'Rojas', 21, 'Medicina', '2026-10-11');

select * from esudiantes

update esudiantes set edad = 30 where id_estudiantes = 1;

delete from esudiantes where id_estudiantes=1;

select * from esudiantes where edad>18;

sel