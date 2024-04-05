package seedu.address.logic.autocomplete;

import static seedu.address.logic.parser.CliSyntax.PREFIX_NUSNET;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import seedu.address.commons.util.Trie;

// TODO: code quality issues
/**
 * AutoComplete for NUSNET ID
 */
public class AutoCompleteNusNetId implements AutoComplete {
    private static Trie nusNetIdTrie;
    private static final Pattern NUSNET_ID_FORMAT = Pattern.compile(PREFIX_NUSNET.getPrefix() + "(.*)");

    /**
     * Initializes the NUSNET ID trie with the given NUSNET IDs. This method should be called once at
     * the start of the initialization of LogicManager.
     *
     * @param nusNetIds the NUSNET IDs to initialize the trie with
     */
    public static void initialize(String... nusNetIds) {
        nusNetIdTrie = new Trie(Arrays.stream(nusNetIds).map(String::toUpperCase).toArray(String[]::new));
    }

    /**
     * Update the NUSNET ID trie with the given NUSNET IDs. This method is just a wrapper for the
     * initialize method in Trie to make the intention clearer.
     *
     * @param nusNetIds the NUSNET IDs to update the trie with
     */
    public static void update(String... nusNetIds) {
        initialize(nusNetIds);
    }

    @Override
    public AutoCompleteResult getAutoComplete(String input) {
        assert nusNetIdTrie != null;

        Matcher m = NUSNET_ID_FORMAT.matcher(input);
        boolean isNusNetId = m.find();
        assert isNusNetId;

        String partialNusNetId = m.group(1);
        List<String> fullNusNetIds = nusNetIdTrie.findAllWordsWithPrefix(partialNusNetId.toUpperCase());

        assert fullNusNetIds != null;
        if (fullNusNetIds.isEmpty()) {
            return new AutoCompleteResult();
        }

        // Strip the input from the full commands and sort the list
        return new AutoCompleteResult(
                fullNusNetIds.stream()
                    .map(c -> c.substring(partialNusNetId.length()))
                    .sorted()
                    .collect(Collectors.toList())
        );
    }
}
