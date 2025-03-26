# Аннотация `@RestController` в Spring

## Описание
Аннотация `@RestController` в Spring — это специализированная версия `@Controller`, объединяющая её с `@ResponseBody`. Она упрощает создание RESTful веб-сервисов, автоматически сериализуя возвращаемые объекты в JSON или XML без необходимости аннотировать каждый метод `@ResponseBody`.

## Исходный код аннотации
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController {

    @AliasFor(annotation = Controller.class)
    String value() default "";
}
```

## Разбор кода

### 1. Наследование от `@Controller`
Аннотация `@RestController` содержит `@Controller`, что делает её Spring-компонентом и позволяет регистрировать классы с этой аннотацией как контроллеры в контексте Spring.

### 2. Автоматическое применение `@ResponseBody`
Добавление `@ResponseBody` означает, что все методы контроллера автоматически сериализуют возвращаемый объект в HTTP-ответ (обычно JSON или XML). Это избавляет от необходимости вручную помечать каждый метод `@ResponseBody`.

### 3. `@AliasFor(annotation = Controller.class)`
Атрибут `value()` в `@RestController` является алиасом для `value()` аннотации `@Controller`, что позволяет задавать имя компонента (Spring Bean) для контроллера при его регистрации.

## Применение

### Без `@RestController`
```java
@Controller
public class MyController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

### С `@RestController`
```java
@RestController
public class MyController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

Как видно, `@RestController` устраняет необходимость в `@ResponseBody` на каждом методе.

## Вывод
Аннотация `@RestController` предназначена для создания RESTful API в Spring. Она объединяет `@Controller` и `@ResponseBody`, упрощая разработку контроллеров, где все методы автоматически сериализуют ответ в JSON/XML. Это делает код чище и удобнее для работы с REST API.