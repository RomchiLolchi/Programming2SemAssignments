package pseudographics;

import calculators.Calculator;
import calculators.Exp4jCalculator;

import java.util.Scanner;
import java.util.function.Function;

//todo write docs
//todo add calculator version and yScalingFactor to args
public class PseudographicsStart {
    public static void main(String[] args) {
        Function<Float, Float> func = x -> x * x;
        Func.drawSymbolPlot(func, -5.0f, 5.0f, 11);
    }
}
