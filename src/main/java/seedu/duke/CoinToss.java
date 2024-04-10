package seedu.duke;

//@@author runxinghuan
import seedu.duke.stats.MatchStat;

import java.util.Random;

/**
 * Coin toss before each match.
 */
public class CoinToss {
    public static final int HEAD = 1;
    public static final int TAIL = 2;
    public static final int UPRIGHT = 3;

    /**
     * Displays the coin result.
     * Then displays message according to the correctness of the guess.
     *
     * @param guess guess made by the user
     */
    public static void executeCoinToss(int guess) {
        int coinResult;
        coinResult = tossACoin();
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
    static void processGuessResult(int guess, int coinResult) {
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
    static void displayResult(int coinResult) {
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

    /**
     * Produces the result of a coin toss.
     * There are three outcomes. The probability of each outcome is equal.
     *
     * @return result of a coin toss
     */
    public static int tossACoin() {
        Random rand = new Random();
        int result;
        int coinResult = rand.nextInt(6);
        if (coinResult <= 1) {
            result = HEAD;
        } else if (coinResult <= 3) {
            result = TAIL;
        } else {
            result = UPRIGHT; //same probability for all three outcomes
        }
        return result;
    }
}
