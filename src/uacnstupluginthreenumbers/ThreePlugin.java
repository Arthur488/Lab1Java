package uacnstupluginthreenumbers;

import uacnstupluginapi.BinaryOperator;
import uacnstupluginapi.Plugin;

public class ThreePlugin implements BinaryOperator, Plugin {

    public static void main(String[] args) {

    }

    public static final String PLUGIN_NAME = "Three operation plugin";

    @Override
    public void invoke() {
        System.out.println(PLUGIN_NAME + " loaded");
    }

    @Override
    public double calculateBinary(double firstOperand, double secondOperand, double thirdOperand) {
        return firstOperand + secondOperand + thirdOperand;
    }


}
