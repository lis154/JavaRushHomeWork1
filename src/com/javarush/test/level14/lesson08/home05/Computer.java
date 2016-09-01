package com.javarush.test.level14.lesson08.home05;

import java.security.Key;

/**
 * Created by i.lapshinov on 21.03.2016.
 */
public class Computer
{
    private Mouse mouse;
    private Keyboard keyboard;
    private Monitor monitor;

   /* public Computer()
    {}*/
    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor)
    {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    public Computer()
    {
       mouse = new Mouse();
        keyboard = new Keyboard();
        monitor = new Monitor();
    }


    public Monitor getMonitor()
    {
        return monitor;
    }

    public Keyboard getKeyboard()
    {

        return keyboard;
    }

    public Mouse getMouse()
    {

        return mouse;
    }
}
