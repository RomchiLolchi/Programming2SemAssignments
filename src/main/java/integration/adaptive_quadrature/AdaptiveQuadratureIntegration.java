package integration.adaptive_quadrature;

import calculators.Calculator;
import integration.rectangle.RectangleIntegration;

public class AdaptiveQuadratureIntegration {
    public static final RectangleIntegration rectangleIntegration = new RectangleIntegration();

    public double adaptiveIntegration(Calculator calculator, double bottomEdge, double topEdge, double accuracy) {
        double mid = (bottomEdge + topEdge) / 2;
        double basicTrap = rectangleIntegration.rectangleIntegration(calculator, bottomEdge, topEdge, 1);
        double refinedTrap = rectangleIntegration.rectangleIntegration(calculator, bottomEdge, mid, 1) + rectangleIntegration.rectangleIntegration(calculator, mid, topEdge, 1);

        if (Math.abs(refinedTrap - basicTrap) < 3 * accuracy) {
            return refinedTrap;
        } else {
            double leftIntegral = adaptiveIntegration(calculator, bottomEdge, mid, accuracy/2);
            double rightIntegral = adaptiveIntegration(calculator, mid, topEdge, accuracy/2);
            return leftIntegral + rightIntegral;
        }
    }
}
