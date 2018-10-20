//@author: linnnruoo
package seedu.address.ui;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
// import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;

/**
 * Calendar view of the App
 */

public class CalendarPanel extends UiPart<Region> {
    private static final String FXML = "CalendarPanel.fxml";

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
}
