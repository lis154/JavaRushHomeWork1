package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");




    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        while (reader1.ready())
        {
            lines.add(reader1.readLine());
        }

        for (String line: lines)
        {
            int n = 0;
            for (int i =0; i < words.size(); i++)
            {
                if (line.contains(words.get(i)))
                {
                    n++;
                }
            }

            if (n == 2)
            {
                System.out.println(line);
            }
        }

        reader.close();
        reader1.close();

    }
}
