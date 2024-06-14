package pseudographics;

import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Objects;

public class Exp4jCalculator extends Calculator {

    public Exp4jCalculator() {
        super();
    }

    public Exp4jCalculator(String function) {
        super(function);
    }

    @Override
    public double func(double x) {
        if (Objects.equals(getFunction(), "")) throw new IllegalStateException("Default function hasn't been set!");

        return new ExpressionBuilder(getFunction())
                .variable("x")
                .build()
                .setVariable("x", x)
                .evaluate();
    }

    @Override
    public double func(String inputFunc, double x) {
        return new ExpressionBuilder(inputFunc)
                .variable("x")
                .build()
                .setVariable("x", x)
                .evaluate();
    }
}
