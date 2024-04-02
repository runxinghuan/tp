package seedu.duke.player;

import java.util.Random;

//@@author HenryGan138

public class Player {
    public String name;
    public int matchCount;
    private int power;
    private int skill;
    Random rand = new Random();

    public Player(String name, int matchCount) {
        this.name = name;
        this.matchCount = matchCount;
    }
    public void printSelfInfo(){
        System.out.println("--------Player Info--------");
        System.out.println("Name: "+this.name);
        System.out.println("Number of match played: "+this.matchCount);
        printPower();
        printSkill();
        System.out.println("---------------------------");
    }

    public int getSkill() { //For inheritance
        return skill;
    }

    protected void printPower(){} //For override

    protected void printSkill(){} //For override

    public void printGoalBeforeShoot(){} //For override

    public void printGoalBeforeSave(){} //For override

    public void printGoalAfterShoot(boolean goalScored, int direction){} //For override

    public void upgradePower(int level){} //For override

    public float aiDirectionAdjust(int aiDir){
        return 0;
    } //For override

    public float shootDirectionAdjust(int dir){
        return 0;
    }  //For override

    public float shootDirectionFormula(int left, int right, int dir, int power){
        float prob=rand.nextFloat();
        if (power==1){
            prob=prob/2;
            return (float) (left*prob+dir*0.5+right*(0.5-prob));
        }else if (power==2){
            prob=prob/4;
            return (float) (left*prob+dir*0.75+right*(0.25-prob));
        }else{
            prob=prob/10;
            return (float)(left*prob+dir*0.9+right*(0.1-prob));
        }
    }

    public float rangeAdjust(){
        return 0;
    }
}
