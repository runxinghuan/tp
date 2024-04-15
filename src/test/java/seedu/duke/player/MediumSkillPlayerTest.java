package seedu.duke.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediumSkillPlayerTest {
    private MediumSkillPlayer player;

    @BeforeEach
    void setUp() {
        player = new MediumSkillPlayer("TestPlayer", 10, 2);
    }

    @Test
    void shootDirectionAdjust_withinRange_expectAdjustedValue() {
        for (int dir = 0; dir <= 5; dir++) {
            float adjusted = player.shootDirectionAdjust(dir);
            assertTrue(adjusted >= 0 && adjusted <= 5, "Direction should be adjusted within 0 to 5");
        }
    }

    @Test
    void shootDirectionAdjust_outOfRange_expectMissedTarget() {
        float adjusted = player.shootDirectionAdjust(6);
        assertEquals(-1, adjusted, "Direction out of range should return -1 for a miss");
    }

    @Test
    void shootDirectionAdjust_randomPower_levelsImpact() {
        // Repeated test to average the results
        final int iterations = 10;
        float totalBeginner = 0, totalMedium = 0;

        for (int i = 0; i < iterations; i++) {
            player.upgradePower(1); // Set power level to beginner
            totalBeginner += player.shootDirectionAdjust(3);

            player.upgradePower(2); // Set power level to medium
            totalMedium += player.shootDirectionAdjust(3);
        }

        float averageBeginner = totalBeginner / iterations;
        float averageMedium = totalMedium / iterations;

        assertNotEquals(averageBeginner, averageMedium, "Averages of different power levels should differ significantly");
    }
}