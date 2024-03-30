package org.example;

public class Pair {
    String attribute;
    String value;

    public Pair(String attribute, String value, Class type) {
        this.attribute = attribute;
        this.value = value;
        this.type = type;
    }

    Class type;
}
