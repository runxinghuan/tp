package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.stats.MatchStat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoinTossTest {

    @Test
    void executeCoinToss() {
        CoinToss.executeCoinToss(CoinToss.HEAD); //unable to assert because the result is determined by a random number
    }

    @Test
    void tossACoin() {
        assertRange(0, 5, CoinToss.tossACoin());
    }

    public void assertRange(int expectedMin, int expectedMax, int actual) {
        assertTrue(actual >= expectedMin && actual <= expectedMax);
    }

    @Test
    void displayResultForHead() {
        CoinToss.displayResult(CoinToss.HEAD);
    }

    @Test
    void displayResultForTail() {
        CoinToss.displayResult(CoinToss.TAIL);
    }

    @Test
    void displayResultForUpright() {
        CoinToss.displayResult(CoinToss.UPRIGHT);
    }

    @Test
    void processGuessResultForCorrectGuess() {
        CoinToss.processGuessResult(CoinToss.HEAD, CoinToss.HEAD);
        assertTrue(MatchStat.getIsPlayerShootTurn());
    }

    @Test
    void processGuessResultForWrongGuess() {
        CoinToss.processGuessResult(CoinToss.HEAD, CoinToss.TAIL);
        assertFalse(MatchStat.getIsPlayerShootTurn());
    }
}
