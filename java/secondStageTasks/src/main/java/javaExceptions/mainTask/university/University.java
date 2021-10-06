package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.LackOfFacultyException;
import javaExceptions.mainTask.featuredCategories.Faculties;
import javaExceptions.mainTask.featuredCategories.Lessons;

import java.util.List;
import java.util.stream.Collectors;

public class University {
    private List<Faculty> facultyList;

    public University(List<Faculty> facultyList) {
        this.facultyList = facultyList;
        if (facultyList.isEmpty()) {
            throw new LackOfFacultyException("The university must have at least 1 faculty");
        }
    }

    public List<Student> findStudentByFullName(String name, String surname, String patronymic){
        List<Student> foundStudent = facultyList.stream()
                .flatMap(faculty -> faculty.getGroupList().stream())
                .flatMap(group -> group.getStudentList().stream())
                .filter(student -> (student.getStudentName().equals(name))
                        && (student.getStudentSurname().equals(surname))
                        && (student.getStudentPatronymic().equals(patronymic)))
                .collect(Collectors.toList());
    return foundStudent;
    }
    public List<Lesson> findLessonInGroupInFaculty(Lessons lessonName, String groupName, Faculties facultyName){
        List<Lesson> foundLesson = facultyList.stream()
                .filter(faculty -> faculty.getFacultyName().equals(facultyName))
                .flatMap(group -> group.getGroupList().stream())
                .filter(group -> group.getGroupName().equals(groupName))
                .flatMap(student -> student.getStudentList().stream())
                .flatMap(lesson -> lesson.getLessonList().stream())
                .filter(lesson -> lesson.getLessonName().equals(lessonName))
                .collect(Collectors.toList());
        return foundLesson;
    }

    public List<Lesson> findLessonInUniversity(Lessons lessonName){
        List<Lesson> foundLesson = facultyList.stream()
                .flatMap(group -> group.getGroupList().stream())
                .flatMap(student -> student.getStudentList().stream())
                .flatMap(lesson -> lesson.getLessonList().stream())
                .filter(lesson -> lesson.getLessonName().equals(lessonName))
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
                .stream().mapToDouble(o -> o.getLessonMark())
                .sum()) / (findLessonInGroupInFaculty(lessonName, groupName, facultyName).size());
    }
    public double getLessonAverageMarkInUniversity(Lessons lessonName) {
        System.out.print("Средний балл в университете, по: " + lessonName + " =");
        return  (findLessonInUniversity(lessonName)
                .stream().mapToDouble(o -> o.getLessonMark())
                .sum()) / (findLessonInUniversity(lessonName).size());
    }

    @Override
    public String toString() {
        return "University{" +
                "facultyList=" + facultyList +
                '}';
    }
}
