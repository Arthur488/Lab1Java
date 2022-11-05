package uacnstupluginminusoperation;

import uacnstupluginapi.BinaryOperator;
import uacnstupluginapi.Plugin;

public class MinusPlugin implements Plugin, BinaryOperator {

    public static void main(String[] args) {

    }

    public static final String PLUGIN_NAME = "Minus operation plugin";
    @Override
    public void invoke() {
        System.out.println(PLUGIN_NAME + " loaded");
    }
    @Override
    public double calculateBinary(double firstOperand, double secondOpearnd) {
        return firstOperand - secondOpearnd;
    }
}

