package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();



        ArrayList<String> lines2 = new ArrayList<String>();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        while (reader1.ready())
        {
            lines2.add(reader1.readLine());
        }
        reader1.close();
        String ob="";
        String newL;
        int kol = 0;
        for (String line: lines2)
        {
            newL = line.replaceAll("\\p{Punct}", " ");
            ob = ob + newL + " ";



        }

        String[] mas = ob.split(" ");
        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i].equals("world") || mas[i].equals("World"))
                kol++;
        }

        System.out.println(kol);



    }
}
