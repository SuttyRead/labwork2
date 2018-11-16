package com.ua.sutty.lab6;

import interfaces.task6.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class IOUtilsImpl implements IOUtils {

    @Override
    public void replaceChars(Reader reader, Writer writer, String s, String s1) {
        int a;
        char[] str = s.toCharArray();
        try {
            while ((a = reader.read()) != -1) {

                for (int i = 0; i < s.length(); i++) {
                    if (a == str[i]){
                        a = s1.charAt(i);
                        break;
                    }

                }
                    writer.write(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] findFiles(String s) {

        File file = new File(s);

        String[] list = file.list();
        assert list != null;
        System.out.println(Arrays.toString(list));
        return new String[0];
    }

    @Override
    public String[] findFiles(String s, String s1) {
        return new String[0];
    }

    @Override
    public void copyFile(String s, String s1) {

    }

    @Override
    public void copyFileBuffered(File file, File file1) {

    }

    @Override
    public void copyFileBest(String s, String s1) {

    }


}
