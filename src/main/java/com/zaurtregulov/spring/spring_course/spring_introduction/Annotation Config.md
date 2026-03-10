# Аннотации

Два этапа:
1. Сканирование классов и поиск аннотации @Component
2. Создание (регистрация) бина в Spring Container

Если к аннотации @Component не прописать bean id, то бину будет назначен дефолтный id.
По умолчанию bean id получается из имени класса, заменяя его первую заглавную букву на прописную.
Cat -> cat;
FavoriteSong -> favoriteSong;
SQLTest -> SQLTest; (если 2 заглавных буквы подряд)


## @Autowired (для DI)
- конструктор
- сеттер (любой метод с параметром)
- поле (Field injection)

DI через @Autowired
1. Сканирование пакета, поиск класса с аннотацией @Component
2. При наличии аннотации @Autowired начинается поиск подходящего по типу бина
    - Если находится 1 подходящий бин - то внедрение зависимости
    - Если подходящих по типу бинов нет - исключение
    - Если подходящих бинов больше одного - исключение

Выбирать способ @Autowired DI можно любой, главное придерживаться одного типа в проекте.

## @Qualifier
Если при использовании @Autowired подходящих бинов больше одного.
 
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Autowired
@Qualifier("dog")
private Pet pet;

@Autowired
@Qualifier("dog")
public void setPet(Pet pet);

@Autowired
public Person(@Qualifier("dog") Pet pet) {}
```

## @Value
Для внедрения строк и значений.

добавить в контекст.xml <context:property-placeholder location="classpath:myApp.properties"/>

```java
@Value("Burdukov")
    private String surname;
@Value("${person.age}")
private int age;
```

