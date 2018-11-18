package com.ua.sutty.lab3;

import interfaces.task3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilsImpl implements StringUtils {

    public StringUtilsImpl() {
    }

    @Override
    public String invert(String s) {
        if (s == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    @Override
    public String compareWords(String s, String s1) {
        if (s == null || s1 == null) {
            throw new NullPointerException("String is null");
        }
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            for (int j = 0; j < s1.length(); j++) {
                if (s.charAt(i) == s1.charAt(j)) {
                    k++;
                }
            }
            if (k == 0) {
                characters.add(s.charAt(i));
            }
        }
        return characters.toString();

    }

    @Override
    public double parseDouble(String s) throws RuntimeException {
        if (s == null){
            throw new NullPointerException("String is null");
        }
        Matcher m = Pattern.compile("^-?[0-9]+([.,])?([0-9]+)?(e([-+])?[0-9]+)?").matcher(s);
        if (m.find()) {
            s = m.group();
        } else {
            throw new IllegalArgumentException("We can't parse double of "
                    + s, new NumberFormatException("We can't parse"));
        }
        s = s.replace(",", ".");
        return Double.parseDouble(s);
    }
}
