package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();


        FileInputStream inputStream  = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        ArrayList<Character> mass = new ArrayList<>();
        ArrayList<Double> massDb = new ArrayList<>();
        int prov;
        String chislo = "";
        while (inputStream.available() > 0)
        {
            prov = inputStream.read();
            mass.add((char) prov);
            if (prov == 32 || inputStream.available()==0)
            {
                if (prov == 32)
                {
                    for (int i = 0; i < mass.size()-1; i++)
                    {
                        chislo = chislo + mass.get(i);
                    }
                }
                else
                {
                    for (int i = 0; i < mass.size(); i++)
                    {
                        chislo = chislo + mass.get(i);
                    }
                }
                massDb.add(Double.parseDouble(chislo));
                chislo = "";
                mass.clear();
            }
        }
        int vuv2;
        byte[] t;

        for (Double elem : massDb)
        {
            vuv2 = (int)Math.round(elem);
            String str = Integer.toString(vuv2);
            t = str.getBytes("ascii");
            outputStream.write(t);
            outputStream.write(32);

        }
        reader.close();
        inputStream.close();
        outputStream.close();

    }
}
