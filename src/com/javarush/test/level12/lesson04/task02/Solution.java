package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int i = 5;
        Integer j = 10;

        Solution r = new Solution();
        r.print(i);
        r.print(j);
    }

    public void print(int i)
    {
        System.out.println("Int " + i);
    }

    public void print (Integer i){
        System.out.println("Integer " + i);
    }
    //Напишите тут ваши методы
}
