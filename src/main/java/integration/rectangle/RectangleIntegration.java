package integration.rectangle;

import calculators.Calculator;

public class RectangleIntegration {
    public double rectangleIntegration(Calculator calculator, double bottomEdge, double topEdge, int stepCount) {
        double width = (topEdge - bottomEdge) / stepCount;
        double totalArea = 0.0;
        for (int i = 0; i < stepCount; i++) {
            double x = bottomEdge + i * width;
            totalArea += calculator.func(x) * width;
        }
        return totalArea;
    }
}
