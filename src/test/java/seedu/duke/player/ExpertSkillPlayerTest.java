package seedu.duke.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpertSkillPlayerTest {
    private ExpertSkillPlayer player;

    @BeforeEach
    void setUp() {
        player = new ExpertSkillPlayer("TestPlayer", 10);
    }

    @Test
    void shootDirectionAdjust_validDirections_expectAdjustedWithinRange() {
        for (int dir = 0; dir <= 8; dir++) {
            float adjusted = player.shootDirectionAdjust(dir);
            assertTrue(adjusted >= 0 && adjusted <= 8, "Adjusted direction should be within 0 to 8 for experts");
        }
    }

    @Test
    void shootDirectionAdjust_invalidDirection_expectMissedTarget() {
        float adjusted = player.shootDirectionAdjust(9);
        assertEquals(-1, adjusted, "Direction out of range should return -1 indicating a miss");
    }

    @Test
    void shootDirectionAdjust_randomPower_levelsImpact() {
        final int iterations = 10;
        float totalMedium = 0, totalExpert = 0;

        for (int i = 0; i < iterations; i++) {
            player.upgradePower(1); // Set power level to medium
            totalMedium += player.shootDirectionAdjust(4);

            player.upgradePower(2); // Set power level to expert
            totalExpert += player.shootDirectionAdjust(4);
        }

        float averageMedium = totalMedium / iterations;
        float averageExpert = totalExpert / iterations;

        assertNotEquals(averageMedium, averageExpert, "Averages of medium and expert power levels should differ significantly for an expert player");
    }
}
