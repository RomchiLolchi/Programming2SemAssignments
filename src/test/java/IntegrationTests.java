import integration.adaptive_quadrature.AdaptiveQuadratureIntegration;
import integration.montecarlo.MonteCarloIntegration;
import integration.rectangle.RectangleIntegration;
import integration.trapezoid.TrapezoidIntegration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTests {

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsProvider")
    void rectangleIntegrationTest(Function<Float, Float> function, float bottomEdge, float topEdge, int stepCount, float expected) {
        assertEquals(RectangleIntegration.rectangleIntegration(function, bottomEdge, topEdge, stepCount), expected, 0.01f);
    }

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsProvider")
    void trapezeIntegrationTest(Function<Float, Float> function, float bottomEdge, float topEdge, int stepCount, float expected) {
        assertEquals(TrapezoidIntegration.trapezoidIntegration(function, bottomEdge, topEdge, stepCount), expected, 0.01f);
    }

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsProvider")
    void monteCarloIntegrationTest(Function<Float, Float> function, float bottomEdge, float topEdge, int stepCount, float expected) {
        assertEquals(MonteCarloIntegration.monteCarloIntegration(function, bottomEdge, topEdge, stepCount), expected, 0.05f);
    }

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsWithAccuracyProvider")
    void adaptiveQuadratureIntegrationTest(Function<Float, Float> function, float bottomEdge, float topEdge, float accuracy, float expected) {
        assertEquals(AdaptiveQuadratureIntegration.adaptiveIntegration(new AdaptiveQuadratureIntegration.RectangleIntegrationFunction(), function, bottomEdge, topEdge, accuracy), expected, accuracy * 10f);
    }

    static Stream<Arguments> functionsAndIntegrationSpecsProvider() {
        return Stream.of(
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) Math.pow(x, 2)), 0f, 1f, 1000, 1/3f),
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) Math.sin(x)), 0f, (float) Math.PI, 1000, 2f),
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) (2 * Math.pow(x, 3) - 5 * Math.pow(x, 2) + Math.sin(x))), 0f, 1f, 1000, -0.7f),
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) Math.pow(Math.E, x)), 0f, 1f, 1000, (float) Math.E - 1)
        );
    }

    static Stream<Arguments> functionsAndIntegrationSpecsWithAccuracyProvider() {
        return Stream.of(
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) Math.pow(x, 2)), 0f, 1f, 0.01f, 1/3f),
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) Math.sin(x)), 0f, (float) Math.PI, 0.01f, 2f),
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) (2 * Math.pow(x, 3) - 5 * Math.pow(x, 2) + Math.sin(x))), 0f, 1f, 0.01f, -0.7f),
                Arguments.arguments(((Function<Float, Float>) (x) -> (float) Math.pow(Math.E, x)), 0f, 1f, 0.01f, (float) Math.E - 1)
        );
    }
}
