package integration.montecarlo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

//todo rename class on paste to platform!!!
public class MonteCarloIntegration {
    public static Float monteCarloIntegration(Function<Float, Float> func, Float a, Float b, Integer n) {
        float sumY = 0;
        for (int i = 0; i < n; i++) {
            sumY += func.apply(ThreadLocalRandom.current().nextFloat(a, b));
        }
        return (b - a) * sumY / n;
    }
}