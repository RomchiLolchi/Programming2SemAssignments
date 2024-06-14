package pseudographics;

public abstract class Calculator {
    private String function;

    public Calculator() {
        function = "";
    }

    public Calculator(String function) {
        this.function = function;
    }

    abstract public double func(double x);

    abstract public double func(String inputFunc, double x);

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }
}
