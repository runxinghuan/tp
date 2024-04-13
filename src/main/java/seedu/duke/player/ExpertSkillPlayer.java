package seedu.duke.player;

import seedu.duke.Formatter;
import seedu.duke.ui.Ui;

//@@author HenryGan138

public class ExpertSkillPlayer extends Player {
    private final int skill = 3;

    public ExpertSkillPlayer(String name, int matchCount) {
        super(name, matchCount);
    }
    public ExpertSkillPlayer(String name, int matchCount, int power) {
        super(name, matchCount, power);
    }

    @Override
    public void printSelfInfo() {
        super.printSelfInfo();
    }

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

    @Override
    public int getSkill() {
        return skill;
    }

    //For now, only finished visualization part, user can only choose 0,1,2
    //Will be completed in V2.0b
    @Override
    public void printGoalBeforeShoot() {
        Formatter.printGoalBeforeShotforExpert();
    }

    @Override
    public void printGoalBeforeSave() {
        Formatter.printGoalBeforeSaveForExpert();
    }

    @Override
    public void printGoalAfterShoot(boolean goalScored, int direction) {
        Formatter.printGoalAfterShotExpert(goalScored, direction);
    }

    @Override
    public void upgradePower(int level) {
        assert level>=0&&level<=2;
        this.power=level+1;
    }

    @Override
    public float shootDirectionAdjust(int dir){
        int left= Math.max(dir - 1, 0);
        int right= Math.max(dir + 1, 8);
        return this.shootDirectionFormula(left,right,dir,this.power);
    }

    @Override
    public float shootDirectionFormula(int left, int right, int dir, int power) {
        return super.shootDirectionFormula(left, right, dir, power);
    }

    @Override
    public float aiDirectionAdjust(int aiDir) {
        return (float) (4*aiDir);
    }

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
//@@author
