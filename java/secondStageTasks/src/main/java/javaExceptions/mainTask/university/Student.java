package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.WrongLessonException;

import java.util.List;

public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private List<Lesson> lessonsList;

    public Student(String studentName, String studentSurname, String studentPatronymic, List<Lesson> lessonList) {
        this.name = studentName;
        this.surname = studentSurname;
        this.patronymic = studentPatronymic;
        this.lessonsList = lessonList;
        if (lessonList.isEmpty()){
            throw new WrongLessonException("Student must have at least 1 lesson");
        }
    }

    public List<Lesson> getLessonsList() {
        return lessonsList;
    }

    public double getStudentAverageMarks(){
        return (lessonsList.stream().mapToDouble(o-> o.getMark()).sum()) / lessonsList.size();
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + name + '\'' +
                ", studentSurname='" + surname + '\'' +
                ", studentPatronymic='" + patronymic + '\'' +
                ", lessonList=" + lessonsList +
                '}';
    }
}
