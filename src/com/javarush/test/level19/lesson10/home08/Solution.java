package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        ArrayList<String> lines = new ArrayList<String>();

        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        while (reader1.ready())
        {
            String line = reader1.readLine();
            lines.add(line);

            String reverseLine = new StringBuffer(line).reverse().toString();
            System.out.println(reverseLine);


        }

        reader.close();
        reader1.close();


    }
}
