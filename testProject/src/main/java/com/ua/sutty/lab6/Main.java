package com.ua.sutty.lab6;

import interfaces.task6.IOUtils;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        IOUtils ioUtils = new IOUtilsImpl();

        try (FileReader fileReader = new FileReader("text.txt");
             FileWriter fileWriter = new FileWriter("copy_text.txt")) {
            ioUtils.replaceChars(fileReader, fileWriter, "123", "abc");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ioUtils.findFiles("/home/NIX/suttyread/Desktop");

    }

}
