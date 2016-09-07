package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {

        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
        while (reader1.ready())
        {
            lines.add(reader1.readLine());
        }

        for (String line : lines)
        {
           String[] mas = line.split(" ");
            int day, month, god;
            String name = "";
            god = Integer.parseInt(mas[mas.length-1]);
            month = Integer.parseInt(mas[mas.length-2]);
            day = Integer.parseInt(mas[mas.length-3]);
            for (int i = 0; i < mas.length-3;i++)
            {
                if (i == mas.length-4)
                {
                    name = name + mas[i];
                }
                else
                name = name + mas[i] + " ";
            }
            Date docDate = new GregorianCalendar(god, month, day).getTime();
            PEOPLE.add(new Person(name, docDate));

        }
        reader1.close();






    }

}
