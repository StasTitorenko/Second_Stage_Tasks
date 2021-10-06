package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.WrongGradeException;
import javaExceptions.mainTask.featuredCategories.Lessons;

public class Lesson {
    private Lessons lessonName;
    private int lessonMark;

    public Lesson(Lessons lessons, int mark) {
        this.lessonName = lessons;
        this.lessonMark = mark;
        if ((lessonMark < 0) || (lessonMark > 10)) {
            throw new WrongGradeException("Student's mark should be in 0-10 range");
        }
    }

    public int getLessonMark() {
        return lessonMark;
    }

    public Lessons getLessonName() {
        return lessonName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName=" + lessonName +
                ", lessonMark=" + lessonMark +
                '}';
    }
}
