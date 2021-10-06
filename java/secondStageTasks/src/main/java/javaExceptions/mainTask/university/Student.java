package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.LackOfLessonException;

import java.util.List;

public class Student {
    private String studentName;
    private String studentSurname;
    private String studentPatronymic;
    private List<Lesson> lessonList;

    public Student(String studentName, String studentSurname, String studentPatronymic, List<Lesson> lessonList) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentPatronymic = studentPatronymic;
        this.lessonList = lessonList;
        if (lessonList.isEmpty()){
            throw new LackOfLessonException("Student must have at least 1 lesson");
        }
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public double getStudentAverageMarks(){
        return (lessonList.stream().mapToDouble(o-> o.getLessonMark()).sum()) / lessonList.size();
    }
    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentPatronymic() {
        return studentPatronymic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", studentPatronymic='" + studentPatronymic + '\'' +
                ", lessonList=" + lessonList +
                '}';
    }
}
