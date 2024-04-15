# Developer Guide

## Class Structure



# Design of various features
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


The procedure is facilitated by `MatchStat` class. It records current round number, match number, player score, Ai 
score, whether it's the player's turn to shoot, whether the match ends, whether the player wins, and whether the match 
is a new match (has not started shooting).

The `updateStat(boolean isGoal)` method converts the outcomes of player's commands into player score 
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

2. Then `getAiDirection()` in the `Ai` class is called. It returns `aiDir` of type `int`, which represents the 
direction at which Ai wants to save the penalty.

3. Then methods 2, 6 and 8 will adjust the shoot direction and AI direction based on random numbers generated. They try 
to add randomness into the game.

4. After that, `CommandList` has a self invocation to call its 
`goalCheck(adjustedAiDirection, adjustedDirection, adjustedRange)` method. This method decides whether the shoot scores 
or not, and returns `isScoreGoal` of type `boolean`.

5. `isScoreGoal` is then passed to the `updateStat(isScoreGoal)` method in the `MatchStat` class. The method changes 
`playerScore` and `aiScore` (both stored in `MatchStat` class) based on `isScoreGoal` read and inverts 
`isPlayerShootTurn` stored in `MatchStat` class to show now it's AI's turn to shoot. `MatchStat` then has a self 
invocation to call its `decideMatchEnd()` method.

6. `decideMatchEnd()` method reads `roundCount`, `playerScore` and `aiScore` in `MatchStat` class, and decides whether a 
match ends based on the two rules mentioned above. It then changes `isMatchEnd` and `isPlayerWin` in `MatchStat` class 
accordingly.

7. After step 5, all the stats that need to be changed after `shoot` command have been updated. Hence, 
`updateStat(isScoreGoal)` method returns. However, messages need to be printed out for the player to see that his 
command finishes executing. Thus, the `printGoalAfterShot(isScoreGoal, adjustedDirection)` method in the `Player` class 
is called. It prints out all the necessary messages for the user.


## Coin Toss

### Overview

Coin tosses are used to decide which team shoots first in the penalty shoot out. If the player guesses the coin toss 
correctly, he can shoot first. If not, AI shoots first. We included a coin toss feature in the game.

### Design

Here’s a class diagram of the `CoinToss` component:

![CoinTossClassDiagram.png](diagrams%2FCoinTossClassDiagram.png)

There are two classes `CoinToss`, `Coin` and one enumeration `CoinResult`. We define an enumeration type called 
`CoinResult` to ensure that variables of type `CoinResult` will never be assigned an invalid value. The `CoinToss` class
is responsible for executing coin tosses. The `Coin` class represents a coin used in the coin toss. It has a result, and
can be tossed. Note that there is no association between `CoinToss` and `Coin`, because `CoinToss` does not store an 
attribute of the `Coin` class. `CoinToss` only has a dependency on `Coin`, because there is only a transient interaction
in the `executeCoinToss(guess: CoinResult)` method.

The sequence diagram below illustrates the interactions within the `CoinToss` component. For this example, `head` is 
guessed by the player.

![CoinTossSequential.png](diagrams%2FCoinTossSequential.png)

How the `CoinToss` component works:
1. After parsing of the input, `executeCoinToss(HEAD)` in the `CoinToss` class is called.
2. Then a `coin` object of type `Coin` is created.
3. In the constructor of Coin, `tossACoin()` method is executed, which assigns the `result` attribute of `coin` a value.
This result represents the result of the coin toss.
4. The `coin` object is created and returned to the `CoinToss` class. Then `getResult()` method of the `coin` object is 
called. `coinResult` is returned to the `CoinToss` class.
5. Then the `CoinToss` class calls `displayResult(coinResult)` to show player the result of the coin toss.
6. The `CoinToss` class also calls `processGuessResult(guess, coinResult)` to decide whether the guess is correct. This 
method also displays the correctness of the guess and updates the stats in MatchStat class accordingly.
7. Finally, `executeCoinToss(HEAD)` returns.

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

## Player Class Overview

### Design

