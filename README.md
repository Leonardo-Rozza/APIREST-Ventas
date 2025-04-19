# VentasApp

**Api REST sobre ventas básicas.**  
Proyecto construido con Spring Boot, Java 21 y Maven.

---

## 📦 Tecnologías

- **Java 21**
- **Spring Boot 3.4.3** con:
    - Spring Web
    - Spring Data JPA
    - Spring Validation
    - Spring Boot DevTools
- **MySQL Connector/J** (runtime)
- **Lombok** (anotaciones)
- **MapStruct** (DTO ↔ entidad)
- **Maven** como gestor de dependencias y ciclo de vida

---

## 🚀 Requisitos

- Java 21 SDK
- Maven 3.6+
- Una base de datos MySQL corriendo (local o remota)

---

## ⬇️ Instalación

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Leonardo-Rozza/APIREST-Ventas.git
   cd APIREST-Ventas
   ```

2. Configurar el acceso a la base de datos en  
   `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ventasdb
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_CONTRASEÑA
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Construir el proyecto con Maven:
   ```bash
   mvn clean install
   ```

4. Arrancar la aplicación:
   ```bash
   mvn spring-boot:run
   ```
   Por defecto escuchará en `http://localhost:8080`.

---

## 🛠️ Endpoints

### Countries

| Método | Ruta                 | Descripción               |
| ------ | -------------------- | ------------------------- |
| GET    | `/api/countries`     | Listar todos los países   |
| GET    | `/api/countries/{id}`| Obtener país por ID       |
| POST   | `/api/countries`     | Crear un nuevo país       |
| PUT    | `/api/countries/{id}`| Actualizar país existente |
| DELETE | `/api/countries/{id}`| Eliminar país por ID      |

### Customers

| Método | Ruta                   | Descripción                 |
| ------ | ---------------------- | --------------------------- |
| GET    | `/api/customers`       | Listar todos los clientes   |
| GET    | `/api/customers/{id}`  | Obtener cliente por ID      |
| POST   | `/api/customers`       | Crear un nuevo cliente      |
| PUT    | `/api/customers/{id}`  | Actualizar cliente existente|
| DELETE | `/api/customers/{id}`  | Eliminar cliente por ID     |

### Products

| Método | Ruta                 | Descripción                 |
| ------ | -------------------- | --------------------------- |
| GET    | `/api/products`      | Listar todos los productos  |
| GET    | `/api/products/{id}` | Obtener producto por ID     |
| POST   | `/api/products`      | Crear un nuevo producto     |
| PUT    | `/api/products/{id}` | Actualizar producto existente |
| DELETE | `/api/products/{id}` | Eliminar producto por ID      |

### ProductForSale

| Método | Ruta                                 | Descripción                                |
| ------ | ------------------------------------ | ------------------------------------------ |
| GET    | `/api/productForSale`                | Listar todas las relaciones producto‑venta |
| GET    | `/api/productForSale/{id}`           | Obtener relación producto‑venta por ID     |
| GET    | `/api/productForSale/sale/{saleId}`  | Listar líneas de venta de una venta específica |
| GET    | `/api/productForSale/product/{productId}` | Listar líneas donde aparece un producto |
| POST   | `/api/productForSale`                | Agregar producto a una venta               |
| PUT    | `/api/productForSale/{id}`           | Actualizar cantidad en línea de venta      |
| DELETE | `/api/productForSale/{id}`           | Eliminar línea de venta por ID             |

### Sales

| Método | Ruta                            | Descripción                                       |
| ------ | ------------------------------- | ------------------------------------------------- |
| GET    | `/api/sales`                    | Listar todas las ventas                           |
| GET    | `/api/sales/{id}`               | Obtener venta por ID                              |
| GET    | `/api/sales/customer/{customerId}` | Listar ventas de un cliente (ID)               |
| GET    | `/api/sales/product/{productId}`   | Listar ventas donde se vendió un producto (ID) |
| POST   | `/api/sales`                    | Crear una nueva venta (devuelve ID)               |
| PUT    | `/api/sales/{id}`               | Actualizar una venta existente                   |
| DELETE | `/api/sales/{id}`               | Eliminar una venta por ID                         |

> Los detalles de validación y mapeo entre entidades y DTO's se implementan con MapStruct y `@Valid` en los controladores.

---

## 📖 Documentación y referencias

- Spring Boot Maven Plugin.
- Spring Web, Data JPA, Validation.
- MySQL Connector/J, Lombok, MapStruct.

---

