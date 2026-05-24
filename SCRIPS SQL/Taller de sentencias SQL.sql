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

update esudiantes set apellidos = 'garcía' where id_estudiantes = 1;
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

insert into estudiantes (id_estudiantes, nombres, apellidos, edad, curso, fechaRegistro, correo) values
(1, 'juan', 'perez', 20, 'programacion', '2026-01-10', 'juan.perez@mail.com'),
(2, 'maria', 'lopez', 17, 'diseño gráfico', '2026-02-05', 'maria.lopez@mail.com'),
(3, 'carlos', 'ramirez', 22, 'ingeniería civil', '2026-03-12', 'carlos.ramirez@mail.com'),
(4, 'ana', 'torres', 16, 'matemáticas', '2026-04-01', 'ana.torres@mail.com'),
(5, 'luis', 'martinez', 19, 'administración', '2026-05-15', 'luis.martinez@mail.com');

select * from estudiantes;

select * from estudiantes where curso = 'matemáticas';

select * from estudiantes where fechaRegistro > '2026-03-01';

update estudiantes set correo = 'juan.actualizado@mail.com' where id_estudiantes = 1;
update estudiantes set curso = 'matemáticas aplicadas' where id_estudiantes = 4;
update estudiantes set edad = 18 where id_estudiantes = 2;
update estudiantes set curso = 'ingeniería de software' where id_estudiantes = 3;
update estudiantes set fechaRegistro = '2026-11-01' where id_estudiantes = 5;

delete from estudiantes where id_estudiantes = 1;
delete from estudiantes where id_estudiantes = 2;
delete from estudiantes where id_estudiantes = 3;
delete from estudiantes where id_estudiantes = 4;
delete from estudiantes where id_estudiantes = 5;


