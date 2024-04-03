package seedu.duke.player;

import seedu.duke.Formatter;
import seedu.duke.ui.Ui;

//@@author HenryGan138

public class BeginnerSkillPlayer extends Player {
    private final int skill=1;

    public BeginnerSkillPlayer(String name, int matchCount) {
        super(name, matchCount);
    }

    public BeginnerSkillPlayer(String name, int matchCount, int power) {
        super(name, matchCount, power);
    }

    @Override
    public void printSelfInfo() {
        super.printSelfInfo();
    }

    @Override
    protected void printPower(){
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
    public void printGoalBeforeSave() {
        Formatter.printGoalBeforeSaveForBeginner();
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
        if (dir>2){
            System.out.println("Oops! Remember, beginners start with directions 0, 1, and 2. But keep playing to unlock more kicks!");
            System.out.println("Practice makes perfect. Let's aim for those goals together!");
            dir = dir%3;
        }
        int left=(dir-1==0)?0:dir-1;
        int right=(dir+1==2)?2:dir+1;
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
        float range=0;
        switch (Ui.difficultyLevel){
        case EASY:
            range = (float)0.1;
            break;
        case MEDIUM:
            range = (float)0.2;
            break;
        case HARD:
            range = (float)0.5;
            break;
        default:
            range =0;
        }
        return range;
    }
}
