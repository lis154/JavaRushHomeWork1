package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
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

        FileInputStream inputStream2 = new FileInputStream(file2);
        FileInputStream inputStream1 = new FileInputStream(file1);

        ArrayList<Integer> mass1 = new ArrayList<>();
        int i = 0;
        while (inputStream1.available() > 0)
        {
            mass1.add(inputStream1.read());
        }

        inputStream1.close();

        FileOutputStream outputStream = new FileOutputStream(file1);
        while (inputStream2.available() > 0)
        {
            outputStream.write(inputStream2.read());
        }

        for (Integer elem : mass1)
        {
            outputStream.write(elem);
        }

        reader.close();
        inputStream2.close();
        outputStream.close();

    }
}
