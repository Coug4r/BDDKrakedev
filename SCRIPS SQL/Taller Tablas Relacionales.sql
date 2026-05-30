
-- Tabla libros
create table libros (
    codigo varchar(5) primary key,
    titulo varchar(50) not null,
    pagina int not null
);

-- Tabla autores
create table autores (
    id int primary key,
    nombre varchar(50) not null,
    pais varchar(30) not null
);

-- Tabla de rompimiento libro_autor
create table libro_autor (
    la_libro_codigo_fk varchar(5) not null,
    la_autor_id_fk int not null,
    anio_publicacion int not null,
    primary key (la_libro_codigo_fk, la_autor_id_fk),
    foreign key (la_libro_codigo_fk) references libros(codigo),
    foreign key (la_autor_id_fk) references autores(id)
);

-- Inserts para libros (4 registros)
insert into libros (codigo, titulo, pagina)
values ('L001', 'Cien Años de Soledad', 471);

insert into libros (codigo, titulo, pagina)
values ('L002', 'Don Quijote de la Mancha', 863);

insert into libros (codigo, titulo, pagina)
values ('L003', 'La Ciudad y los Perros', 398);

insert into libros (codigo, titulo, pagina)
values ('L004', 'Rayuela', 600);

-- Inserts para autores (3 registros)
insert into autores (id, nombre, pais)
values (1, 'Gabriel García Márquez', 'Colombia');

insert into autores (id, nombre, pais)
values (2, 'Miguel de Cervantes', 'España');

insert into autores (id, nombre, pais)
values (3, 'Mario Vargas Llosa', 'Perú');

-- Inserts para libro_autor (5 relaciones)
insert into libro_autor (la_libro_codigo_fk, la_autor_id_fk, anio_publicacion)
values ('L001', 1, 1967);

insert into libro_autor (la_libro_codigo_fk, la_autor_id_fk, anio_publicacion)
values ('L002', 2, 1605);

insert into libro_autor (la_libro_codigo_fk, la_autor_id_fk, anio_publicacion)
values ('L003', 3, 1963);

insert into libro_autor (la_libro_codigo_fk, la_autor_id_fk, anio_publicacion)
values ('L004', 3, 1963);

insert into libro_autor (la_libro_codigo_fk, la_autor_id_fk, anio_publicacion)
values ('L004', 1, 1963); -- Ejemplo de coautoría

-- Consulta 1: título, autor, país y año de publicación
select l.titulo, a.nombre, a.pais, la.anio_publicacion
from libro_autor la
inner join libros l on la.la_libro_codigo_fk = l.codigo
inner join autores a on la.la_autor_id_fk = a.id;

-- Consulta 2: libros publicados después del año 2020
select l.titulo, la.anio_publicacion
from libro_autor la
inner join libros l on la.la_libro_codigo_fk = l.codigo
where la.anio_publicacion > 2020;

-- Consulta 3: autores de un país específico (ejemplo: 'España')
select nombre, pais
from autores
where pais = 'España';

-- Consulta 4: ordenar los libros por año de publicación descendente
select l.titulo, la.anio_publicacion
from libro_autor la
inner join libros l on la.la_libro_codigo_fk = l.codigo
order by la.anio_publicacion desc;

-- Consulta 5: contar cuántos libros tiene cada autor
select a.nombre, count(la.la_libro_codigo_fk) as cantidad_libros
from libro_autor la
inner join autores a on la.la_autor_id_fk = a.id
group by a.nombre;
