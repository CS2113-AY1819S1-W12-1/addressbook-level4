package seedu.address.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import seedu.address.logic.commands.ExportAllCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ScheduleCommand;

public class CommandSuggestionTest {
    private CommandSuggestion commandSuggestion = new CommandSuggestion();

    @Test
    public void getSuggestion() {
        // "abcDEF" input is not similar to any command
        assertSame(commandSuggestion.getSuggestion("abcDEF"), CommandSuggestion.NO_SUGGESTION);

        // "hist" input is similar to "list" command
        assertEquals(commandSuggestion.getSuggestion("hist"),
            String.format(CommandSuggestion.SUGGESTION_HEADER, ListCommand.COMMAND_WORD));

        // "shedule" input is similar to "schedule" command
        assertEquals(commandSuggestion.getSuggestion("shedule"),
            String.format(CommandSuggestion.SUGGESTION_HEADER, ScheduleCommand.COMMAND_WORD));

        // "exportalll" input is similar to "exportall" command
        assertEquals(commandSuggestion.getSuggestion("exportalll"),
            String.format(CommandSuggestion.SUGGESTION_HEADER, ExportAllCommand.COMMAND_WORD));
    }

}
