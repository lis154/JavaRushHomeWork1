package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public int min(int i, int j)
    {
        if (i < j)
            return i;
        else
            return j;
    }

    public long min(long i, long j)
    {
        if (i < j)
            return i;
        else
            return j;
    }

    public double min(double i, double j)
    {
        if (i < j)
            return i;
        else
            return j;
    }


    //Напишите тут ваши методы
}
