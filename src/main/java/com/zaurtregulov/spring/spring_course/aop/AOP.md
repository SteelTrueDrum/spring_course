# Aspect Oriented Programming (AOP)
Аспектно-ориентировное программирование (АОП)
парадигма программирования, основанная на идее разделения основного и служебного функционала.
Служебный функционал записывается в Aspect-классы.
В основе Aspect заключена сквозная логика (cross-cutting logic).

*Code tangling* - Переплетение бизнес-логики со служебным функционалом.
*Code scattering* - Разбросанность служебного функционала по всему проекту.

К сквозному функционалу относят:
- логирование
- проверка прав
- обработка транзакций
- обработка исключений
- кэширование

AOP frameworks:
- Spring AOP
- AspectJ

Помечаем класс конфигурации аннотацией @EnableAspectJAutoProxy,
затем создаем класс Аспекта и помечаем его аннотацией @Aspect.

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy
public class MyConfig {}
```

## Advice
Метод, который находится в Aspect-классе (сквозная логика) и определяет, что должно произойти.
## Advice типы
- Before - выполняется до метода основной логики
- After returning - только после нормального окончания метода основной логики
- After throwing - только если было выброшено исключение
- After / After finally - выполняется после окончания метода основной логики
- Around - до и после метода основной логики

## Pointcut
Выражение, описывающее где должен быть применен Advice.

Spring AOP использует **AspectJ Pointcut expression language**.

Шаблон Pointcut:
**execution(** modifiers-pattern? **return-type-pattern** declaring-type-pattern?)
**method-name-pattern(parameters-pattern)** throws-pattern? **)**

Пример: 
- @Before("execution(public void getBook())") → из любого класса с таким методом
- @Before("execution(public void aop.Library.getBook())") → (из конкретного класса Library)
- @Before("execution(public void get*())") → (любой класс метод начинающийся с "get...")
- @Before("execution(public * returnBook())") -> метод с любым возвращаемым типом.
- @Before("execution(* *())") → метод без параметров с любым возвращаемым типом и именем.