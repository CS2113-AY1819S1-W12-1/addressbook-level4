package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
//import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
//import seedu.address.model.person.Person;

/**
 * Edits the remark for a person specified by the INDEX
 */
public class RemarkCommand extends Command {

    public static final String COMMAND_WORD = "remark";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the remark for a person specified in the INDEX. "
            + "Parameters: INDEX (must be a positive integer)"
            + PREFIX_REMARK + "REMARK"
            + "Example: " + COMMAND_WORD + " 1"
            + PREFIX_REMARK + "Likes to sleep";

    public static final String REMARK_PARAMETERS = "Index: %1$d, Remark: %2$s";
    //public static final String MESSAGE_REMARK_SUCCESS = "New remark added for: %1$s";
    //public static final String MESSAGE_DELETE_REMARK_SUCCESS = "Remark deleted for: %1$s";

    private final Index targetIndex;
    private final String remark;

    public RemarkCommand(Index targetIndex, String remark) {
        requireNonNull(targetIndex, remark);

        this.targetIndex = targetIndex;
        this.remark = remark;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        throw new CommandException(String.format(REMARK_PARAMETERS, targetIndex.getOneBased(), remark));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof RemarkCommand)) {
            return false;
        }

        RemarkCommand e = (RemarkCommand) other;
        return targetIndex.equals(e.targetIndex) && remark.equals(e.remark);
    }
}
