package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws Exception
    {
        fillInPropertiesMap();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println("key - " + entry.getKey() + " value111 - " + entry.getValue());
        }
    }

    public static void fillInPropertiesMap() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();
        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        OutputStream outputStream = new FileOutputStream(fileName3);
        save(outputStream);

        ;//implement this method - реализуйте этот метод

    }

    public static void save(OutputStream outputStream) throws Exception {

        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Map.Entry<String, String> entry : properties.entrySet())
        {
            printWriter.println(entry.getKey() + " = " + entry.getValue());
            //System.out.println("");
        }
        printWriter.close();
        //plement this method - реализуйте этот метод
    }

    public static void load(InputStream inputStream) throws Exception {

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> massProp = new ArrayList<>();
        while(reader1.ready()){
            String stroka = reader1.readLine();
            char[] mass = stroka.toCharArray();
            if (mass[mass.length-1] == '\\')
            {
                stroka = stroka + reader1.readLine();
            }
            massProp.add(stroka);
        }

        for (String str : massProp)
        {
            String key = "";
            String value = "";
            boolean pereh = false;
            char[] mass = str.toCharArray();
            for (int i = 0; i < mass.length; i++)
            {
                if (i < mass.length - 1)
                {
                    if (mass[i] == '=' && mass[i-1] != '\\')
                    {
                        pereh = true;
                        if (mass[i+1] == ' ')
                        {
                            i++;
                        }
                       // i++;
                    } else if (mass[i] == ':' && mass[i-1] != '\\')
                    {
                        pereh = true;
                        i++;
                    } else if (mass[i] == ' ' && mass[i-1] != '\\')
                    {
                        pereh = true;

                    }

                    if (pereh == false)
                    {
                        key = key + mass[i];
                    } else value = value + mass[i+1];
                }
            }
            properties.put(key, value);
        }
        reader1.close();

         //implement this method - реализуйте этот метод
    }
}
