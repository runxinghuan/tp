package seedu.duke.cointoss;

//@@author runxinghuan
import seedu.duke.Formatter;
import seedu.duke.stats.MatchStat;

import static seedu.duke.cointoss.CoinResult.UPRIGHT;

/**
 * Coin toss before each match.
 */
public class CoinToss {
    /**
     * Displays the coin result.
     * Then displays message according to the correctness of the guess.
     *
     * @param guess guess made by the user
     */
    public static void executeCoinToss(CoinResult guess) {
        Coin coin = new Coin();
        CoinResult coinResult;
        coinResult = coin.getResult();
        displayResult(coinResult);

        if (coinResult == UPRIGHT) {
            return;
        }
        processGuessResult(guess, coinResult);
        MatchStat.setMatchReady();
    }

    /**
     * Print message and update match stats according to the correctness of the guess.
     *
     * @param guess guess made by the user
     * @param coinResult result of the coin toss
     */
    static void processGuessResult(CoinResult guess, CoinResult coinResult) {
        if (guess == coinResult) {
            Formatter.printCorrectGuess();
            MatchStat.setForShootFirst();
        } else {
            Formatter.printWrongGuess();
            MatchStat.setForSaveFirst();
        }
    }

    /**
     * Displays the result of the coin toss based on different results.
     * Uses methods in Formatter class.
     *
     * @param coinResult result of the coin toss
     */
    static void displayResult(CoinResult coinResult) {
        switch (coinResult) {
        case HEAD:
            Formatter.printCoinHead();
            break;
        case TAIL:
            Formatter.printCoinTail();
            break;
        case UPRIGHT:
            Formatter.printCoinUpright();
            break;
        default:
            break;
        }
    }
}