The `Player` class is a class designed to implementing shoot function and storing user parameters that influence game performance. This class encapsulates essential player attributes which are vital throughout the game:

- `name`: String - The name of the player.
- `matchCount`: int - Counts the number of matches played.
- `power`: int - Indicates the player's power level, affecting the accuracy of shots.
- `skill`: int - Determines the range of directional choices available to the player during gameplay.

### Skill Level Subclasses

The game features several subclasses derived from the `Player` class, each representing different skill levels: `BeginnerSkillPlayer`, `MediumSkillPlayer`, and `ExpertSkillPlayer`. These subclasses provide specialized behaviors through method overriding, tailored to each skill level for a dynamic and engaging gameplay experience.

### Implementation Details

The `Player` class uses Object-Oriented Programming (OOP) principles, particularly polymorphism and encapsulation, to manage player attributes and behaviors dynamically. An `ArrayList<Player>` is utilized to manage collections of these player instances effectively.

- **Example Scenario**:
   - When a user starts the game, a `BeginnerSkillPlayer` named "Bruno" is instantiated.
   - All actions taken by the player, such as completing matches or adjusting power settings, trigger updates within the `Player` class.
   - The `Player` class interacts with the `PlayerList` to manage and update player data collectively.

This structure is designed to leverage the flexibility of OOP to adapt player functionalities based on game interactions dynamically.

### Methods and Their Roles

Each method in the `Player` class is designed to perform specific roles that enhance the interactivity and responsiveness of the game environment:

- `printSelfInfo()`: Displays the player's basic information, including name, match count, power, and skill.
- `printGoalBeforeShoot()`: Prepares the player for a shooting attempt, visualized through an on-screen graph.
- `printGoalBeforeSave()`: Prepares the player for a saving attempt, supported by graphical feedback.
- `printGoalAfterShoot(boolean goalScored, int direction)`: Outputs the result of a shooting attempt, enhancing player feedback.
- `upgradePower(int level)`: Allows players to set their power level, influencing shot effectiveness.
- `shootDirectionAdjust(int dir)`: Alters shooting direction based on the player's current power level.
- `shootDirectionFormula(int left, int right, int dir, int power)`: Calculates the optimal shooting direction using provided parameters.
- `aiDirectionAdjust(int aiDir)`: Adjusts AI behavior based on the player's skill level, ensuring suitable challenge levels.
- `rangeAdjust()`: Modifies the shooting range to match the game's set difficulty levels.

  ![UML Class Diagram](diagrams%2Fplayer.png)

## PlayerList Class

### Attributes

- `l1`: ArrayList<Player> - Manages a dynamic list of player objects.

### Methods

- `skillUpgrade(int curPlayer)`: Enhances the skill level of the specified player.

### Utilizing ArrayList

ArrayList<Player> stores and manages player objects, allowing for efficient access and modification, which is essential for real-time gameplay updates.

### Leveraging Polymorphism

Polymorphism is integral to our game, allowing us to abstract player actions in the `Player` class and provide specific implementations in its subclasses. This design pattern simplifies codebase maintenance and enhances gameplay by introducing dynamic behavior based on the player's skill level.

#### Implementation: ExecuteShoot Method

The `executeShoot` method from CommandList Class exemplifies polymorphism in action, adjusting player behavior during shooting based on player's skill level.

```java
public static void executeShoot(String[] readArgumentTokens) {
  float adjustedDirection = PlayerList.l1.get(Ui.curPlayer).shootDirectionAdjust(selectedDirectionIndex);
  float adjustedAiDirection = PlayerList.l1.get(Ui.curPlayer).aiDirectionAdjust(Ai.getAiDirection());
  float adjustedRange = PlayerList.l1.get(Ui.curPlayer).rangeAdjust();
  //...
  PlayerList.l1.get(Ui.curPlayer).printGoalAfterShoot(isScoreGoal, Math.round(adjustedDirection));
}
```
#### Implementation: Skill Upgrade Mechanism

The `skillUpgrade` method in the `PlayerList` class is a key feature, allowing players to improve their skills based on game performance. The method checks the player's current skill and match count, upgrading their skill level if certain conditions are met.
he mechanism operates through a structured process, enhancing the gaming experience by offering a realistic approach to skill progression:

