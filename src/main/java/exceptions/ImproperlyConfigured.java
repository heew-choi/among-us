package exceptions;

public class ImproperlyConfigured extends Exception {
    public ImproperlyConfigured() {
        super();
    }

    public ImproperlyConfigured(String message) {
        super(message);
    }
}
