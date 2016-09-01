package com.javarush.test.level11.lesson11.home03;

/* Эволюция
Написать четыре класса: Fish(Рыбы), Animal(Животные), Ape(Обезьяны), Human (Человек).
Унаследовать животных от рыб, обезьян от животных и человека от обезьян.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Fish
    {
        String name;

        public void setName(String name)
        {
            this.name = name;
        }
        public String getName()
        {return "Fish";}
    }

    public class Animal extends Fish
    {
        public String getName()
        {return "Animal";}
    }

    public class Ape extends Animal
    {
        public String getName()
        {return "Ape";}
    }

    public class Human extends Ape
    {
        public String getName()
        {return "Human";}
    }

}
