package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class WrongLessonException extends NoSuchElementException {
     public WrongLessonException(String s) {
        super(s);
    }
}
