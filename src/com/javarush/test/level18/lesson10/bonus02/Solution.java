package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        int maxId = 0;

        for (String line : lines)
        {
            if (!(line.equals("")))
            {

                int id;
                byte[] mass = line.getBytes(); // получчаем массив байт
                String num = "";
                for (int i = 0; i < 8; i++)
                {


                    if (mass[i] != 32)
                    {

                        num = num + (char) mass[i];
                    } else
                    {
                        i = 8;
                    }

                }
                id = Integer.parseInt(num);
                if (id > maxId) maxId = id;

            }
        }

        inputStream.close();
        String quantity = args[args.length-1];
        String price = args[args.length-2];
        String name = "";
        for (int i = 1; i < args.length-2;i++)
        {
            name = name + args[i];
        }

        quantity = sozdaniePoly(quantity, 4);
        price = sozdaniePoly(price, 8);
        name = sozdaniePoly(name, 30);
        maxId++;
        String maxISt = maxId + "";
        maxISt = sozdaniePoly(maxISt, 8);

        String vuvod = "\r\n" + maxISt + name + price + quantity;
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "UTF-8"));
        pw.write(vuvod);
        pw.close();
    }

    public static String sozdaniePoly (String stroka, int razm)
    {
        String str = stroka;
        if (stroka.length() > razm)
        {
            stroka = stroka.substring(0,razm);
        }
        else
        {


            for (int i = 0; i < razm - str.length(); i++)
            {
                stroka = stroka + " ";
            }

        }

        return stroka;
    }
}