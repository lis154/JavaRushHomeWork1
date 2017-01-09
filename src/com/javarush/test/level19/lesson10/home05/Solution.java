package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {



        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
        while (reader1.ready())
        {
            lines.add(reader1.readLine());
        }

        reader1.close();

        FileWriter writer = new FileWriter(args[1]);



        Pattern pattern = Pattern.compile(".*\\d.*");

        for (String line: lines)
        {
            String[] mas = line.split(" ");
            for (String mass: mas)
            {

                Matcher matcher = pattern.matcher(mass);
                boolean matches = matcher.matches();
                if (matches)
                {

                    writer.write(mass + " ");
                }
            }
        }

        writer.close();



    }
}
