package seedu.duke.cointoss;

//@@author runxinghuan
import java.util.Random;

import static seedu.duke.cointoss.CoinResult.HEAD;
import static seedu.duke.cointoss.CoinResult.TAIL;
import static seedu.duke.cointoss.CoinResult.UPRIGHT;

/**
 * A coin in the coin toss.
 */
public class Coin {
    private final CoinResult result;

    public Coin() {
        this.result = this.tossACoin();
    }

    /**
     * Produces the result of a coin toss.
     * There are three outcomes. The probability of each outcome is equal.
     *
     * @return result of a coin toss
     */
    public CoinResult tossACoin() {
        Random rand = new Random();
        CoinResult result;
        int randomProcess = rand.nextInt(6);
        if (randomProcess <= 1) {
            result = HEAD;
        } else if (randomProcess <= 3) {
            result = TAIL;
        } else {
            result = UPRIGHT; //same probability for all three outcomes
        }
        return result;
    }

    public CoinResult getResult() {
        return result;
    }
}
