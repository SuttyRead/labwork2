package com.ua.sutty.lab3;

import interfaces.task3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringUtilsImpl implements StringUtils {

    public StringUtilsImpl() {
    }

    @Override
    public String invert(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    @Override
    public String compareWords(String s, String s1) {
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
        char[] newStr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 48 && s.charAt(i) <= 57) || s.charAt(i) == 46) {
                newStr[i] = s.charAt(i);
                continue;
            }
            break;
        }
        return Double.parseDouble(new String(newStr).trim());
    }
}
