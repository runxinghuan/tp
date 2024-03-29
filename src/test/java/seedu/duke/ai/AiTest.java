package seedu.duke.ai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.DifficultyLevel.EASY;

public class AiTest {
    @Test
    public void directionIsLegal() {
        Ai ai = new Ai(EASY);
        int value = ai.getAiDirection();
        this.assertRange(0, 2, value);
    }

    public void assertRange(int expectedMin, int expectedMax, int actual) {
        assertTrue(actual >= expectedMin && actual <= expectedMax);
    }
}
