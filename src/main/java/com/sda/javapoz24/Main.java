package com.sda.javapoz24;

import com.sda.javapoz24.dao.MysqlDBConnection;
import com.sda.javapoz24.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Student student = new Student();
        student.setFirstName("Antek");

        System.out.println(student);*/

        //1. Model - implementacja
        //2. Zdefiniowanie parametrów bazy danych
        //  a. tworzymy klasę, która odczyta z resources parametry bazy
        //  b. tworzymy klasę która z użyciem mysqldatasource stworzy połączenie
        //3. Tworzymy zapytania do bazy danych
        //4. Tworzymy DAO = Data Access Objects
        // --test
        //5. Tworzymy zapytania + metodę insert

        StudentDao dao = new StudentDao(new MysqlDBConnection());
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("Podaj komendę [insert, list, delete]");
            command = scanner.nextLine();
            //todo: dodać metodę update

            if (command.startsWith("insert")) {                   // insert Paweł Gaweł 20 true MALE
                                                                    // 0      1     2     3  4    5
                String[] words = command.split(" ");
                Student student = Student.builder()
                        .firstName(words[1])
                        .lastName(words[2])
                        .age(Integer.parseInt(words[3]))
                        .awarded(Boolean.parseBoolean(words[4]))
                        .gender(Gender.valueOf(words[5].toUpperCase()))
                        .build();
                dao.insertStudent(student);

            } else if (command.startsWith("list")) {
                //list
                List<Student> list = dao.getAllStudents();

                System.out.println("Rekordy: ");
                list.forEach(System.out::println); // wypisz rekordy na ekran (linia pod linią)
                System.out.println(); // dopisz jedną linię odstępu

                } else if (command.startsWith("delete")){
                    // delete 1
                    String[] words = command.split(" ");
                    dao.deleteStudent(Long.parseLong(words[1]));

                } else if (command.startsWith("modify")){
                // modify Marian Kowalski 40 true MALE 3
                String[] words = command.split(" ");
                Student student = Student.builder()
                            .firstName(words[1])
                            .lastName(words[2])
                            .age(Integer.parseInt(words[3]))
                            .awarded(Boolean.parseBoolean(words[4]))
                            .gender(Gender.valueOf(words[5].toUpperCase()))
                            .build();

                    dao.updateStudent(Long.parseLong(words[6]), student);
            }
        } while (!command.equalsIgnoreCase("quit")); //enter i 'quit' -> program się kończy

        //dao.insertStudent(new Student(null, "Paweł", "Gaweł", 20, true, Gender.MALE));
        //tabela powinna zostać automatycznie stworzona
    }
}
