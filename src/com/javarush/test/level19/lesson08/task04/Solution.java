package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.
вода:
Пример вы
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        //ArrayList<String> mas = new ArrayList<>();
        String[] mass = result.split(" ");
        int a = Integer.parseInt(mass[0]);
        String deistv = mass[1];
        int b = Integer.parseInt(mass[2]);
        //System.out.println(mass[0] + " " + mass[1] + " " + mass[2]);
        int c;
        if (deistv.equals("+"))
        {
            c = a + b;
        }
        else if (deistv.equals("-"))
        {
            c = a - b;
        }
        else if (deistv.equals("*"))
        {
            c = a * b;
        }
        else c = 0;
        System.out.println (mass[0] + " " + mass[1] + " " + mass[2] + " " + mass[3] + " " + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

