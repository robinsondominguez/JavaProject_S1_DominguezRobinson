### Proyecto TecnoStore
### Grupo: S1
### Lenguaje: Java
### Estudiante: Robinson Dominguez Ulloa
## Profesor: David


## Ubicacion: Cajasan, Campuslands
### Ciudad: Bucaramanga
### Fecha: 2026

# Descripcion del projecto

El objetivo de este proyecto es desarrollar un sistema de consola en Java para la empresa TecnoStore, con el fin de automatizar la gestión de ventas, inventario y clientes.

Actualmente, la empresa maneja sus registros de manera manual mediante hojas de cálculo, lo que puede generar errores, pérdida de información y dificultades en el control del stock y las ventas.
Por ello, el sistema busca optimizar estos procesos mediante una solución digital.

El programa permitirá:

- Registrar y administrar el catálogo de celulares.

- Gestionar la información de los clientes.

- Registrar ventas y calcular automáticamente el total con IVA.

- Actualizar el inventario al realizar una venta.

- Generar reportes de ventas e inventario.

Además, el proyecto aplica principios de Programación Orientada a Objetos (POO), uso de colecciones y Stream API, manejo de excepciones, conexión a base de datos con JDBC y organización del código mediante una estructura por capas, simulando buenas prácticas de desarrollo profesional.

De esta manera, el sistema proporciona una solución más organizada, segura y eficiente para la gestión de la tienda TecnoStore.

## Estructura del projecto
```
📁 src
└── main
    └── java
        ├──📁 Controlador
        |   ├── Conexion.java
        |   ├── GestionCelulares.java
        |   ├── GestionCelularesDAO.java
        |   ├── GestionClientes.java
        |   ├── GestionClientesDAO.java
        |   ├── GestionReportes.java
        |   ├── GestionReportesDAO.java
        |   ├── GestionVentas.java
        |   ├── GestionReportesDAO.java
        |   └── GmailValidation.java
        ├──📁 Modelo
        |   ├── Celular.java
        |   ├── Cliente.java
        |   └── Venta.java
        └──📁 Vista
            ├── Main.java
            ├── MainCelulares.java
            ├── MainClientes.java
            ├── MainReportes.java
            └── MainVentas.java
```

## Descripcion Rapida
En la carpeta principal Main(Java), se encontraran 3 Carpetas, aplicando el modelo **MVC** (Modelo, Vista, Controlador).
Este Modelo tiene como objetivo que cada archivo sea clasificado sea su objetivo.

El archivo **Modelo**, Tiene como proposito crear el **cuerpo** de los objetos o entidades que vayamos a utilizar.
Se usa para hacer funciones, retornos, comparaciones, creaciones, **comer digitalmente**, lo que usted necesites.

El archivo **Controlador**, es el que va a utilizar el modelo, es como el padre y el madre, para conformar una familia necesitan ambos + un hijo (Vista).
este tiene como objetivo el funcionamiento y logica de cada cosa que se vaya a diseñar.

El archivo **Vista** Tiene como proposito el acceso e intersacion del usuario con las opciones que la aplicacion puede ofrecer, Es como un menu de **Comida** que te muestra que platos puedes ordenar.

## Ejemplos.
**Vista**<br>
![](https://drive.google.com/file/d/1qHLc5XuhH27E9GLujCRa9kvYtkw53L9w/view?usp=drive_link)
**Controlador**<br>
![](https://drive.google.com/file/d/1StLeX-zhgHU09kZWR0ncARMYezeKTnBA/view?usp=drive_link)
**Modelo**<br>
![](https://drive.google.com/file/d/1Y65A6VeRfdmLERslNK4s0NbNWIm48SAV/view?usp=drive_link)

## Base de datos
Para la base de datos se ha utilizado MySQL, con su plataforma de MySQL WorkBench.
### Por Que?
MySQL Es una base de datos relativamente facil de usar y mantener, pero no le quita que tiene un potencial para ser usado en projectos pequeños - medianos.<br> Aunque no es muy recomendable en projectos Gigantes.
De igual fomra es buena opcion por su gran variedad de opciones y Funciones.

## Grafica
![](https://drive.google.com/file/d/1cB-cun1jvCAfk8RcImQsbZKzwXYnfW8Y/view?usp=drive_link)

# Como Usar Cada Opcion

Comenzaremos por el Vista. El Vista tiene 4 opciones:

- **Gestionar Celulares**

- **Gestionar Clientes**

- **Gestionar Ventas**

- **Generar Reporte (Gestionar Reporte)**

- **Salir**

Cada opcion le mandara a otra Vista(**Sonidos de Confeti**), pero en estas vistas habran mas opciones mas especificas, Vamos a ir por unas de ellas.

### Gestionar Celulares
![](./img/Gestion%20Celulares.png)

Gestionar Celulares, tiene 5 opciones (Tecnicamente 4, la 5 obviamente debe estar si o si), las cuales cada una tiene un objetivo diferente.

## Registrar Celular
Su funcion sera el de registrar un celular, este pedira el marca, modelo, sistema, precio, stock. para guardar y enviarselo todo a la base de datos.

## Eliminar Celular
Su funcion sera el de Eliminar un celular en especifico, la forma en que lo hace es por su id.

## Actualizar Celular
Su funcion sera el de Actualizar un celular por su id, es como el anterior pero en vez de eliminar este actualizar los campos stock y precios(No hay mucha libertad).

## Listar Celular
Su funcion sera el de Lanzar una lista con todos los celulares existentes.

### Gestion Clientes
![](./img/Gestion%20Clientes.png)

Gestion Clientes, tristemente solo tiene una opcion la cual es registrar un cliente y buscar.

## Registrar Cliente
Su funcion sera el de registrar un cliente, este pedira el nombre, identificacion, correo y el telefono para guardar y enviarselo todo a la base de datos.

## Buscar Cliente
Su funcion sera el de Buscar un Cliente en especifico, la forma en que lo hace es por su id.

### Gestionar Ventas
![](./img/Gestion%20Ventas.png)

Gestionar Ventas, tiene 3 opciones las cuales cada una tiene un objetivo diferente.

## Registrar Venta
Su funcion sera el de registrar una venta, este pedira el id del cliente que realizara la venta para despues preguntarle cuantas veces va a comprar, hay al finalizar se verifica si hay stock, suma el iva a TODOS los celulares involucrados, y se registrara la venta para despues

## Ver Reporte
Lanza una lista con todas las ventas registradas, simplemente mostrara la persona, cuanto compro, y cuanto le costo.

## Listar Ventas
Practicamente se me colo esta funcion, es practicamente lo mismo que el de Ver Reporte, solo que lo olvide y se quedo hay.

### Gestion Reporte
![](./img/Gestion%20Reportes.png)

Gestion Reporte, tiene unicamente 2 opciones las cuales cada una tiene un objetivo diferente.

## Listar Stock Bajo
Su funcion sera el de Listar los celulares en los cuales cumplan el requisito de tener menos de 5 en stock si tiene mas no se imprimara.

## Generar Reporte (.txt)
Su funcion sera el de generar un reporte un poco mas detallado, en el cual Se obtendra la persona, y esa persona se le mostrara lo que ha comprado, este añade la fecha en que realizo la compra.

# Tablas de la Base de datos (MySQL)
```sql
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
```
## Datos de Prueba
```sql
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
```
