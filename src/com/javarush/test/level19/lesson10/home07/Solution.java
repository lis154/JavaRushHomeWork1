package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String file2 = reader.readLine();


        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        FileWriter writer = new FileWriter(file2);
        int n = 0;
        while (reader1.ready())
        {

            String line = reader1.readLine();
            String[] mass = line.split(" ");
            for (int i=0; i<mass.length;i++)
            {
               if (mass[i].length() > 6)
               {
                   if (n == 0)
                   {
                       writer.write(mass[i]);
                       n++;
                   }
                   else
                   {
                       writer.write("," + mass[i]);
                   }
               }
            }
        }
        reader.close();
        reader1.close();
        writer.close();

    }
}
