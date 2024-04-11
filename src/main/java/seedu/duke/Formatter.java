package seedu.duke;

import seedu.duke.stats.MatchStat;

import java.util.logging.Logger;

public class Formatter {
    private static final Logger logger = Logger.getLogger(Formatter.class.getName());

    /**
     * Appends a newline to a given string and returns the resulting string
     *
     * @param str the given string
     * @return A new string with a newline character appended to it
     */
    public static String appendNewLine(String str) {
        return String.format("%s\n", str);
    }

    public static void printWrapper(String wrapWith) {
        System.out.print("\t");
        for (int i = 0; i < 60; i++) {
            System.out.print(wrapWith);
        }
        System.out.print("\n");
    }

    /**
     * Prints welcome message at start of program
     */
    public static void printWelcomeMsg() {
        printWrapper("-");
        System.out.println("\t Welcome to NUSFC 24 ");
        printWrapper("-");
    }

    /**
     * Prints goodbye message when program terminates
     */
    public static void printGoodbyeMsg() {
        printWrapper("-");
        System.out.println("\t See you next time on court!");
        printWrapper("-");
    }

    /**
     * Method to check if the shot resulted in a goal
     * If shoot direction matches save direction, it's not a goal and the returned value is false.
     */

    //@@author HenryGan138
    public static void printGoalBeforeShotforBeginner() {
        assert MatchStat.getRoundCount() > 0 : "Round count should be greater than zero.";
        logger.info("Round " + MatchStat.getRoundCount());
        System.out.println("Match " + MatchStat.getMatchCount());
        System.out.println("Round " + MatchStat.getRoundCount());
        System.out.println("_______________________________");
        System.out.println("|         |         |         |");
        System.out.println("|         |         |         |");
        System.out.println("|    0    |    1    |    2    |");
        System.out.println("|         |         |         |");
        System.out.println("|         |         |         |");
        System.out.println("Select direction to shoot :");
    }

    public static void printGoalBeforeShotforMedium() {
        assert MatchStat.getRoundCount() > 0 : "Round count should be greater than zero.";
        logger.info("Round " + MatchStat.getRoundCount());
        System.out.println("Match " + MatchStat.getMatchCount());
        System.out.println("Round " + MatchStat.getRoundCount());
        System.out.println("_______________________________");
        System.out.println("|    0    |    1    |    2    |");
        System.out.println("|         |         |         |");
        System.out.println("|_________|_________|_________|");
        System.out.println("|         |         |         |");
        System.out.println("|    3    |    4    |    5    |");
        System.out.println("|         |         |         |");
        System.out.println("Select direction to shoot :");
    }

    public static void printGoalBeforeShotforExpert() {
        assert MatchStat.getRoundCount() > 0 : "Round count should be greater than zero.";
        logger.info("Round " + MatchStat.getRoundCount());
        System.out.println("Match " + MatchStat.getMatchCount());
        System.out.println("Round " + MatchStat.getRoundCount());
        System.out.println("_______________________________");
        System.out.println("|    0    |    1    |    2    |");
        System.out.println("|---------|---------|---------|");
        System.out.println("|    3    |    4    |    5    |");
        System.out.println("|---------|---------|---------|");
        System.out.println("|    6    |    7    |    8    |");
        System.out.println("Select direction to shoot :");
    }

    public static void printGoalAfterShotBeginner(boolean goalScored, int direction) {
        if (!goalScored) {
            logger.info("No goal :((((");
            System.out.println("_______________________________");
            System.out.println("\\         \\         \\         \\");
            System.out.println(" \\         \\         \\         \\");
            System.out.println("  \\         \\         \\         \\");
            System.out.println("   \\         \\         \\         \\");
            System.out.println("    \\         \\         \\         \\");
            System.out.println("no goal :((((");

        } else {
            logger.info("GOAL!!!!");
            switch (direction){
            case 0:
                System.out.println("_______________________________");
                System.out.println("| *    *  |         |         |");
                System.out.println("|    *    |         |         |");
                System.out.println("|*   *    |    1    |    2    |");
                System.out.println("|      *  |         |         |");
                System.out.println("|   *     |         |         |");
                break;
            case 1:
                System.out.println("_______________________________");
                System.out.println("|         |  *  *   |         |");
                System.out.println("|         |       * |         |");
                System.out.println("|    0    | *   *   |    2    |");
                System.out.println("|         |    *    |         |");
                System.out.println("|         |*   *  * |         |");
                break;
            case 2:
                System.out.println("_______________________________");
                System.out.println("|         |         | *      *|");
                System.out.println("|         |         |     *   |");
                System.out.println("|    0    |    1    |  *   *  |");
                System.out.println("|         |         |*      * |");
                System.out.println("|         |         | *   *   |");
                break;
            }
            System.out.println("GOAL!!!!");
        }
        showScore();
    }

