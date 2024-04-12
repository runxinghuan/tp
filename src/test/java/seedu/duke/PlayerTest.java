package seedu.duke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.duke.player.Player;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("John", 0);
    }

    @Test
    void testAddCoins() {
        player.addCoins(100);
        assertEquals(100, player.coins);
    }

    @Test
    void testDeductCoins() {
        player.addCoins(200);
        player.deductCoins(50);
        assertEquals(150, player.coins);
    }

    @Test
    void testHasEnoughCoins() {
        player.addCoins(100);
        assertTrue(player.hasEnoughCoins(50));
        assertFalse(player.hasEnoughCoins(150));
    }

    @Test
    void testResetCoins() {
        player.addCoins(100);
        player.resetCoins();
        assertEquals(0, player.coins);
    }

    @Test
    void testCalculatePerformanceCoins() {
        player.calculatePerformanceCoins(true);
        assertEquals(10, player.coins);
    }

    @Test
    void testPurchaseCustomizationItem() {
        player.addCoins(200);
        player.purchaseCustomizationItem("Power Boost", 150);
        assertEquals(50, player.coins);
        assertEquals(2, player.power);
    }

    @Test
    void testUpgradePower() {
        player.upgradePower(2);
        assertEquals(3, player.power);
    }

    @Test
    void testShootDirectionAdjust() {
        float adjustedDirection = player.shootDirectionAdjust(3);
        assertTrue(adjustedDirection >= 0 && adjustedDirection <= 8);
    }

    @Test
    void testAiDirectionAdjust() {
        Ui.difficultyLevel = DifficultyLevel.EASY;
        float adjustedDirection = player.aiDirectionAdjust(2);
        assertEquals(2, adjustedDirection);
    }

    @Test
    void testRangeAdjust() {
        Ui.difficultyLevel = DifficultyLevel.MEDIUM;
        float range = player.rangeAdjust();
        assertEquals(0.5f, range);
    }
}