package com.javarush.test.level19.lesson03.task04;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

       private Scanner scaner;

        PersonScannerAdapter (Scanner scaner)
        {
            this.scaner = scaner;
        }


        @Override
        public Person read() throws IOException, ParseException
        {
                String strok = scaner.nextLine();
                String[] stroki = strok.split(" ");
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");

            Date data = format.parse(stroki[3] + "." + stroki[4] + "." + stroki[5]);

           Person person = new Person(stroki[1], stroki[2], stroki[0], data);



            return person;
        }

        @Override
        public void close() throws IOException
        {
            this.scaner.close();
        }
    }
}
