package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String s = "";
        Scanner in = new Scanner(new File(file));
        while (in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();
        int dlinna = args[0].length();
        ArrayList<Prov> prov = new ArrayList<>();

        char[] mass = s.toCharArray();
        for (int i = 0; i < mass.length; i++)
        {
            String strokaProb = "";
            Prov provEr = new Prov();
            if (mass[i] == '<' && mass[i + 1] != '/')
            {
                for (int j = i + 1; j < i + dlinna + 1; j++)
                {
                    strokaProb = strokaProb + mass[j];
                }
                if (strokaProb.equals(args[0]))
                {

                    provEr.setName("vhod");
                    provEr.setNom(i);
                    prov.add(provEr);
                }
            }
            if (mass[i] == '<' && mass[i + 1] == '/')
            {
                for (int j = i + 2; j < i + dlinna + 2; j++)
                {
                    strokaProb = strokaProb + mass[j];
                }
                if (strokaProb.equals(args[0]))
                {
                    provEr.setName("vuhod");
                    provEr.setNom(i);
                    prov.add(provEr);
                }
            }
        }

        for (int i = 0; i < prov.size(); i++)
        {

            if (prov.get(i).getName().equals("vuhod") && i == prov.size() - 1 || prov.get(i).getName().equals("vuhod") && prov.get(i + 1).getName().equals("vhod"))
            {
                int n = 0, koef;
                for (int j = 0; j < i + 1; j++)
                {
                    if (prov.get(j).getName().equals("vuhod"))
                    {
                        n++;
                    }
                }
                koef = n;
                for (int k = i; k > -1; k--)
                {
                    String strokGot2 = "";
                    for (int o = prov.get(k - n * 2 + 1).getNom(); o < prov.get(k).getNom() + 7; o++)
                    {
                        strokGot2 = strokGot2 + mass[o];

                    }
                    System.out.println(strokGot2);
                    if (n == 1) k = 0;
                    n--;
                }
                for (int p = i; p > i - 2 * koef + 1; p--)
                {
                    prov.remove(i);
                }
                i = 0;

            }
        }

    }

    public static class Prov
    {
        Integer nom;
        String name;

        public Integer getNom()
        {
            return nom;
        }

        public String getName()
        {
            return name;
        }

        public void setNom(Integer nom)
        {
            this.nom = nom;
        }

        public void setName(String name)
        {
            this.name = name;
        }
    }
}









