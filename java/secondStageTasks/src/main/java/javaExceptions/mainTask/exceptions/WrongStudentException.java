package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class WrongStudentException extends NoSuchElementException {
     public WrongStudentException(String s) {
        super(s);
    }
}
