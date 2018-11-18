package com.ua.sutty.lab6;

import interfaces.task6.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class IOUtilsImpl implements IOUtils {

    @Override
    public void replaceChars(Reader reader, Writer writer, String s, String s1) {
        if (reader == null || writer == null) {
            throw new NullPointerException("in or out is null");
        }
        if (s == null) {
            s = "";
        }
        if (s1 == null) {
            s1 = "";
        }
        if (s.length() != s1.length()) {
            throw new IllegalArgumentException("Length first string not" +
                    " equals second string");
        }
        int a;
        char[] str = s.toCharArray();
        try {
            while ((a = reader.read()) != -1) {
                for (int i = 0; i < s.length(); i++) {
                    if (a == str[i]) {
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

        if (s == null) {
            throw new NullPointerException("s is null");
        }

        File file = new File(s);
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }

        File[] files = file.listFiles();
        List<String> pathList = new ArrayList<>();
        for (File f : Objects.requireNonNull(files)) {
            if (f.isFile()) {
                pathList.add(f.getAbsolutePath());
            } else {
                pathList.addAll(Arrays.asList(findFiles(f.getAbsolutePath())));
            }
        }
        String[] result = new String[pathList.size()];
        return pathList.toArray(result);
    }

    @Override
    public String[] findFiles(String s, String s1) {
        if (s == null) {
            throw new NullPointerException("s is null");
        }
        File file = new File(s);
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }
        File[] files = file.listFiles();
        List<String> pathList = new ArrayList<>();
        for (File f : Objects.requireNonNull(files)) {
            if (f.isFile()) {
                String name = f.getName();
                String regex = ".*(" + s1 + ")$";
                boolean res = name.matches(regex);
                if (res) {
                    pathList.add(f.getAbsolutePath());
                }
            } else {
                pathList.addAll(Arrays.asList(findFiles(f.getAbsolutePath(), s1)));
            }
        }
        String[] result = new String[pathList.size()];
        return pathList.toArray(result);
    }

    @Override
    public void copyFile(String s, String s1) {
        try(InputStream input = new FileInputStream(s);
            OutputStream output = new FileOutputStream(s1)) {
            someCopyFile(input, output);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("FIle not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void copyFileBuffered(File file, File file1) {
        try (InputStream input = new BufferedInputStream(new FileInputStream(file));
             OutputStream output = new BufferedOutputStream(new FileOutputStream(file1))) {
            someCopyFile(input, output);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("FIle not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void someCopyFile(InputStream input, OutputStream output) throws IOException {
        int c;
        long firstPoint = System.nanoTime();
        while ((c = input.read()) != -1) {
            output.write(c);
        }
        long secondPoint = System.nanoTime();
        System.out.println(secondPoint - firstPoint);
    }

    @Override
    public void copyFileBest(String s, String s1) {
        if (s == null || s1 == null){
            throw new NullPointerException("Don't have file");
        }
        Path sourcePath = Paths.get(s);
        Path destinationPath = Paths.get(s1);
        try {
            long firstPoint = System.nanoTime();
            Files.copy(sourcePath, destinationPath, StandardCopyOption.COPY_ATTRIBUTES);
            long secondPoint = System.nanoTime();
            System.out.println(secondPoint - firstPoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
