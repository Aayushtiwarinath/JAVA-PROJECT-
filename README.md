# Student Management System (Spring MVC + Hibernate + MySQL)

## Mandatory features
- Front end  : Thymeleaf HTML pages + CSS (`templates/`, `static/`)
- Back end   : Spring Boot (Java 17)
- Database   : MySQL via JDBC (`application.properties`)
- CRUD       : Create, Read (+search), Update, Delete students

## Special features
- Java Bean  : `model/Student.java` (private fields, no-arg constructor, getters/setters, Serializable)
- Hibernate  : JPA entity + `JpaRepository` (Hibernate is the JPA provider)
- Spring MVC : `controller` -> `service` -> `repository` layered architecture
- Bonus      : Bean Validation (@NotBlank, @Email, @Min/@Max), duplicate-email check, search

## Architecture
Browser -> StudentController (MVC) -> StudentService -> StudentRepository (Hibernate) -> MySQL

## Run
Requirements: JDK 17+, Maven, MySQL running.
1. Edit DB username/password in `src/main/resources/application.properties`
2. `mvn spring-boot:run`
3. Open http://localhost:8080

No MySQL? Run with in-memory H2:
`mvn spring-boot:run -Dspring-boot.run.profiles=h2`
