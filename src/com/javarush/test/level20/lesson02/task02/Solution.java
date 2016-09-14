package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();

            OutputStream outputStream = new FileOutputStream(name);
            InputStream inputStream = new FileInputStream(name);



            JavaRush javaRush = new JavaRush();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            User user = new User();
            user.setFirstName("Smth");
            user.setLastName("Again");
            user.setBirthDate(format.parse("12.12.2014"));
            System.out.println(format.parse("12.12.2014"));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            for (User user: users)
            {
                String hasName = user.getFirstName()!= null ? "yes" : "no" ;
                writer.println(hasName);
                if (hasName.equals("yes"))
                {
                    String ferstName = user.getFirstName(); if (!(ferstName != null)) ferstName = "noFirstName";
                    writer.println(ferstName);

                    String lastName = user.getLastName(); if (!(lastName != null)) lastName = "noLastName";
                    writer.println(lastName);

                   // Date berth = format(user.getBirthDate());
                    writer.println(user.getBirthDate().toString());

                    writer.println(user.isMale());

                    writer.println(user.getCountry().toString());

                   // writer.println(user.getClass().toString());

                }
            }
            writer.close();// /implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasName = reader.readLine();
            if (hasName.equals("yes"))
            {
                User user = new User();
                String name = reader.readLine();
                        if (name.equals("noFirstName"))
                        {
                            user.setFirstName(null);
                        }
                        else
                            user.setFirstName(name);
                String Lastname = reader.readLine();
                if (Lastname.equals("noLastName"))
                {
                    user.setLastName(null);
                }
                else
                    user.setLastName(Lastname);
                SimpleDateFormat parserSDF = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);

                String date2 = reader.readLine();


                Date date = parserSDF.parse(date2);

                user.setBirthDate(date);

                if (reader.readLine().equals("true"))
                {
                    user.setMale(true);
                } else user.setMale(false);

                user.setCountry(User.Country.valueOf(reader.readLine()));

                users.add(user);


            }
            reader.close();
        }
    }
}
