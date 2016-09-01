package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);

        double kolSim = 0;
        double kolProb = 0;
        while (inputStream.available() > 0)
        {
            int t = inputStream.read();
            if (t == 32)
            {
                kolProb++;
                kolSim++;
            }
            else
            {
                kolSim++;
            }

        }
        double r = (kolProb / kolSim) * 100;
        double newDouble = new BigDecimal(r).setScale(2, RoundingMode.UP).doubleValue();

        System.out.println(newDouble);
        inputStream.close();

    }
}
