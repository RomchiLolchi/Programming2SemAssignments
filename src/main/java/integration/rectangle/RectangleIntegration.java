package integration.rectangle;

import java.util.function.Function;

//todo rename class on paste to platform!!!
public class RectangleIntegration {
    public static Float rectangleIntegration(Function<Float, Float> func, Float a, Float b, Integer n) {
        Float width = (b - a) / n;
        float totalArea = 0.0f;
        for (int i = 0; i < n; i++) {
            Float x = a + i * width;
            totalArea += func.apply(x) * width;
        }
        return totalArea;
    }
}
