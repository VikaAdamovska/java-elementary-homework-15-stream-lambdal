package edu.hillel.homework;

import java.util.Objects;

public class Student {
    /*1) Создать класс Student c свойствами name (String), age (double), mark(int)
      2) Создать 5 тестовых объектов класса Student и занести их в List
      3) C помощью stream:
      получить Set который содержит имена студентов
      получить Map где ключ - name,значение - объект Student (1)
      получить List студентов, отсортированных по age
      посчитать количество студентов с списке
      посчитеть количество уникальных студентов в списке (distinct)
      4) Map из пункта (1) с помощью stream:
      распечатать содержимое Map в формате ключ = знаяение, используя форматируемый вывод (String.format)
     преобразовать Map в Set который будет содержать age студентов*/

    private final String name;
    private final double age;
    private final int mark;

    public Student(String name, double age, int mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.age, age) == 0 &&
                mark == student.mark &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, mark);
    }
}
