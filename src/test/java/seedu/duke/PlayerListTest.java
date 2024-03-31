package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.player.BeginnerSkill;
import seedu.duke.player.ExpertSkill;
import seedu.duke.player.MediumSkill;

import static org.junit.jupiter.api.Assertions.*;

class PlayerListTest {
    @Test
    void skillUpgrade_beginner5_expectMedium() {
        PlayerList.l1.clear();
        PlayerList.l1.add(new BeginnerSkill("Player1", 5)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.l1.size());
        assertTrue(PlayerList.l1.get(0) instanceof MediumSkill);
    }

    @Test
    void skillUpgrade_medium3_expectMedium() {
        PlayerList.l1.clear();
        PlayerList.l1.add(new MediumSkill("Player1", 3)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.l1.size());
        assertTrue(PlayerList.l1.get(0) instanceof MediumSkill);
    }

    @Test
    void skillUpgrade_medium5_expectExpert() {
        PlayerList.l1.clear();
        PlayerList.l1.add(new MediumSkill("Player1", 5)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.l1.size());
        assertTrue(PlayerList.l1.get(0) instanceof ExpertSkill);
    }

    @Test
    void skillUpgrade_medium6_expectExpert() {
        PlayerList.l1.clear();
        PlayerList.l1.add(new MediumSkill("Player1", 6)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.l1.size());
        assertTrue(PlayerList.l1.get(0) instanceof ExpertSkill);
    }

    @Test
    void skillUpgrade_expert4_expectExpert() {
        PlayerList.l1.clear();
        PlayerList.l1.add(new ExpertSkill("Player1", 4)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.l1.size());
        assertTrue(PlayerList.l1.get(0) instanceof ExpertSkill);
    }
}