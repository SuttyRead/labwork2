package com.ua.sutty.lab3;

import interfaces.task3.StringUtils;

public class Main {

    public static void main(String[] args) {
        StringUtils utils = new StringUtilsImpl();

        System.out.println(utils.invert("hello"));
        System.out.println(utils.compareWords("Hello4mn5Worpld",
                "World546546546"));
        try {
            System.out.println(utils.parseDouble("123.563f33gfh345"));
            System.out.println(utils.parseDouble(".123.563f33gfh345"));
        } catch (Exception e) {
            System.err.println("Incorrect number. " +
                    "Error was caused in method \"parseDouble\" at " +
                    "com.ua.sutty.lab3.StringUtilsImpl.parseDouble(" +
                    "StringUtils.java:37)");
            throw new IllegalArgumentException("No opportunity to transform");
        }
        StringDivImpl stringDiv = new StringDivImpl();
        System.out.println(stringDiv.div("123.6", "123.6"));

//        try {
//            System.out.println(utils.parseDouble("123.563f33gfh345"));
//            System.out.println(utils.parseDouble(".123.563f33gfh345"));
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }

    }
}
