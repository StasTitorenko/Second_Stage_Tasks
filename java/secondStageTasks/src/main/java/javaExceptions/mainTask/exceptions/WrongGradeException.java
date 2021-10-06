package javaExceptions.mainTask.exceptions;

public class WrongGradeException  extends  IllegalArgumentException{
    public WrongGradeException(String s) {
        super(s);
    }
}