    public static void printGoalAfterShotMedium(boolean goalScored, int direction) {
        if (!goalScored) {
            logger.info("No goal :((((");
            System.out.println("_______________________________");
            System.out.println("\\         \\         \\         \\");
            System.out.println(" \\         \\         \\         \\");
            System.out.println("  \\         \\         \\         \\");
            System.out.println("   \\         \\         \\         \\");
            System.out.println("    \\         \\         \\         \\");
            System.out.println("no goal :((((");
        } else {
            logger.info("GOAL!!!!");
            switch (direction) {
            case 0:
                System.out.println("_______________________________");
                System.out.println("|*   *    |    1    |    2    |");
                System.out.println("|  *   *  |         |         |");
                System.out.println("|_________|_________|_________|");
                System.out.println("|         |         |         |");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|         |         |         |");
                break;
            case 1:
                System.out.println("_______________________________");
                System.out.println("|    0    | *   *   |    2    |");
                System.out.println("|         |*   *  * |         |");
                System.out.println("|_________|_________|_________|");
                System.out.println("|         |         |         |");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|         |         |         |");
                break;
            case 2:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |  *   *  |");
                System.out.println("|         |         |*      * |");
                System.out.println("|_________|_________|_________|");
                System.out.println("|         |         |         |");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|         |         |         |");
                break;
            case 3:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|         |         |         |");
                System.out.println("|_________|_________|_________|");
                System.out.println("| *    *  |         |         |");
                System.out.println("|*   *    |    4    |    5    |");
                System.out.println("|         |         |         |");

                break;
            case 4:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|         |         |         |");
                System.out.println("|_________|_________|_________|");
                System.out.println("|         |       * |         |");
                System.out.println("|    3    | *   *   |    5    |");
                System.out.println("|         |         |         |");
                break;
            case 5:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|         |         |         |");
                System.out.println("|_________|_________|_________|");
                System.out.println("|         |         | *      *|");
                System.out.println("|    3    |    4    |  *   *  |");
                System.out.println("|         |         |         |");
                break;
            }
            System.out.println("GOAL!!!!");
        }
        showScore();
    }

    public static void printGoalAfterShotExpert(boolean goalScored, int direction) {
        if (!goalScored) {
            logger.info("No goal :((((");
            System.out.println("_______________________________");
            System.out.println("\\         \\         \\         \\");
            System.out.println(" \\         \\         \\         \\");
            System.out.println("  \\         \\         \\         \\");
            System.out.println("   \\         \\         \\         \\");
            System.out.println("    \\         \\         \\         \\");
            System.out.println("no goal :((((");
        } else {
            logger.info("GOAL!!!!");
            switch (direction) {
            case 0:
                System.out.println("_______________________________");
                System.out.println("|*   *   *|    1    |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    |    7    |    8    |");
                break;
            case 1:
                System.out.println("_______________________________");
                System.out.println("|    0    | *   *   |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    |    7    |    8    |");
                break;
            case 2:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |  *   *  |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    |    7    |    8    |");
                break;
            case 3:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|  *   *  |    4    |    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    |    7    |    8    |");
                break;
            case 4:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |*   *   *|    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    |    7    |    8    |");
                break;
            case 5:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |    4    | *  * *  |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    |    7    |    8    |");
                break;
            case 6:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|*   *    |    7    |    8    |");
                break;
            case 7:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    | *   *   |    8    |");
                break;
            case 8:
                System.out.println("_______________________________");
                System.out.println("|    0    |    1    |    2    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    3    |    4    |    5    |");
                System.out.println("|---------|---------|---------|");
                System.out.println("|    6    |    7    |  *   *  |");
                break;
            }
            System.out.println("GOAL!!!!");
        }
        showScore();
    }
    //@@author

