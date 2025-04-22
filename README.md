# EduSpring: Hibernate + H2 + Unit & Integration Tests

Этот проект представляет собой **Spring Boot-приложение**, использующее **Hibernate** для работы с базой данных и поддерживающее **Unit и интеграционные тесты** (JUnit 5 и Mockito).

---

##  **Запуск проекта**

### 1. **Компиляция проекта**
Выполните команду:
```bash
mvn clean install
```
Она соберёт проект, скомпилирует код и подготовит зависимости.

### 2. **Запуск приложения**
После успешной компиляции можно запустить приложение командой:
```bash
mvn spring-boot:run
```
Это стартует **Spring Boot** и подключит базу H2.

### 3. **Запуск всех тестов (юнит + интеграционные)**
Чтобы проверить работоспособность приложения, запустите все тесты:
```bash
mvn verify
```
Эта команда выполнит **JUnit-тесты и интеграционные тесты**.

---

## **Зависимости**

Основные зависимости, указанные в `pom.xml`:
- **Spring Boot** (`spring-boot-starter`)
- **Hibernate ORM** (`hibernate-core`)
- **H2 Database** (`com.h2database:h2`)
- **JUnit 5** (`junit-jupiter`)
- **Mockito** (`mockito-core`)
- **Maven Surefire & Failsafe** (для запуска тестов)

---

## **Настройки Hibernate**

Конфигурация хранится в `hibernate.cfg.xml`:

```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">org.h2.Driver</property>
        <property name="hibernate.connection.url">jdbc:h2:mem:testdb</property>
        <property name="hibernate.connection.username">sa</property>
        <property name="hibernate.connection.password"></property>
        <property name="hibernate.dialect">org.hibernate.dialect.H2Dialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>

        <mapping class="com.example.edu_spring.model.User"/> <!-- Маппинг сущности -->
    </session-factory>
</hibernate-configuration>
```
Эта конфигурация создаёт базу **H2 в памяти** (`mem:testdb`) и автоматически обновляет схему (`hbm2ddl.auto=update`).

---

## **Переключение на PostgreSQL**

### 1. **Добавление зависимости**
В `pom.xml` добавьте:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.5.4</version>
</dependency>
```

### 2. **Настройки Hibernate для PostgreSQL**
В `hibernate.cfg.xml` замените параметры на:
```xml
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/mydb</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">password</property>
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
<property name="hibernate.hbm2ddl.auto">update</property>
```

### 3. **Запуск PostgreSQL**
Если PostgreSQL ещё не запущен, стартуйте контейнер через `Docker`:
```bash
docker run --name postgres -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres
```
Или настройте базу вручную через **pgAdmin**.

---