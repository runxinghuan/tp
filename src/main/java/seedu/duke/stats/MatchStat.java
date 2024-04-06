package seedu.duke.stats;

//@@author runxinghuan

/**
 * Stats related to match progress of the game.
 */
public class MatchStat {
    private static int matchCount = 1;
    private static int roundCount = 1;
    private static int playerScore = 0;
    private static int aiScore = 0;
    private static boolean isPlayerWin = false;
    private static boolean isMatchEnd = false;
    private static boolean isPlayerTurn = true;
    private static boolean isNewMatch = true;

    /**
     * Updates playerScore, aiScore and roundCount after "shoot" and "save" commands.
     *
     * @param isGoal Whether the shooter scores or not.
     */
    public static void updateStat(boolean isGoal) {
        if (isPlayerTurn && isGoal) {
            playerScore += 1;
        } else if (!isPlayerTurn && isGoal) {
            aiScore += 1;
        }
        isPlayerTurn = !isPlayerTurn;

        decideMatchEnd();
        assert playerScore + aiScore <= roundCount : "Wrong computation of score.";
        roundCount += 1;
    }

    /**
     * Resets the stats after a new match starts.
     */
    public static void updateForNewMatch() {
        roundCount = 1;
        playerScore = 0;
        aiScore = 0;
        matchCount += 1;
        isMatchEnd = false;
        isPlayerTurn = true;
    }

    /**
     * Decides whether a match ends based on best-of-five kicks and sudden death rules.
     */
    private static void decideMatchEnd() {
        int roundsLeftForOneSide = (10 - roundCount) / 2;
        if (roundCount % 2 == 1) {
            roundsLeftForOneSide += 1;
        }

        if (roundCount < 10 && playerScore > aiScore) {
            int scoreDifference = playerScore - aiScore;
            if (scoreDifference > roundsLeftForOneSide) {
                isMatchEnd = true;
                isPlayerWin = true;
            }
        }

        if (roundCount < 10 && playerScore < aiScore) {
            int scoreDifference = aiScore - playerScore;
            if (scoreDifference > roundsLeftForOneSide) {
                isMatchEnd = true;
                isPlayerWin = false;
            }
        }

        if (roundCount >= 10 && isCompleteRound() && playerScore != aiScore) {
            isMatchEnd = true;
            isPlayerWin = playerScore > aiScore;
        }
    }

    /**
     * Decides whether both sides have finished shooting in a round.
     */
    private static boolean isCompleteRound() {
        return roundCount % 2 == 0;
    }

    public static boolean getIsNewMatch() {
        return isNewMatch;
    }

    public static boolean getIsPlayerWin() {
        return isPlayerWin;
    }

    public static int getMatchCount() {
        return matchCount;
    }

    public static int getRoundCount() {
        return roundCount;
    }

    public static boolean getIsMatchEnd() {
        return isMatchEnd;
    }

    public static int getPlayerScore() {
        return playerScore;
    }

    public static int getAiScore() {
        return aiScore;
    }

    public static void setMatchCount(int matchCount) {
        MatchStat.matchCount = matchCount + 1;
    }

    public static boolean getIsPlayerTurn() {
        return isPlayerTurn;
    }

    public static void setForShootFirst() {
        isPlayerTurn = true;
    }

    public static void setForSaveFirst() {
        isPlayerTurn = false;
    }

    public static void setMatchReady() {
        isNewMatch = false;
    }
}
