create table personasComunes(
    cedula varchar(5) primary key,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    estatura double precision,
    edad int
);

create table estado_civil_comun(
    codigo char(1) primary key,
    descripcion varchar(30) not null
);

insert into personasComunes (cedula, nombre, apellido, estatura, edad)
values ('00001', 'Juan', 'Pérez', 1.75, 30);
insert into personasComunes (cedula, nombre, apellido, estatura, edad)
values ('00002', 'María', 'Gómez', 1.62, 25);
insert into personasComunes (cedula, nombre, apellido, estatura, edad)
values ('00003', 'Carlos', 'Ramírez', 1.80, 40);

insert into estado_civil_comun (codigo, descripcion)
values ('S', 'Soltero');
insert into estado_civil_comun (codigo, descripcion)
values ('C', 'Casado');
insert into estado_civil_comun (codigo, descripcion)
values ('U', 'Union libre');

alter table personasComunes add estado_civil char(1);
select * from personasComunes;
select * from estado_civil_comun;

alter table personasComunes add constraint fk_estado_civil foreign key(estado_civil) references estado_civil_comun(codigo);
update personasComunes set estado_civil = 'S' where cedula='00001';
update personasComunes set estado_civil = 'C' where cedula = '00002';
update personasComunes set estado_civil = 'U' where cedula = '00003';

insert into personasComunes (cedula, nombre, apellido, estatura, edad, estado_civil)
values ('00004', 'Lucía', 'Fernández', 1.68, 28, 'S');
insert into personasComunes (cedula, nombre, apellido, estatura, edad, estado_civil)
values ('00005', 'Andrés', 'Mendoza', 1.82, 35, 'C');
insert into personasComunes (cedula, nombre, apellido, estatura, edad, estado_civil)
values ('00006', 'Sofía', 'Torres', 1.60, 22, 'U');
insert into personasComunes (cedula, nombre, apellido, estatura, edad, estado_civil)
values ('00007', 'Pedro', 'Castillo', 1.74, 40, 'S');
insert into personasComunes (cedula, nombre, apellido, estatura, edad, estado_civil)
values ('00008', 'Valeria', 'Gómez', 1.70, 27, 'C');
insert into personasComunes (cedula, nombre, apellido, estatura, edad, estado_civil)
values ('00009', 'Miguel', 'Ramírez', 1.85, 33, 'U');


select personasComunes.cedula, personasComunes.nombre, personasComunes.apellido, estado_civil_comun.descripcion from personasComunes inner join estado_civil_comun on personasComunes.estado_civil = estado_civil_comun.codigo;

select p.nombre, p.apellido, e.descripcion from personasComunes p inner join estado_civil_comun e on p.estado_civil = e.codigo
where e.descripcion like 'S%';

select count(e.descripcion as total_personas from personasComunes p inner join estado_civil_comun e on p.estado_civil = e.codigo WHERE e.descripcion = 'Soltero';

select e.descripcion, count(*) as total_persona
from personasComunes p inner join estado_civil_comun e
on p.estado_civil = e.codigo
GROUP by e.descripcion;

create table producto(
codigo varchar(5) primary key,
nombre varchar(50) not null,
telefono varchar(10)
);

INSERT INTO producto(codigo,nombre,telefono)
values
('P1','Papas',100),
('P2','K-Chitos',200),
('P3','Chifles',123),
('P4','Rufles',122);

INSERT INTO proveedores(id,nombre,telefono)
values
(1,'Inalecsa','123456789'),
(2,'Fritolay','987654321');

create table por
