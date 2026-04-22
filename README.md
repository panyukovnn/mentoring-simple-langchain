# Mentoring Quarkus Langchain Tools Demo

Простой проект для демонстрации работы tools и skills в LLM (Quarkus + LangChain4j + DeepSeek).

## Пример вызова tools

```shell
curl --get --data-urlencode "q=Сложи 436 + 79563, для сложения используй tool" http://localhost:8081/ai-tools
```

```shell
curl --get --data-urlencode "q=Вычти из результата 5432, для вычитания используй tool" http://localhost:8081/ai-tools
```

## Пример вызова skills

```shell
curl --get --data-urlencode "q=Напиши стихотворение о весне" http://localhost:8081/ai-skills
```