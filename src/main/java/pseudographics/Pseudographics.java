package pseudographics;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Pseudographics {

    private static final double yScalingFactor = 0.3;

    public void drawSymbolPlot(Calculator calculator, double bottomEdge, double topEdge, int stringCount) {
        SortedMap<Double, Double> xyPairs = new TreeMap<>();
        double xStep = (topEdge - bottomEdge) / stringCount;
        for (double x = bottomEdge; x <= topEdge; x += xStep) {
            xyPairs.put(x, calculator.func(x));
        }


        int yGraphicStep = (int) Math.round((Collections.max(xyPairs.values()) - Collections.min(xyPairs.values())) / yScalingFactor);

        xyPairs.forEach((x, y) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < y * yGraphicStep - 1; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("*");
            System.out.println(stringBuilder);
        });
        System.out.println();
    }
}
