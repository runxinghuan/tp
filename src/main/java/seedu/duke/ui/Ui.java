package seedu.duke.ui;

import seedu.duke.*;
import seedu.duke.stats.MatchStat;
import seedu.duke.stats.PlayerList;
import seedu.duke.exception.ProcessInputException;
import seedu.duke.exception.ArgumentMismatchException;
import seedu.duke.exception.BadTokenException;
import seedu.duke.exception.IllegalCommandException;

import java.util.Scanner;
import java.util.logging.Level;

public class Ui {
    public static final Scanner IN = new Scanner(System.in);
    public static int curPlayer = 0; // The player in current game return by account login.
    public static int curSaver = 0; // The saver in current game return by account login.
    private static boolean isRunning = true;
    public static String userInput;
    private static Parser userCommandReader;
    public static DifficultyLevel difficultyLevel = DifficultyLevel.EASY;

    /**
     * Reads user input and stores it
     */
    public static void beginListening() {
        userInput = IN.nextLine();
    }

    /**
     * Parses read input into its parameters
     *
     * @throws ProcessInputException If command read from input is invalid
     */

    public static void processInput() throws ProcessInputException {
        try {
            userCommandReader = new Parser(userInput);
        } catch (IllegalCommandException e) {
            Formatter.printErrorWrongCommand();
            throw new ProcessInputException();
        } catch (ArgumentMismatchException e1) {
            int userArgumentCount = e1.userArgumentCount;
            int correctArgumentCount = SyntaxAnalyser.getArgumentCount(e1.userCommandName);
            Formatter.printErrorArgumentsMismatch(e1.userCommandName, userArgumentCount, correctArgumentCount);
            throw new ProcessInputException();
        } catch (BadTokenException e2) {
            Formatter.printErrorBadTokens();
            throw new ProcessInputException();
        }
    }

    /**
     * Runs command based on parsed input
     */
    public static void executeCommand() {
        String readUserCommand = userCommandReader.getCommandName();
        String[] readArgumentTokens = userCommandReader.getArgumentTokens();
        CommandList selectedCommand = CommandList.valueOf(readUserCommand);

        //@@author runxinghuan
        if (MatchStat.getIsNewMatch()) {
            switch (selectedCommand) {
            case HEAD:
                CoinToss.executeCoinToss(CoinToss.HEAD);
                return;
            case TAIL:
                CoinToss.executeCoinToss(CoinToss.TAIL);
                return;
            case BYE:
                CommandList.executeBye();
                return;
            case HELP:
                CommandList.executeHelpAtStart();
                return;
            default:
                Formatter.printErrorUnknown();
                return;
            }
        }

        if (MatchStat.getIsMatchEnd()) {
            switch (selectedCommand) {
            case YES:
                MatchStat.updateForNewMatch();
                return;
            case NO:
                CommandList.executeBye();
                return;
            case BYE:
                CommandList.executeBye();
                return;
            case HELP:
                CommandList.executeHelpAfterMatch();
                return;
            default:
                Formatter.printErrorUnknown();
                return;
            }
        }

        if (MatchStat.getIsPlayerShootTurn() && selectedCommand == CommandList.SAVE) {
            Formatter.printErrorUnknown();
            return;
        }

        if (!MatchStat.getIsPlayerShootTurn() && selectedCommand == CommandList.SHOOT) {
            Formatter.printErrorUnknown();
            return;
        }

        switch (selectedCommand) {
        case BYE:
            CommandList.executeBye();
            break;
        case SHOOT:
            CommandList.executeShoot(readArgumentTokens);
            break;
        case PENALTY:
            CommandList.executePenalty(difficultyLevel);
            break;
        case EASY:
            difficultyLevel = DifficultyLevel.EASY;
            System.out.println("Difficulty level set to EASY");
            break;
        case MEDIUM:
            difficultyLevel = DifficultyLevel.MEDIUM;
            System.out.println("Difficulty level set to MEDIUM");
            break;
        case HARD:
            difficultyLevel = DifficultyLevel.HARD;
            System.out.println("Difficulty level set to HARD");
            break;
        case UPGRADE:
            CommandList.executeUpgrade(readArgumentTokens);
            CommandList.executeSaverUpgrade(readArgumentTokens);
            break;
        case SAVE:
            CommandList.executeSave(readArgumentTokens);
            break;
        case HELP:
            CommandList.executeHelpDuringGame();
            break;
        case CUSTOMIZATION:
            PlayerList.playerList.get(curPlayer).displayCustomizationMenu();
            break;
        //insert new executable command here
        default:
            Formatter.printErrorUnknown();
        }
    }

    public static void setIsRunning(boolean runState) {
        isRunning = runState;
    }

    public static boolean getIsRunning() {
        return isRunning;
    }
}
