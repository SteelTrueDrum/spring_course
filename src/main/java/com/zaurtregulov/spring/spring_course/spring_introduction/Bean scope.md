# Bean scope
(область видимости)

- singleton
- prototype

- request
- session
- global-session

## Singleton
"Одиночка" - default
- Создается сразу после прочтения контейнером конфиг файла
- является общим для всех кто запросит его у контейнера
- подходит для stateless объектов

## Prototype
- создается только после обращению к контейнеру (с помощью getBean())
- для каждого такого обращения создается новый бин
- подходит для stateful объектов


# Bean Lifecycle
Запуск - начало работы Container - создание бина - внедряются DI - **init-method** (выполняется при создании бина) -
используем бин - конец работы с Container - **destroy-method** (до завершения приложения) - остановка.

Чаще всего **init-method** используется для открытия или настройки ресурсов (БД, стримов)
**destroy-method** используется для их закрытия.

У данных методов access modifiers может быть любым.
У данных методов return type может быть любым, но т.к. нельзя использовать возвращаемое значение - используют void;
Название этих методов может быть любым.
В этих методов не должно быть параметров.

```
    <bean id="myPet"
          class="com.zaurtregulov.spring.spring_course.spring_introduction.Cat"
          init-method="init"
          destroy-method="destroy">
    </bean>
```
если scope=prototype:
init-method создается для каждого бина.
destroy-method не вызывается. Необходимо самому писать код для закрытия/освобождения ресурсов в бине.

## Установка Scope аннотацией

```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Dog {
}

@Component
@Scope("prototype")
public class Cat {}
```
## @PostConstruct и @PreDestroy 
Зависимость Javax Annotation API 1.3.2

```java
@PostConstruct
public void init() {}

@PreDestroy
public void destroy() {}
```
