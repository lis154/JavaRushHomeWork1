package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
        while (reader1.ready())
        {
            lines.add(reader1.readLine());
        }

        Map<String, Double> mass  = new TreeMap<>();

        for (String line: lines)
        {
            String[] masLin = line.split(" ");
            String name = masLin[0];
            Double znach = Double.parseDouble(masLin[1]);

            if (!(mass.containsKey(name)))
            {
                mass.put(name, znach);
            }
            else
            {
                double value = mass.get(name);
                mass.put(name, value + znach);
            }
        }

        Double max = 0.0;

        for (Double value : mass.values()) {
            if (max < value)
            {
                max = value;
            }
        }

        //System.out.println(max);

        for (Map.Entry entry : mass.entrySet()) {
            if (entry.getValue() == max)
            {
                System.out.println(entry.getKey());
            }
        }

        reader1.close();

    }
}
