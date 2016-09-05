package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
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
            vuvS = line.replaceAll("\\p{Punct}","");
            vuvod.add(vuvS );
        }

        ArrayList<String> vuvod2 = new ArrayList<>();
        for (String line: vuvod)
        {
            vuvS = line.replaceAll("\\n","");
            vuvod2.add(vuvS);
        }

        for (String line: vuvod2)
        {
            writer.write(line);
        }

        writer.close();

    }
}
