package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException
    {



        int chCode = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String s = null;
            StringBuilder sb = new StringBuilder();
            while ((s = reader.readLine()) != null) {
                sb.append(s + "\n");
            }
            char[] charsArray = new char[sb.length() - 1];
            sb.getChars(0, sb.length() - 1, charsArray, 0); //exclude last "\n" which doesn't exist in file
            int[] charsFreqArray = new int[256];
            for (char ch: charsArray) {
                chCode = ch;
                charsFreqArray[ch]++;
            }
            for (int i = 0; i < charsFreqArray.length; i++) {
                if (charsFreqArray[i] > 0) {
                    System.out.println((char)i + " " + charsFreqArray[i]);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(chCode);
            e.printStackTrace();
        }
    }




      /*  FileInputStream inputStream  = new FileInputStream("C:\\Users\\i.lapshinov\\Downloads\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\home06\\1.txt");

        ArrayList<Integer> mass = new ArrayList<>();

        while (inputStream.available() > 0)
        {
            mass.add(inputStream.read());
        }


        Collections.sort(mass);
        int kolEl = 1;

        for (int i=0; i<mass.size();i++)
        {
            if(i != mass.size()-1)
            {
                if (mass.get(i) == mass.get(i + 1))
                {
                    kolEl++;
                }

                if (mass.get(i) != mass.get(i + 1))
                {
                    int t = mass.get(i);
                    char c = (char) t;
                    System.out.println(c + " " + kolEl);
                    kolEl = 1;
                }
            }
        }
        inputStream.close();*/

   // }
}
