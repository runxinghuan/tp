# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}



## AI Class 

### Overview

The `Ai` class is responsible for generating a random direction for the computer player (AI) to shoot or save in the game. The difficulty level of the game determines the range of directions the AI can choose from.

### Design

The `Ai` class has the following components:

1. `minDirection` and `maxDirection` static variables to store the minimum and maximum direction values based on the difficulty level.
2. A constructor that takes a `DifficultyLevel` object as input and initializes the `minDirection` and `maxDirection` based on the difficulty level.
3. A `getAiDirection()` static method that generates a random direction within the range of `minDirection` and `maxDirection`.
4. Getter methods `getMinDirection()` and `getMaxDirection()` to retrieve the minimum and maximum direction values, respectively.

### Implementation

The `Ai` class is implemented as follows:

```java
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
```

The constructor initializes the `minDirection` and `maxDirection` based on the `DifficultyLevel` parameter. The `getAiDirection()` method generates a random integer within the range of `minDirection` and `maxDirection` using the `Random` class from Java's `util` package.

### Alternatives Considered

An alternative design could be to have separate classes for different difficulty levels, each with its own implementation of the `getAiDirection()` method. However, this would lead to code duplication and make the codebase more difficult to maintain.

## Penalty Class

### Overview

The `Penalty` class handles the penalty command in the game. It prompts the user to enter the direction to shoot the penalty and checks if the user's input is valid. It then compares the user's input with the AI's direction and determines whether a goal is scored or not.

### Design

The `Penalty` class has the following components:

1. A `PENALTY_PROMPT` constant string to display the prompt for the user to enter the penalty direction.
2. An `executePenalty()` method that takes an `Ai` object as input and executes the penalty command.
3. A `getUserPenaltyDirection()` method that prompts the user to enter the penalty direction and returns the corresponding integer value.
4. A `convertToShootDirection()` method that converts the user's input direction to an integer value, validating the input and handling invalid inputs.

### Implementation

The `Penalty` class is implemented as follows:

```java
public class Penalty {
    private static final String PENALTY_PROMPT = "Enter the direction to shoot the penalty (0, 1, or 2): ";

    public static void executePenalty(Ai ai) {
        int userDirection = getUserPenaltyDirection();
        int aiDirection = ai.getAiDirection();
        boolean isGoal = CommandList.goalCheck(userDirection, aiDirection);
        Formatter.printGoalAfterShot(isGoal);
    }

    private static int getUserPenaltyDirection() {
        System.out.print(PENALTY_PROMPT);
        String directionString = Ui.userInput;
        int userDirection = convertToShootDirection(directionString);
        return userDirection;
    }

    public static int convertToShootDirection(String direction) {
        int directionIndex;
        try {
            directionIndex = Integer.parseInt(direction);
        } catch (NumberFormatException e) {
            Formatter.printErrorWrongArgumentType("PENALTY", "^[0-2]$", 0);
            return -1; // Invalid input
        }

        if (directionIndex >= Ai.getMinDirection() && directionIndex <= Ai.getMaxDirection()) {
            return directionIndex;
        } else {
            Formatter.printErrorWrongArgumentType("PENALTY", "^[0-2]$", 0);
            return -1; // Invalid direction
        }
    }
}
```

The `executePenalty()` method calls the `getUserPenaltyDirection()` method to get the user's input direction, gets the AI's direction using the `Ai` class, and then checks if a goal is scored using the `goalCheck()` method in the `CommandList` class. The `getUserPenaltyDirection()` method prompts the user to enter the direction and calls the `convertToShootDirection()` method to validate and convert the user's input.

The `convertToShootDirection()` method first tries to parse the input string into an integer using `Integer.parseInt()`. If the parsing fails, it prints an error message using the `Formatter` class and returns -1 to indicate an invalid input. If the parsing succeeds, it checks if the direction is within the valid range based on the `minDirection` and `maxDirection` values from the `Ai` class. If the direction is valid, it returns the direction index; otherwise, it prints an error message and returns -1.

### Alternatives Considered

An alternative implementation could be to have separate methods for handling different types of input validation, such as checking if the input is a valid integer and checking if the input is within the valid range. This would make the code more modular and easier to maintain.

## DifficultyLevel Enum

### Overview

The `DifficultyLevel` enum represents the difficulty levels of the game. It has three values: `EASY`, `MEDIUM`, and `HARD`.

### Design

The `DifficultyLevel` enum is a simple enumeration that defines the three difficulty levels of the game.

### Implementation

The `DifficultyLevel` enum is implemented as follows:

```java
public enum DifficultyLevel {
    EASY,
    MEDIUM,
    HARD
}
```

### Alternatives Considered

An alternative to using an enum could be to use integer constants or string constants to represent the difficulty levels. However, enums provide type safety and better code readability, making them a preferred choice for representing a fixed set of values.

## Class Diagrams

```
+-------------+
|DifficultyLevel|
+-------------+
| EASY        |
| MEDIUM      |
| HARD        |
+-------------+

+------------+
|     Ai     |
+------------+
| -minDirection: int
| -maxDirection: int
+------------+
| +Ai(difficultyLevel: DifficultyLevel)
| +getAiDirection(): int
| +getMinDirection(): int
| +getMaxDirection(): int
+------------+

+----------------+
|     Penalty    |
+----------------+
| -PENALTY_PROMPT: String
+----------------+
| +executePenalty(ai: Ai): void
| -getUserPenaltyDirection(): int
| +convertToShootDirection(direction: String): int
+----------------+

+----------------+
|   CommandList  |
+----------------+
| +goalCheck(userInput: int, aiInput: int): boolean
+----------------+

+-------------+
|  Formatter  |
+-------------+
| +printGoalAfterShot(goalScored: boolean): void
| +printErrorWrongArgumentType(commandName: String, regex: String, argumentPosition: int): void
+-------------+

+--------+
|   Ui   |
+--------+
| -userInput: String
+--------+

```

The `Ai` class depends on the `DifficultyLevel` enum to determine the range of directions for the AI. The `Penalty` class uses the `Ai` class to get the AI's direction and compares it with the user's input direction. The `CommandList` class provides the `goalCheck()` method to determine if a goal is scored based on the user's and AI's directions. The `Formatter` class is responsible for printing the goal result and error messages related to wrong argument types. The `Ui` class provides the user's input direction to the `Penalty` class.

## Future Enhancements

1. **Adaptive AI Difficulty**: Implement an adaptive AI difficulty system where the AI's behavior changes based on the player's performance. This could involve adjusting the range of directions or introducing other challenges for the AI.

2. **Penalty Shootout Mode**: Implement a penalty shootout mode where the game is decided by a series of penalty kicks. This could involve additional rules and scoring mechanisms specific to penalty shootouts.

3. **Custom Difficulty Levels**: Allow users to define custom difficulty levels by specifying the range of directions or other parameters that affect the AI's behavior.

4. **Advanced AI Strategies**: Enhance the AI's decision-making capabilities by implementing more advanced strategies and algorithms. This could involve considering factors such as the player's previous shots, game statistics, or other relevant data.

5. **Multiplayer Mode**: Implement a multiplayer mode where multiple players can participate in the game, either locally or over a network.