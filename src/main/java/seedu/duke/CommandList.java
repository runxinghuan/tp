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

    public static boolean goalCheck(float userInput, float aiInput, float range) {
        assert userInput >= 0 && userInput <= 8 :
                "Illegal userInput generated!";
        assert aiInput >= 0 && aiInput <= 8 :
                "Illegal aiInput generated!";
        return ((userInput>(aiInput+range))||userInput<(aiInput-range));
    }

    public static void executePenalty(DifficultyLevel difficultyLevel) {
        Ai ai = new Ai(difficultyLevel);
        Penalty.executePenalty(ai);
    }
  
    public static void executeShoot(String[] readArgumentTokens) {
        String selectedDirection = readArgumentTokens[0];
        int selectedDirectionIndex = Integer.parseInt(selectedDirection);
        float adjustedDirection = PlayerList.playerList.get(Ui.curPlayer).shootDirectionAdjust(selectedDirectionIndex);
        float adjustedAiDirection = PlayerList.playerList.get(Ui.curPlayer).aiDirectionAdjust(Ai.getAiDirection());
        float adjustedRange = PlayerList.playerList.get(Ui.curPlayer).rangeAdjust();

        testForShoot(adjustedDirection, adjustedAiDirection, adjustedRange);
        boolean isScoreGoal = goalCheck(adjustedAiDirection, adjustedDirection,adjustedRange);

        MatchStat.updateStat(isScoreGoal);
        PlayerList.playerList.get(Ui.curPlayer).printGoalAfterShoot(isScoreGoal, Math.round(adjustedDirection));
    }

    private static void testForShoot(float adjustedDirection, float adjustedAiDirection, float adjustedRange) {
        System.out.println("Shoot: " + adjustedDirection);
        System.out.println("Save: " + adjustedAiDirection);
        System.out.println("Range: " + adjustedRange);
    }

    public static void executeUpgrade(String[] level){
        String upgradeLevel = level[0];
        int upgradeLevelIndex = Integer.parseInt(upgradeLevel);
        PlayerList.playerList.get(Ui.curPlayer).upgradePower(upgradeLevelIndex);
        PlayerList.playerList.get(Ui.curPlayer).printSelfInfo();
    }

    public static void executeSave(String[] readArgumentTokens) {
        String userSaveDirection = readArgumentTokens[0];
        int userSaveDirectionIndex = Integer.parseInt(userSaveDirection);
        int aiPenaltyDirection = Ai.getAiDirection();
        boolean isGoalSaved = userSaveDirectionIndex == aiPenaltyDirection;
        boolean isGoal = !isGoalSaved;
        MatchStat.updateStat(isGoal);
        Formatter.printSaveResult(isGoalSaved);
    }

    //insert new command here
}

