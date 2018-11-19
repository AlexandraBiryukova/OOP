package sis3;

public class SizeException extends Exception {
    @Override
    public String getMessage() {
        return "There are no registered ";
    }
}
