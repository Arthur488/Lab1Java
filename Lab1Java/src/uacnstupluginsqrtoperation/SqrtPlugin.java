package uacnstupluginsqrtoperation;

import uacnstupluginapi.Plugin;
import uacnstupluginapi.UnaryOperator;

public class SqrtPlugin implements Plugin, UnaryOperator {
    public static void main(String[] args) {

    }

    public static final String PLUGIN_NAME = "Sqrt operation plugin";
    @Override
    public void invoke() {
        System.out.println(PLUGIN_NAME + " loaded");
    }


    @Override
    public double calculateUnary(double number) {
        return Math.sqrt(number);
    }
}
