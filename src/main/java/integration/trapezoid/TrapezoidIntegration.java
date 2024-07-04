package integration.trapezoid;

import java.util.function.Function;

//todo rename class on paste to platform!!!
public class TrapezoidIntegration {
    public static Float trapezoidIntegration(Function<Float, Float> func, Float a, Float b, Integer n) {
        float width = (b - a) / n;
        float totalArea = 0.5f * (func.apply(a) + func.apply(b));
        for (int i = 1; i < n; i++) {
            float x = a + i * width;
            totalArea += func.apply(x);
        }
        totalArea *= width;
        return totalArea;
    }
}
