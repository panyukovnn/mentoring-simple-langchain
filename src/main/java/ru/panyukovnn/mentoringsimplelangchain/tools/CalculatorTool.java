package ru.panyukovnn.mentoringsimplelangchain.tools;

import dev.langchain4j.agent.tool.Tool;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorTool {

    @Tool("Сложение двух чисел")
    public double sum(double a, double b) {
        Log.infof("Вызвана инструмент sum с параметрами %s и %s", a, b);

        return a + b;
    }

    @Tool("Вычитание двух чисел")
    public double subtract(double a, double b) {
        Log.infof("Вызван инструмент subtract с параметрами %s и %s", a, b);

        return a - b;
    }
}
