package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.ui.util.SyntaxHighlighter;

/**
 * A UI component that displays the {@code MESSAGE_USAGE} of a {@code Command}
 * in the {@code HelpWindow}.
 */
public class HelpWindowCommandCard extends UiPart<Region> {

    private static final String FXML = "HelpWindowCommandCard.fxml";
    private static final SyntaxHighlighter helpCardSyntax = new SyntaxHighlighter("cell_small_label");

    @FXML
    private Label commandWord;
    @FXML
    private VBox messageUsage;

    /**
     * Creates a {@code HelpWindowCommandCard} with the given {@code commandWord}
     * and the {@code messageUsage} of the {@code Command}.
     */
    public HelpWindowCommandCard(String commandWord, String messageUsage) {
        super(FXML);
        this.commandWord.setText(commandWord);
        this.messageUsage.getChildren().setAll(
                helpCardSyntax.generateLines(messageUsage)
        );
    }
}
