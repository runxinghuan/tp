package seedu.duke.ui;

import seedu.duke.cointoss.CoinResult;
import seedu.duke.cointoss.CoinToss;
import seedu.duke.CommandList;
import seedu.duke.DifficultyLevel;
import seedu.duke.Formatter;
import seedu.duke.Parser;
import seedu.duke.SyntaxAnalyser;
import seedu.duke.stats.MatchStat;
import seedu.duke.stats.PlayerList;
import seedu.duke.exception.ProcessInputException;
import seedu.duke.exception.ArgumentMismatchException;
import seedu.duke.exception.BadTokenException;
import seedu.duke.exception.IllegalCommandException;

import java.util.Scanner;

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
            executeBeforeMatch(selectedCommand);
            return;
        }

        if (MatchStat.getIsMatchEnd()) {
            executeAfterMatch(selectedCommand);
            return;
        }

        if (MatchStat.getIsPlayerShootTurn() && selectedCommand == CommandList.SAVE) {
            Formatter.printErrorUnknown();
            return;
        }

        if (!MatchStat.getIsPlayerShootTurn() && selectedCommand == CommandList.SHOOT) {
            Formatter.printErrorUnknown();
            return;
        }
        //@@author hwc0419

        executeMainMatch(selectedCommand, readArgumentTokens);
    }

    /**
     * Executes the command in a match.
     */
    private static void executeMainMatch(CommandList selectedCommand, String[] readArgumentTokens) {
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
        case SETPOWER:
            CommandList.executeSetPower(readArgumentTokens);
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

    //@@author runxinghuan

    /**
     * Executes the command when a match ends.
     */
    private static void executeAfterMatch(CommandList selectedCommand) {
        switch (selectedCommand) {
        case YES:
            MatchStat.updateForNewMatch();
            break;
        case NO:
            CommandList.executeBye();
            break;
        case BYE:
            CommandList.executeBye();
            break;
        case HELP:
            CommandList.executeHelpAfterMatch();
            break;
        case CUSTOMIZATION:
            PlayerList.playerList.get(curPlayer).displayCustomizationMenu();
            return;
        default:
            Formatter.printErrorUnknown();
        }
    }

    /**
     * Executes the command before a match starts.
     */
    private static void executeBeforeMatch(CommandList selectedCommand) {
        switch (selectedCommand) {
        case HEAD:
            CoinToss.executeCoinToss(CoinResult.HEAD);
            break;
        case TAIL:
            CoinToss.executeCoinToss(CoinResult.TAIL);
            break;
        case BYE:
            CommandList.executeBye();
            break;
        case HELP:
            CommandList.executeHelpAtStart();
            break;
        case CUSTOMIZATION:
            PlayerList.playerList.get(curPlayer).displayCustomizationMenu();
            return;
        default:
            Formatter.printErrorUnknown();
        }
    }
}
