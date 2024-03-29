package seedu.duke;

import seedu.duke.ai.Ai;
import seedu.duke.stats.MatchStat;
import seedu.duke.ui.Ui;

public enum CommandList {

    BYE, SHOOT, PENALTY, YES, NO, UPGRADE, EASY, MEDIUM, HARD, SAVE;

    //insert new user command name here
    ;

    /**
     * Exits the program
     */
    public static void executeBye() {
        Formatter.printGoodbyeMsg();
        Ui.setIsRunning(false);
    }

    public static boolean goalCheck(int userInput, int aiInput) {
        assert userInput >= 0 && userInput <= 2 :
                "Illegal userInput generated!";
        assert aiInput >= 0 && aiInput <= 2 :
                "Illegal aiInput generated!";
        return userInput != aiInput;
    }

    public static void executePenalty(DifficultyLevel difficultyLevel) {
        Ai ai = new Ai(difficultyLevel);
        Penalty.executePenalty(ai);
    }
  
    public static void executeShoot(String[] readArgumentTokens) {
        String selectedDirection = readArgumentTokens[0];
        int selectedDirectionIndex = Integer.parseInt(selectedDirection);
        boolean isScoreGoal = goalCheck(Ai.getAiDirection(), selectedDirectionIndex);

        MatchStat.updateStat(true, isScoreGoal); //Need to update after save command.
        Formatter.printGoalAfterShot(isScoreGoal);
    }

    public static void executeUpgrade(String[] level){
        String upgradeLevel = level[0];
        int upgradeLevelIndex = Integer.parseInt(upgradeLevel);

        PlayerList.l1.get(Ui.curplayer).upgradePower(upgradeLevelIndex);
        PlayerList.l1.get(Ui.curplayer).printSelfInfo();
    }

//    public static void executeSave() {
//        Save.executeSave();
//    }

    //insert new command here
}

