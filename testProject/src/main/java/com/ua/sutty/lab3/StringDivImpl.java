package com.ua.sutty.lab3;

import interfaces.task3.StringDiv;
import interfaces.task3.StringUtils;

public class StringDivImpl implements StringDiv {

    public StringDivImpl() {
    }

    @Override
    public double div(String s, String s1) {
        StringUtils stringUtils = new StringUtilsImpl();
        double firstVariable = stringUtils.parseDouble(s);
        double secondVariable = stringUtils.parseDouble(s1);
        return firstVariable / secondVariable;
    }
}
