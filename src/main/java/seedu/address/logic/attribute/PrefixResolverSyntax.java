package seedu.address.logic.attribute;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NUSNET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

/**
 * Contains the prefix resolvers.
 */
public class PrefixResolverSyntax {
    public static final PrefixResolver PREFIX_MAJOR_RESOLVER = new PrefixResolver(
            PREFIX_MAJOR, AttributeValueGeneratorManager::getMajorAttributeValues
    );

    public static final PrefixResolver PREFIX_NUSNET_RESOLVER = new PrefixResolver(
            PREFIX_NUSNET, AttributeValueGeneratorManager::getNusNetIdAttributeValues
    );

    public static final PrefixResolver PREFIX_EMAIL_RESOLVER = new PrefixResolver(
            PREFIX_EMAIL, AttributeValueGeneratorManager::getEmailAttributeValues
    );

    public static final PrefixResolver PREFIX_NAME_RESOLVER = new PrefixResolver(
            PREFIX_NAME, AttributeValueGeneratorManager::getNameAttributeValues
    );

    public static final PrefixResolver PREFIX_PHONE_RESOLVER = new PrefixResolver(
            PREFIX_PHONE, AttributeValueGeneratorManager::getPhoneAttributeValues
    );

    public static final PrefixResolver PREFIX_TAG_RESOLVER = new PrefixResolver(
            PREFIX_TAG, AttributeValueGeneratorManager::generateTagAttributeValues
    );

    public static final PrefixResolver[] ALL_PREFIX_RESOLVERS = new PrefixResolver[]{
        PREFIX_EMAIL_RESOLVER, PREFIX_NAME_RESOLVER, PREFIX_TAG_RESOLVER,
        PREFIX_MAJOR_RESOLVER, PREFIX_NUSNET_RESOLVER, PREFIX_PHONE_RESOLVER
    };
}
