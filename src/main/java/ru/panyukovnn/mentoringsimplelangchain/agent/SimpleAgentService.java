package ru.panyukovnn.mentoringsimplelangchain.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import ru.panyukovnn.mentoringsimplelangchain.tools.CalculatorTool;

@RegisterAiService(tools = { CalculatorTool.class })
public interface SimpleAgentService {

    @SystemMessage("Ты полезный ассистент. Отвечай кратко и по делу. Если для точности нужно выполнить математические расчеты, то используй соответствующие инструменты.")
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}
