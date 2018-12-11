package topic08.lambdas.lambdacalc;

public class LambdaCalculator {

    @FunctionalInterface
    interface MathOperation{
        int operation(int a, int b);
    }

    public static int useLambda(int a, int b, MathOperation o){
        return o.operation(a, b);
    }
}
