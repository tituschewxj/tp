package seedu.address.logic.commands.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.StringUtil.areStrippedStringsEqual;

/**
 * A container for {@code Command} message specific utility functions.
 */
public class CommandMessageUsageUtil {

    public static final String EXAMPLE_LABEL = "Example: ";

    public static final String PARAMETER_LABEL = "Parameters: ";

    public static final String CONSTRAINT_LABEL = "Constraints: ";

    /**
     * Generates the message usage, given the {@code commandWord}, {@code description},
     * and {@code example} as strings.
     */
    public static String generateMessageUsage(String commandWord, String description,
                                              String example) {
        return commandWord + ": "
                + description + "\n"
                + EXAMPLE_LABEL + example;
    }

    /**
     * Generates the message usage, given the {@code commandWord}, {@code description},
     * {@code parameters}, and {@code example} as strings.
     */
    public static String generateMessageUsage(String commandWord, String description,
                                              String parameters, String example) {
        return commandWord + ": "
                + description + "\n"
                + PARAMETER_LABEL + parameters + "\n"
                + EXAMPLE_LABEL + example;
    }

    /**
     * Generates the message usage, given the {@code commandWord}, {@code description},
     * {@code parameters}, {@code constraints} and {@code example} as strings.
     */
    public static String generateMessageUsage(String commandWord, String description,
                                              String parameters, String constraints, String example) {
        return commandWord + ": "
                + description + "\n"
                + PARAMETER_LABEL + parameters + "\n"
                + CONSTRAINT_LABEL + constraints + "\n"
                + EXAMPLE_LABEL + example;
    }

    /**
     * Generates the message usage, given the {@code commandWord}, {@code description} as strings,
     * and the {@code parameters}.
     */
    public static String generateMessageUsage(String commandWord, String description,
                                              Parameter... parameters) {
        String constraints = generateMessageUsageConstraints(parameters);

        if (constraints.isBlank()) {
            return generateMessageUsage(
                    commandWord,
                    description,
                    generateMessageUsageParameters(parameters),
                    generateMessageUsageExample(commandWord, parameters)
            );
        }

        return generateMessageUsage(
                commandWord,
                description,
                generateMessageUsageParameters(parameters),
                constraints,
                generateMessageUsageExample(commandWord, parameters)
        );
    }

    /**
     * Generates the message usage parameters, given the {@code parameters}.
     */
    public static String generateMessageUsageParameters(Parameter... parameters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Parameter p : parameters) {
            stringBuilder
                    .append(p.getFormattedParameterDetails())
                    .append(" ");
        }

        return stringBuilder.toString().trim();
    }

    /**
     * Generates the message usage constraints, given the {@code parameters}.
     */
    public static String generateMessageUsageConstraints(Parameter... parameters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Parameter p : parameters) {
            String constraint = p.getParameterConstraint();
            if (!constraint.isBlank()) {
                stringBuilder
                        .append(constraint)
                        .append(" ");
            }
        }

        return stringBuilder.toString().trim();
    }

    /**
     * Generates the message usage example, given the {@code commmandWord} and {@code parameters}.
     */
    public static String generateMessageUsageExample(String commandWord, Parameter... parameters) {
        StringBuilder stringBuilder = new StringBuilder(commandWord + " ");

        for (Parameter p : parameters) {
            String exampleValue = p.getParameterWithExampleValues();
            if (!exampleValue.isBlank()) {
                stringBuilder
                        .append(exampleValue)
                        .append(" ");
            }
        }

        return stringBuilder.toString().trim();
    }

    /**
     * Returns true if the text is {@link #EXAMPLE_LABEL} or {@link #PARAMETER_LABEL}.
     */
    public static boolean isUtilLabel(String text) {
        requireNonNull(text);
        return areStrippedStringsEqual(EXAMPLE_LABEL, text)
                || areStrippedStringsEqual(PARAMETER_LABEL, text)
                || areStrippedStringsEqual(CONSTRAINT_LABEL, text);
    }
}
