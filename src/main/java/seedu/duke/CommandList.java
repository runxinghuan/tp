package seedu.duke;

import seedu.duke.ai.Ai;
import seedu.duke.stats.MatchStat;
import seedu.duke.stats.PlayerList;
import seedu.duke.ui.Ui;

//@@author hwc0419
public enum CommandList {

    BYE, SHOOT, PENALTY, YES, NO, SETPOWER, EASY, MEDIUM, HARD, SAVE, HEAD, TAIL, HELP, CUSTOMIZATION;

    /**
     * Exits the program
     */

    //@@author
    public static void executeBye() {
        Formatter.printGoodbyeMsg();
        Ui.setIsRunning(false);
    }

    public static boolean goalCheck(float userInput, float aiInput, float range) {
        assert aiInput >= 0 && aiInput <= 8 :
                "Illegal aiInput generated!";
        if ((int)userInput==-1){
            return false;
        }
        return ((userInput>(aiInput+range))||userInput<(aiInput-range));
    }

    public static void executePenalty(DifficultyLevel difficultyLevel) {
        Ai ai = new Ai(difficultyLevel);
        Penalty.executePenalty(ai);
    }

    //@@author HenryGan138
    /**
     * Executes the shooting process based on the provided argument tokens indicating the direction of the shoot.
     * This method processes the selected shooting direction, adjusts it based on player abilities, checks if the
     * shoot results in a goal, and updates various game statistics and player status accordingly.
     *
     * @param readArgumentTokens An array of strings representing command-line arguments.
     *                           The first token is expected to be the shooting direction as a string, which should be convertible to an integer.
     */
    public static void executeShoot(String[] readArgumentTokens) {
        String selectedDirection = readArgumentTokens[0];
        int selectedDirectionIndex = Integer.parseInt(selectedDirection);

        float adjustedDirection = PlayerList.playerList.get(Ui.curPlayer).shootDirectionAdjust(selectedDirectionIndex);
        float adjustedAiDirection = PlayerList.playerList.get(Ui.curPlayer).aiDirectionAdjust(Ai.getAiDirection());
        float adjustedRange = PlayerList.playerList.get(Ui.curPlayer).rangeAdjust();

        afterShootAnalysis(adjustedDirection);
        boolean isScoreGoal = goalCheck(adjustedDirection, adjustedAiDirection, adjustedRange);

        MatchStat.updateStat(isScoreGoal);
        PlayerList.playerList.get(Ui.curPlayer).calculatePerformanceCoins(isScoreGoal);
        PlayerList.playerList.get(Ui.curPlayer).printGoalAfterShoot(isScoreGoal, Math.round(adjustedDirection));
    }

    /**
     * Performs post-shoot analysis, printing the result of the shoot if it did not miss the target.
     * This method is utilized internally by the {@code executeShoot} method.
     *
     * @param adjustedDirection The adjusted shooting direction calculated based on player skills and conditions.
     */
    private static void afterShootAnalysis(float adjustedDirection) {
        int missedShot=-1;
        if ((int)adjustedDirection!=missedShot){
            System.out.println("----AFTER SHOT ANALYSIS----");
            System.out.printf("Your shoot aims at: %.2f\n",adjustedDirection);
            System.out.println("---------------------------");
        }
    }

    /**
     * Sets the power level of the current player based on the specified level.
     * This method reads the power level from the input, parses it to an integer, and applies it to the current player.
     * After upgrading the player's power, it also prints the player's information to display the new state.
     *
     * @param level An array of strings where the first element should be the power level as a string.
     *              This string should be convertible to an integer that corresponds to a valid power level.
     */
    public static void executeSetPower(String[] level){
        String upgradeLevel = level[0];
        int upgradeLevelIndex = Integer.parseInt(upgradeLevel);
        PlayerList.playerList.get(Ui.curPlayer).upgradePower(upgradeLevelIndex);
        PlayerList.playerList.get(Ui.curPlayer).printSelfInfo();
    }

