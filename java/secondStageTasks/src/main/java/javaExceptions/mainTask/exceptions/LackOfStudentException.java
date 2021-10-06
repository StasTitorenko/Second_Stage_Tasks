package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class LackOfStudentException extends NoSuchElementException {
     public LackOfStudentException(String s) {
        super(s);
    }
}
