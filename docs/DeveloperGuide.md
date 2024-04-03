# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Class Structure

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


## Real penalty shootout setting


### Overview


As we are making a penalty shootout game, we should make the procedure of a match in the game the same as that of a 
real penalty shootout. Here is the procedure of a real penalty shootout:


Teams take turns to kick from the penalty mark, until each has taken five kicks. However, if one side has scored more 
goals than the other could possibly reach with all of its remaining kicks, the shoot-out immediately ends, regardless 
of the number of kicks remaining; this basis is called "best-of-five kicks".


If after five rounds of kicks, the teams have scored an equal number of goals (or neither team has scored any goals), 
additional rounds of one kick each are used until one team scores and the other misses. This is known as sudden death.


### Design


The procedure is facilitated by `MatchStat`. It records current round number, match number, player score, Ai score, 
whether it's the player's turn to shoot, whether the match ends, and whether the player wins. 

The `updateStat(boolean isPlayer, boolean isGoal)` method converts the outcomes of player's commands into player score 
and Ai score after `penalty` or `save` commands. 

The `decideMatchEnd()` method decides whether a match ends based on the rules mentioned above. 

The `updateForNewMatch()` method is called after a match ends, and the player starts a new match. The method resets all 
the stats recorded except for the `matchCount`, which is added one to show that the player has finished one more match.

As we now only need to record the match stats of one player, the class is implemented as a utility class. (i.e. Using 
class level fields and methods.) We may change it to an instantiable class later when we need to record the match stats 
of multiple players. Here is the class diagram of the class:


![MatchStatClassDiagram.png](diagrams%2FMatchStatClassDiagram.png)

The sequence diagram below illustrates the interactions between other classes and the `MatchStat` class. For this 
example, `shoot 1` is entered by the player.


![MatchStatSequential.png](diagrams%2FMatchStatSequential.png)

How the `MatchStat` class works:
1. After parsing of the input, `executeShoot("1")` in the `CommandList` class is called.

2. Then `getAiDirection()` in the `Ai` class is called. It returns `direction` of type `int`, which represents the 
direction at which Ai wants to save the penalty.

3. After that, `CommandList` has a self invocation to call its `goalCheck(1, direction)` method. This method decides 
whether the shoot scores or not, and returns `isScoreGoal` of type `boolean`.

4. `isScoreGoal` is then passed to the `updateStat(isScoreGoal)` method in the `MatchStat` class. The method changes 
`playerScore` and `aiScore` (both stored in the same class) based on `isScoreGoal` read and `isPlayerTurn` stored in the
same class. `MatchStat` then has a self invocation to call its `decideMatchEnd()` method.

5. `decideMatchEnd()` method reads `roundCount`, `playerScore` and `aiScore` in the same class, and decides whether a 
match ends based on the two rules mentioned above. It then changes `isMatchEnd` and `isPlayerWin` in the same class 
accordingly.

6. After step 5, all the stats that need to be changed after `shoot` command have been updated. Hence, 
`updateStat(isScoreGoal)` method returns. However, messages need to be printed out for the player to see that his 
command finishes executing. Thus, the `printGoalAfterShot(isScoreGoal)` method in the `Formatter` class is called. It 
prints out all the necessary messages for the user.


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

## Player Class

### Introduction

The `Player` class utilizes Object-Oriented Programming principles to track and store a user's performance, implementing functionality that varies based on the player's skill level. As the foundation of our player management system, it encapsulates common attributes and behaviors essential for all player types.

### Skill Level Subclasses

Subclasses `BeginnerSkill`, `MediumSkill`, and `ExpertSkill` are derived from the `Player` base class, each tailored to represent different skill levels. These subclasses override specific methods to provide behaviors unique to each skill level, ensuring a dynamic and engaging gameplay experience.

### Attributes

- `name`: String - Identifies the player.
- `matchCount`: int - Tracks the number of matches played.
- `power`: int - Represents the player's power level.
- `skill`: int - Indicates the player's skill level.

### Methods

- `printSelfInfo()`: Displays the player's basic information.
- `printGoalBeforeShoot()`: Prepares the player for a shooting attempt.
- `printGoalBeforeSave()`: Prepares the player for a saving attempt.
- `printGoalAfterShoot(boolean goalScored, int direction)`: Shows the outcome of a shooting attempt.
- `upgradePower(int level)`: Enhances the player's power based on the specified level.
- `shootDirectionAdjust(int dir)`: Modifies the shooting direction for the player.
- `shootDirectionFormula(int left, int right, int dir, int power)`: Computes the shooting direction.
- `aiDirectionAdjust(int aiDir)`: Modifies the AI's direction to offer a challenge.
- `rangeAdjust()`: Modifies the shooting range according to the game's difficulty.

  ![UML Class Diagram](diagrams%2Fplayer.png)

```java
public class MediumSkill extends Player {
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
}
```
## PlayerList Class

### Attributes

- `l1`: ArrayList<Player> - Manages a dynamic list of player objects.

### Methods

- `skillUpgrade(int curPlayer)`: Enhances the skill level of the specified player.

### Utilizing ArrayList

The `PlayerList` class showcases the strategic use of `ArrayList<Player>` for player management, chosen for its dynamic resizing capabilities and efficient access times. This choice aligns with our need to manage a variable number of player objects dynamically.

### Leveraging Polymorphism

Polymorphism is integral to our game, allowing us to abstract player actions in the `Player` class and provide specific implementations in its subclasses. This design pattern simplifies codebase maintenance and enhances gameplay by introducing dynamic behavior based on the player's skill level.

