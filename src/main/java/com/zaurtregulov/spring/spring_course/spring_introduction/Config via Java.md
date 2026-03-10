# Конфигурация с помощью Java кода

## Способ 1
Создать класс MyConfig. И прописать две аннотации.
@Configuration - означает, что данный класс является конфигурацией.
@ComponentScan - показываем какой пакет нужно сканировать на наличие бинов и аннотаций.

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("package")
public class MyConfig {}
```
```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
```

## Способ 2
Все бины и DI описываются внутри класса конфигурации. @Component не нужны.
Данный способ не использует аннотацию @Autowired. Все зависимости прописываются вручную.
Название метода - это bean id.
Аннотация @Bean перехватывает все обращения к бину и управляет его созданием.

```java
import com.zaurtregulov.spring.spring_course.spring_introduction.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }
}
```

# @PropertySource
Для того чтобы работали аннотации @Value необходимо в MyConfig добавить аннотацию @PropertySource.
@PropertySource - указывает на файл property.

```java
import org.springframework.beans.factory.annotation.Value;

@Value("${person.surname}")
private String surname;
```

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myApp.properties")
public class MyConfig {}
```