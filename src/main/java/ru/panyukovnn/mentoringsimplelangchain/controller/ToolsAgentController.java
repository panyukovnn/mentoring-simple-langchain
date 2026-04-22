package ru.panyukovnn.mentoringsimplelangchain.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import ru.panyukovnn.mentoringsimplelangchain.agent.ToolsAgentService;

@Path("/ai-tools")
@ApplicationScoped
public class ToolsAgentController {

    @Inject
    ToolsAgentService agent;

    @GET
    public String chat(@QueryParam("q") String q) {
        return agent.chat("tools-chat-memory-id", q);
    }
}
