package ru.panyukovnn.mentoringsimplelangchain.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(systemMessageProviderSupplier = SkillsSystemMessageProvider.class)
public interface SkillsAgentService {

    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}