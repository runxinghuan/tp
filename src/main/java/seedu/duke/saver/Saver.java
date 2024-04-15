package seedu.duke.saver;

import java.util.Random;

//@@author ymirmeddeb
/**
 * Represents a goalkeeper (saver) in the game, including their basic information, saving skill, and abilities.
 * This class provides a foundation for developing goalkeeper behaviors such as saving goals and upgrading skills.
 */

public class Saver {
    public static final double SAVING_PROBABILITY_FOR_BEGINNER = 0.5;
    public static final double SAVING_PROBABILITY_FOR_MEDIUM = 0.75;
    public static final double SAVING_PROBABILITY_FOR_EXPERT = 0.9;

    public String name; // The name of the saver
    public int matchCount; // The number of matches the saver has played
    public int power; // Represents the physical power/strength of the saver
    private int skill; // The skill level of the saver
    Random rand = new Random(); // Random object for generating probabilities

    /**
     * Constructs a new Saver with a default power level.
     *
     * @param name The name of the saver.
     * @param matchCount The number of matches played by the saver.
     */
    public Saver(String name, int matchCount) {
        this.name = name;
        this.matchCount = matchCount;
        this.power=1;
    }
    /**
     * Constructs a new Saver with a specified power level.
     *
     * @param name The name of the saver.
     * @param matchCount The number of matches played by the saver.
     * @param power The power level of the saver.
     */
    public Saver(String name, int matchCount, int power) {
        this.name = name;
        this.matchCount = matchCount;
        this.power = power;
    }

    /**
     * Prints information about the saver, including name, number of matches played, power, and skill level.
     */
    public void printSelfInfo(){
        System.out.println("--------Saver Info--------");
        System.out.println("Name: "+this.name);
        System.out.println("Number of match played: "+this.matchCount);
        printPower();
        printSkill();
        System.out.println("---------------------------");
    }

    /**
     * Gets the skill level of the saver.
     *
     * @return The skill level of the saver.
     */
    public int getSkill() { //For inheritance
        return skill;
    }

    /**
     * Placeholder method for printing the saver's power. Intended to be overridden in subclasses.
     */
    protected void printPower(){} //For override

    /**
     * Placeholder method for printing the saver's skill. Intended to be overridden in subclasses.
     */
    protected void printSkill(){} //For override

    /**
     * Placeholder method for indicating action before a save attempt. Intended to be overridden.
     */
    public void printGoalBeforeSave(){} //For override

    /**
     * Placeholder method for indicating the outcome after a save attempt. Intended to be overridden.
     *
     * @param goalScored Indicates whether a goal was scored or not.
     * @param direction The direction in which the goal was attempted.
     */
    public void printGoalAfterSave(boolean goalScored, int direction){} //For override

    /**
     * Placeholder method for upgrading the saver's power. Intended to be overridden.
     *
     * @param level The new power level.
     */
    public void upgradePower(int level){} //For override

    /**
     * Placeholder method for adjusting the AI's shot direction. Intended to be overridden.
     *
     * @param aiDir The AI's chosen direction.
     * @return The adjusted direction.
     */
    public float aiDirectionAdjust(int aiDir){
        return 0;
    } //For override

    /**
     * Placeholder method for adjusting the saver's save direction. Intended to be overridden.
     *
     * @param dir The chosen save direction.
     * @return The adjusted save direction.
     */
    public float saveDirectionAdjust(int dir){
        return 0;
    }  //For override

    /**
     * Calculates a directional formula based on the saver's power and direction.
     *
     * @param left The probability adjustment for the left direction.
     * @param right The probability adjustment for the right direction.
     * @param dir The chosen direction.
     * @param power The power of the saver.
     * @return The calculated direction value.
     */
    public float saveDirectionFormula(int left, int right, int dir, int power){
        float prob = rand.nextFloat();

        if (power == 1) {
            prob = prob / 2;
            return (float) (left * prob + dir * SAVING_PROBABILITY_FOR_BEGINNER + right * ((1 - SAVING_PROBABILITY_FOR_BEGINNER) - prob));
        } else if (power == 2) {
            prob = prob / 4;
            return (float) (left * prob + dir * SAVING_PROBABILITY_FOR_MEDIUM + right * ((1 - SAVING_PROBABILITY_FOR_MEDIUM) - prob));
        } else {
            prob = prob / 10;
            return (float) (left * prob + dir * SAVING_PROBABILITY_FOR_EXPERT + right * ((1- SAVING_PROBABILITY_FOR_EXPERT) - prob));
        }
    }

    /**
     * Placeholder method for adjusting the range of effectiveness. Intended to be overridden.
     *
     * @return The adjusted range value.
     */
    public float rangeAdjust(){
        return 0;
    }
}
