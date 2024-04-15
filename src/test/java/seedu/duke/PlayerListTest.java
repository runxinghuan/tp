package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.player.BeginnerSkillPlayer;
import seedu.duke.player.ExpertSkillPlayer;
import seedu.duke.player.MediumSkillPlayer;
import seedu.duke.stats.PlayerList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerListTest {
    @Test
    void skillUpgrade_beginner5_expectMedium() {
        PlayerList.playerList.clear();
        PlayerList.playerList.add(new BeginnerSkillPlayer("Player1", 5)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.playerList.size());
        assertTrue(PlayerList.playerList.get(0) instanceof MediumSkillPlayer);
    }

    @Test
    void skillUpgrade_medium3_expectMedium() {
        PlayerList.playerList.clear();
        PlayerList.playerList.add(new MediumSkillPlayer("Player1", 3)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.playerList.size());
        assertTrue(PlayerList.playerList.get(0) instanceof MediumSkillPlayer);
    }

    @Test
    void skillUpgrade_medium5_expectExpert() {
        PlayerList.playerList.clear();
        PlayerList.playerList.add(new MediumSkillPlayer("Player1", 5)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.playerList.size());
        assertTrue(PlayerList.playerList.get(0) instanceof ExpertSkillPlayer);
    }

    @Test
    void skillUpgrade_medium6_expectExpert() {
        PlayerList.playerList.clear();
        PlayerList.playerList.add(new MediumSkillPlayer("Player1", 6)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.playerList.size());
        assertTrue(PlayerList.playerList.get(0) instanceof ExpertSkillPlayer);
    }

    @Test
    void skillUpgrade_expert4_expectExpert() {
        PlayerList.playerList.clear();
        PlayerList.playerList.add(new ExpertSkillPlayer("Player1", 4)); // Assuming matchCount is 5
        PlayerList.skillUpgrade(0);
        assertEquals(1, PlayerList.playerList.size());
        assertTrue(PlayerList.playerList.get(0) instanceof ExpertSkillPlayer);
    }
}
