package com.javarush.test.level15.lesson12.home07;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {

    public static List<String> lines = new ArrayList<String>();

    static {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_NAME));
            String line = null;
            while ((line=reader.readLine())!=null) {lines.add(line);}
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
