package seedu.duke.stats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.stats.MatchStat.INITIAL_MATCH_COUNT;
import static seedu.duke.stats.MatchStat.INITIAL_ROUND_COUNT;
import static seedu.duke.stats.MatchStat.INITIAL_SCORE;
import static seedu.duke.stats.MatchStat.aiScore;
import static seedu.duke.stats.MatchStat.isMatchEnd;
import static seedu.duke.stats.MatchStat.isNewMatch;
import static seedu.duke.stats.MatchStat.isPlayerShootTurn;
import static seedu.duke.stats.MatchStat.isPlayerWin;
import static seedu.duke.stats.MatchStat.matchCount;
import static seedu.duke.stats.MatchStat.playerScore;
import static seedu.duke.stats.MatchStat.roundCount;

public class MatchStatTest {
    @BeforeEach
    public void setUp() {
        matchCount = INITIAL_MATCH_COUNT;
        roundCount = INITIAL_ROUND_COUNT;
        playerScore = INITIAL_SCORE;
        aiScore = INITIAL_SCORE;
        isPlayerWin = false;
        isMatchEnd = false;
        isPlayerShootTurn = true;
        isNewMatch = true;
    }
    @Test
    public void updateForNewMatch() {
        MatchStat.updateForNewMatch();
        assertEquals(roundCount, INITIAL_ROUND_COUNT);
        assertEquals(playerScore, INITIAL_SCORE);
        assertEquals(aiScore, INITIAL_SCORE);
        assertFalse(isMatchEnd);
        assertTrue(isPlayerShootTurn);
    }

    @Test
    public void setMatchReady() {
        MatchStat.setMatchReady();
        assertFalse(isNewMatch);
    }

    @Test
    public void setForShootFirst() {
        MatchStat.setForShootFirst();
        assertTrue(isPlayerShootTurn);
    }

    @Test
    public void setForSaveFirst() {
        MatchStat.setForSaveFirst();
        assertFalse(isPlayerShootTurn);
    }

    @Test
    public void setMatchCount() {
        MatchStat.setMatchCount(1);
        assertEquals(2, matchCount);
    }

    @Test
    void playerWins() {
        playerScore = 3;
        aiScore = 0;
        roundCount = 6;
        MatchStat.decideMatchEnd();
        assertTrue(isMatchEnd);
        assertTrue(isPlayerWin);
    }

    @Test
    void playerLoses() {
        playerScore = 0;
        aiScore = 3;
        roundCount = 6;
        MatchStat.decideMatchEnd();
        assertTrue(isMatchEnd);
        assertFalse(isPlayerWin);
    }

    @Test
    void updateStatForIsGoalAndNotPlayerShoot() {
        isPlayerShootTurn = false;
        MatchStat.updateStat(true);
        assertEquals(0, MatchStat.getPlayerScore());
        assertEquals(1, MatchStat.getAiScore());
        assertTrue(MatchStat.getIsPlayerShootTurn());
        assertEquals(2, MatchStat.getRoundCount());
    }

    @Test
    void updateStatForIsGoal() {
        MatchStat.updateStat(true);
        assertEquals(1, MatchStat.getPlayerScore());
        assertEquals(0, MatchStat.getAiScore());
        assertFalse(MatchStat.getIsPlayerShootTurn());
        assertEquals(2, MatchStat.getRoundCount());
    }

    @Test
    void getIsNewMatch() {
        assertTrue(MatchStat.getIsNewMatch());
    }

    @Test
    void getIsPlayerWin() {
        assertFalse(MatchStat.getIsPlayerWin());
    }

    @Test
    void getMatchCount() {
        assertEquals(INITIAL_MATCH_COUNT, MatchStat.getMatchCount());
    }

    @Test
    void getRoundCount() {
        assertEquals(INITIAL_ROUND_COUNT, MatchStat.getRoundCount());
    }

    @Test
    void getIsMatchEnd() {
        assertFalse(MatchStat.getIsMatchEnd());
    }

    @Test
    void getPlayerScore() {
        assertEquals(INITIAL_SCORE, MatchStat.getPlayerScore());
    }

    @Test
    void getAiScore() {
        assertEquals(INITIAL_SCORE, MatchStat.getAiScore());
    }

    @Test
    void getIsPlayerShootTurn() {
        assertTrue(MatchStat.getIsPlayerShootTurn());
    }
}
