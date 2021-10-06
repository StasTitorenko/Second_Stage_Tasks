package javaExceptions.mainTask.exceptions;

import java.util.NoSuchElementException;

public class LackOfGroupException extends NoSuchElementException {
     public LackOfGroupException(String s) {
        super(s);
    }
}
