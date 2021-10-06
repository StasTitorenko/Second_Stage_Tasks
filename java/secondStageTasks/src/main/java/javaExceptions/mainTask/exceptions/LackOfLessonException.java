package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class LackOfLessonException extends NoSuchElementException {
     public LackOfLessonException(String s) {
        super(s);
    }
}
