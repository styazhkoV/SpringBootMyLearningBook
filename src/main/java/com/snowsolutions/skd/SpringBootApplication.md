# Аннотация `@SpringBootApplication` в Spring Boot

Аннотация `@SpringBootApplication` — это составная (мета-аннотация) из Spring Boot, которая объединяет три ключевые аннотации:

1. **`@SpringBootConfiguration`** — эквивалент `@Configuration`, указывает, что этот класс содержит определения бинов Spring.
2. **`@EnableAutoConfiguration`** — включает механизм автоконфигурации Spring Boot, который автоматически настраивает бины, базы данных, веб-серверы и другие компоненты на основе зависимостей.
3. **`@ComponentScan`** — включает сканирование компонентов в указанных пакетах и их подкаталогах, чтобы автоматически регистрировать `@Component`, `@Service`, `@Repository`, `@Controller` и другие бины.

## Разбор кода аннотации

### 1. **Мета-аннотации**
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
```
- `@Target(ElementType.TYPE)` — аннотацию можно применять только к классам.
- `@Retention(RetentionPolicy.RUNTIME)` — аннотация доступна во время выполнения через Reflection API.
- `@Documented` — аннотация будет включена в JavaDoc.
- `@Inherited` — позволяет подклассам унаследовать аннотацию.

### 2. **Ключевые аннотации внутри**
```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(...)
```
- `@SpringBootConfiguration` делает класс конфигурационным.
- `@EnableAutoConfiguration` автоматически подключает нужные бины на основе зависимостей.
- `@ComponentScan(...)` сканирует классы и загружает их в контекст Spring.

### 3. **Параметры аннотации**
```java
@AliasFor(annotation = EnableAutoConfiguration.class)
Class<?>[] exclude() default {};
```
- Позволяет исключить классы из автоконфигурации.

```java
@AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
String[] scanBasePackages() default {};
```
- Позволяет указать пакеты, в которых искать компоненты.

```java
@AliasFor(annotation = Configuration.class)
boolean proxyBeanMethods() default true;
```
- Управляет проксированием `@Bean` методов, чтобы обеспечить Singleton-семантику.

## Итог
`@SpringBootApplication` — это сокращённая запись для конфигурации Spring Boot-приложений, которая автоматически включает автоконфигурацию, сканирование компонентов и определение бинов.