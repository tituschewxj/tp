package seedu.address.logic.commands;

/**
 * CustomAssertionError extends AssertionError to provide a more specific error indication
 * for scenarios where a method is invoked inappropriately. It simplifies the process
 * of throwing assertion errors with a default or custom message across the application.
 */
public class CustomAssertionError extends AssertionError {
    // Static message for the error
    private static final String DEFAULT_MESSAGE = "This method should not be called.";

    /**
     * Constructs a CustomAssertionError with a default error message.
     * This default message indicates that a method, which should not have been called, was invoked.
     */
    public CustomAssertionError() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Constructs a CustomAssertionError with a custom message.
     * Allows specifying a detailed message that describes the context or reason
     * why the error is being thrown.
     *
     * @param message The custom message to be associated with this error.
     */
    public CustomAssertionError(String message) {
        super(message);
    }

    /**
     * Throws a CustomAssertionError with the default message.
     * This static method provides a convenient way to throw an assertion error indicating
     * that a certain operation or method call is invalid and should not have occurred.
     * The default message is used for this error.
     *
     * @throws CustomAssertionError always, with the default error message.
     */
    public static void throwDefault() {
        throw new CustomAssertionError();
    }
}


