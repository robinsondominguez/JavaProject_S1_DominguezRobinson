CREATE DATABASE TecnoStore;
USE TecnoStore;

drop database TecnoStore;

CREATE TABLE celulares (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    sistema_operativo VARCHAR(20) NOT NULL,
    categoriaGama VARCHAR(20) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    identificacion VARCHAR(20) NOT NULL UNIQUE,
    correo VARCHAR(100),
    telefono VARCHAR(20)
);

CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha DATETIME NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

CREATE TABLE detalle_ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_celular INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES ventas(id),
    FOREIGN KEY (id_celular) REFERENCES celulares(id)
);

-- Datos de Prueba

INSERT INTO clientes (nombre, identificacion, correo, telefono) VALUES
('Juan Pérez', '1001234567', 'juan.perez@gmail.com', '3001234567'),
('María Gómez', '1007654321', 'maria.gomez@hotmail.com', '3019876543'),
('Carlos Rodríguez', '1011122233', 'carlos.rodriguez@gmail.com', '3024567890'),
('Laura Martínez', '1022233344', 'laura.martinez@yahoo.com', '3036547891'),
('Andrés Torres', '1033344455', 'andres.torres@gmail.com', '3047891234'),
('Camila Herrera', '1044455566', 'camila.herrera@hotmail.com', '3053219876'),
('Santiago López', '1055566677', 'santiago.lopez@gmail.com', '3068527419'),
('Valentina Rojas', '1066677788', 'valentina.rojas@gmail.com', '3071597538');

INSERT INTO celulares (marca, modelo, sistema_operativo, categoriaGama, precio, stock) VALUES
('Samsung', 'Galaxy S23', 'Android', 'Alta', 4200000.00, 10),
('Samsung', 'Galaxy A54', 'Android', 'Media', 1800000.00, 15),
('Apple', 'iPhone 15', 'iOS', 'Alta', 5200000.00, 5),
('Apple', 'iPhone 13', 'iOS', 'Media', 3500000.00, 12),
('Xiaomi', 'Redmi Note 12', 'Android', 'Media', 1200000.00, 20),
('Motorola', 'Moto G84', 'Android', 'Media', 1100000.00, 18),
('Huawei', 'P50 Pro', 'Android', 'Alta', 3900000.00, 4),
('Realme', 'Realme C55', 'Android', 'Baja', 800000.00, 25),
('Oppo', 'Oppo Reno 10', 'Android', 'Alta', 3000000.00, 3),
('Honor', 'Honor X8', 'Android', 'Media', 950000.00, 14);


SELECT * FROM ventas;
SELECT * FROM detalle_ventas;
SELECT user, host FROM mysql.user;
SELECT * FROM celulares;
