package pseudographics;

import java.util.Scanner;

//todo write docs
//todo add calculator version and yScalingFactor to args
public class PseudographicsStart {
    public static void main(String[] args) {
        String function;
        double bottomEdge;
        double topEdge;
        int stringCount;

        if (args.length != 0) {
            function = args[0];
            bottomEdge = Double.parseDouble(args[1]);
            topEdge = Double.parseDouble(args[2]);
            stringCount = Integer.parseInt(args[3]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter function: ");
            function = scanner.next();
            System.out.print("Enter bottom edge: ");
            bottomEdge = Double.parseDouble(scanner.next());
            System.out.print("Enter top edge: ");
            topEdge = Double.parseDouble(scanner.next());
            System.out.print("Enter row count: ");
            stringCount = Integer.parseInt(scanner.next());
        }

        Calculator calculator = new Exp4jCalculator(function);
        Pseudographics pseudographics = new Pseudographics();
        pseudographics.drawSymbolPlot(calculator, bottomEdge, topEdge, stringCount);
    }
}
