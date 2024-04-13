package seedu.duke.cointoss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoinTest {
    @Test
    void testCoinRange() {
        Coin coin = new Coin();
        assertTrue(coin.getResult() == CoinResult.HEAD || coin.getResult() == CoinResult.TAIL ||
                coin.getResult() == CoinResult.UPRIGHT);
    }
}
