package sis3;

public class MarkException extends Exception {
    @Override
    public String getMessage() {
        return "Mark must be between 0 and 100";
    }
}
