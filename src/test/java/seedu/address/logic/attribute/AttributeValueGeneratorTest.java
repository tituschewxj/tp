package seedu.address.logic.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.autocomplete.PrefixResolverSyntax.PREFIX_EMAIL_RESOLVER;
import static seedu.address.logic.autocomplete.PrefixResolverSyntax.PREFIX_MAJOR_RESOLVER;
import static seedu.address.logic.autocomplete.PrefixResolverSyntax.PREFIX_NAME_RESOLVER;
import static seedu.address.logic.autocomplete.PrefixResolverSyntax.PREFIX_NUSNET_RESOLVER;
import static seedu.address.logic.autocomplete.PrefixResolverSyntax.PREFIX_PHONE_RESOLVER;
import static seedu.address.logic.autocomplete.PrefixResolverSyntax.PREFIX_TAG_RESOLVER;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AttributeValueGeneratorTest {

    @BeforeAll
    static void setUp() {
        AttributeValueGenerator.updateAddressBook(getTypicalAddressBook());
    }


    @Test
    void getNusNetIdAttributeValues() {
        List<String> list = PREFIX_NUSNET_RESOLVER.resolvePrefix("");
        assertEquals(7, list.size());

        list = PREFIX_NUSNET_RESOLVER.resolvePrefix("E0000001");
        assertEquals(1, list.size());
        assertEquals("E0000001", list.get(0));
    }

    @Test
    void getMajorAttributeValues() {
        List<String> list = PREFIX_MAJOR_RESOLVER.resolvePrefix("");
        assertEquals(3, list.size());

        list = PREFIX_MAJOR_RESOLVER.resolvePrefix("P");
        assertEquals(1, list.size());
        assertEquals("Psychology", list.get(0));
    }

    @Test
    void getPhoneAttributeValues() {
        List<String> list = PREFIX_PHONE_RESOLVER.resolvePrefix("");
        assertEquals(7, list.size());

        list = PREFIX_PHONE_RESOLVER.resolvePrefix("87");
        assertEquals(1, list.size());
        assertEquals("87652533", list.get(0));
    }

    @Test
    void getEmailAttributeValues() {
        List<String> list = PREFIX_EMAIL_RESOLVER.resolvePrefix("");
        assertEquals(7, list.size());

        list = PREFIX_EMAIL_RESOLVER.resolvePrefix("c");
        assertEquals(1, list.size());
        assertEquals("cornelia@example.com", list.get(0));
    }

    @Test
    void getNameAttributeValues() {
        List<String> list = PREFIX_NAME_RESOLVER.resolvePrefix("");
        assertEquals(7, list.size());

        list = PREFIX_NAME_RESOLVER.resolvePrefix("Carl");
        assertEquals(1, list.size());
        assertEquals("Carl Kurz", list.get(0));
    }

    @Test
    void generateTagAttributeValues() {
        List<String> list = PREFIX_TAG_RESOLVER.resolvePrefix("");
        assertEquals(2, list.size());

        list = PREFIX_TAG_RESOLVER.resolvePrefix("fri");
        assertEquals(1, list.size());
        assertEquals("friends", list.get(0));
    }
}
