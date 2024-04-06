package seedu.address.logic.attribute;

import static seedu.address.logic.attribute.PrefixResolverSyntax.ALL_PREFIX_RESOLVERS;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import seedu.address.commons.core.LogsCenter;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;
import seedu.address.storage.StorageManager;

/**
 * Manages the updating of attribute data to its data generators.
 * <p>
 * Contains accessible attribute value generators,
 * that can be referenced to generate attribute value data.
 */
public class AttributeValueGeneratorManager {

    /** The latest address book instance, with the most updated data. */
    private static ReadOnlyAddressBook latestAddressBook;
    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);

    /**
     * Updates the address book reference, which updates the linked trie.
     */
    public static void updateAddressBook(ReadOnlyAddressBook addressBook) {
        if (addressBook == null) {
            return;
        }

        latestAddressBook = addressBook;
        Arrays.stream(ALL_PREFIX_RESOLVERS)
                .forEach(PrefixResolver::notifyOutdatedData);

        logger.info("Sent data update to attribute tries");
    }

    public static List<String> getNusNetIdAttributeValues() {
        return generateAttributeValues(person -> person.getNusNet().value);
    }

    public static List<String> getMajorAttributeValues() {
        return generateAttributeValues(person -> person.getMajor().value);
    }

    public static List<String> getPhoneAttributeValues() {
        return generateAttributeValues(person -> person.getPhone().value);
    }

    public static List<String> getEmailAttributeValues() {
        return generateAttributeValues(person -> person.getEmail().value);
    }

    public static List<String> getNameAttributeValues() {
        return generateAttributeValues(person -> person.getName().toString());
    }

    /**
     * Generates all attribute values given a function to convert a person into a string.
     *
     * @param ps A function that converts a person into one of their attribute strings.
     * @return The list of generated attribute values.
     */
    private static List<String> generateAttributeValues(PersonStringifier ps) {
        assert latestAddressBook != null;
        return latestAddressBook
                .getPersonList()
                .stream()
                .map(ps::stringifyPerson)
                .collect(Collectors.toList());
    }

    /**
     * Generates all tag values that appear in people.
     * <p>
     * As each person can have multiple tags, it needs a different implementation
     * compared to other attributes that appear once in a person.
     */
    public static List<String> generateTagAttributeValues() {
        assert latestAddressBook != null;
        return latestAddressBook
                .getPersonList()
                .stream()
                .flatMap(person -> person
                        .getTags()
                        .stream()
                        .map(tag -> tag.tagName))
                .collect(Collectors.toList());
    }

    /**
     * An interface to convert a person into a string of an attribute value.
     */
    @FunctionalInterface
    private interface PersonStringifier {
        String stringifyPerson(Person person);
    }
}
