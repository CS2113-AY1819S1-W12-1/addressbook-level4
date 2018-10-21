package seedu.address.ui;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;

/**
 * @@ author: linnnruoo
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
        //calendarView.showMonthPage();
        calendarView.showWeekPage();
        calendarView.setShowDeveloperConsole(true);
        calendarView.setShowSearchResultsTray(false);
        calendarView.setShowToolBar(false);

        // Set css
        String fullpath = getClass().getResource("/view/CalendarTheme.css").toExternalForm();
        calendarView.getStylesheets().removeAll();
        calendarView.getStylesheets().add(fullpath);

        calendar = new Calendar("Your Weekly Schedule");
        calendar.setReadOnly(true);

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
