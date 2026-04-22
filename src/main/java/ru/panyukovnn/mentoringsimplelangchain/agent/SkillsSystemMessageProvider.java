package ru.panyukovnn.mentoringsimplelangchain.agent;

import io.quarkiverse.langchain4j.runtime.aiservice.SystemMessageProvider;
import io.quarkiverse.langchain4j.skills.runtime.SkillsToolProvider;
import jakarta.enterprise.inject.spi.CDI;

import java.util.Optional;

public class SkillsSystemMessageProvider implements SystemMessageProvider {

    @Override
    public Optional<String> getSystemMessage(Object memoryId) {
        SkillsToolProvider skillsToolProvider = CDI.current().select(SkillsToolProvider.class).get();
        String skillsDescription = skillsToolProvider.getSkills().formatAvailableSkills();

        return Optional.of("""
                Ты полезный ассистент. Отвечай на русском языке.

                %s
                """.formatted(skillsDescription));
    }
}