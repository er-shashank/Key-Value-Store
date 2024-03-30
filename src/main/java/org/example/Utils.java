package org.example;


public class Utils {


    public static Class getDataType(String value) throws Exception {
       if(isInteger(value))
           return Integer.class;
       if(isBoolean(value))
           return Boolean.class;

       if(isFloatingPoint(value))
           return Float.class;

        return String.class;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isString(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public static boolean isBoolean(String str) {
        return str.equals("true")|| str.equals("false");
    }

    public static boolean isFloatingPoint(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
