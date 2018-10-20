package seedu.address.logic;

/**
 * Finds how similar two given strings are.
 * @author elstonayx
 */
public class StringSimilarity {
    private static final int ARRAY_PADDING = 1;
    private static final int DELETION_COST = 1;
    private static final int ADDITION_COST = 1;
    private static final int SUBSTITUTION_COST = 1;

    /**
     * Finds the edit distance between two strings.
     * @param userCommand the command the user has entered
     * @param commandToCheck the reference command to check the edit difference in string
     * @return {@code int} the edit distance of the two strings
     */
    public int editDistance(String userCommand, String commandToCheck) {
        int[][] distanceArray = new int[userCommand.length() + ARRAY_PADDING][commandToCheck.length() + ARRAY_PADDING];

        for (int i = 0; i < userCommand.length() + ARRAY_PADDING; i++) {
            distanceArray[i][0] = i;
        }

        for (int j = 0; j < commandToCheck.length() + ARRAY_PADDING; j++) {
            distanceArray[0][j] = j;
        }

        for (int i = 0; i < userCommand.length(); i++) {
            for (int j = 0; j < commandToCheck.length(); j++) {
                if (userCommand.charAt(i) == commandToCheck.charAt(j)) {
                    distanceArray[i + ARRAY_PADDING][j + ARRAY_PADDING] = distanceArray[i][j];
                } else {
                    distanceArray[i + ARRAY_PADDING][j + ARRAY_PADDING] = minimum(
                            distanceArray[i + ARRAY_PADDING][j] + DELETION_COST,
                            distanceArray[i][j + ARRAY_PADDING] + ADDITION_COST,
                            distanceArray[i][j] + SUBSTITUTION_COST
                    );
                }
            }
        }

        return distanceArray[userCommand.length()][commandToCheck.length()];
    }

    private int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
