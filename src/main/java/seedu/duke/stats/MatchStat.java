package seedu.duke.stats;
//@@author runxinghuan

/**
 * Stats related to match progress of the game.
 */
public class MatchStat {
    public static final int MAX_ROUND_FOR_NOT_A_DRAW = 10;
    public static final int INITIAL_ROUND_COUNT = 1;
    public static final int INITIAL_MATCH_COUNT = 1;
    public static final int INITIAL_SCORE = 0;
    public static final int NUMBER_OF_TEAMS = 2;
    static int matchCount = INITIAL_MATCH_COUNT;
    static int roundCount = INITIAL_ROUND_COUNT;
    static int playerScore = INITIAL_SCORE;
    static int aiScore = INITIAL_SCORE;
    static boolean isPlayerWin = false;
    static boolean isMatchEnd = false;
    static boolean isPlayerShootTurn = true;
    static boolean isNewMatch = true;

    /**
     * Updates playerScore, aiScore and roundCount after "shoot" and "save" commands.
     *
     * @param isGoal Whether the shooter scores or not.
     */
    public static void updateStat(boolean isGoal) {
        if (isPlayerShootTurn && isGoal) {
            playerScore += 1;
        } else if (!isPlayerShootTurn && isGoal) {
            aiScore += 1;
        }
        isPlayerShootTurn = !isPlayerShootTurn;

        decideMatchEnd();
        assert playerScore + aiScore <= roundCount : "Wrong computation of score.";
        roundCount += 1;
    }

    /**
     * Resets the stats after a new match starts.
     */
    public static void updateForNewMatch() {
        roundCount = INITIAL_ROUND_COUNT;
        playerScore = INITIAL_SCORE;
        aiScore = INITIAL_SCORE;
        matchCount += 1;
        isMatchEnd = false;
        isPlayerShootTurn = true;
        isNewMatch = true;
    }

    /**
     * Decides whether a match ends based on best-of-five kicks and sudden death rules.
     */
    static void decideMatchEnd() {
        int roundsLeftForPlayer = (MAX_ROUND_FOR_NOT_A_DRAW - roundCount) / NUMBER_OF_TEAMS;
        int roundsLeftForAI = (MAX_ROUND_FOR_NOT_A_DRAW - roundCount) / NUMBER_OF_TEAMS;
        if (isPlayerShootTurn && !isCompleteRound()) {
            roundsLeftForPlayer += 1;
        }
        if (!isPlayerShootTurn && !isCompleteRound()) {
            roundsLeftForAI += 1;
        }

        if (roundCount < MAX_ROUND_FOR_NOT_A_DRAW && playerScore > aiScore) {
            int scoreDifference = playerScore - aiScore;
            if (scoreDifference > roundsLeftForAI) {
                isMatchEnd = true;
                isPlayerWin = true;
            }
        }

        if (roundCount < MAX_ROUND_FOR_NOT_A_DRAW && playerScore < aiScore) {
            int scoreDifference = aiScore - playerScore;
            if (scoreDifference > roundsLeftForPlayer) {
                isMatchEnd = true;
                isPlayerWin = false;
            }
        }

        if (roundCount >= MAX_ROUND_FOR_NOT_A_DRAW && isCompleteRound() && playerScore != aiScore) {
            isMatchEnd = true;
            isPlayerWin = playerScore > aiScore;
        }
    }

    /**
     * Decides whether both sides have finished shooting in a round.
     * As there are two teams, they shoot penalties in turns, an even roundCount means both sides have finished
     * shooting in a round.
     */
    private static boolean isCompleteRound() {
        return roundCount % NUMBER_OF_TEAMS == 0;
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

    public static boolean getIsPlayerShootTurn() {
        return isPlayerShootTurn;
    }

    public static void setForShootFirst() {
        isPlayerShootTurn = true;
    }

    public static void setForSaveFirst() {
        isPlayerShootTurn = false;
    }

    public static void setMatchReady() {
        isNewMatch = false;
    }
}
