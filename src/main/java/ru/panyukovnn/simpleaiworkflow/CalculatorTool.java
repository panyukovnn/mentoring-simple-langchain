package ru.panyukovnn.simpleaiworkflow;

import dev.langchain4j.agent.tool.Tool;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorTool {

    @Tool("Сложить два числа")
    public double add(double a, double b) {
        Log.infof("Вызвана утилита CalculatorTool с параметрами %s и %s", a, b);

        return a + b;
    }
}
