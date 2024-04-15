package seedu.duke.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BeginnerSkillPlayerTest {
    private BeginnerSkillPlayer player;

    @BeforeEach
    void setUp() {
        player = new BeginnerSkillPlayer("TestPlayer", 10);
    }

    @Test
    void shootDirectionAdjust_validDirections_expectAdjustedWithinRange() {
        for (int dir = 0; dir <= 2; dir++) {
            float adjusted = player.shootDirectionAdjust(dir);
            assertTrue(adjusted >= 0 && adjusted <= 2, "Adjusted direction should be within 0 to 2 for beginners");
        }
    }

    @Test
    void shootDirectionAdjust_invalidDirection_expectMissedTarget() {
        float adjusted = player.shootDirectionAdjust(3);
        assertEquals(-1, adjusted, "Direction out of range should return -1 indicating a miss");
    }

    @Test
    void shootDirectionAdjust_randomPower_levelsImpact() {
        final int iterations = 10;
        float totalBeginner = 0, totalMedium = 0;

        for (int i = 0; i < iterations; i++) {
            player.upgradePower(0); // Set power level to beginner
            totalBeginner += player.shootDirectionAdjust(1);

            player.upgradePower(2); // Set power level to medium
            totalMedium += player.shootDirectionAdjust(1);
        }

        float averageBeginner = totalBeginner / iterations;
        float averageMedium = totalMedium / iterations;

        assertNotEquals(averageBeginner, averageMedium, "Averages of beginner and medium power levels should differ significantly for a beginner player");
    }
}