package exceptions;

public class ImproperlyConfigured extends RuntimeException {
    public ImproperlyConfigured() {
        super();
    }

    public ImproperlyConfigured(String message) {
        super(message);
    }
}
