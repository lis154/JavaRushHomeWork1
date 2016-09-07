package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

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

        for (Map.Entry<String, Double> entry : mass.entrySet()) {
            System.out.println(entry.getKey() +" "
                    + entry.getValue());
        }

        reader1.close();







    }
}