    //@@author ymirmeddeb
    /**
     * Checks whether a save attempt was successful based on the user's input, AI's shot direction, and the allowed range for a successful save.
     * This method asserts that both the user's input and the AI's input are within valid bounds before determining the success of the save.
     *
     * @param userInput The direction of the saver's attempt to save the goal.
     * @param aiInput The direction of the AI's shot.
     * @param range The range within which a save attempt is considered successful.
     * @return {@code true} if the save attempt is successful, {@code false} otherwise.
     */
    public static boolean saveCheck(float userInput, float aiInput, float range) {
        assert aiInput >= 0 && aiInput <= 8 :
                "Illegal aiInput generated!";
        if ((int)userInput==-1){
            return false;
        }
        return ((userInput<(aiInput+range))||userInput>(aiInput-range));
    }

    //@@author ymirmeddeb
    /**
     * Executes the upgrade of the current saver's power level based on the specified level.
     * This method retrieves the current saver from {@code SaverList}, upgrades their power, and then prints their updated information.
     *
     * @param level The array containing the new power level to upgrade the saver to.
     */
    public static void executeSaverUpgrade(String[] level){
        String upgradeLevel = level[0];
        int upgradeLevelIndex = Integer.parseInt(upgradeLevel);
        SaverList.saverList.get(Ui.curSaver).upgradePower(upgradeLevelIndex);
        SaverList.saverList.get(Ui.curSaver).printSelfInfo();
        System.out.printf("Your power level has been upgraded to %s%n", level[0]);
    }

    private static void afterSaveAnalysis(float adjustedDirection, float adjustedRange) {
        int missedShot=-1;
        if ((int)adjustedDirection!=missedShot){
            System.out.println("----AFTER SAVE ANALYSIS----");
            System.out.printf("Your save aims at: %.2f\n",adjustedDirection);
            System.out.printf("Shooter's cover range: %.2f\n",adjustedRange);
            System.out.println("---------------------------");
        }
    }

    //@@author ymirmeddeb
    /**
     * Executes a save attempt, adjusting the direction based on the current saver's abilities, comparing it to the AI's shot direction, and determining the success of the save.
     * It then updates the match statistics and prints the outcome of the save attempt.
     *
     * @param readArgumentTokens The array containing the selected direction for the save attempt.
     */
    public static void executeSave(String[] readArgumentTokens) {
        String selectedDirection = readArgumentTokens[0];
        int selectedDirectionIndex = Integer.parseInt(selectedDirection);

        float adjustedSaveDirection = SaverList.saverList.get(Ui.curSaver).saveDirectionAdjust(selectedDirectionIndex);
        float adjustedAiDirection = SaverList.saverList.get(Ui.curSaver).aiDirectionAdjust(Ai.getAiDirection());
        float adjustedRange = SaverList.saverList.get(Ui.curSaver).rangeAdjust();

        afterSaveAnalysis(adjustedSaveDirection, adjustedRange);
        boolean isGoalSaved = saveCheck(adjustedSaveDirection, adjustedAiDirection, adjustedRange);

        MatchStat.updateStat(isGoalSaved);
        PlayerList.playerList.get(Ui.curPlayer).calculatePerformanceCoins(isGoalSaved);
        SaverList.saverList.get(Ui.curSaver).printGoalAfterSave(!isGoalSaved, Math.round(adjustedSaveDirection));
    }

    //@@author ymirmeddeb
    /**
     * Prints the commands available after a match is over
     */
    public static void executeHelpAfterMatch() {
        Formatter.printHelpAfterMatch();
    }

    //@@author ymirmeddeb
    /**
     * Prints the commands available when you first start the game
     */
    public static void executeHelpAtStart() {
        Formatter.printHelpAtStart();
    }

    //@@author ymirmeddeb
    /**
     * Prints the commands available during the game
     */
    public static void executeHelpDuringGame() {
        Formatter.printHelpDuringGame();
    }
}

