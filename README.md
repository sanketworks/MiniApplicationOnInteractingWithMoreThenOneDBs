# BootJPAProj08 – Multi DB Interaction using Spring Boot

A Spring Boot JPA project demonstrating interaction with **multiple databases** in a single application.

This project uses:

* **Oracle Database** → Product module
* **MySQL Database** → Offers/Promotions module

The application configures separate:

* DataSources
* EntityManagerFactory
* TransactionManager
* Repository packages

for each database.

---

## 📌 Project Overview

This project shows how to connect one Spring Boot application with **two relational databases** and perform CRUD operations independently.

### Oracle DB

Stores:

* Product details

### MySQL DB

Stores:

* Promotional offers

The application inserts data into both databases using `CommandLineRunner`.

---

## 🛠 Tech Stack

| Technology      |  Version |
| --------------- | -------: |
| Java            |       21 |
| Spring Boot     |      3.x |
| Spring Data JPA |   Latest |
| Hibernate       |   Latest |
| Oracle DB       | 21c / XE |
| MySQL           |       8+ |
| Maven           |   Latest |
| Lombok          |   Latest |

---

## 📂 Project Structure

```bash
src/main/java
└── com.nt
    ├── BootJpaProj08MultiDbInteractionApplication.java
    │
    ├── config
    │   ├── OracleDBConfig.java
    │   └── MySQLDBConfig.java
    │
    ├── model
    │   ├── prod
    │   │   └── Product.java
    │   │
    │   └── promotions
    │       └── Offers.java
    │
    ├── repository
    │   ├── prod
    │   │   └── IProductRepository.java
    │   │
    │   └── promotions
    │       └── IOffersRepository.java
    │
    └── runners
        └── MultiDBTestRunner.java

src/main/resources
└── application.properties
```

---

## ⚙ Database Configuration

### application.properties

```properties
spring.application.name=BootJPAProj08-MultiDBInteraction

# Oracle DB
oracle.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
oracle.datasource.jdbc-url=jdbc:oracle:thin:@localhost:1521:orcl
oracle.datasource.username=system
oracle.datasource.password=Tiger501

# MySQL DB
mysql.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
mysql.datasource.jdbc-url=jdbc:mysql://localhost:3306/ntspbms718db
mysql.datasource.username=root
mysql.datasource.password=your-password
```

---

## Oracle Configuration

Configured in:

```text
OracleDBConfig.java
```

Contains:

* Oracle DataSource
* EntityManagerFactory
* JpaTransactionManager
* Repository scanning

Repository package:

```text
com.nt.repository.prod
```

Entity package:

```text
com.nt.model.prod
```

---

## MySQL Configuration

Configured in:

```text
MySQLDBConfig.java
```

Contains:

* MySQL DataSource
* EntityManagerFactory
* JpaTransactionManager
* Repository scanning

Repository package:

```text
com.nt.repository.promotions
```

Entity package:

```text
com.nt.model.promotions
```

---

## Entities

### Product (Oracle)

Table:

```sql
MULTI_DB_PRODUCT
```

Fields:

* pid
* pname
* price
* qty
* vendor

Example:

```java
Product prod =
        new Product(
            "Table",
            50000.0,
            10.0,
            "IKEA");
```

---

### Offers (MySQL)

Table:

```sql
MULTI_DB_OFFERS
```

Fields:

* offerId
* offerName
* offerCode
* discountPercentage
* expiryDate

Example:

```java
Offers offers =
        new Offers(
            "Janmastami",
            "JS-108",
            10.0f,
            LocalDateTime.now());
```

---

## Runner Class

### MultiDBTestRunner

Runs automatically on application startup.

Actions:

### Save Product into Oracle

```java
productRepo.save(prod);
```

### Save Offer into MySQL

```java
offersRepo.save(offers);
```

---

## Sample Console Output

```text
Product is saved with the id value :: 1
===========================
Offers is saved with id value :: 10000
```

---

## Verify Data

### Oracle

```sql
SELECT * FROM MULTI_DB_PRODUCT;
```

### MySQL

```sql
SELECT * FROM MULTI_DB_OFFERS;
```

---

## Run Project

Clone repository

```bash
git clone https://github.com/your-username/BootJPAProj08-MultiDBInteraction.git
```

Move into project

```bash
cd BootJPAProj08-MultiDBInteraction
```

Build

```bash
mvn clean install
```

Run

```bash
mvn spring-boot:run
```

---

## Concepts Covered

✔ Multiple DataSources

✔ Spring Data JPA

✔ EntityManagerFactory

✔ Repository package separation

✔ TransactionManager configuration

✔ Oracle + MySQL integration

✔ Spring Boot auto startup runner

---

## Future Enhancements

* REST APIs
* CRUD operations
* Service layer
* Distributed transaction management (JTA / XA)
* Exception handling
* Swagger integration

---

## Author

Sanket Mishra

Java | Spring Boot | JPA | Hibernate

```
```
