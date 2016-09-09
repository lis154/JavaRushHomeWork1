package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String file2 = reader.readLine();

        ArrayList<String> lines1 = new ArrayList<String>();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        while (reader1.ready())
        {
            lines1.add(reader1.readLine());
        }
        ArrayList<String> lines2 = new ArrayList<String>();
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        while (reader2.ready())
        {
            lines2.add(reader2.readLine());
        }
        int m = 1;
        int max = lines1.size();
        if (max < lines2.size())
        {
            max = lines2.size();
            m=2;
        }
        int n=0;

        int i = 0;
       while (i < max)
       {
           if (i != max-1)
           {
               if (lines1.get(i).equals(lines2.get(n)))
               {
                   LineItem item = new LineItem(Type.SAME, lines1.get(i));
                   lines.add(item);
                   i++;
                   n++;
               } else
               {
                   if (lines1.get(i).equals(lines2.get(n + 1)))
                   {
                       LineItem item = new LineItem(Type.ADDED, lines2.get(n));
                       lines.add(item);
                       n++;
                   } else
                   {
                       LineItem item = new LineItem(Type.REMOVED, lines1.get(i));
                       lines.add(item);
                       i++;

                   }
               }
           }
           else
           {

                if (m == 1)
                {
                    LineItem item = new LineItem(Type.REMOVED, lines1.get(i));
                    lines.add(item);

                }
                else
                {
                    LineItem item = new LineItem(Type.ADDED, lines2.get(n));
                    lines.add(item);
                }

               i++;
           }

       }
        reader.close();
        reader2.close();
        reader1.close();
        for (int j=0; j<lines.size();j++)
        {
            System.out.println(lines.get(j).getType() + " " +lines.get(j).getLine());
        }

    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        public Type getType()
        {
            return type;
        }

        public String getLine()
        {
            return line;
        }
    }
}