    public static void printGoalAfterShot(boolean goalScored, int direction) {
        if (!goalScored) {
            logger.info("No goal :((((");
            System.out.println("_______________________________");
            System.out.println("\\         \\         \\         \\");
            System.out.println(" \\         \\         \\         \\");
            System.out.println("  \\         \\         \\         \\");
            System.out.println("   \\         \\         \\         \\");
            System.out.println("    \\         \\         \\         \\");
            System.out.println("no goal :((((");

        } else {
            logger.info("GOAL!!!!");
            switch (direction){
            case 0:
                System.out.println("_______________________________");
                System.out.println("| *    *  |         |         |");
                System.out.println("|    *    |         |         |");
                System.out.println("|*   *    |    1    |    2    |");
                System.out.println("|      *  |         |         |");
                System.out.println("|   *     |         |         |");
                break;
            case 1:
                System.out.println("_______________________________");
                System.out.println("|         |  *  *   |         |");
                System.out.println("|         |       * |         |");
                System.out.println("|    0    | *   *   |    2    |");
                System.out.println("|         |    *    |         |");
                System.out.println("|         |*   *  * |         |");
                break;
            case 2:
                System.out.println("_______________________________");
                System.out.println("|         |         | *      *|");
                System.out.println("|         |         |     *   |");
                System.out.println("|    0    |    1    |  *   *  |");
                System.out.println("|         |         |*      * |");
                System.out.println("|         |         | *   *   |");
                break;
            }
            System.out.println("GOAL!!!!");
        }
        showScore();
    }

    private static void showScore() {
        System.out.println("Your score: " + MatchStat.getPlayerScore());
        System.out.println("Opponent's score: " + MatchStat.getAiScore());
    }

    //@@author runxinghuan

    /**
     * Prints the result after a match ends.
     */
    public static void printMatchResult() {
        if (MatchStat.getIsPlayerWin()) {
            System.out.println("Nice! You won this match! Want a new match?");
        } else {
            System.out.println("You lost this match. Wanna a new match?");
        }
    }

    //@@author ymirmeddeb
    /**
     * Prints out the goal before "save" command when the player's saving ability is beginner.
     */
    public static void printGoalBeforeSaveForBeginner() {
        assert MatchStat.getRoundCount() > 0 : "Round count should be greater than zero.";
        System.out.println("Match " + MatchStat.getMatchCount());
        System.out.println("Round " + MatchStat.getRoundCount());
        System.out.println("_______________________________");
        System.out.println("|         |         |         |");
        System.out.println("|         |         |         |");
        System.out.println("|    0    |    1    |    2    |");
        System.out.println("|         |         |         |");
        System.out.println("|         |         |         |");
        System.out.println("\nSelect direction to save : [0-2]");
    }

    /**
     * Prints out the goal before "save" command when the player's saving ability is medium.
     */
    public static void printGoalBeforeSaveForMedium() {
        assert MatchStat.getRoundCount() > 0 : "Round count should be greater than zero.";
        System.out.println("Match " + MatchStat.getMatchCount());
        System.out.println("Round " + MatchStat.getRoundCount());
        System.out.println("_______________________________");
        System.out.println("|    0    |    1    |    2    |");
        System.out.println("|         |         |         |");
        System.out.println("|_________|_________|_________|");
        System.out.println("|         |         |         |");
        System.out.println("|    3    |    4    |    5    |");
        System.out.println("|         |         |         |");
        System.out.println("\nSelect direction to save : [0-5]");
    }

