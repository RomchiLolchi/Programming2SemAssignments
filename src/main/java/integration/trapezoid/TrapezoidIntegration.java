package integration.trapezoid;

import calculators.Calculator;

public class TrapezoidIntegration {
    public double trapezeIntegration(Calculator calculator, double bottomEdge, double topEdge, int stepCount) {
        double width = (topEdge - bottomEdge) / stepCount;
        double totalArea = 0.5 * (calculator.func(bottomEdge) + calculator.func(topEdge));
        for (int i = 1; i < stepCount; i++) {
            double x = bottomEdge + i * width;
            totalArea += calculator.func(x);
        }
        totalArea *= width;
        return totalArea;
    }
}
