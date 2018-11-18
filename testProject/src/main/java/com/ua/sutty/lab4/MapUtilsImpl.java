package com.ua.sutty.lab4;

import interfaces.task4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsImpl implements MapUtils {

    public static final String str = "Returns an Image object that can then " +
            "be painted on the screen. The url that is passed as " +
            "an argument must specify an absolute URL";

    @Override
    public Map<String, Integer> findThrees(String s) {
        if (s == null) {
            throw new NullPointerException("String is null");
        }
        Map<String, Integer> maps = new HashMap<>();
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == s.charAt(0)) {
                if (str.charAt(i + 1) == s.charAt(1)) {
                    if (str.charAt(i + 2) == s.charAt(2)) {
                        value++;
                    }
                }
            }
        }
        maps.put(s, value);
        return maps;
    }

}
