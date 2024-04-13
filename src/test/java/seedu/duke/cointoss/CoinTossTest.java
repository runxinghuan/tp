package seedu.duke.cointoss;

import org.junit.jupiter.api.Test;
import seedu.duke.stats.MatchStat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoinTossTest {

    @Test
    void guessForHead() {
        CoinToss.executeCoinToss(CoinResult.HEAD);
        //unable to assert because the result is determined by a random number
    }

    @Test
    void displayResultForHead() {
        CoinToss.displayResult(CoinResult.HEAD);
    }

    @Test
    void displayResultForTail() {
        CoinToss.displayResult(CoinResult.TAIL);
    }

    @Test
    void displayResultForUpright() {
        CoinToss.displayResult(CoinResult.UPRIGHT);
    }

    @Test
    void processGuessResultForCorrectGuess() {
        CoinToss.processGuessResult(CoinResult.HEAD, CoinResult.HEAD);
        assertTrue(MatchStat.getIsPlayerShootTurn());
    }

    @Test
    void processGuessResultForWrongGuess() {
        CoinToss.processGuessResult(CoinResult.HEAD, CoinResult.TAIL);
        assertFalse(MatchStat.getIsPlayerShootTurn());
    }
}