    /**
     * Prints out the goal before "save" command when the player's saving ability is expert.
     */
    public static void printGoalBeforeSaveForExpert() {
        assert MatchStat.getRoundCount() > 0 : "Round count should be greater than zero.";
        System.out.println("Match " + MatchStat.getMatchCount());
        System.out.println("Round " + MatchStat.getRoundCount());
        System.out.println("_______________________________");
        System.out.println("|    0    |    1    |    2    |");
        System.out.println("|---------|---------|---------|");
        System.out.println("|    3    |    4    |    5    |");
        System.out.println("|---------|---------|---------|");
        System.out.println("|    6    |    7    |    8    |");
        System.out.println("\nSelect direction to save : [0-8]");
    }

    //@@author ymirmeddeb
    /**
     * Prints out the goal after "save" command when the player's saving ability is expert.
     * If isGoalSaved is false, "no save :((((" is printed with a depiction of a broken goal post.
     * If isGoalSaved is true, "SAVED!!!!" is printed with a depiction of a goal post with the square corresponding to direction has "SAVED" instead of the direction.
     *
     * @param isGoalSaved Indicates whether a goal was scored or not.
     * @param direction The direction in which the save was attempted.
     */
    public static void printGoalAfterSaveForBeginner(boolean isGoalSaved, int direction) {
        if (!isGoalSaved) {
            logger.info("No save :((((");
            System.out.println("_______________________________");
            System.out.println("\\         \\         \\         \\");
            System.out.println(" \\         \\         \\         \\");
            System.out.println("  \\         \\         \\         \\");
            System.out.println("   \\         \\         \\         \\");
            System.out.println("    \\         \\         \\         \\");
            System.out.println("no save :((((");

        } else {
            logger.info("SAVE!!!!");
            switch (direction){
                case 0:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|         |         |         |");
                    System.out.println("|  SAVED  |    1    |    2    |");
                    System.out.println("|         |         |         |");
                    System.out.println("|         |         |         |");
                    break;
                case 1:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|         |         |         |");
                    System.out.println("|    0    |  SAVED  |    2    |");
                    System.out.println("|         |         |         |");
                    System.out.println("|         |         |         |");
                    break;
                case 2:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|         |         |         |");
                    System.out.println("|    0    |    1    |  SAVED  |");
                    System.out.println("|         |         |         |");
                    System.out.println("|         |         |         |");
                    break;
            }
            System.out.println("SAVE!!!!");
        }
        showScore();
    }

    //@@author ymirmeddeb
    /**
     * Prints out the goal after "save" command when the player's saving ability is expert.
     * If isGoalSaved is false, "no save :((((" is printed with a depiction of a broken goal post.
     * If isGoalSaved is true, "SAVED!!!!" is printed with a depiction of a goal post with the square corresponding to direction has "SAVED" instead of the direction.
     *
     * @param isGoalSaved Indicates whether a goal was scored or not.
     * @param direction The direction in which the save was attempted.
     */
    public static void printGoalAfterSaveMedium(boolean isGoalSaved, int direction) {
        if (!isGoalSaved) {
            logger.info("No save :((((");
            System.out.println("_______________________________");
            System.out.println("\\         \\         \\         \\");
            System.out.println(" \\         \\         \\         \\");
            System.out.println("  \\         \\         \\         \\");
            System.out.println("   \\         \\         \\         \\");
            System.out.println("    \\         \\         \\         \\");
            System.out.println("no save :((((");
        } else {
            logger.info("SAVE!!!!");
            switch (direction) {
                case 0:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|  SAVED  |    1    |    2    |");
                    System.out.println("|_________|_________|_________|");
                    System.out.println("|         |         |         |");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|         |         |         |");
                    break;
                case 1:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|    0    |  SAVED  |    2    |");
                    System.out.println("|_________|_________|_________|");
                    System.out.println("|         |         |         |");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|         |         |         |");
                    break;
                case 2:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|    0    |    1    |  SAVED  |");
                    System.out.println("|_________|_________|_________|");
                    System.out.println("|         |         |         |");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|         |         |         |");
                    break;
                case 3:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|_________|_________|_________|");
                    System.out.println("|         |         |         |");
                    System.out.println("|  SAVED  |    4    |    5    |");
                    System.out.println("|         |         |         |");
                    break;
                case 4:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|_________|_________|_________|");
                    System.out.println("|         |         |         |");
                    System.out.println("|    3    |  SAVED  |    5    |");
                    System.out.println("|         |         |         |");
                    break;
                case 5:
                    System.out.println("_______________________________");
                    System.out.println("|         |         |         |");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|_________|_________|_________|");
                    System.out.println("|         |         |         |");
                    System.out.println("|    3    |    4    |  SAVED  |");
                    System.out.println("|         |         |         |");
                    break;
            }
            System.out.println("SAVE!!!!");
        }
        showScore();
    }

