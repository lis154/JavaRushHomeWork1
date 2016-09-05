package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileWriter writer = new FileWriter(file2);
        ArrayList<String> lines2 = new ArrayList<String>();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        while (reader1.ready())
        {
            lines2.add(reader1.readLine());
        }

        reader1.close();
        String vuvS;
        ArrayList<String> vuvod = new ArrayList<>();
        for (String line: lines2)
        {
            vuvS = line.replaceAll("\\.", "!");
            vuvod.add(vuvS + "\r\n");
        }

        for (String line: vuvod)
        {
            writer.write(line);
        }

        writer.close();

    }
}
