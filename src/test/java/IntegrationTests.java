import calculators.Exp4jCalculator;
import integration.adaptive_quadrature.AdaptiveQuadratureIntegration;
import integration.montecarlo.MonteCarloIntegration;
import integration.rectangle.RectangleIntegration;
import integration.trapezoid.TrapezoidIntegration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTests {

    private static final RectangleIntegration rectangleIntegration = new RectangleIntegration();
    private static final TrapezoidIntegration trapezoidIntegration = new TrapezoidIntegration();
    private static final MonteCarloIntegration monteCarloIntegration = new MonteCarloIntegration();
    private static final AdaptiveQuadratureIntegration adaptiveQuadratureIntegration = new AdaptiveQuadratureIntegration();

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsProvider")
    void rectangleIntegrationTest(String function, double bottomEdge, double topEdge, int stepCount, double expected) {
        assertEquals(rectangleIntegration.rectangleIntegration(new Exp4jCalculator(function), bottomEdge, topEdge, stepCount), expected, 0.01);
    }

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsProvider")
    void trapezeIntegrationTest(String function, double bottomEdge, double topEdge, int stepCount, double expected) {
        assertEquals(trapezoidIntegration.trapezeIntegration(new Exp4jCalculator(function), bottomEdge, topEdge, stepCount), expected, 0.01);
    }

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsProvider")
    void monteCarloIntegrationTest(String function, double bottomEdge, double topEdge, int stepCount, double expected) {
        assertEquals(monteCarloIntegration.monteCarloIntegration(new Exp4jCalculator(function), bottomEdge, topEdge, stepCount), expected, 0.05);
    }

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsWithAccuracyProvider")
    void adaptiveQuadratureIntegrationTest(String function, double bottomEdge, double topEdge, double accuracy, double expected) {
        assertEquals(adaptiveQuadratureIntegration.adaptiveIntegration(new Exp4jCalculator(function), bottomEdge, topEdge, accuracy), expected, accuracy * 10);
    }

    static Stream<Arguments> functionsAndIntegrationSpecsProvider() {
        return Stream.of(
                Arguments.arguments("x^2", 0, 1, 1000, 1/3),
                Arguments.arguments("sin(x)", 0, Math.PI, 1000, 2),
                Arguments.arguments("2*x^3 - 5*x^2 + sin(x)", 0, 1, 1000, -0.7),
                Arguments.arguments("e^x", 0, 1, 1000, Math.E - 1)
        );
    }

    static Stream<Arguments> functionsAndIntegrationSpecsWithAccuracyProvider() {
        return Stream.of(
                Arguments.arguments("x^2", 0, 1, 0.01, 1/3),
                Arguments.arguments("sin(x)", 0, Math.PI, 0.01, 2),
                Arguments.arguments("2*x^3 - 5*x^2 + sin(x)", 0, 1, 0.01, -0.7),
                Arguments.arguments("e^x", 0, 1, 0.01, Math.E - 1)
        );
    }
}
