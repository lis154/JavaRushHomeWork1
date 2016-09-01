package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread thread1 = new SpecialThread();
        SpecialThread thread2 = new SpecialThread();
        SpecialThread thread3 = new SpecialThread();
        SpecialThread thread4 = new SpecialThread();
        SpecialThread thread5 = new SpecialThread();

        Thread thread11 = new Thread(thread1);
        Thread thread21 = new Thread(thread2);
        Thread thread31 = new Thread(thread3);
        Thread thread41 = new Thread(thread4);
        Thread thread51 = new Thread(thread5);



        list.add(thread11);
        list.add(thread21);
        list.add(thread31);
        list.add(thread41);
        list.add(thread51);


        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
