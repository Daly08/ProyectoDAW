--Galindo Castillo Dalia Julissa
--Proyecto DAW
--Llenado de la tablas

INSERT INTO Cliente(codigo,nombre, telefono)
VALUES ('1','Julissa','2851087745'),
('2','Nayubel','2855504439'),
('3','Liz','2294837497');

INSERT INTO Tratamiento(codigo,nombre, precio)
VALUES('1','Uñas de acrilico','300'),
('2','Gel en pies','100'),
('3','Gel el manos','100'),
('4','PediSpa','150');

INSERT INTO Promocion(codigo,nombre, precio, vigencia)
VALUES ('1','Gel','70','1'),
('2','Spa','100','1'),
('3','Manicura','150','0');

INSERT INTO Cita(codigo,fecha, horario, cod_cliente,cod_tratamiento,cod_promocion,cancelar)
VALUES ('1','20/05/2023','09:00','1','1','1','0'),
('2','20/05/2023','13:00','2','4','1','1'),
('3','20/05/2023','15:00','1','3','1','1');