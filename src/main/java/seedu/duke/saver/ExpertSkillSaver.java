package seedu.duke.saver;

import seedu.duke.Formatter;
import seedu.duke.ui.Ui;

//@@author ymirmeddeb
/**
 * Represents an expert skill level saver in the game.
 * This class extends {@link Saver} and provides specific implementations for a beginner saver's behavior and abilities.
 * It includes methods for adjusting save direction, upgrading power, and printing saver information.
 */
public class ExpertSkillSaver extends Saver {
    private final int skill = 3; // Indicates the expert skill level

    /**
     * Constructs a new ExpertSkillSaver with specified attributes.
     *
     * @param name The name of the saver.
     * @param matchCount The number of matches played by the saver.
     * @param power The power level of the saver.
     */
    public ExpertSkillSaver(String name, int matchCount, int power) {
        super(name, matchCount, power);
    }

    /**
     * Prints information about the saver, enhancing the superclass implementation with expert skill level-specific details.
     */
    @Override
    public void printSelfInfo() {
        super.printSelfInfo();
    }

    /**
     * Prints the power level of the saver in a visual format, customized for the expert skill level.
     * Overrides the placeholder method in the superclass.
     */
    @Override
    protected void printPower() {
        System.out.print("Power:");
        for (int i=0; i<3;i++){
            if (i<power){
                System.out.print(" ###");
            }else{
                System.out.print("    ");
            }
        }
        if (power==1){
            System.out.println(" Level-Beginner");
        }else if (power == 2){
            System.out.println(" Level-Medium");
        }else{
            System.out.println(" Level-Expert");
        }
    }

    /**
     * Prints the skill level of the saver in a visual format, indicating "Level-Expert".
     * Overrides the placeholder method in the superclass.
     */
    @Override
    protected void printSkill(){
        System.out.print("Skill:");
        for (int i=0; i<3;i++){
            if (i<skill){
                System.out.print(" ###");
            }else{
                System.out.print("    ");
            }
        }
        System.out.println(" Level-Expert");
    }

    /**
     * Retrieves the skill level of the saver.
     * Overrides the placeholder method in the superclass.
     *
     * @return The skill level of the saver, indicating an expert level.
     */
    @Override
    public int getSkill() {
        return skill;
    }

    /**
     * Displays the visual representation before a save attempt, tailored for expert skill level.
     * Overrides the placeholder method in the superclass.
     */
    @Override
    public void printGoalBeforeSave() {
        Formatter.printGoalBeforeSaveForExpert();
    }

    /**
     * Displays the outcome after a save attempt for an expert skill level saver.
     * Overrides the placeholder method in the superclass.
     *
     * @param goalScored Indicates whether a goal was scored against the saver.
     * @param direction The direction of the AI's shot.
     */
    @Override
    public void printGoalAfterSave(boolean goalScored, int direction) {
        Formatter.printGoalAfterSaveExpert(goalScored, direction);
    }

    /**
     * Upgrades the power level of the saver, ensuring it is within valid bounds.
     * Overrides the placeholder method in the superclass.
     *
     * @param level The new power level to be set.
     */
    @Override
    public void upgradePower(int level) {
        assert level>=0&&level<=2;
        this.power=level+1;
    }

    /**
     * Adjusts the save direction for an expert skill level saver, potentially modifying
     * the direction based on game mechanics.
     * Overrides the placeholder method in the superclass.
     *
     * @param dir The initial save direction chosen by the saver.
     * @return The adjusted save direction.
     */
    @Override
    public float saveDirectionAdjust(int dir){
        int expertMinSave = 0;
        int expertMaxSave = 8;
        int left= Math.max(dir - 1, expertMinSave);
        int right= Math.max(dir + 1, expertMaxSave);
        return this.saveDirectionFormula(left,right,dir,this.power);
    }

    /**
     * Calculates the direction formula based on the given parameters.
     * This method is overridden to utilize the parent class's implementation directly without any modifications specific to the beginner skill level saver.
     * It is used to determine the effectiveness of a save attempt based on the direction and power of the saver.
     *
     * @param left The left boundary of the save attempt.
     * @param right The right boundary of the save attempt.
     * @param dir The chosen direction of the save.
     * @param power The power level of the saver.
     * @return The calculated direction value as a float.
     */
    @Override
    public float saveDirectionFormula(int left, int right, int dir, int power) {
        return super.saveDirectionFormula(left, right, dir, power);
    }

    /**
     * Adjusts the AI's shot direction, providing a straightforward return for expert skill level.
     *
     * @param aiDir The AI's chosen shot direction.
     * @return The adjusted AI shot direction.
     */
    @Override
    public float aiDirectionAdjust(int aiDir) {
        return (float) (4*aiDir);
    }

    /**
     * Adjusts the range of effectiveness based on the current difficulty level set in the game.
     * This method determines how forgiving the game is when comparing the saver's chosen direction to the AI's shot direction.
     * A higher difficulty results in a smaller margin for error.
     *
     * @return The adjusted range of effectiveness as a float, varying with the game's difficulty level.
     */
    @Override
    public float rangeAdjust() {
        float range=0;
        switch (Ui.difficultyLevel){
            case EASY:
                range = (float)0.4;
                break;
            case MEDIUM:
                range = (float)0.8;
                break;
            case HARD:
                range = (float)2;
                break;
            default:
                range =0;
        }
        return range;
    }
}
