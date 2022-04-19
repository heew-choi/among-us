package exceptions;

public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException() {
        super();
    }

    public InvalidCommandException(String s) {
        super(s);
    }
}
