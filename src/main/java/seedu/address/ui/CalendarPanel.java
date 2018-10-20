//@author: linnnruoo
package seedu.address.ui;

// import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
// import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;

//import com.google.common.eventbus.Subscribe;
// import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.model.AddressBookChangedEvent;

/**
 * Calendar view of the App
 */

public class CalendarPanel extends UiPart<Region> {
    private static final String FXML = "CalendarPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(this.getClass());

    @FXML
    private CalendarView calendarView;

    private Calendar calendar;

    public CalendarPanel() {
        super(FXML);
        registerAsAnEventHandler(this);

        calendarView.setShowAddCalendarButton(false);
        calendarView.setShowPrintButton(false);
        calendarView.showWeekPage();

        // Set css
        String fullpath = getClass().getResource("/view/calendar.css").toExternalForm();
        calendarView.getStylesheets().removeAll();
        calendarView.getStylesheets().add(fullpath);

        // calendar = new Calendar("Your Weekly Schedule");
        // calendar.setReadOnly(true);

        CalendarSource myCalendarSource = new CalendarSource("My Personal Weekly Schedule");
        myCalendarSource.getCalendars().addAll(calendar);
        calendarView.getCalendarSources().addAll(myCalendarSource);
    }

    /**
     * Frees resources allocated to the browser.
     */
    public void freeResources() {
        calendarView = null;
    }

    private void handleAddressBookChangedEvent(AddressBookChangedEvent event) {
        // TODO: display lists of to do tasks
    }
}
