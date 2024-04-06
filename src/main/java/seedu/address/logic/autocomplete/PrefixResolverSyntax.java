package seedu.address.logic.autocomplete;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NUSNET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.attribute.AttributeValueGenerator;

/**
 * Contains the prefix resolvers.
 */
public class PrefixResolverSyntax {
    public static final PrefixResolver PREFIX_MAJOR_RESOLVER = new PrefixResolver(
            PREFIX_MAJOR, AttributeValueGenerator::getMajorAttributeValues
    );

    public static final PrefixResolver PREFIX_NUSNET_RESOLVER = new PrefixResolver(
            PREFIX_NUSNET, AttributeValueGenerator::getNusNetIdAttributeValues
    );

    public static final PrefixResolver PREFIX_EMAIL_RESOLVER = new PrefixResolver(
            PREFIX_EMAIL, AttributeValueGenerator::getEmailAttributeValues
    );

    public static final PrefixResolver PREFIX_NAME_RESOLVER = new PrefixResolver(
            PREFIX_NAME, AttributeValueGenerator::getNameAttributeValues
    );

    public static final PrefixResolver PREFIX_PHONE_RESOLVER = new PrefixResolver(
            PREFIX_PHONE, AttributeValueGenerator::getPhoneAttributeValues
    );

    public static final PrefixResolver PREFIX_TAG_RESOLVER = new PrefixResolver(
            PREFIX_TAG, AttributeValueGenerator::generateTagAttributeValues
    );

    public static final PrefixResolver[] ALL_PREFIX_RESOLVERS = new PrefixResolver[]{
        PREFIX_EMAIL_RESOLVER, PREFIX_NAME_RESOLVER, PREFIX_TAG_RESOLVER,
        PREFIX_MAJOR_RESOLVER, PREFIX_NUSNET_RESOLVER, PREFIX_PHONE_RESOLVER
    };
}
