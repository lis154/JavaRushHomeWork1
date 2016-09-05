package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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


        String stroka = "";
        for (String line: lines2)
        {
            stroka = stroka + line;
        }
        String[] mass = stroka.split(" ");
        ArrayList<String> rez = new ArrayList<>();
        for (int i = 0; i < mass.length;i++)
        {
           // System.out.println(mass[i]);
            boolean prov = checkString(mass[i]);
            if (prov)
            {
                rez.add(mass[i]);
                writer.write(mass[i] + " ");
                //System.out.println(mass[i]);
            }
        }

        writer.close();

    }

    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
