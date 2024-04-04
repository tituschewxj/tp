package seedu.address.logic.autocomplete;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.util.CommandWordUtil.getAllCommandWords;

import java.util.List;
import java.util.stream.Collectors;

import seedu.address.commons.util.Trie;

/**
 * Auto complete commands
 */
public class AutoCompleteCommand implements AutoComplete {
    private static Trie commandTrie;

    /**
     * Initializes the command trie with the given commands. This method should be called once at
     * the start of the initialization of LogicManager.
     *
     * @see seedu.address.logic.LogicManager
     */
    public static void initialize() {
        commandTrie = new Trie(getAllCommandWords());
    }

    @Override
    public AutoCompleteResult getAutoComplete(String input) {
        requireNonNull(commandTrie);
        List<String> fullCommands = commandTrie.findAllWordsWithPrefix(input);

        assert fullCommands != null;
        if (fullCommands.isEmpty()) {
            return new AutoCompleteResult();
        }

        // Strip the input from the full commands and sort the list
        return new AutoCompleteResult(
                fullCommands.stream()
                        .map(c -> c.substring(input.length()))
                        .sorted()
                        .collect(Collectors.toList())
        );
    }
}
