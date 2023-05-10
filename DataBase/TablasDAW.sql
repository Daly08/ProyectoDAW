--Galindo Castillo Dalia Julissa
--Proyecto DAW
--Creacion de las tablas

CREATE TABLE Cliente(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Nombre VARCHAR(50) NOT NULL,
	Telefono VARCHAR(10) NOT NULL
);

CREATE TABLE Tratamiento(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Nombre VARCHAR(50) NOT NULL,
	Precio FLOAT NOT NULL
);

CREATE TABLE Promocion(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Nombre VARCHAR(50) NOT NULL,
	Precio FLOAT NOT NULL,
	Vigencia BOOLEAN NOT NULL
); 

CREATE TABLE Cita(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Fecha DATE NOT NULL,
	Horario TIME NOT NULL,
	Cod_Cliente INTEGER NOT NULL,
	Cod_Tratamiento INTEGER NOT NULL,
	Cod_Promocion INTEGER NOT NULL,
	Cancelar BOOLEAN NOT NULL,
	FOREIGN KEY (Cod_Cliente) REFERENCES Cliente(Codigo),
	FOREIGN KEY (Cod_Tratamiento) REFERENCES Tratamiento(Codigo),
	FOREIGN KEY (Cod_Promocion) REFERENCES Promocion(Codigo)
);