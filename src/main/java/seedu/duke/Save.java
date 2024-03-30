package seedu.duke;

import seedu.duke.ai.Ai;
import seedu.duke.stats.MatchStat;
import seedu.duke.ui.Ui;

public class Save {

    public static void executeSave() {
        int userSaveDirection = getUserSaveDirection();
        int aiPenaltyDirection = Ai.getAiDirection();
        boolean isGoalSaved = userSaveDirection == aiPenaltyDirection;
        Formatter.printSaveResult(isGoalSaved);
        MatchStat.updateStat(isGoalSaved);
    }

    private static int getUserSaveDirection() {
        int userDirection = -1;
        while (userDirection == -1) {
            System.out.print("Enter the direction to save the penalty (0, 1, or 2): ");
            String directionString = Ui.IN.nextLine().trim();
            userDirection = convertToShootDirection(directionString);
            if (userDirection == -1) {
                System.out.println("Invalid direction! Please enter 0, 1, or 2.");
            }
        }
        return userDirection;
    }

    private static int convertToShootDirection(String direction) {
        try {
            int directionIndex = Integer.parseInt(direction);
            if (directionIndex >= 0 && directionIndex <= 2) {
                return directionIndex;
            } else {
                return -1; // Invalid direction
            }
        } catch (NumberFormatException e) {
            return -1; // Input was not an integer
        }
    }
}
