package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        int[] mas = {1, 2};
        try
        {
            System.out.println(mas[3]);

        }catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            List list = null;
            list.add(1);
        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            InputStream is = new FileInputStream("111.txt");
        } catch(FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            Integer.parseInt("none");

        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {

            Object x[] = new String[10];
            x[0] = Integer.valueOf(100);

        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }
        try {
            Object i = Integer.valueOf(42);
            String s = (String)i;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            int[] numbs = new int[-1];

        }catch(NegativeArraySizeException e) {
            exceptions.add(e);
        }
        try {
            throw new UnsupportedOperationException("Invalid operation for sorted list.");
        }catch(UnsupportedOperationException e) {
            exceptions.add(e);
        }
        try {
            throw new SecurityException("Hmmm maybe SecurityException");
        } catch (SecurityException e) {
            exceptions.add(e);
        }


        //Add your code here


    }
}
