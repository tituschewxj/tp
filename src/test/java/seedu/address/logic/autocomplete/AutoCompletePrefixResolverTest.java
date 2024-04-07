package seedu.address.logic.autocomplete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NUSNET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.attribute.PrefixResolver;
import seedu.address.logic.parser.Prefix;

class AutoCompletePrefixResolverTest {

    private List<String> listA;
    private List<String> listB;
    private PrefixResolver prefixResolverA;
    private PrefixResolver prefixResolverB;
    private AutoCompletePrefixResolver autoCompletePrefixResolver;
    @BeforeEach
    void setUp() {
        listA = new ArrayList<>();
        listA.addAll(Arrays.asList("abc", "defg", "hijk", "lmnop", "qrs", "tuv", "wxyz"));
        prefixResolverA = new PrefixResolver(new Prefix("abc/"), () -> listA);

        listB = new ArrayList<>();
        listB.addAll(Arrays.asList("c 1 2 3", "b 4 56", "a7 8 9", "b 654", "c321", "a9 87"));
        prefixResolverB = new PrefixResolver(new Prefix("c/"), () -> listB);

        autoCompletePrefixResolver = new AutoCompletePrefixResolver(prefixResolverA, prefixResolverB);
    }

    @Test
    void getAutoComplete_emptyResolvedResult() {
        clearAndNotifyResolver(listA, prefixResolverA);

        assertEquals("", autoCompletePrefixResolver.getAutoComplete("abc/").getNextResult());
        assertEquals("", autoCompletePrefixResolver.getAutoComplete("").getNextResult());
        assertEquals("", autoCompletePrefixResolver.getAutoComplete("!(#*$)(@#*&").getNextResult());

        assertThrows(AssertionError.class, () -> autoCompletePrefixResolver.getAutoComplete(null));
    }

    @Test
    void getAutoComplete_noPrefixResolvers() {
        AutoCompletePrefixResolver resolver = new AutoCompletePrefixResolver();

        assertEquals("", resolver.getAutoComplete("abc/").getNextResult());
        assertEquals("", resolver.getAutoComplete("").getNextResult());
    }

    @Test
    void getAutoComplete_updateGenerator_singleAttribute() {
        List<String> nusNetIds = new ArrayList<>();
        nusNetIds.addAll(Arrays.asList("e1234567", "e7654321", "e0000000"));
        PrefixResolver prefixResolver = new PrefixResolver(PREFIX_NUSNET, () -> nusNetIds);
        AutoCompletePrefixResolver ac = new AutoCompletePrefixResolver(prefixResolver);

        assertEquals("234567", ac.getAutoComplete("nn/e1").getNextResult());
        assertEquals("654321", ac.getAutoComplete("nn/e7").getNextResult());
        assertEquals("000000", ac.getAutoComplete("nn/e0").getNextResult());

        clearAndNotifyResolver(nusNetIds, prefixResolver, "e1111111", "e2222222", "e3333333");

        assertEquals("111111", ac.getAutoComplete("nn/e1").getNextResult());
        assertEquals("222222", ac.getAutoComplete("nn/e2").getNextResult());
        assertEquals("333333", ac.getAutoComplete("nn/e3").getNextResult());

        clearAndNotifyResolver(nusNetIds, prefixResolver);

        assertEquals("", ac.getAutoComplete("nn/e1").getNextResult());
    }

    @Test
    void getAutoComplete_updateGenerator_multipleAttributes() {
        // Blank value after prefix
        AutoCompleteResult result = autoCompletePrefixResolver.getAutoComplete("abc/");
        assertEquals("abc", result.getNextResult());
        assertEquals("defg", result.getNextResult());
        assertEquals("hijk", result.getNextResult());

        // New data generated
        clearAndNotifyResolver(listA, prefixResolverA, "ABC", "DEF");
        result = autoCompletePrefixResolver.getAutoComplete("abc/");
        assertEquals("ABC", result.getNextResult());
        assertEquals("DEF", result.getNextResult());
        assertEquals("ABC", result.getNextResult());

        // Other generator unaffected
        result = autoCompletePrefixResolver.getAutoComplete("c/");
        assertEquals("a7 8 9", result.getNextResult());
        assertEquals("a9 87", result.getNextResult());
        assertEquals("b 4 56", result.getNextResult());
    }

    @Test
    void getAutoComplete_multipleAttributes() {
        // Multiple prefixes present
        AutoCompleteResult result = autoCompletePrefixResolver.getAutoComplete("abc abc/qrs xyz/xxx abc/");
        assertEquals("abc", result.getNextResult());
        assertEquals("defg", result.getNextResult());
        assertEquals("hijk", result.getNextResult());

        // Trie matching
        result = autoCompletePrefixResolver.getAutoComplete("abc/!@#$$%@%(#%$*^ c/c");
        assertEquals(" 1 2 3", result.getNextResult());
        assertEquals("321", result.getNextResult());
        assertEquals(" 1 2 3", result.getNextResult());

        // No match
        assertEquals("", autoCompletePrefixResolver.getAutoComplete("ABC/").getNextResult());
        assertEquals("", autoCompletePrefixResolver.getAutoComplete("xxc/").getNextResult());
        assertEquals("", autoCompletePrefixResolver.getAutoComplete("c/ab").getNextResult());
    }

    /**
     * Clears, updates and notifies the resolver that the new data is present.
     */
    private void clearAndNotifyResolver(List<String> list, PrefixResolver resolver, String... newData) {
        list.clear();
        list.addAll(Arrays.asList(newData));
        resolver.notifyOutdatedData();
    }
}
