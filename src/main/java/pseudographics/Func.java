package pseudographics;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;

public class Func {

    private static final double yScalingFactor = 15;

    public static void drawSymbolPlot(Function<Float, Float> func, Float bottomEdge, Float topEdge, Integer stringCount) {
        SortedMap<Float, Float> xyPairs = new TreeMap<>();
        float xStep = (topEdge - bottomEdge) / stringCount;
        for (float x = bottomEdge; x <= topEdge; x += xStep) {
            xyPairs.put(x, func.apply(x));
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
