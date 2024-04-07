package seedu.address.logic.attribute;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.util.Trie;

/**
 * Represents the trie of all of an attribute values.
 * <p>
 * The trie is lazily evaluated,
 * meaning the values are only generated when necessary,
 * improving performance.
 */
public class AttributeTrie {

    /** If the trie is present, it does not need to be regenerated. Otherwise, generate the trie. */
    private Optional<Trie> trieCache;

    /** The generator function to generate new values when needed */
    private final AttributeValueGenerator valuesGenerator;

    /**
     * Creates a new attribute trie of an attribute.
     */
    public AttributeTrie(AttributeValueGenerator valuesGenerator) {
        this.trieCache = Optional.empty();
        this.valuesGenerator = valuesGenerator;
    }

    /**
     * Finds all the attribute values in the trie that matches the given prefix.
     *
     * @param prefix The prefix to match the attribute values with.
     * @return The list of values as strings that matches the prefix.
     */
    public List<String> findAllValuesWithPrefix(String prefix) {
        return trieCache
                .orElseGet(this::generateTrie)
                .findAllWordsWithPrefix(prefix);
    }

    /**
     * Generates and caches the trie only when the autocompletion for this attribute trie is needed.
     */
    private Trie generateTrie() {
        trieCache = Optional.of(new Trie(
                valuesGenerator
                        .generate()
                        .toArray(String[]::new)
        ));
        return trieCache.get();
    }

    /**
     * Clears the stored attribute trie.
     */
    public void clearCache() {
        trieCache = Optional.empty();
    }
}
