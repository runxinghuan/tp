package seedu.duke.player;

import seedu.duke.Formatter;
import seedu.duke.ui.Ui;

//@@author HenryGan138

public class BeginnerSkillPlayer extends Player {
    private final int skill=1;

    public BeginnerSkillPlayer(String name, int matchCount) {
        super(name, matchCount);
    }

    @Override
    public void printSelfInfo() {
        super.printSelfInfo();
    }

    @Override
    protected void printPower(){
        int powerLevelTotal = 3;
        System.out.print("Power:");
        for (int i = 0; i < powerLevelTotal; i++){
            if (i < power){
                System.out.print(" ###");
            }else{
                System.out.print("    ");
            }
        }
        if (power == 1){
            System.out.println(" Level-Beginner");
        }else if (power == 2){
            System.out.println(" Level-Medium");
        }else{
            System.out.println(" Level-Expert");
        }
    }

    @Override
    protected void printSkill(){
        int skillLevelTotal = 3;
        System.out.print("Skill:");
        for (int i = 0; i < skillLevelTotal; i++){
            if (i < skill){
                System.out.print(" ###");
            }else{
                System.out.print("    ");
            }
        }
        System.out.println(" Level-Beginner");
    }

    @Override
    public int getSkill() {
        return skill;
    }

    @Override
    public void printGoalBeforeShoot() {
        Formatter.printGoalBeforeShotforBeginner();
    }

    @Override
    public void printGoalAfterShoot(boolean goalScored, int direction) {
        Formatter.printGoalAfterShotBeginner(goalScored, direction);
    }

    @Override
    public void upgradePower(int level) {
        assert level>=0&&level<=2;
        this.power=level+1;
    }

    @Override
    public float shootDirectionAdjust(int dir){
        int beginnerMinShoot = 0;
        int beginnerMaxShoot = 2;
        if (dir> beginnerMaxShoot){
            System.out.println("----------WARNING----------");
            System.out.println("Oops! Remember, beginners can only start with directions 0, 1, and 2. ");
            System.out.println("You failed to shoot on target.");
            System.out.println("Practice makes perfect. Keep playing to unlock more kicks!");
            System.out.println("---------------------------");
            int missTargetVariable = -1;
            return this.shootDirectionFormula(missTargetVariable, missTargetVariable, missTargetVariable,this.power);
        }
        int left= Math.max(dir - 1, beginnerMinShoot);
        int right= Math.min(dir + 1, beginnerMaxShoot);
        return this.shootDirectionFormula(left,right,dir,this.power);
    }

    @Override
    public float shootDirectionFormula(int left, int right, int dir, int power) {
        return super.shootDirectionFormula(left, right, dir, power);
    }

    @Override
    public float aiDirectionAdjust(int aiDir) {
        return (float) (aiDir);
    }

    @Override
    public float rangeAdjust() {
        float range;
        switch (Ui.difficultyLevel){
        case EASY:
            range = (float)EASY_GK_COVERED_RANGE;
            break;
        case MEDIUM:
            range = (float)MEDIUM_GK_COVERED_RANGE;
            break;
        case HARD:
            range = (float)HARD_GK_COVERED_RANGE;
            break;
        default:
            return 0;
        }
        return range;
    }
}
//@@author
