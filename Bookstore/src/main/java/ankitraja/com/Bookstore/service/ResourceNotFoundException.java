package ankitraja.com.Bookstore.service;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String userNotFound) {
        super("RuntimeException");
    }
}