1. **Skill Level Assessment**: Evaluates a player's current skill level and performance metrics, like match count and success rate.

2. **Determination of Skill Upgrade Eligibility**: Responsible to assess if a player qualifies for a skill upgrade, based on their game performance.

3. **Application of Skill Upgrade**: Adjusts the player's skill attribute to a higher level if they meet the necessary criteria and enhancing their gameplay capabilities.

4. **Feedback to the User**: Provides in-game notifications or UI messages to inform the player of their upgraded skills

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

## Saver and SaverList Class

### Overview

The `Saver` and `Saverlist` class is implemented in the same way the `Player` and `PlayerList` class is.

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


## Product scope
### Target user profile

Designed for football fans seeking a straightforward alternative to complex, high-spec "AAA" games like FIFA or PES. Ideal for those who prefer simplicity and quick gameplay over detailed simulation.

### Value proposition

NUSFC 24 offers football enthusiasts a refreshing break from the complexities of 3D games like FIFA or eFootball. Dive into the core thrill of football with our focus on the art of penalty shooting and goalkeeping, celebrating the pure joy and challenge of the game's decisive moments.

## User Stories

| Version | As a ... | I want to ...                        | So that I can ...                           |
|---------|----------|--------------------------------------|---------------------------------------------|
| v1.0    | user     | see the goal                         | know where to shoot my penalty              |
| v1.0    | user     | add shoot command                    | choose the penalty direction like real game |
| v1.0    | user     | have an ai goalkeeper                | know whether my penalty is saved            |
| v2.0    | user     | level my player up                   | try different functions in the game         |
| v2.0    | user     | have a real penalty shootout setting | experience a more realistic game            |
| v2.0    | user     | toss a coin before each match        | see which team should shoot first           |
| v2.0    | user     | select difficulty mode               | keep refining my skills                     |


## Non-Functional Requirements

1. Should work on any *mainstream OS* as long as it has Java `11` or above installed.
2. Should allow the player to play as long as he wants without a noticeable sluggishness in performance for typical 
usage.

## Glossary

* Mainstream OS: Windows, Linux, Unix, macOS

## Instructions for manual testing

### Launch and shutdown
1. Initial launch
   1. Download the jar file and copy into an empty folder
   2. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar tp.jar` command to run
      the application.
2. Use `bye` to exit the game

### Coin Toss
1. Prerequisites: You are at the beginning of a match.
2. Test case: `head` or `tail`

   Expected: A coin is tossed, and its result is shown. If the coin is not `UPRIGHT`, you are told whether you guess it
right, and you can start the game properly.
3. Test case: `bye`

    Expected: You will exit the program.
4. Test case: Other invalid commands like `shoot 0`, `save 0`, `...`

   Expected: An error message is shown, and you are asked to guess the coin result again.

### Match Ending Criteria
1. Prerequisites: You finished guessing the coin toss, and are in a match.
2. You need to enter alternating commands `shoot int` and `save int` to progress the match.
3. Try to make the scores to satisfy the two penalty shoot out rules (Best-of-five Kicks and Sudden Death).

   Expected: The match ends, showing whether you have won or lost.

## Future Enhancements

1. **Adaptive AI Difficulty**: Implement an adaptive AI difficulty system where the AI's behavior changes based on the player's performance. This could involve adjusting the range of directions or introducing other challenges for the AI.

2. **Penalty Shootout Mode**: Implement a penalty shootout mode where the game is decided by a series of penalty kicks. This could involve additional rules and scoring mechanisms specific to penalty shootouts.

3. **Custom Difficulty Levels**: Allow users to define custom difficulty levels by specifying the range of directions or other parameters that affect the AI's behavior.

4. **Advanced AI Strategies**: Enhance the AI's decision-making capabilities by implementing more advanced strategies and algorithms. This could involve considering factors such as the player's previous shots, game statistics, or other relevant data.

5. **Multiplayer Mode**: Implement a multiplayer mode where multiple players can participate in the game, either locally or over a network.

