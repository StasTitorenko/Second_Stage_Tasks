package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class WrongFacultyException extends NoSuchElementException {
      public WrongFacultyException(String s) {
        super(s);
    }
}
