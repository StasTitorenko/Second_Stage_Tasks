package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class LackOfFacultyException extends NoSuchElementException {
      public LackOfFacultyException(String s) {
        super(s);
    }
}
