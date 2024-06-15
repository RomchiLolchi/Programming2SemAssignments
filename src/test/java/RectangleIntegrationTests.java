import calculators.Exp4jCalculator;
import integration.rectangle.RectangleIntegration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleIntegrationTests {

    private static final RectangleIntegration rectangleIntegration = new RectangleIntegration();

    @ParameterizedTest
    @MethodSource("functionsAndIntegrationSpecsProvider")
    void integrationTest(String function, double bottomEdge, double topEdge, int stepCount, double expected) {
        assertEquals(rectangleIntegration.rectangleIntegration(new Exp4jCalculator(function), bottomEdge, topEdge, stepCount), expected, 0.01);
    }

    static Stream<Arguments> functionsAndIntegrationSpecsProvider() {
        return Stream.of(
                Arguments.arguments("x^2", 0, 1, 1000, 1/3),
                Arguments.arguments("sin(x)", 0, Math.PI, 1000, 2),
                Arguments.arguments("2*x^3 - 5*x^2 + sin(x)", 0, 1, 1000, -0.7),
                Arguments.arguments("e^x", 0, 1, 1000, Math.E - 1)
        );
    }
}
