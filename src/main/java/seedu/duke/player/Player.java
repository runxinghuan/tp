package seedu.duke.player;

import seedu.duke.Formatter;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
    public String name;
    public int matchCount;
    public int power;
    private int skill;
    Random rand = new Random();

    public Player(String name, int matchCount) {
        this.name = name;
        this.matchCount = matchCount;
        this.power = 1;
    }

    public Player(String name, int matchCount, int power) {
        this.name = name;
        this.matchCount = matchCount;
        this.power = power;
    }

    public void printSelfInfo() {
        System.out.println("--------Player Info--------");
        System.out.println("Name: " + this.name);
        System.out.println("Number of match played: " + this.matchCount);
        printPower();
        printSkill();
        System.out.println("---------------------------");
    }

    public int getSkill() { //For inheritance
        return skill;
    }

    protected void printPower() {
    } //For override

    protected void printSkill() {
    } //For override

    public void printGoalBeforeShoot() {
    } //For override

    public void printGoalBeforeSave() {
    } //For override

    public void printGoalAfterShoot(boolean goalScored, int direction) {
    } //For override

    public void upgradePower(int level) {
    } //For override

    public float aiDirectionAdjust(int aiDir) {
        return 0;
    } //For override

    public float shootDirectionAdjust(int dir) {
        return 0;
    }  //For override

    public float shootDirectionFormula(int left, int right, int dir, int power) {
        float prob = rand.nextFloat();
        if (power == 1) {
            prob = prob / 2;
            return (float) (left * prob + dir * 0.5 + right * (0.5 - prob));
        } else if (power == 2) {
            prob = prob / 4;
            return (float) (left * prob + dir * 0.75 + right * (0.25 - prob));
        } else {
            prob = prob / 10;
            return (float) (left * prob + dir * 0.9 + right * (0.1 - prob));
        }
    }

    public float rangeAdjust() {
        return 0;
    }

    // New method to create a custom team
    public static List<Player> createCustomTeam() {
        List<Player> customTeam = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create your custom team:");
        System.out.println("Enter the number of players in your team (1-11):");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (numPlayers < 1 || numPlayers > 11) {
            System.out.println("Invalid number of players. Using default team.");
            return customTeam;
        }

        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter the name of player " + i + ":");
            String playerName = scanner.nextLine();

            System.out.println("Enter the skill level of player " + i + " (1-Beginner, 2-Medium, 3-Expert):");
            int skillLevel = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (skillLevel < 1 || skillLevel > 3) {
                System.out.println("Invalid skill level. Using default skill level (Beginner).");
                skillLevel = 1;
            }

            Player player;
            switch (skillLevel) {
                case 1:
                    player = new BeginnerSkillPlayer(playerName, 0);
                    break;
                case 2:
                    player = new MediumSkillPlayer(playerName, 0);
                    break;
                case 3:
                    player = new ExpertSkillPlayer(playerName, 0);
                    break;
                default:
                    player = new BeginnerSkillPlayer(playerName, 0);
                    break;
            }

            customTeam.add(player);
        }

        System.out.println("Custom team created successfully!");
        return customTeam;
    }
}