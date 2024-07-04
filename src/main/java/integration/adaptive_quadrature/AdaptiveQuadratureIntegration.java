package integration.adaptive_quadrature;

import integration.rectangle.RectangleIntegration;

import java.util.function.Function;

//todo rename class on paste to platform!!!
public class AdaptiveQuadratureIntegration {
    @FunctionalInterface
    public interface Function4<Function, A, B, N, Result> {
        Result apply(Function function, A a, B b, N n);
    }

    public static class RectangleIntegrationFunction implements Function4<Function<Float, Float>, Float, Float, Integer, Float> {

        @Override
        public Float apply(Function<Float, Float> func, Float a, Float b, Integer n) {
            return RectangleIntegration.rectangleIntegration(func, a, b, n);
        }
    }

    public static Float adaptiveIntegration(Function4<Function<Float, Float>, Float, Float, Integer, Float> integrationFunc, Function<Float, Float> func, Float a, Float b, Float tol) {
        float mid = (a + b) / 2;
        float basicTrap = integrationFunc.apply(func, a, b, 1);
        float refinedTrap = integrationFunc.apply(func, a, mid, 1) + integrationFunc.apply(func, mid, b, 1);

        if (Math.abs(refinedTrap - basicTrap) < 3 * tol) {
            return refinedTrap;
        } else {
            double leftIntegral = adaptiveIntegration(integrationFunc, func, a, mid, tol / 2);
            double rightIntegral = adaptiveIntegration(integrationFunc, func, mid, b, tol / 2);
            return (float) (leftIntegral + rightIntegral);
        }
    }
}
