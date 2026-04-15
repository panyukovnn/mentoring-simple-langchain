package ru.panyukovnn.mentoringsimplelangchain.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import ru.panyukovnn.mentoringsimplelangchain.agent.SimpleAgentService;

@Path("/ai")
@ApplicationScoped
public class AgentController {

    @Inject
    SimpleAgentService agent;

    @GET
    public String chat(@QueryParam("q") String q, @QueryParam("sessionId") String sessionId) {
        String memory = sessionId == null || sessionId.isBlank()
            ? "default"
            : sessionId;

        return agent.chat(memory, q);
    }
}
