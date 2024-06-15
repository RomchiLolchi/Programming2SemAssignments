package integration.montecarlo;

import calculators.Calculator;

import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloIntegration {
    public double monteCarloIntegration(Calculator calculator, double bottomEdge, double topEdge, int stepCount) {
        double sumY = 0;
        for (int i = 0; i < stepCount; i++) {
            sumY += calculator.func(ThreadLocalRandom.current().nextDouble(bottomEdge, topEdge));
        }
        return (topEdge - bottomEdge) * sumY / stepCount;
    }
}