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
    private int coins;
    Random rand = new Random();

    public Player(String name, int matchCount) {
        this.name = name;
        this.matchCount = matchCount;
        this.power = 1;
        this.coins = 0;
    }

    public Player(String name, int matchCount, int power) {
        this.name = name;
        this.matchCount = matchCount;
        this.power = power;
        this.coins = 0;
    }

    public void printSelfInfo() {
        System.out.println("--------Player Info--------");
        System.out.println("Name: " + this.name);
        System.out.println("Number of match played: " + this.matchCount);
        System.out.println("Coins: " + this.coins);
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
        calculatePerformanceCoins(goalScored);
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
        float skillFactor = 1.0f + (skill * 0.1f);
    
        if (power == 1) {
            prob = prob / 2;
            return (float) (left * prob + dir * 0.5 * skillFactor + right * (0.5 - prob));
        } else if (power == 2) {
            prob = prob / 4;
            return (float) (left * prob + dir * 0.75 * skillFactor + right * (0.25 - prob));
        } else {
            prob = prob / 10;
            return (float) (left * prob + dir * 0.9 * skillFactor + right * (0.1 - prob));
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

    // New method to purchase customizations
    public void purchaseCustomizations() {
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;

        while (continueShopping) {
            System.out.println("Welcome to the Customization Shop!");
            System.out.println("Your current coins: " + coins);
            System.out.println("Available customizations:");
            System.out.println("1. Increase Power (Cost: 100 coins)");
            System.out.println("2. Increase Skill (Cost: 200 coins)");
            System.out.println("3. Exit Shop");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (coins >= 100) {
                        power++;
                        coins -= 100;
                        System.out.println("Power increased! Current Power: " + power);
                    } else {
                        System.out.println("Insufficient coins to purchase Power upgrade.");
                    }
                    break;
                case 2:
                    if (coins >= 200) {
                        skill++;
                        coins -= 200;
                        System.out.println("Skill increased! Current Skill: " + skill);
                    } else {
                        System.out.println("Insufficient coins to purchase Skill upgrade.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Customization Shop. Thank you for your purchases!");
                    continueShopping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }

    // Method to add coins to the player's balance
    public void addCoins(int amount) {
        coins += amount;
        System.out.println(amount + " coins added to your balance. Current balance: " + coins);
    }

    // Method to deduct coins from the player's balance
    public void deductCoins(int amount) {
        if (coins >= amount) {
            coins -= amount;
            System.out.println(amount + " coins deducted from your balance. Current balance: " + coins);
        } else {
            System.out.println("Insufficient coins. Deduction failed.");
        }
    }

    // Method to check if the player has enough coins for a purchase
    public boolean hasEnoughCoins(int amount) {
        return coins >= amount;
    }

    // Method to reset the player's coins to zero
    public void resetCoins() {
        coins = 0;
        System.out.println("Your coin balance has been reset to zero.");
    }

    // Method to display the player's current coin balance
    public void displayCoinBalance() {
        System.out.println("Your current coin balance is: " + coins);
    }

    // Method to calculate and add coins based on the player's performance
    public void calculatePerformanceCoins(boolean goalScored) {
        int performanceCoins = 0;
    
        if (goalScored) {
            performanceCoins += 10;    }
    
        addCoins(performanceCoins);
    
        System.out.println("Performance Coins earned: " + performanceCoins);
    }

    // Method to purchase a specific customization item
    public void purchaseCustomizationItem(String item, int cost) {
        if (hasEnoughCoins(cost)) {
            deductCoins(cost);
            System.out.println("You have purchased the " + item + " customization!");
            applyCustomization(item);
        } else {
            System.out.println("Insufficient coins to purchase the " + item + " customization.");
        }
    }

    // Method to apply a customization to the player's attributes or appearance
    private void applyCustomization(String item) {
        if (item.equals("Power Boost")) {
            upgradePower(power + 1);
            System.out.println("Power increased by 1! Current Power: " + power);
        } else if (item.equals("Skill Boost")) {        skill++;
            System.out.println("Skill increased by 1! Current Skill: " + skill);
        }
    }

    // Method to display the available customization items and their costs
    public void displayCustomizationItems() {
        System.out.println("Available Customization Items:");
        System.out.println("1. Power Boost - Cost: 150 coins");
        System.out.println("2. Skill Boost - Cost: 200 coins");
        System.out.println("3. Fancy Uniform - Cost: 100 coins");
    }

    // Method to handle the customization item purchase process
    public void handleCustomizationPurchase() {
        Scanner scanner = new Scanner(System.in);
        displayCustomizationItems();
    
        System.out.print("Enter the number of the customization item you want to purchase: ");
        int choice = scanner.nextInt();
    
        switch (choice) {
            case 1:
                purchaseCustomizationItem("Power Boost", 150);
                break;
            case 2:
                purchaseCustomizationItem("Skill Boost", 200);
                break;
            default:
                System.out.println("Invalid choice. Purchase canceled.");
                break;
        }
    }

    // Method to display the customization menu
    public void displayCustomizationMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exitMenu = false;
    
        while (!exitMenu) {
            System.out.println("Customization Menu:");
            System.out.println("1. Purchase Customizations");
            System.out.println("2. View Coin Balance");
            System.out.println("3. Exit");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    handleCustomizationPurchase();
                    break;
                case 2:
                    displayCoinBalance();
                    break;
                case 3:
                    exitMenu = true;
                    System.out.println("Exiting Customization Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
    
            System.out.println();
        }
    }
}