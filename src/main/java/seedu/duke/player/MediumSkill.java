package seedu.duke.player;

import seedu.duke.Formatter;
import seedu.duke.ui.Ui;
import java.util.Random;

//@@author HenryGan138

public class MediumSkill extends Player {
    private int power = 1;
    private final int skill = 2;
    Random rand = new Random();
    public MediumSkill(String name, int matchCount) {
        super(name, matchCount);
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
    public int getSkill() {
        return skill;
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
        System.out.println(" Level-Medium");
    }

    @Override
    public void printGoalBeforeShoot() {
        Formatter.printGoalBeforeShotforMedium();
    }

    @Override
    public void printGoalBeforeSave() {
        Formatter.printGoalBeforeSaveForMedium();
    }

    @Override
    public void printGoalAfterShoot(boolean goalScored, int direction) {
        Formatter.printGoalAfterShotMedium(goalScored, direction);
    }
    @Override
    public void upgradePower(int level) {
        assert level>=0&&level<=2;
        this.power=level+1;
    }

    @Override
    public float shootDirectionAdjust(int dir){
        if (dir>5){
            System.out.println("Oops! Remember, beginners start with directions 0, 1, and 2. But keep playing to unlock more kicks!");
            System.out.println("Practice makes perfect. Let's aim for those goals together!");
            dir = dir%6;
        }
        int left=(dir-1==0)?0:dir-1;
        int right=(dir+1==5)?5:dir+1;
        return this.shootDirectionFormula(left,right,dir,this.power);
    }

    @Override
    public float shootDirectionFormula(int left, int right, int dir, int power) {
        return super.shootDirectionFormula(left, right, dir, power);
    }

    @Override
    public float aiDirectionAdjust(int aiDir) {
        return (float) (2.5*aiDir);
    }

    @Override
    public float rangeAdjust() {
        float range=0;
        switch (Ui.difficultyLevel){
        case EASY:
            range = (float)0.25;
            break;
        case MEDIUM:
            range = (float)0.5;
            break;
        case HARD:
            range = (float)1.25;
            break;
        default:
            range =0;
        }
        return range;
    }
}
