package seedu.duke.stats;
import seedu.duke.player.ExpertSkillPlayer;
import seedu.duke.player.MediumSkillPlayer;
import seedu.duke.player.Player;
import seedu.duke.stats.MatchStat;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

//@@author HenryGan138

/**
 * Provides functionality for managing a list of player objects,
 * v2.0 add the ability to upgrade a player's skill based on their current skill level and match count.
 *
 */
public class PlayerList {
    public static ArrayList<Player> playerList = new ArrayList<>();

    public static void skillUpgrade(int curPlayer){
        Player player = playerList.get(curPlayer);
        player.matchCount= Math.max(MatchStat.getMatchCount(),player.matchCount);

        if (player.getSkill()==1){
            playerList.add(new MediumSkillPlayer(player.name,player.matchCount, player.power));
            System.out.println("--------NUSFC24-------");
            System.out.println("Congratulations! Your player's skill has updated to medium level.");
        }else if ((player.getSkill()==2)&&(player.matchCount>=5)){
            playerList.add(new ExpertSkillPlayer(player.name,player.matchCount, player.power));
            System.out.println("--------NUSFC24-------");
            System.out.println("Congratulations! Your player's skill has updated to expert level.");
        }else{
            return;
        }
        Ui.curPlayer = playerList.size()-2;
        playerList.remove(0);
        playerList.get(Ui.curPlayer).printSelfInfo();
    }
}
//author