package com.javarush.test.level11.lesson11.home02;

/* AppleIPhone и SamsungGalaxyS2
Написать два класса AppleIPhone и SamsungGalaxyS2.
Унаследовать SamsungGalaxyS2 от AppleIPhone.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class AppleIPhone
    {
        private String name;
        public void setName(String name)
        {
            this.name = name;
        }
        public String getName()
        {
            return "Apple";
        }


    }

    public class SamsungGalaxyS2 extends AppleIPhone
    {
        public String getName()
        {
            return "Samsung";
        }


    }
}
