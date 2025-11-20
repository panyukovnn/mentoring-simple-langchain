package ru.panyukovnn.simpleaiworkflow;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = { CalculatorTool.class })
public interface SimpleAgentService {

    @SystemMessage("Ты полезный ассистент. Отвечай кратко и по делу. Если для точности нужен расчет или текущее время — используй соответствующие инструменты.")
    String chat(@UserMessage String userMessage);
}
