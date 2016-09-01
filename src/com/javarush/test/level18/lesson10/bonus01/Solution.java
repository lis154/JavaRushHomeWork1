package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String param, fileName, fileOutprutName;
        param = args[0];
        fileName = args[1];
        fileOutprutName = args[2];

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutprutName);

        if (param.equals("-e"))
        {
            while (inputStream.available() > 0)
            {
                int data = inputStream.read() + 2;
                outputStream.write(data);
            }
        }
        else if (param.equals("-d"))
        {
            while (inputStream.available() > 0)
            {
                int data = inputStream.read() - 2;
                outputStream.write(data);
            }
        }
        inputStream.close();
        outputStream.close();

    }

}
