package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by i.lapshinov on 02.04.2016.
 */
public class Plane implements Flyable

{
    int count;
    @Override
    public void fly()
    {

    }
    public Plane(int count)
    {
        this.count = count;
    }
}
