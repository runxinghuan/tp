package seedu.duke;

import seedu.duke.stats.MatchStat;

import java.util.Random;

public class CoinToss {
    public static final int HEAD = 1;
    public static final int TAIL = 2;
    public static final int UPRIGHT = 3;

    public static void executeCoinToss(int guess) {
        int coinResult;
        coinResult = tossACoin();
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

        if (coinResult == UPRIGHT) {
            return;
        }
        if (guess == coinResult) {
            Formatter.printCorrectGuess();
            MatchStat.setForShootFirst();
        } else {
            Formatter.printWrongGuess();
            MatchStat.setForSaveFirst();
        }
        MatchStat.setMatchReady();
    }

    public static int tossACoin() {
        Random rand = new Random();
        int result;
        int coinResult = rand.nextInt(6);
        if (coinResult <= 1) {
            result = HEAD;
        } else if (coinResult <= 3) {
            result = TAIL;
        } else {
            result = UPRIGHT;
        }
        return result;
    }
}
