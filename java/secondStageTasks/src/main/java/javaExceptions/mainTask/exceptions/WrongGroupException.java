package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class WrongGroupException extends NoSuchElementException {
     public WrongGroupException(String s) {
        super(s);
    }
}
