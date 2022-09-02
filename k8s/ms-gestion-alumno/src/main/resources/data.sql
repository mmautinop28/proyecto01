insert into Tipo_Documento(id_tipo_documento,tipo, descripcion_larga,descripcion_corta)
values ('01', 'LIBRETA ELECTORAL O DNI','L.E / DNI');

insert into Tipo_Documento(tipo, descripcion_larga,descripcion_corta)
values ('04', 'CARNET DE EXTRANJERIA','CARNET EXT.');

insert into Tipo_Documento(tipo, descripcion_larga,descripcion_corta)
values ('06', 'REG. UNICO DE CONTRIBUYENTES','RUC');

insert into Tipo_Documento(tipo, descripcion_larga,descripcion_corta)
values ('07', 'PASAPORTE','PASAPORTE');

INSERT INTO alumno
(apellido_paterno,apellido_materno,nombre,id_tipo_documento,numero_documento,correo,telefono, fecha_registro,estado)
VALUES ('KURT', 'GALDOS', 'MARIO', '1', '994947686', 'lluna@gmail.com', '567-2045', '2021-04-28 21:57:31', '1');