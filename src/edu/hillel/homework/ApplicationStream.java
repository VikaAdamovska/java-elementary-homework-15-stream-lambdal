package edu.hillel.homework;

import java.util.*;
import java.util.stream.Collectors;

public class ApplicationStream {
    public static void main(String[] args) {

        Student fistStudent = new Student("Ivanov Sergey", 35.0, 10);
        Student secondStudent = new Student("Ivanov Pavel", 25.0, 9);
        Student thirdStudent = new Student("Petrov Dima", 20.0, 10);
        Student fourthStudent = new Student("Beliy Nazar", 22.5, 7);
        Student fifthStudent = new Student("Nazarenko Nika", 30.5, 11);

        List<Student> studentsList = new LinkedList<>();
        studentsList.add(fistStudent);
        studentsList.add(secondStudent);
        studentsList.add(thirdStudent);
        studentsList.add(fourthStudent);
        studentsList.add(fifthStudent);

        //получить Set который содержит имена студентов

        Set<String> setName = studentsList.stream().map(student -> student.getName()).collect(Collectors.toSet());
        System.out.println("NEW SET \n");
        setName.stream().forEach(System.out::println);

        //получить Map где ключ - name,значение - объект Student (1)

        Map<String, Student> studentsMap = studentsList.stream().collect(Collectors.toMap(Student::getName, student -> student));
        System.out.println("\nNEW MAP \n");
        studentsMap.entrySet().stream().forEach(System.out::println);

        //получить List студентов, отсортированных по age

        List<Student> sortByAge = studentsList.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        System.out.println("\nNEW LIST \n");
        sortByAge.stream().forEach(System.out::println);

        //посчитать количество студентов с списке

        long sumStudents = studentsList.stream().count();
        int sumStudents1 = studentsList.size();
        System.out.println(String.format("\nSum by collection counter is:  %d, sum by stream counter is: %d!", sumStudents, sumStudents1));

        //посчитеть количество уникальных студентов в списке (distinct)

        studentsList.add(new Student("Ivanov Pavel", 25.0, 9));
        long uniqueValues = studentsList.stream().distinct().count();
        System.out.println(String.format("\nSum of unique values is: %d", uniqueValues));

        /*распечатать содержимое Map в формате ключ = знаяение, используя форматируемый вывод (String.format)
         преобразовать Map в Set который будет содержать age студентов*/

        System.out.println("\nSTUDENTS MAP with formatted output \n");
        studentsMap.entrySet().stream().forEach(entry -> System.out.println(
                String.format("map key - %s : map value - %s", entry.getKey(), entry.getValue())));


        Set<Double> ageSet = studentsMap.entrySet().stream().map(
                entry -> entry.getValue().getAge()).collect(Collectors.toSet());
        System.out.println("\nNEW AGE SET \n");
        ageSet.stream().forEach(System.out::println);
    }
}
