package com.ua.sutty.lab6;

import interfaces.task6.IOUtils;

import java.io.*;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {

        IOUtils ioUtils = new IOUtilsImpl();

//        try (FileReader fileReader = new FileReader("text.txt");
//             FileWriter fileWriter = new FileWriter("copy_text.txt")) {
//            ioUtils.replaceChars(fileReader, fileWriter, "123", "abc");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ioUtils.findFiles("/home/NIX/suttyread/Desktop");

//        System.out.println(Arrays.toString(ioUtils.findFiles("C:\\Program Files\\Java\\jdk1.8.0_191\\lib", "jar")));
//        System.out.println("end");

//        try (Writer writer = new FileWriter("text.txt");
//             FileReader reader = new FileReader("copyText.txt")
//        ) {
//            writer.write("Hello1");
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        ioUtils.copyFile("text.txt", "copyText.txt");
//        ioUtils.copyFileBuffered(new File("text.txt"), new File("copyText.txt"));
        ioUtils.copyFileBest("text.txt", "copyText.txt");

    }

}
