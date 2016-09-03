package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOut;
    AdapterFileOutputStream (FileOutputStream fileOut)
    {
        this.fileOut = fileOut;
    }

    @Override
    public void flush() throws IOException
    {
      this.fileOut.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {

        this.fileOut.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
        this.fileOut.close();

    }
}

