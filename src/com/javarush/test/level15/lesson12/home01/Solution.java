package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*String znach;
        while(!(znach = bufferedReader.readLine()).equals("exit"))
        {
            boolean prov = true;
            char c;
            int n = znach.length();
            for (int y = 0;  y < n; y++)
            {
                c=znach.charAt(y);
                if ((c!='0')&&(c!='1')&&(c!='2')&&(c!='3')&&(c!='4')&&(c!='5')&&(c!='6')&&(c!='7')&&(c!='8')&&(c!='9')&&(c!='.'))
                {
                   prov = false;

                    break;
                }
            }
            int i;

            if (prov == true)
            {

                if (znach.contains("."))
                {
                    Double t = Double.valueOf(znach);
                    print(t);
                    // print(40.0);
                } else if ((i = Integer.parseInt(znach)) > 0 && i < 128)
                {


                    print((short)Integer.parseInt(znach));


                } else if (i >= 128)
                {
                    print(i);
                }
            }
            else print(znach);

        }
        */
            String value;
            while (!(value = reader.readLine()).equals("exit"))
            {
                try
                {
                    if (value.contains("."))
                        print(Double.parseDouble(value));
                    else if (Integer.parseInt(value) >= 128)
                        print(Integer.parseInt(value));
                    else if (Integer.parseInt(value) > 0 && Integer.parseInt(value) < 128)
                        print((short) Integer.parseInt(value));
                    else print(value);
                }
                catch (NumberFormatException e)
                {
                    print(value);
                }
            }
        reader.close();

    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
