package seedu.duke.ai;

import seedu.duke.DifficultyLevel;

import java.util.Random;

public class Ai {
    private static int minDirection;
    private static int maxDirection;

    public Ai(DifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY:
                minDirection = 0;
                maxDirection = 2;
                break;
            case MEDIUM:
                minDirection = 0;
                maxDirection = 3;
                break;
            case HARD:
                minDirection = 0;
                maxDirection = 4;
                break;
        }
    }

    public static int getAiDirection() {
        Random rand = new Random();
        int direction = rand.nextInt(maxDirection - minDirection + 1) + minDirection;
        assert direction >= minDirection && direction <= maxDirection : "Illegal AI direction generated!";
        return direction;
    }


    public static int getMinDirection() {
        return minDirection;
    }

    public static int getMaxDirection() {
        return maxDirection;
    }
}
