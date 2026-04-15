package ru.panyukovnn.mentoringsimplelangchain.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;
import ru.panyukovnn.mentoringsimplelangchain.tools.CalculatorTool;

@RegisterAiService
public interface SimpleAgentService {

    @ToolBox(CalculatorTool.class)
    @SystemMessage("Ты полезный ассистент. Отвечай кратко и по делу")
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}
