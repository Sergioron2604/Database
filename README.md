Trabajo construcción sotware Base de datos, tablas alternadas:

CREATE TABLE Usuarios (
    Usuario_ID INT PRIMARY KEY,
    Nombre VARCHAR2(100),
    Email VARCHAR2(100)
);

CREATE TABLE Cuentas (
    Cuenta_ID INT PRIMARY KEY,
    Usuario_ID INT,
    Tipo VARCHAR2(50),
    Saldo NUMBER(10,2),
    FOREIGN KEY (Usuario_ID) REFERENCES Usuarios(Usuario_ID)
);

CREATE TABLE Transacciones (
    Transaccion_ID INT PRIMARY KEY,
    Usuario_ID INT,
    Cuenta_ID INT,
    Monto NUMBER(10,2),
    Fecha DATE,
    Tipo VARCHAR2(50),
    FOREIGN KEY (Usuario_ID) REFERENCES Usuarios(Usuario_ID),
    FOREIGN KEY (Cuenta_ID) REFERENCES Cuentas(Cuenta_ID)
);
