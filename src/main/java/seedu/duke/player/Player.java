package seedu.duke.player;

import java.util.*;

//@@author HenryGan138
public class Player {
    // Constants
    public static final double EASY_GK_COVERED_RANGE = 0.1;
    public static final double MEDIUM_GK_COVERED_RANGE = 0.2;
    public static final double HARD_GK_COVERED_RANGE = 0.5;
    public static final int COIN_NUMBER_INITIALIZE = 0;
    private static final double ONTARGET_PROBABILITY_FOR_BEGINNER = 0.5;
    private static final double ONTARGET_PROBABILITY_FOR_MEDIUM = 0.75;
    private static final double ONTARGET_PROBABILITY_FOR_EXPOERT = 0.9;

    // Instance fields
    public String name;
    public int matchCount;
    public int power;
    private int skill;
    public int coins;
    private Random rand = new Random();

    /**
     * Constructor for creating a player with a specified name and match count, initializing with default power and coins.
     *
     * @param name The name of the player.
     * @param matchCount The number of matches the player has participated in.
     */
    public Player(String name, int matchCount) {
        this.name = name;
        this.matchCount = matchCount;
        this.power = 1;
        this.coins = COIN_NUMBER_INITIALIZE;
    }

    /**
     * Constructor for creating a player with specified name, match count, and power.
     *
     * @param name The name of the player.
     * @param matchCount The number of matches the player has participated in.
     * @param power The initial power level of the player.
     */
    public Player(String name, int matchCount, int power) {
        this.name = name;
        this.matchCount = matchCount;
        this.power = power;
        this.coins = COIN_NUMBER_INITIALIZE;
    }

    /**
     * Prints basic information about the player including name, match count, and coins.
     * This method also calls the overridden {@code printPower} and {@code printSkill} methods
     * to display power and skill level-specific details.
     */
    public void printSelfInfo() {
        System.out.println("--------Player Info--------");
        System.out.println("Name: " + this.name);
        System.out.println("Number of match played: " + this.matchCount);
        System.out.println("Coins: " + this.coins);
        printPower();
        printSkill();
        System.out.println("---------------------------");
    }

    /**
     * Retrieves the skill level of the player. This method is intended for overriding to provide specific skill levels in subclasses.
     *
     * @return The skill level of the player.
     */
    public int getSkill() { //For inheritance
        return skill;
    }

    /**
     * Prints the power level of the player. This method is intended for overriding in subclasses to provide detailed power level information.
     */
    protected void printPower() {
    }

    /**
     * Prints the skill level of the player. This method is intended for overriding in subclasses to provide detailed skill level information.
     */
    protected void printSkill() {
    }

    /**
     * Placeholder method to be overridden in subclasses to print messages before a shoot attempt.
     */
    public void printGoalBeforeShoot() {
    }

    /**
     * Placeholder method to be overridden in subclasses to handle actions and print messages after a shoot based on whether a goal was scored.
     *
     * @param goalScored Indicates if a goal was scored.
     * @param direction The direction in which the goal was attempted.
     */
    public void printGoalAfterShoot(boolean goalScored, int direction) {
        calculatePerformanceCoins(goalScored);
    }

    /**
     * Placeholder method to be overridden in subclasses to upgrade the player's power level based on the given level.
     *
     * @param level The new power level to set.
     */
    public void upgradePower(int level) {
    }

    /**
     * Placeholder method to be overridden in subclasses to adjust AI direction for shooting based on the player's capabilities.
     *
     * @param aiDir The AI's proposed shooting direction.
     * @return The adjusted direction.
     */
    public float aiDirectionAdjust(int aiDir) {
        return COIN_NUMBER_INITIALIZE;
    }

    /**
     * Placeholder method to be overridden in subclasses to adjust the shooting direction based on the player's input and capabilities.
     *
     * @param dir The intended direction of the shoot.
     * @return The adjusted shooting direction.
     */
    public float shootDirectionAdjust(int dir) {
        return COIN_NUMBER_INITIALIZE;
    }

    /**
     * Calculates the shooting direction formula based on the player's power and intended direction.
     * This method uses a random probability influenced by the player's power to adjust the shooting accuracy.
     *
     * @param left The left boundary for the shooting direction.
     * @param right The right boundary for the shooting direction.
     * @param dir The intended direction of the shoot.
     * @param power The power level of the player.
     * @return The adjusted shooting direction.
     */
    public float shootDirectionFormula(int left, int right, int dir, int power) {
        float prob = rand.nextFloat();

        if (power == 1) {
            prob = prob / 2;
            return (float) (left * prob + dir * ONTARGET_PROBABILITY_FOR_BEGINNER + right * ((1 - ONTARGET_PROBABILITY_FOR_BEGINNER) - prob));
        } else if (power == 2) {
            prob = prob / 4;
            return (float) (left * prob + dir * ONTARGET_PROBABILITY_FOR_MEDIUM + right * ((1 - ONTARGET_PROBABILITY_FOR_MEDIUM) - prob));
        } else {
            prob = prob / 10;
            return (float) (left * prob + dir * ONTARGET_PROBABILITY_FOR_EXPOERT + right * ((1- ONTARGET_PROBABILITY_FOR_EXPOERT) - prob));
        }
    }

    /**
     * Placeholder method to be overridden in subclasses to adjust the range of shooting based on the player's capabilities and game difficulty.
     *
     * @return The adjusted shooting range.
     */
    public float rangeAdjust() {
        return COIN_NUMBER_INITIALIZE;
    }

    //@@author

    //@@author IncyBot
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
                    player = new BeginnerSkillPlayer(playerName, COIN_NUMBER_INITIALIZE);
                    break;
                case 2:
                    player = new MediumSkillPlayer(playerName, COIN_NUMBER_INITIALIZE);
                    break;
                case 3:
                    player = new ExpertSkillPlayer(playerName, COIN_NUMBER_INITIALIZE);
                    break;
                default:
                    player = new BeginnerSkillPlayer(playerName, COIN_NUMBER_INITIALIZE);
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
        coins = COIN_NUMBER_INITIALIZE;
        System.out.println("Your coin balance has been reset to zero.");
    }

    // Method to display the player's current coin balance
    public void displayCoinBalance() {
        System.out.println("Your current coin balance is: " + coins);
    }

    // Method to calculate and add coins based on the player's performance
    public void calculatePerformanceCoins(boolean goalScored) {
        int performanceCoins = COIN_NUMBER_INITIALIZE;
    
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
            try {
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
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
    
            System.out.println();
        }
    }
}
//@@author
