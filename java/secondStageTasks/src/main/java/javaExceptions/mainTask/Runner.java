package javaExceptions.mainTask;

import javaExceptions.mainTask.featuredCategories.Faculties;
import javaExceptions.mainTask.featuredCategories.Lessons;
import javaExceptions.mainTask.university.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Group> engeneeringGroups = new ArrayList<>();
        List<Group> mathematicalGroups = new ArrayList<>();
        List<Group> itGroups = new ArrayList<>();
        //Engeneering
       Group en12 = new Group("EN-12", Arrays.asList(
                new Student("Сидоров", "Сергей", "Петрович", Arrays.asList(
                        new Lesson(Lessons.MATHS, 9),
                        new Lesson(Lessons.RUSSIAN_LANGUAGE, 10)
                )),
                new Student("Сидоров", "Сергей", "Иванович", Arrays.asList(
                        new Lesson(Lessons.MATHS, 5),
                        new Lesson(Lessons.RUSSIAN_LANGUAGE, 5)
                ))
        ));
        engeneeringGroups.add(en12);
        Group en22 = new Group("EN-22", Arrays.asList(
                new Student("Петров", "Петр", "Петрович", Arrays.asList(
                        new Lesson(Lessons.MATHS, 8),
                        new Lesson(Lessons.RUSSIAN_LANGUAGE, 8),
                        new Lesson(Lessons.DRAWING, 8)
                )),
                new Student("Петров", "Петр", "Валентинович", Arrays.asList(
                        new Lesson(Lessons.MATHS, 6),
                        new Lesson(Lessons.RUSSIAN_LANGUAGE, 6),
                        new Lesson(Lessons.DRAWING,6)
                ))
        ));
        engeneeringGroups.add(en22);
        Faculty engeeniring = new Faculty(Faculties.ENGENEERING, engeneeringGroups);
        //Mathematical
        Group ay11 = new Group("AY-11", Arrays.asList(
                new Student("Иванов", "Иван", "Иванович", Arrays.asList(
                        new Lesson(Lessons.MATHS, 7),
                        new Lesson(Lessons.RUSSIAN_LANGUAGE, 7)
                )),
                new Student("Иванов", "Иван", "Петрович", Arrays.asList(
                        new Lesson(Lessons.MATHS, 4),
                        new Lesson(Lessons.RUSSIAN_LANGUAGE,4)
                ))
        ));
        mathematicalGroups.add(ay11);
        Group ay21 = new Group("AY-21", Arrays.asList(
                new Student("Кожемякин", "Владислав", "Павлович", Arrays.asList(
                        new Lesson(Lessons.ALGOROTHMIZATION, 10),
                        new Lesson(Lessons.ENGLISH_LANGUAGE, 10)
                )),
                new Student("Кожемякин", "Владислав", "Сергеевич", Arrays.asList(
                        new Lesson(Lessons.ALGOROTHMIZATION, 3),
                        new Lesson(Lessons.ENGLISH_LANGUAGE, 3)
                ))
        ));
        mathematicalGroups.add(ay21);
        Faculty mathematical = new Faculty(Faculties.MATHEMATICAL, mathematicalGroups);
        //IT
        Group pk12 = new Group("PK-12", Arrays.asList(
                new Student("Козлов", "Максим", "Петрович", Arrays.asList(
                        new Lesson(Lessons.ALGOROTHMIZATION, 6),
                        new Lesson(Lessons.MATHS, 6)
                )),
                new Student("Козлов", "Максим", "Геннадьевич", Arrays.asList(
                        new Lesson(Lessons.MATHS.ALGOROTHMIZATION, 7),
                        new Lesson(Lessons.MATHS, 7)
                ))
        ));
        itGroups.add(pk12);
        Group pk22 = new Group("PK-22", Arrays.asList(
                new Student("Поддубный", "Сергей", "Иванович", Arrays.asList(
                        new Lesson(Lessons.ENGLISH_LANGUAGE, 10),
                        new Lesson(Lessons.LAW, 10),
                        new Lesson(Lessons.PROGRAMMING, 10)
                )),
                new Student("Поддубный", "Сергей", "Степанович", Arrays.asList(
                        new Lesson(Lessons.ENGLISH_LANGUAGE, 3),
                        new Lesson(Lessons.LAW, 10),
                        new Lesson(Lessons.PROGRAMMING, 3)
                ))

        ));
        itGroups.add(pk22);

       /* List<Group> testGroup = new ArrayList<>();
        Group test = new Group("test", Arrays.asList());
        testGroup.add(test);
        */
        //Faculty test = new Faculty(Faculties.ENGENEERING,null);
        //University testU = new University(null);

        Faculty it = new Faculty(Faculties.IT, itGroups);
        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(engeeniring);
        facultyList.add(mathematical);
        facultyList.add(it);
        University mIU = new University(facultyList);

        //Средний балл по всем предметам студента
       System.out.println(mIU.getStudentAverageMark("Поддубный", "Сергей", "Степанович"));
       //Средний бал по конкретному предмету в конкретной группе и факультете
       System.out.println(mIU.getLessonAverageMark(Lessons.LAW,"PK-22",Faculties.IT));
       //Средний бал по предмету для всего университета
       System.out.println(mIU.getLessonAverageMarkInUniversity(Lessons.RUSSIAN_LANGUAGE));
    }
}
