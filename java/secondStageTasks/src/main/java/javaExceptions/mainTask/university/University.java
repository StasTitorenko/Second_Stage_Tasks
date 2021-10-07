package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.WrongFacultyException;
import javaExceptions.mainTask.featuredCategories.Faculties;
import javaExceptions.mainTask.featuredCategories.Lessons;

import java.util.List;
import java.util.stream.Collectors;

public class University {
    private List<Faculty> facultiesList;

    public University(List<Faculty> facultyList) {
        this.facultiesList = facultyList;

            if ((facultyList == null) || (facultyList.isEmpty())) {
            throw new WrongFacultyException("University must have at least 1 faculty");
        }
    }

    public List<Student> findStudentByFullName(String name, String surname, String patronymic){
        List<Student> foundStudent = facultiesList.stream()
                .flatMap(faculty -> faculty.getGroupsList().stream())
                .flatMap(group -> group.getStudentsList().stream())
                .filter(student -> (student.getName().equals(name))
                        && (student.getSurname().equals(surname))
                        && (student.getPatronymic().equals(patronymic)))
                .collect(Collectors.toList());
    return foundStudent;
    }

    public List<Lesson> findLessonInGroupInFaculty(Lessons lessonName, String groupName, Faculties facultyName){
        List<Lesson> foundLesson = facultiesList.stream()
                .filter(faculty -> faculty.getName().equals(facultyName))
                .flatMap(group -> group.getGroupsList().stream())
                .filter(group -> group.getName().equals(groupName))
                .flatMap(student -> student.getStudentsList().stream())
                .flatMap(lesson -> lesson.getLessonsList().stream())
                .filter(lesson -> lesson.getName().equals(lessonName))
                .collect(Collectors.toList());
        return foundLesson;
    }

    public List<Lesson> findLessonInUniversity(Lessons lessonName){
        List<Lesson> foundLesson = facultiesList.stream()
                .flatMap(group -> group.getGroupsList().stream())
                .flatMap(student -> student.getStudentsList().stream())
                .flatMap(lesson -> lesson.getLessonsList().stream())
                .filter(lesson -> lesson.getName().equals(lessonName))
                .collect(Collectors.toList());
        return foundLesson;
    }

    public double getStudentAverageMark(String name, String surname, String patronymic) {
        System.out.print("Средний балл у: " + name + " " + surname + " " + patronymic + " =");
        return  findStudentByFullName(name, surname, patronymic)
                .stream().mapToDouble(o -> o.getStudentAverageMarks())
                .sum();
    }
    public double getLessonAverageMark(Lessons lessonName, String groupName, Faculties facultyName) {
        System.out.print("Средний балл по: " + lessonName + " у группы: " + groupName + " на факультете: " + facultyName + " =");
        return  (findLessonInGroupInFaculty(lessonName, groupName, facultyName)
                .stream().mapToDouble(o -> o.getMark())
                .sum()) / (findLessonInGroupInFaculty(lessonName, groupName, facultyName).size());
    }
    public double getLessonAverageMarkInUniversity(Lessons lessonName) {
        System.out.print("Средний балл в университете, по: " + lessonName + " =");
        return  (findLessonInUniversity(lessonName)
                .stream().mapToDouble(o -> o.getMark())
                .sum()) / (findLessonInUniversity(lessonName).size());
    }

    @Override
    public String toString() {
        return "University{" +
                "facultyList=" + facultiesList +
                '}';
    }
}
