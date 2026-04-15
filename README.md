
# Mentoring Quarkus Langchain Tools Demo

Простой проект для демонстрации работы tools в LLM

### Пример вызова

Русский ввод с автоматическим URL-кодированием параметра `q`:

```shell
curl --get --data-urlencode "q=Сложи 436 + 79563, для сложения используй tool" http://localhost:8080/ai
```

```shell
curl --get --data-urlencode "q=Вычти из результата 5432, для вычитания используй tool" http://localhost:8080/ai
```

