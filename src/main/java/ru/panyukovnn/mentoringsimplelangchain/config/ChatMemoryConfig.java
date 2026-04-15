package ru.panyukovnn.mentoringsimplelangchain.config;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

@ApplicationScoped
public class ChatMemoryConfig {

    @Produces
    @Singleton
    public ChatMemoryProvider chatMemoryProvider() {
        InMemoryChatMemoryStore store = new InMemoryChatMemoryStore();

        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(20)
                .chatMemoryStore(store)
                .build();
    }
}