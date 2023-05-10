--Galindo Castillo Dalia Julissa
--Proyecto DAW
--Creacion de las tablas

CREATE TABLE Cliente(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Nombre VARCHAR(30) NOT NULL,
	Telefono VARCHAR(10) NOT NULL
);

CREATE TABLE Manicurista(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Nombre VARCHAR(30) NOT NULL,
	Telefono VARCHAR(10) NOT NULL
);

CREATE TABLE Tratamiento(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Nombre VARCHAR(30) NOT NULL,
	Precio INTEGER NOT NULL,
	Cod_Manicurista INTEGER NOT NULL,
	FOREIGN KEY (Cod_Manicurista) REFERENCES Manicurista(Codigo)
);

CREATE TABLE Cita(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	Fecha DATE NOT NULL,
	Horario VARCHAR(20) NOT NULL,
	Cod_Cliente INTEGER NOT NULL,
	Cod_Tratamiento INTEGER NOT NULL,
	FOREIGN KEY (Cod_Cliente) REFERENCES Cliente(Codigo),
	FOREIGN KEY (Cod_Tratamiento) REFERENCES Tratamiento(Codigo)
);

CREATE TABLE Cita_Disp(
	Codigo SERIAL PRIMARY KEY NOT NULL,
	F_Disponible VARCHAR(11) NOT NULL,
	Horario DATE NOT NULL
);