package ru.panyukovnn.mentoringsimplelangchain.config;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ChatMemoryBean implements ChatMemoryProvider {

    private final InMemoryChatMemoryStore store = new InMemoryChatMemoryStore();

    @Override
    public ChatMemory get(Object memoryId) {
        return new PersistentChatMemory(MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(20)
                .chatMemoryStore(store)
                .build());
    }

    /**
     * Wraps MessageWindowChatMemory and makes clear() a no-op.
     * <p>
     * Quarkus creates AI services as @RequestScoped beans. At the end of each request,
     * QuarkusAiServiceContext.close() calls clearChatMemory(), which wipes all chat memory.
     * By suppressing clear(), messages stored in InMemoryChatMemoryStore persist across requests.
     */
    private static class PersistentChatMemory implements ChatMemory {
        private final ChatMemory delegate;

        PersistentChatMemory(ChatMemory delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object id() {
            return delegate.id();
        }

        @Override
        public void add(ChatMessage message) {
            delegate.add(message);
        }

        @Override
        public List<ChatMessage> messages() {
            return delegate.messages();
        }

        @Override
        public void set(Iterable<ChatMessage> messages) {
            delegate.set(messages);
        }

        @Override
        public void clear() {
            // intentional no-op: Quarkus calls clear() on request end via
            // QuarkusAiServiceContext.close() -> clearChatMemory(), which would erase
            // all conversation history. We suppress this to keep memory persistent.
        }
    }
}
