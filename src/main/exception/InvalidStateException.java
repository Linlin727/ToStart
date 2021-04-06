package exception;

public class InvalidStateException extends InvalidUserInputException {
    public InvalidStateException(String message) {
        super(message);
    }
}
