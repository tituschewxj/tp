package seedu.address.logic.commands;

/**
 * InappropriateMethodCallAssertionError extends AssertionError to provide a more specific error indication
 * for scenarios where a method is invoked inappropriately. It simplifies the process
 * of throwing assertion errors with a default or custom message across the application.
 */
public class InappropriateMethodCallAssertionError extends AssertionError {
    // Static message for the error
    private static final String INAPPROPRIATE_METHOD_CALL_MESSAGE = "This method should not be called.";

    /**
     * Constructs a InappropriateMethodCallAssertionError with a default error message.
     * This default message indicates that a method, which should not have been called, was invoked.
     */
    public InappropriateMethodCallAssertionError() {
        super(INAPPROPRIATE_METHOD_CALL_MESSAGE);
    }

    /**
     * Constructs a InappropriateMethodCallAssertionError with a custom message.
     * Allows specifying a detailed message that describes the context or reason
     * why the error is being thrown.
     *
     * @param message The custom message to be associated with this error.
     */
    public InappropriateMethodCallAssertionError(String message) {
        super(message);
    }

    /**
     * Throws a InappropriateMethodCallAssertionError with the default message.
     * This static method provides a convenient way to throw an assertion error indicating
     * that a certain operation or method call is invalid and should not have occurred.
     * The default message is used for this error.
     *
     * @throws InappropriateMethodCallAssertionError always, with the default error message.
     */
    public static void throwDefault() {
        throw new InappropriateMethodCallAssertionError();
    }
}


