
### Запуск приложения

```shell
 ./gradlew quarkusDev -Dquarkus.profile=localdev
```

в application-localdev.yml должен быть задан ключ для llm 

### Пример вызова

Русский ввод с автоматическим URL-кодированием параметра `q`:

```shell
curl --get --data-urlencode "q=Сложи 436 + 79563, для сложения используй CalculatorTool" http://localhost:8080/ai
```

