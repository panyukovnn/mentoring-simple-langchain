package ru.panyukovnn.mentoringsimplelangchain;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = { CalculatorTool.class })
public interface SimpleAgentService {

    @SystemMessage("Ты полезный ассистент. Отвечай кратко и по делу. Если для точности нужно рассчитать сумму чисел, то используй соответствующие инструменты.")
    String chat(@UserMessage String userMessage);
}