#### ExecuteShoot Method

The `executeShoot` method exemplifies polymorphism in action, adjusting player behavior during shooting based on their skill level.

```java
public static void executeShoot(String[] readArgumentTokens) {
  float adjustedDirection = PlayerList.l1.get(Ui.curPlayer).shootDirectionAdjust(selectedDirectionIndex);
  float adjustedAiDirection = PlayerList.l1.get(Ui.curPlayer).aiDirectionAdjust(Ai.getAiDirection());
  float adjustedRange = PlayerList.l1.get(Ui.curPlayer).rangeAdjust();
  //...
  PlayerList.l1.get(Ui.curPlayer).printGoalAfterShoot(isScoreGoal, Math.round(adjustedDirection));
}
```
### Skill Upgrade Mechanism

The `skillUpgrade` method in the `PlayerList` class is a key feature, allowing players to improve their skills based on game performance. The method checks the player's current skill and match count, upgrading their skill level if certain conditions are met.
he mechanism operates through a structured process, enhancing the gaming experience by offering a realistic approach to skill progression:

1. **Skill Level Assessment**: The system evaluates a player's current skill level alongside their performance metrics, such as match count and success rate.

2. **Determination of Skill Upgrade Eligibility**: Utilizing predefined criteria, the system determines if a player qualifies for a skill upgrade. These criteria may include metrics like a minimum number of matches played or specific performance thresholds.

3. **Application of Skill Upgrade**: Eligible players will have their skill attribute adjusted to a higher level. This upgrade might unlock new abilities, enhance stats, or offer other in-game advantages.

4. **Feedback to the User**: The system informs the user of the successful skill upgrade through UI messages or other feedback mechanisms, providing immediate recognition of their achievement.

![UML Class Diagram](diagrams%2FupdateSkill.png)

### Alternatives Considered

#### Alternative Collections for Player Management
- **HashSet<Player>**: Evaluated for its uniqueness properties and constant-time performance for add, remove, and contains operations. It was ultimately not selected due to the ordered nature of player management required in our game, which is better served by a List implementation.

#### Polymorphism Implementation Methods
- **Interface-based Polymorphism**: An alternative approach using interfaces to define common behaviors for all players was considered. While this would have provided a clean separation of concerns, the decision to use class inheritance and method overriding was driven by the shared attributes and methods across player types, favoring a more hierarchical structure.

### Future Improvements and Additions

The player management system is designed with extensibility in mind, allowing for continuous improvements and the addition of new features. Here are some planned enhancements:

#### Skill-Based Matchmaking

- Implement an algorithm for skill-based matchmaking, allowing players to compete against opponents with similar skill levels, enhancing the competitiveness and fairness of matches.

#### Advanced Player Statistics

- Expand the player class to include more detailed statistics, such as win/loss ratios, average scores, and other performance metrics. This data could be used to provide insights to players on their gameplay and areas for improvement.

#### Dynamic Skill Level Adjustments

- Introduce a more dynamic skill level adjustment mechanism, possibly incorporating machine learning to analyze player performance and adjust skill levels in a more nuanced and responsive manner.

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

## Save Class

### Overview

The `Save` class handles the save command in the game. It prompts the user to enter the direction to save the penalty and checks if the user's input is valid. It then compares the user's input with the AI's direction and determines whether a goal is saved or not.

### Design

The `Save` class has the following components:

1. An `executeSave()` method that prompts the user for a direction, gets the AI's penalty kick direction, and then checks if the save is successful.
2. A `getUserSaveDirection()` method that reads the user's input and returns a corresponding integer value after validation.
3. Integration with the `ShootDirectionConverter` class to validate the user's input and ensure it's within the expected range.

### Implementation

Here is the implementation structure of the `Save` class:

```java
public class Save {
    
  public static void executeSave() {
    int userSaveDirection = getUserSaveDirection();
    int aiPenaltyDirection = Ai.getAiDirection();
    boolean isGoalSaved = userSaveDirection == aiPenaltyDirection;


    Formatter.printSaveResult(isGoalSaved);
    Ui.roundCount++;
  }
  
  private static int getUserSaveDirection() {
    int userDirection;
    do {
      System.out.print("Enter the direction to save the penalty (0, 1, or 2): ");
      String directionString = Ui.IN.nextLine().trim();
      userDirection = ShootDirectionConverter.convertToShootDirection(directionString);
      if (userDirection == -1) {
        System.out.println("Invalid direction! Please enter 0, 1, or 2.");
      }
    } while (userDirection == -1);
    return userDirection;
  }
  
}
```

The `executeSave()` method drives the process, starting by invoking `getUserSaveDirection()` to prompt the user for input. It then retrieves the AI's direction with `Ai.getAiDirection()`. A comparison is made, and the result of the attempted save is passed to the `Formatter` for output. The `roundCount` is incremented at the end of the method, signaling the progression of the game.

The `getUserSaveDirection()` method repeatedly prompts the user for input until a valid direction (0, 1, or 2) is entered. Input validation is offloaded to `ShootDirectionConverter.convertToShootDirection()`, which translates the string input into a numeric direction or returns -1 for invalid input.

### Alternatives Considered

The current implementation could be further modularized by separating input collection and input validation into distinct methods. This would potentially improve the readability and maintainability of the code by delineating clear responsibilities within the class structure. Additionally, using exceptions to handle invalid input could provide a cleaner mechanism for managing input errors and reduce the reliance on sentinel values like `-1`.

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

