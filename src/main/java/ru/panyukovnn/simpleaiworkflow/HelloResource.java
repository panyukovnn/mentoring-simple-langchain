package ru.panyukovnn.simpleaiworkflow;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/ai")
@ApplicationScoped
public class HelloResource {

    @Inject
    SimpleAgentService agent;

    @GET
    public String chat(@QueryParam("q") String q) {
        return agent.chat(q == null || q.isBlank() ? "Привет!" : q);
    }
}
