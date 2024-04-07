package seedu.duke;
import seedu.duke.saver.ExpertSkillSaver;
import seedu.duke.saver.MediumSkillSaver;
import seedu.duke.saver.Saver;
import seedu.duke.stats.MatchStat;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

//@@author ymirmeddeb
/**
 * The {@code SaverList} class manages a dynamic list of {@code Saver} objects, representing goalkeepers in the game.
 * It provides functionality to upgrade a saver's skill level based on their performance and the number of matches played.
 * Upgrades move a saver from a beginner to medium, and then to expert skill level, enhancing their saving capabilities.
 */
public class SaverList {
    public static ArrayList<Saver> saverList = new ArrayList<>();

    /**
     * Upgrades the skill level of a specified saver based on the current skill level and the number of matches played.
     * A saver's skill level is upgraded from beginner to medium if they have played one game at the beginner level.
     * A saver's skill level is upgraded from medium to expert if they have played at least 5 matches at the medium level.
     *
     * @param curSaver The index of the current saver in the {@code saverList} whose skill is to be upgraded.
     */
    public static void saverSkillUpgrade(int curSaver){
        Saver saver = saverList.get(curSaver);
        saver.matchCount = Math.max(MatchStat.getMatchCount(), saver.matchCount);

        if (saver.getSkill() == 1) {
            // Upgrade from beginner to medium skill level
            saverList.add(new MediumSkillSaver(saver.name, saver.matchCount, saver.power));
            System.out.println("--------NUSFC24-------");
            System.out.println("Congratulations! Your saver's skill has been updated to medium level.");
        } else if (saver.getSkill() == 2 && saver.matchCount >= 5) {
            // Upgrade from medium to expert skill level
            saverList.add(new ExpertSkillSaver(saver.name, saver.matchCount, saver.power));
            System.out.println("--------NUSFC24-------");
            System.out.println("Congratulations! Your saver's skill has been updated to expert level.");
        } else {
            return; // No upgrade needed
        }

        // Adjust the current saver pointer and remove the old saver entry
        Ui.curSaver = saverList.size() - 2;
        saverList.remove(curSaver);
        saverList.get(Ui.curSaver).printSelfInfo();
    }
}
