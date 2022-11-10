package uacnstupluginascioperation;

import uacnstupluginapi.BinaryOperationasci;
import uacnstupluginapi.Plugin;

public class AsciPlugin implements Plugin, BinaryOperationasci {
    public static void main(String[] args) {

    }

    public static final String PLUGIN_NAME = "ASCI plus code operation plugin";
    @Override
    public void invoke() {
        System.out.println(PLUGIN_NAME + " loaded");
    }
    @Override
    public char calculateAsci(char ch1, char ch2) {

        int ascii1 = ch1;

        int ascii2 = ch2;

        int resCharASCII = ascii1 + ascii2;
        System.out.println("Number of your char in ASCII: " + resCharASCII);

        char resChar = (char)resCharASCII;

        return resChar;
    }
}

