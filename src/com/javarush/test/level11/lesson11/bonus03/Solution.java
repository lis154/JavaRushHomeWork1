package com.javarush.test.level11.lesson11.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное и максимальное числа в массиве.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return new Pair<Integer, Integer>(null, null);
        }
        else
        {
            for (int i = 0; i < array.length-1; i++)
            {
                for (int j = 0; j < array.length - i - 1; j++ )
                {
                    if (array[j] > array[j+1])
                    {
                        int b = array[j];
                        array[j] = array[j+1];
                        array[j+1] = b;
                    }
                }
            }

            Integer min = array[0];
            int c = array.length;
            Integer max = array[c-1];
           // System.out.println(c);
            return new Pair<Integer, Integer>(min, max);
        }
        //Напишите тут ваше решение

        //return new Pair<Integer, Integer>(0, 0);
    }


    public static class Pair<X, Y>
    {
        public X x;
        public Y y;

        public Pair(X x, Y y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
