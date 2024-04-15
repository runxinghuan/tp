package seedu.duke.stats;

import seedu.duke.player.ExpertSkillPlayer;
import seedu.duke.player.MediumSkillPlayer;
import seedu.duke.player.Player;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

//@@author HenryGan138
/**
 * The PlayerList class manages the list of players in the game. It includes methods to manage players'
 * skills and performance after each match, and to create new player instances as players advance in skills.
 */
public class PlayerList {
    public static ArrayList<Player> playerList = new ArrayList<>();

    /**
     * Upgrades the skill level of the current player based on their performance.
     * This method checks the player's current skill and match count to determine if they qualify for a skill level upgrade.
     */
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
