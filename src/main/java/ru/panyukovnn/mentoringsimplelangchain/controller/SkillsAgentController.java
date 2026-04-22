package ru.panyukovnn.mentoringsimplelangchain.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import ru.panyukovnn.mentoringsimplelangchain.agent.SkillsAgentService;

@Path("/ai-skills")
@ApplicationScoped
public class SkillsAgentController {

    @Inject
    SkillsAgentService agent;

    @GET
    public String chat(@QueryParam("q") String q) {
        return agent.chat("skills-chat-memory-id", q);
    }
}