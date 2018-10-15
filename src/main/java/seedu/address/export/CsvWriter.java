package seedu.address.export;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.opencsv.CSVWriter;

import javafx.collections.ObservableList;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Person;

//@@author jitwei98
/**
 * The writer for CSV file of the app.
 */
public class CsvWriter {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private static final int INDEX_PERSON_NAME = 0;
    private static final int INDEX_PERSON_PHONE = 2;
    private static final int INDEX_PERSON_ADDRESS = 3;
    private static final int INDEX_PERSON_EMAIL = 4;

    private final String[] header = { "Name", "Phone", "Address", "Email" };
    private final ObservableList<Person> persons;
    private final Path outputFilepath = Paths.get("data" , "pineapple.csv");

    public CsvWriter(ObservableList<Person> persons) {
        requireAllNonNull(persons);

        // TODO: Refactor this to a exportFileWriter interface
        logger.fine("Initializing with output file: " + outputFilepath.toString());

        this.persons = persons;
    }

    /**
     * Writes to the .csv file as defined in {@code outputFilepath}.
     */
    public void writeToCsv() {
        try {

            File file = new File(String.valueOf(outputFilepath));
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeNext(header);

            List<String[]> data = new ArrayList<>();
            persons.forEach(person -> {
                String[] personDetails = convertToStringArray(person);
                data.add(personDetails);
            });

            writer.writeAll(data);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: Implement a writeToCsv() with a specific filepath.

    /**
     *
     * @param person {@code Person} A single person from the addressbook.
     * @return A string array containing the name, phone, address, and email of
     *          the {@code person}.
     */
    private String[] convertToStringArray(Person person) {
        String[] personDetails = new String[header.length];
        personDetails[INDEX_PERSON_NAME] = person.getName().toString();
        personDetails[INDEX_PERSON_PHONE] = person.getPhone().toString();
        personDetails[INDEX_PERSON_ADDRESS] = person.getAddress().toString();
        personDetails[INDEX_PERSON_EMAIL] = person.getEmail().toString();
        return personDetails;
    }
}
