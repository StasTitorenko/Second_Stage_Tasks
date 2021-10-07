package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.WrongGradeException;
import javaExceptions.mainTask.featuredCategories.Lessons;

public class Lesson {
    private Lessons name;
    private int mark;

    public Lesson(Lessons lessons, int mark) {
        this.name = lessons;
        this.mark = mark;
        if ((this.mark < 0) || (this.mark > 10)) {
            throw new WrongGradeException("Student's mark should be in 0-10 range");
        }
    }

    public int getMark() {
        return mark;
    }

    public Lessons getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName=" + name +
                ", lessonMark=" + mark +
                '}';
    }
}
