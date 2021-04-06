package exception;

public class InvalidTaskException extends InvalidUserInputException {
    public InvalidTaskException(String message) {
        super(message);
    }
}
