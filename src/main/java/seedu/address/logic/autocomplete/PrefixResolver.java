package seedu.address.logic.autocomplete;

import java.util.List;

import seedu.address.logic.attribute.AttributeTrie;
import seedu.address.logic.attribute.AttributeValueGenerator;
import seedu.address.logic.parser.Prefix;

/**
 * Resolves the prefixes using a trie.
 */
public class PrefixResolver {
    private final Prefix prefix;
    private final AttributeTrie attributeTrie;

    /**
     * Creates a resolver for a prefix
     *
     * @param prefix The prefix identifier to resolve on.
     * @param attributeValuesGenerator The generator function to generate attribute values.
     */
    public PrefixResolver(Prefix prefix, AttributeValueGenerator attributeValuesGenerator) {
        assert prefix != null;
        this.prefix = prefix;

        assert attributeValuesGenerator != null;
        this.attributeTrie = new AttributeTrie(attributeValuesGenerator);
    }

    /**
     * Notifies the resolver that new data is available.
     */
    public void notifyOutdatedData() {
        attributeTrie.clearCache();
    }

    public Prefix getPrefix() {
        return prefix;
    }

    /**
     * Resolves the prefix matching.
     *
     * @return The list of values that match.
     */
    public List<String> resolvePrefix(String prefix) {
        return attributeTrie.findAllValuesWithPrefix(prefix);
    }
}