    public static void printCustomizationMenu() {
        System.out.println("Customization Menu:");
        System.out.println("1. Purchase Customizations");
        System.out.println("2. View Coin Balance");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void printCustomizationItems() {
        System.out.println("Available Customization Items:");
        System.out.println("1. Power Boost - Cost: 150 coins");
        System.out.println("2. Skill Boost - Cost: 200 coins");
        System.out.println("3. Fancy Uniform - Cost: 100 coins");
        System.out.print("Enter the number of the customization item you want to purchase: ");
    }

    public static void printInsufficientCoins() {
        System.out.println("Insufficient coins to make the purchase.");
    }

    public static void printCustomizationPurchased(String item) {
        System.out.println("You have successfully purchased the " + item + " customization!");
    }

    public static void printInvalidCustomizationChoice() {
        System.out.println("Invalid choice. Please try again.");
    }

    public static void printExitCustomizationMenu() {
        System.out.println("Exiting Customization Menu.");
    }

    //@@author ymirmeddeb
    /**
     * Prints out the goal after "save" command when the player's saving ability is expert.
     * If isGoalSaved is false, "no save :((((" is printed with a depiction of a broken goal post.
     * If isGoalSaved is true, "SAVED!!!!" is printed with a depiction of a goal post with the square corresponding to direction has "SAVED" instead of the direction.
     *
     * @param isGoalSaved Indicates whether a goal was scored or not.
     * @param direction The direction in which the save was attempted.
     */
    public static void printGoalAfterSaveExpert(boolean isGoalSaved, int direction) {
        if (!isGoalSaved) {
            logger.info("No save :((((");
            System.out.println("_______________________________");
            System.out.println("\\         \\         \\         \\");
            System.out.println(" \\         \\         \\         \\");
            System.out.println("  \\         \\         \\         \\");
            System.out.println("   \\         \\         \\         \\");
            System.out.println("    \\         \\         \\         \\");
            System.out.println("no save :((((");
        } else {
            logger.info("SAVE!!!!");
            switch (direction) {
                case 0:
                    System.out.println("_______________________________");
                    System.out.println("|  SAVED  |    1    |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |    7    |    8    |");
                    break;
                case 1:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |  SAVED  |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |    7    |    8    |");
                    break;
                case 2:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |    1    |  SAVED  |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |    7    |    8    |");
                    break;
                case 3:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|  SAVED  |    4    |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |    7    |    8    |");
                    break;
                case 4:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |  SAVED  |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |    7    |    8    |");
                    break;
                case 5:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |    4    |  SAVED  |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |    7    |    8    |");
                    break;
                case 6:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|  SAVED  |    7    |    8    |");
                    break;
                case 7:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |  SAVED  |    8    |");
                    break;
                case 8:
                    System.out.println("_______________________________");
                    System.out.println("|    0    |    1    |    2    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    3    |    4    |    5    |");
                    System.out.println("|---------|---------|---------|");
                    System.out.println("|    6    |    7    |  SAVED  |");
                    break;
            }
            System.out.println("SAVE!!!!");
        }
        showScore();
    }

    /**
     * Prints "list is empty" if tasks list is empty
     */
    public static void printListEmpty() {
        System.out.println("\t List is empty. Add tasks using commands \"todo\", \"deadline\", \"event\".");
    }

    /**
     * Prints an error message indicating wrong command is entered
     */
    public static void printErrorWrongCommand() {
        System.out.println("\t CommandParser: Command not found ");
    }

    /**
     * Prints an error message indicating command failed to execute
     */
    public static void printErrorExecutionFail() {
        System.out.println("\t Ui: Command could not be executed ");
        System.out.println("\t Try again");
    }

    /**
     * Prints an error message indicating an unknown error has occured
     */
    public static void printErrorUnknown() {
        System.out.println("\t Ui: Unexpected error ");
    }

    /**
     * Prints an error message indicating there is at least one bad argument provided
     */
    public static void printErrorBadTokens() {
        System.out.println("\t Ui: Bad Token Error, please check your arguments");
    }

    /**
     * Prints an error message stating the number of arguments given
     * versus the number of arguments expected for given command
     *
     * @param correctArgumentCount the expected number of arguments for given command
     * @param userArgumentCount    the given number of arguments read from user input
     * @param userCommandName      the command name read from user input
     */
    public static void printErrorArgumentsMismatch(String userCommandName,
                                                   int userArgumentCount, int correctArgumentCount) {
        System.out.printf("\t SyntaxAnalyser: Command %s contains too %s arguments. Given: %d - Expected: %d\n",
                userCommandName,
                userArgumentCount < correctArgumentCount ? "few" : "many",
                userArgumentCount, correctArgumentCount);
    }

    /**
     * Prints an error message indicating that the regex pattern failed to match at a given argument position
     * for a given command name
     *
     * @param argumentPosition the index position of the argument which failed to match the correct type
     * @param regex            the correct type for the argument
     * @param commandName     the name of the given command
     */
    public static void printErrorWrongArgumentType(final String commandName, String regex, int argumentPosition) {
        int userRanking = argumentPosition + 1;
        String rankingSuffix;
        switch (userRanking) {
        case 1:
            rankingSuffix = "st";
            break;
        case 2:
            rankingSuffix = "nd";
            break;
        case 3:
            rankingSuffix = "rd";
            break;
        default:
            rankingSuffix = "th";
            break;
        }
        System.out.printf("\t SyntaxAnalyser: %s expects the %d%s argument to be %s\n",
                commandName, userRanking, rankingSuffix, regex);
    }

    /**
     * Prints an error message indicating the selected index is not in range
     */
    public static void printErrorIndexOutOfRange() {
        System.out.println("\t List: Selected index not in range. Try again.");
    }

    /**
     * Prints an error message indicating the cache file is corrupted at a given line
     *
     * @param lineNum the line number which does not follow the file format of cache file
     */
    public static void printFileCorruptionError(int lineNum) {
        System.out.println("Cache file is corrupted at line " + lineNum);
        System.out.println("Failed to load cache");
        System.out.println("Program will start with empty list");
    }

    //@@author runxinghuan
    /**
     * Prints the message guiding the user to guess the coin toss.
     */
    public static void printBeforeCoinToss() {
        System.out.println("Welcome to a new match!");
        System.out.println("You need to guess a coin toss to decide who shoots the penalty first.");
        System.out.println("If you guess it correctly, you can shoot first!");
        System.out.println("Please guess: head or tail?");
    }

    /**
     * Prints the result (head) of the coin toss.
     */
    public static void printCoinHead() {
        System.out.println("    ----    ");
        System.out.println("  / ^ ^ \\  ");
        System.out.println("  \\  -  /  ");
        System.out.println("    ----    ");
        System.out.println("You got a head!");
    }

    /**
     * Prints the result (tail) of the coin toss.
     */
    public static void printCoinTail() {
        System.out.println("    ----    ");
        System.out.println("  /  1  \\  ");
        System.out.println("  \\     /  ");
        System.out.println("    ----    ");
        System.out.println("You got a tail!");
    }

    /**
     * Prints the result (upright) of the coin toss.
     */
    public static void printCoinUpright() {
        System.out.println("    --    ");
        System.out.println("   /  \\  ");
        System.out.println("   \\  /  ");
        System.out.println("    --    ");
        System.out.println("Oh no! The coin is standing upright on the ground!");
        System.out.println("You need to guess again.");
    }

    /**
     * Prints the message when the user makes a correct guess of coin toss.
     */
    public static void printCorrectGuess() {
        System.out.println("You guess it correctly! You can shoot first now!");
    }

    /**
     * Prints the message when the user makes a wrong guess of coin toss.
     */
    public static void printWrongGuess() {
        System.out.println("You guess it wrongly. But you can save first.");
    }
    //@@author
}
