package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    public Solution(String s)
    {
    }

    public Solution(String s, String ss)
    {
    }

    public Solution(String s, int sa)
    {
    }

    private Solution(int n)
    {
    }

    private Solution(int n, int nn)
    {
    }

    private Solution(int n, String ns)
    {
    }

    protected Solution(boolean b)
    {
    }

    protected Solution(boolean b, boolean bb)
    {
    }

    protected Solution(boolean b, String bs)
    {
    }

    Solution(float t)
    {
    }

    Solution(float t, float tt)
    {
    }

    Solution(float t, String ts)
    {
    }
}

