# Hibernate

## Аннотации
### @Entity 
Entity класс - это POJO класс, который отображает информацию определенной таблицы в БД.
POJO - private поля, getters & setters, конструктор без аргументов.

### @Table 
@Table - помечает к какой именно таблице привязываем класс.

### @Column
@Column - помечает к какому столбцу таблицы привязывается поле класса.

### @Id
@Id - помечает поле, соответствующее столбцу таблицы, который является Primary Key.

## SessionFactory (Фабрика по производству сессий)
SessionFactory читает файл ***hibernate.cfg.xml***.

### Session 
Обертка вокруг подключения к БД с помощью JDBC

## Primary Key
Содержит уникальное значение и не может быть NULL

@GeneratedValue - описывает стратегию генерации для столбца Primary Key;
- GenerationType.IDENTITY - полагается на автоматическое увеличение столбца по правилам БД;
- GenerationType.SEQUENCE - полагается на работу Sequence в БД (Oracle DB);
- GenerationType.TABLE - полагается на значение столбца таблицы (счетчик внутри таблицы);
- GenerationType.AUTO (default) - зависит от типа БД;

```java
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;
```
# HQL
Hibernate Query Language

```java
    // SELECT
    List<Employee> emps = session.createQuery("FROM Employee").getResultList();
    List<Employee> emps2 = session.createQuery("FROM Employee " + "WHERE name = 'Anton'").getResultList();

    // UPDATE
    Employee employee = session.get(Employee.class, 1);
    employee.setSalary(42500);
```
