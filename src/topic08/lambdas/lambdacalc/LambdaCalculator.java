package topic08.lambdas.lambdacalc;

import jdk.dynalink.Operation;

import java.util.function.IntPredicate;

public class LambdaCalculator {

    @FunctionalInterface
    interface MathOperation{
        int operation(int a, int b);
    }

    public static int useLambda(int a, int b, MathOperation o){
        return o.operation(a, b);
    }
}
