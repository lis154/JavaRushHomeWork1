package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int kol = 0;
        FileInputStream inputStream = new FileInputStream("C:\\Users\\i.lapshinov\\Downloads\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home01\\1.txt");

        while (inputStream.available() > 0)
        {
            int t = inputStream.read();
            System.out.println(t);
            if(t > 64 && t < 90 || t > 96 && t < 123)
            {
                kol++;
            }
        }
        System.out.println(kol);
        inputStream.close();


    }
}
