package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tag.Tag;

//@@linnnruoo
/**
 * Deletes a tag from all persons
 */
public class RemoveTagCommand extends Command {

    public static final String COMMAND_WORD = "remove_tag";
    public static final String COMMAND_ALIAS = "rt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes tag from all persons.\n"
            + "Example: " + COMMAND_WORD + "owe money";

    public static final String MESSAGE_DELETE_TAG_SUCCESS = "Removed tag: %1$s";

    private final Tag tag;

    public RemoveTagCommand(Tag tag) {
        this.tag = tag;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        Tag tagToDelete = this.tag;
        model.deleteTag(tagToDelete);
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_DELETE_TAG_SUCCESS, tagToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RemoveTagCommand // instanceof handles nulls
                && tag.equals(((RemoveTagCommand) other).tag)); // state check
    }
}
