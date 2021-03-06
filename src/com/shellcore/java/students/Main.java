package com.shellcore.java.students;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Cesar. 07/06/2017.
 */
public class Main {

    final static List<Student> students = Arrays.asList(
            new Student("Joe","Clay",1994,Gender.MALE),
            new Student("Marie","Smith",1997,Gender.FEMALE),
            new Student("Ann","Thompson",2000,Gender.FEMALE),
            new Student("James","Bond",1989,Gender.MALE),
            new Student("Jennifer","Atkins",1995,Gender.FEMALE),
            new Student("Cristina","Gibbs",1999,Gender.FEMALE),
            new Student("Jason","Clark",1998,Gender.MALE),
            new Student("Kate","Barrett",1992,Gender.FEMALE),
            new Student("Peter","Garner",1999,Gender.MALE),
            new Student("Ben","Walsh",1996,Gender.MALE)
    );

    //Print the full names of each student.
    public static void runExample() {
        students.stream()
                .map(student -> student.getName())
                .forEach(System.out::println);
    }

    //Print the list of each student's last name in uppercase.
    //Hint: map
    public static void runExercise1() {
        students.stream()
                .map(student -> student.getLastName()
                        .toUpperCase())
                .forEach(System.out::println);
    }

    //Print the first name of each male student.
    //Hint: filter
    public static void runExercise2() {
        students.stream()
                .filter(student -> student.getGender().equals(Gender.MALE))
                .map(student -> student.getFirstName())
                .forEach(System.out::println);
    }

    //Print the full names and age of the first 5 students older than 20 years of age.
    //Hint: limit
    public static void runExercise3() {
        students.stream()
                .filter(student -> student.getAge() > 20)
                .limit(5)
                .map(student -> student.getName() + " " + student.getAge())
                .forEach(System.out::println);
    }

    //Print the average age of students.
    //Hint: mapToInt average
    public static void runExercise4() {
        Double average = students.stream()
                .mapToInt(student -> student.getAge())
                .average()
                .getAsDouble();

        System.out.println(average);
    }

    //Print the amount of students who are over 22 years old.
    //Hint: count
    public static void runExercise5() {
        long count = students.stream()
                .filter(student -> student.getAge() > 22)
                .count();
        System.out.println(count);
    }

    //Print a list of age and student name sorted by age.
    //Hint: sorter
    public static void runExercise6() {
        students.stream()
                .sorted((x, y) -> Integer.compare(x.getAge(), y.getAge()))
                .map(student -> student.getAge() + " " + student.getName())
                .forEach(System.out::println);
    }

    //Print a list of students older than 20 years sorted alphabetically with the following format: Lastname, Firstname.
    //Hint: sorter
    public static void runExercise7() {
        students.stream()
                .filter(student -> (student.getAge() > 20))
                .map(student -> (student.getLastName() + ", " + student.getFirstName()))
                .sorted((x, y) -> x.compareTo(y))
                .forEach(System.out::println);
    }

    //Make a list of objects type integer with the different years when students were born, sorted descendingly.
    //Hint: distinct reverseOrder collect
    public static void runExercise8() {
        List <Integer> years =
                students.stream()
                        .map(student -> student.getBirthYear())
                        .sorted((x, y) -> Integer.compare(y, x))
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(years);
    }

    public static void main(String[] args) {
        System.out.println("----------Example---------");
        runExample();
        System.out.println("--------Exercise 1--------");
        runExercise1();
        System.out.println("--------Exercise 2--------");
        runExercise2();
        System.out.println("--------Exercise 3--------");
        runExercise3();
        System.out.println("--------Exercise 4--------");
        runExercise4();
        System.out.println("--------Exercise 5--------");
        runExercise5();
        System.out.println("--------Exercise 6--------");
        runExercise6();
        System.out.println("--------Exercise 7--------");
        runExercise7();
        System.out.println("--------Exercise 8--------");
        runExercise8();

        /* ANSWER

        ----------Example---------
        Joe Clay
        Marie Smith
        Ann Thompson
        James Bond
        Jennifer Atkins
        Cristina Gibbs
        Jason Clark
        Kate Barrett
        Peter Garner
        Ben Walsh
        --------Exercise 1--------
        CLAY
        SMITH
        THOMPSON
        BOND
        ATKINS
        GIBBS
        CLARK
        BARRETT
        GARNER
        WALSH
        --------Exercise 2--------
        Joe
        James
        Jason
        Peter
        Ben
        --------Exercise 3--------
        Joe Clay 23
        James Bond 28
        Jennifer Atkins 22
        Kate Barrett 25
        Ben Walsh 21
        --------Exercise 4--------
        21.1
        --------Exercise 5--------
        3
        --------Exercise 6--------
        17 Ann Thompson
        18 Cristina Gibbs
        18 Peter Garner
        19 Jason Clark
        20 Marie Smith
        21 Ben Walsh
        22 Jennifer Atkins
        23 Joe Clay
        25 Kate Barrett
        28 James Bond
        --------Exercise 7--------
        Atkins, Jennifer
        Barrett, Kate
        Bond, James
        Clay, Joe
        Walsh, Ben
        --------Exercise 8--------
        [2000, 1999, 1998, 1997, 1996, 1995, 1994, 1992, 1989]

        */
    }
}