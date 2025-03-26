# @RequestMapping в Spring

## Описание

`@RequestMapping` — это аннотация в Spring, которая используется для маппинга HTTP-запросов на методы или классы контроллера. Она позволяет задавать URL-адреса, HTTP-методы, заголовки, параметры и типы контента, принимаемые и возвращаемые методом.

Эта аннотация поддерживается как в Spring MVC, так и в Spring WebFlux, работая через `RequestMappingHandlerMapping` и `RequestMappingHandlerAdapter`.

## Исходный код

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
@Reflective(ControllerMappingReflectiveProcessor.class)
public @interface RequestMapping {
    String name() default "";
    @AliasFor("path") String[] value() default {};
    @AliasFor("value") String[] path() default {};
    RequestMethod[] method() default {};
    String[] params() default {};
    String[] headers() default {};
    String[] consumes() default {};
    String[] produces() default {};
}
```

## Атрибуты аннотации

### `value` и `path`

Определяет URL-путь, на который должен среагировать контроллер:
```java
@RequestMapping("/users")
public class UserController {}
```

### `method`

Ограничивает обработку запросов конкретными HTTP-методами:
```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
public List<User> getUsers() {
    return userService.getAllUsers();
}
```

### `params`

Фильтрует запросы по наличию и значению параметров:
```java
@RequestMapping(value = "/users", params = "active=true")
public List<User> getActiveUsers() {}
```

### `headers`

Позволяет задать заголовки запроса:
```java
@RequestMapping(value = "/users", headers = "X-API-KEY=12345")
public List<User> getUsersWithApiKey() {}
```

### `consumes`

Ограничивает обработку запросов по `Content-Type`:
```java
@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
public ResponseEntity<String> uploadFile(MultipartFile file) {}
```

### `produces`

Ограничивает обработку запросов по `Accept`:
```java
@RequestMapping(value = "/users", produces = "application/json")
public List<User> getUsersJson() {}
```

## Использование

### На уровне класса

```java
@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping("/status")
    public String getStatus() {
        return "OK";
    }
}
```

### На уровне метода

```java
@RestController
public class UserController {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
```

## Альтернативные аннотации

Spring предоставляет сокращённые версии `@RequestMapping` для конкретных HTTP-методов:
- `@GetMapping` — для `GET`
- `@PostMapping` — для `POST`
- `@PutMapping` — для `PUT`
- `@DeleteMapping` — для `DELETE`
- `@PatchMapping` — для `PATCH`

```java
@GetMapping("/users")
public List<User> getUsers() {}
```

## Ограничения и особенности

1. **Не может использоваться совместно с другими `@RequestMapping` на одном элементе**
2. **При использовании интерфейсов аннотации должны быть на интерфейсе, а не на классе**
3. **Поддерживает Ant-style шаблоны (`/users/**`) и плейсхолдеры (`/${user.path}`)**

## Вывод

Аннотация `@RequestMapping` — мощный инструмент в Spring MVC/WebFlux, позволяющий настраивать обработку запросов гибко и удобно. Однако в современных проектах рекомендуется использовать `@GetMapping`, `@PostMapping` и другие специализированные аннотации для упрощения кода.