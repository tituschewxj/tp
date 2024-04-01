package seedu.address.ui.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.ui.util.SyntaxHighlighter.BOLD_STYLE_CLASS;
import static seedu.address.ui.util.SyntaxHighlighter.ERROR_STYLE_CLASS;
import static seedu.address.ui.util.SyntaxHighlighter.SUCCESS_STYLE_CLASS;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.MarkAttendanceCommand;


class SyntaxHighlighterTest {
    private static SyntaxHighlighter s;
    private static TextFlow errorTextFlow;
    private static TextFlow successTextFlow;
    private static TextFlow genericTextFlow;
    private static List<TextFlow> multilineTextFlows;

    @BeforeAll
    static void setUp() {
        s = new SyntaxHighlighter();
        errorTextFlow = s.generateLine(Messages.MESSAGE_UNKNOWN_COMMAND);
        successTextFlow = s.generateLine(MarkAttendanceCommand.MESSAGE_MARKED_ATTENDANCE_SUCCESS);
        genericTextFlow = s.generateLine(MarkAttendanceCommand.MESSAGE_USAGE);
        multilineTextFlows = s.generateLines(MarkAttendanceCommand.MESSAGE_MARKED_ATTENDANCE_SUCCESS + "\n"
                + MarkAttendanceCommand.MESSAGE_USAGE
        );
    }

    private void assertTextWrapChildrenKeywordBolded(TextFlow textFlow) {
        for (Node node : textFlow.getChildren()) {
            if (node instanceof Text) {
                Text text = (Text) node;
                String content = text.getText();
                assertEquals(
                        s.isKeyword(content),
                        text.getStyleClass().contains(BOLD_STYLE_CLASS)
                );
            }
        }
    }

    @Test
    void generateLine_errorLine_singleText() {
        ObservableList<Node> nodes = errorTextFlow.getChildren();
        assertEquals(1, nodes.size());
    }

    @Test
    void generateLine_errorLine_errorFormat() {
        Node node = errorTextFlow.getChildren().get(0);
        if (node instanceof Text) {
            Text text = (Text) node;
            assertTrue(text.getStyleClass().contains(ERROR_STYLE_CLASS));
            assertTrue(text.getStyleClass().contains(BOLD_STYLE_CLASS));
        }
    }

    @Test
    void generateLine_successLine_singleText() {
        ObservableList<Node> nodes = successTextFlow.getChildren();
        assertEquals(1, nodes.size());
    }

    @Test
    void generateLine_successLine_successFormat() {
        Node node = successTextFlow.getChildren().get(0);
        if (node instanceof Text) {
            Text text = (Text) node;
            assertTrue(text.getStyleClass().contains(SUCCESS_STYLE_CLASS));
            assertTrue(text.getStyleClass().contains(BOLD_STYLE_CLASS));
        }
    }

    @Test
    void generateLine_genericLine_childrenText() {
        for (Node node : genericTextFlow.getChildren()) {
            assertTrue(node instanceof Text);
        }
    }

    @Test
    void generateLine_genericLine_keywordsBold() {
        assertTextWrapChildrenKeywordBolded(genericTextFlow);
    }

    @Test
    void generateLine_genericLine_noInvalidFormats() {
        for (Node node : genericTextFlow.getChildren()) {
            if (node instanceof Text) {
                Text text = (Text) node;
                assertFalse(text.getStyleClass().contains(ERROR_STYLE_CLASS));
                assertFalse(text.getStyleClass().contains(SUCCESS_STYLE_CLASS));
            }
        }
    }

    @Test
    void generateLines_genericLines_valid() {
        for (TextFlow textFlow : multilineTextFlows) {
            // Ignore non-generic lines
            if (textFlow.getChildren().size() == 1) {
                continue;
            }
            assertTextWrapChildrenKeywordBolded(textFlow);
        }
    }
}
