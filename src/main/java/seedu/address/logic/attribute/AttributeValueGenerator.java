package seedu.address.logic.attribute;

import java.util.List;

/**
 * Generator functional interface for generating a list of attribute string.
 */
@FunctionalInterface
public interface AttributeValueGenerator {
    /**
     * Generates a list of string attribute values.
     */
    List<String> generate();
}
