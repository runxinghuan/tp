# User Guide

## Introduction

NUSFC 24 is an association football-themed game app. Unlike the more famous games like EA Sports FC 24 and eFootball, 
NUSFC 24 is played via a Command Line Interface (CLI). The game does not simulate the main game of a football match. 
Rather, it simulates penalty shoot-out for football.

## Background Information

### Penalty Shoot-out

In a penalty shoot-out, each team takes turns shooting at goal from the penalty mark, with the goal defended only by the
opposing team's goalkeeper.

### Rules for Penalty Shoot-out

#### Best-of-five Kicks

Teams take turns to kick from the penalty mark, until each has taken five kicks. However, if one side has scored more 
goals than the other could possibly reach with all of its remaining kicks, the shoot-out immediately ends, regardless of
the number of kicks remaining.

For example, there are two teams, team A and team B playing a penalty shoot-out. Suppose team A shoots first, and team A
has taken three kicks, scoring all of them (three goals). While team B has taken two kicks now, scoring 0 goal. Now the 
score difference between team A and B is three. The kicks remaining for team B is also three. As the score difference is
not strictly larger than the kicks remaining for team B, it is still possible for team A to miss its two kicks remaining
while team B scores all the three kicks left, making it to be 3:3 after five kicks. Hence, the game does not end 
immediately. However, if team B misses its next kick, now the score difference is still three, but the remaining kicks 
for team B becomes two. The goal difference (3) is larger than the number of kicks left for team B (2). Hence, the game 
ends immediately, with team A being the winner.


#### Sudden Death

If after five rounds of kicks, the teams have scored an equal number of goals (or neither team has scored any goals), 
additional rounds of one kick each are used until one team scores and the other misses.

### Player Attributes Overview

Welcome to our penalty simulator, crafted to offer you a slice of the real-world football experience. Just like in professional sports, progressing through our game mirrors the actual journey of skill development and mastery found in football training.

#### Key Points on Skill and Power

- **Skill** affects your **directional control** during shots, evolving as you gain experience, similar to how footballers improve their aiming with practice.
- **Power** determines the **accuracy and strength** of your shots, akin to a football player's ability to strike the ball powerfully.

Understanding these attributes is crucial for mastering the game and enhancing your virtual football career.

#### Detailed Attribute Explanation

##### Skill: Your Tactical Edge

- **Levels:**
  - **Beginner**: Shoot left, middle, right — your starting abilities. **Alternative directions: (0-2)**
  - **Medium**: Unlock additional directions, reflecting your improved aiming skills. **Alternative directions: (0-5)**
  - **Expert**: Master shooting with the widest range of directions, showcasing your peak precision. **Alternative directions: (0-8)**
![Skill Level Progression Graph](photoUg%2FBeforeShot.png)

- **Progression**:
  - Move from **Beginner to Medium** by playing at least one match.
  - Advance from **Medium to Expert** after at least five matches, emulating the real-life practice and dedication required to excel in football.

#### Power: Your Strength on the Field

- Reflects the might behind each shot. Increasing your power level enhances the accuracy of your shots, mirroring the intensive training footballers undergo to perfect their strike force.
- **Customize Your Power (0-2)**: Choose your power level freely at the beginning of each match, allowing you to strategize your gameplay based on your preferred playing style.

By incorporating these attributes into our game, we aim to provide an immersive experience that closely aligns with the real challenges and achievements of football. As you progress, you’ll find that the journey from a beginner to an expert is not just about winning matches but about honing your skills and strategy to truly master the art of the game.

## Quick Start

1. Ensure that you have Java 11 or above installed in your laptop.
2. Download the latest version of `NUSFC 24` from [here](https://github.com/AY2324S2-CS2113-F15-3/tp/releases/tag/v2.0).
3. Copy the file to the folder where you want to play the game.
4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar tp.jar` command to run
the application.
5. Type the command in the terminal and press Enter to execute it. e.g. typing `shoot 0` and pressing Enter will shoot a
penalty at direction 0 shown in the goal.\
Some example commands you can try:
* `shoot 0`: Shoot a penalty at direction 0 shown in the goal.
* `save 0`: Make a save at direction 0 shown in the goal.
* `upgrade 2`: Upgrade your player to the expert power level.
* `yes`: Restarts a match after a match ends.
* `no`: Does not restart a match after a match ends, and exits the game.
* `bye`: Exits the game.  

6. Refer to the Commands section of this User Guide for details on each command.

## Features

### Coin Toss

Initiates the game by randomly deciding which player goes first, adding an element of chance and fairness to the start of the game.

### Dynamic Difficulty Levels

Allows you to adjust the game's difficulty setting (Easy, Medium, Hard) at any point, tailoring the challenge to your skill level and preferences.

### Listing Commands

Offers an overview of all available commands and their current statuses, helping you navigate the game's functionalities with ease.

...add more features

## Commands

### Exit Command: `bye`

#### Overview

The `bye` command is a straightforward yet crucial feature of this game, allowing players to gracefully exit the game at any moment. This command ensures that users can leave the game safely, ensuring that their progress is saved (if applicable) and that the application closes properly.

#### Usage

To exit the game, simply enter the command:

`bye`

#### Expected Outcome

```
------------------------------------------------------------
                See you next time on court!
------------------------------------------------------------
```
### Help Command: `help`

The `help` command is designed to assist you by displaying a list of available commands based on the current stage of the game. Whether you're just starting, in the heat of a match, or reflecting on your results post-match, `help` can guide you through your options.

#### At Game Start

When you first start the game, invoking this command will display options available for the initial coin toss, including how to exit the game if you change your mind about playing.

Expected Outcome:

At game start, the `help` command will display the following:

```
Here are the commands available
------------------------------------------------------------
    head - Choose 'head' in a coin toss to decide who starts the game.
    tail - Choose 'tail' in the same coin toss.
    bye - Exit the game.
    help - Display this help message again.
------------------------------------------------------------
```

#### During The Game

Using help during gameplay will list actions you can take, such as shooting, saving, adjusting the difficulty, or upgrading your player's power level.

Expected Outcome:

During the game, the `help` command will display the following:

```
Here are the commands available
------------------------------------------------------------
    If it says 'Select direction to shoot :'
        shoot[direction] - Choose a direction to shoot.
------------------------------------------------------------
    If it says 'Select direction to save :'
        save[direction] - Choose a direction to save.
------------------------------------------------------------
    upgrade[power level] - Upgrade the power level of your player.
        0 - Low power level.
        1 - Medium power level.
        2 - High power level.
------------------------------------------------------------
    easy - Set the difficulty to 'easy'.
    meduim - Set the difficulty to 'medium'.
    hard - Set the difficulty to 'hard'.
    bye - Exit the game.
    help - Display this help message again.
------------------------------------------------------------
```

#### After a Match

Once a match concludes, help will show you options for starting a new game or exiting.

Expected Outcome:

After a match, the `help` command will display the following:

```
Here are the commands available
------------------------------------------------------------
    yes - If you want to start a new game.
    no - If you do not want to start a new game. Exit the game.
    bye - Exit the game.
    help - Display this help message again.
------------------------------------------------------------
```

#### Additional Notes
- The `help` command is  available at all stages of the penalty shootout phase.
- The command is case-sensitive, so `help` is considered a valid command, but `Help` and `HELP` are considered invalid inputs.

### Coin Toss Command: `head` or `tail`

#### Overview

The `head` and `tail` commands play a pivotal role in initiating gameplay through a fair and random selection process, akin to a coin toss. These commands are used at the start of a game to determine which player begins, adding an element of chance and strategy right from the outset.

#### Usage 

At the beginning of a game, you will be prompted to choose between `head` or `tail` for the coin toss. Enter one of the following commands based on your choice:

- To choose heads:

  `head`

- To choose tails:

  `tail`

#### Expected Outcome

If the coin lands on its side:

```
    --    
   /  \  
   \  /  
    --    
Oh no! The coin is standing upright on the ground!
You need to guess again.
```

If the user inputs `head` and it is correct:

```
    ----    
  / ^ ^ \  
  \  -  /  
    ----    
You got a head!
You guess it correctly! You can shoot first now!

```

If the user inputs `head` and it is incorrect:

```
    ----    
  /  1  \  
  \     /  
    ----    
You got a tail!
You guess it wrongly. But you can save first.
```

If the user inputs `tail` and it is correct:

```
    ----    
  /  1  \  
  \     /  
    ----    
You got a tail!
You guess it correctly! You can shoot first now!
```

If the user inputs `tail` and it is incorrect:

```
    ----    
  / ^ ^ \  
  \  -  /  
    ----    
You got a head!
You guess it wrongly. But you can save first.
```

#### Additional Notes
- The coin toss command is only available at the start of the game.
- The coin toss command is completely randomised
- The command is case-sensitive, so `head` is considered a valid command, but `Head` and `HEAD` are considered invalid inputs.



### Shoot Command: `shoot`

#### Overview

The `shoot` command is an integral part of the game's penalty shootout mechanics, allowing the player to attempt to shoot a penalty by choosing one of the available directions. This command pits the player's choice against the AI's shot direction, determining whether the penalty is scored or not.

#### Usage

When it's the AI's turn to save, you will be prompted to select a direction to shoot. Enter the shoot command followed by your chosen direction. For example:

shoot[direction] - Choose a direction to take a shot. Directions are represented by numbers (e.g., 0 for left, 1 for center, and 2 for right --> for beginners).

#### Difficulty Settings

The game's difficulty setting also affects the shoot command's effectiveness. You can adjust the difficulty at any time using the following commands:

- `easy` - Sets the game to an easier difficulty, increasing shot success rates.

- `medium` - Offers a balanced difficulty setting for an average challenge.

- `hard` - Sets the game to the hardest difficulty, testing your skills with the most challenging shooting scenarios.

#### Expected Outcome

If the goal is not scored:

```
Shoot: [-]
Save: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
\         \         \         \
 \         \         \         \
  \         \         \         \
   \         \         \         \
    \         \         \         \
no goal :((((
```

If the goal is scored as a beginner player (direction is 0 in this example):

```
Shoot: [-]
Save: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
| *    *  |         |         |
|    *    |         |         |
|*   *    |    1    |    2    |
|      *  |         |         |
|   *     |         |         |
```

If the goal is scored as a medium player (direction is 4 in this example):

```
Shoot: [-]
Save: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
|    0    |    1    |    2    |
|         |         |         |
|_________|_________|_________|
|         |       * |         |
|    3    | *   *   |    5    |
|         |         |         |

```

If the goal is scored as an expert player (direction is 6 in this example):

```
Shoot: [-]
Save: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
|    0    |    1    |    2    |
|---------|---------|---------|
|    3    |    4    |    5    |
|---------|---------|---------|
|    6    |    7    |  *   *  |
```

If the input is above the maximum input allowed for the current expertise level, the game will play for you (beginner inputs 5 and goal is not scored in this example):

```
Oops! Remember, beginners start with directions 0 to 2. But keep playing to unlock more kicks!
Practice makes perfect. Let's aim for those goals together!
Shoot: [-]
Save: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
\         \         \         \
 \         \         \         \
  \         \         \         \
   \         \         \         \
    \         \         \         \
no goal :((((
```

If the input is above 8, an error will be returned:

```
 SyntaxAnalyser: SHOOT expects the 1st argument to be ^[0-8]$
	 Ui: Bad Token Error, please check your arguments
	 Ui: Command could not be executed 
	 Try again
```

#### Additional Notes
- The `shoot` command is only available during the penalty shootout phase.
- Make sure to observe the AI's pattern to improve your chances of saving the penalty.
- The command is case-sensitive, so `shoot 1` is considered a valid command, but `Shoot 1` and `SHOOT 1` are considered invalid inputs.

### Save Command: `save`

#### Overview

The `save` command is an integral part of the game's penalty shootout mechanics, allowing the player to attempt to save a penalty by choosing one of the available directions. This command pits the player's choice against the AI's shot direction, determining whether the penalty is saved or not.

#### Usage

When it's the AI's turn to shoot, you will be prompted to select a direction to save. Enter the save command followed by your chosen direction. For example:

save[direction] - Choose a direction to attempt a save. Directions are represented by numbers (e.g., 0 for left, 1 for center, and 2 for right --> for beginners).

#### Understanding Saver Skill Levels

Your ability to save goals is significantly impacted by your saver's skill level. As you progress through the game, you'll have the opportunity to upgrade your saver from a Beginner to Medium and finally to an Expert. Each level enhances your saver's effectiveness:

- BeginnerSkillSaver: Starts with basic saving capabilities. Ideal for new players getting accustomed to the game mechanics.

- MediumSkillSaver: Offers improved saving chances with a moderate increase in skill and power. Suitable for players looking for a balanced challenge.

- ExpertSkillSaver: Provides the best saving abilities, significantly increasing your chances of stopping the AI's shots. Designed for experienced players seeking the ultimate challenge.

#### Difficulty Settings

The game's difficulty setting also affects the save command's effectiveness. You can adjust the difficulty at any time using the following commands:

- `easy` - Sets the game to an easier difficulty, increasing save success rates.

- `medium` - Offers a balanced difficulty setting for an average challenge.

- `hard` - Sets the game to the hardest difficulty, testing your skills with the most challenging saving scenarios.

#### Expected Outcome

If the goal is not saved:

```
Save: [-]
Shoot: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
\         \         \         \
 \         \         \         \
  \         \         \         \
   \         \         \         \
    \         \         \         \
no save :((((
```

If the goal is saved as a beginner saver (direction is 0 in this example):

```
Save: [-]
Shoot: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
|         |         |         |
|         |         |         |
|  SAVED  |    1    |    2    |
|         |         |         |
|         |         |         |
```

If the goal is saved as a medium saver (direction is 4 in this example):

```
Save: [-]
Shoot: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
|         |         |         |
|    0    |    1    |    2    |
|_________|_________|_________|
|         |         |         |
|    3    |  SAVED  |    5    |
|         |         |         |

```

If the goal is saved as an expert saver (direction is 6 in this example):

```
Save: [-]
Shoot: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
|    0    |    1    |    2    |
|---------|---------|---------|
|    3    |    4    |    5    |
|---------|---------|---------|
|    6    |    7    |  SAVED  |
```

If the input is above the maximum input allowed for the current expertise level, the game will play for you (beginner inputs 5 and goal is not saved in this example):

```
Oops! Remember, beginners start with directions 0 to 2. But keep playing to unlock more kicks!
Practice makes perfect. Let's aim for those goals together!
Save: [-]
Shoot: [-]
Range: [-]
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
\         \         \         \
 \         \         \         \
  \         \         \         \
   \         \         \         \
    \         \         \         \
no save :((((
```

If the input is above 8, an error will be returned:

```
 SyntaxAnalyser: SAVE expects the 1st argument to be ^[0-8]$
	 Ui: Bad Token Error, please check your arguments
	 Ui: Command could not be executed 
	 Try again
```

#### Additional Notes
- The `save` command is only available during the penalty shootout phase.
- Make sure to observe the AI's pattern to improve your chances of saving the penalty.
- The command is case-sensitive, so `save 1` is considered a valid command, but `Save 1` and `SAVE 1` are considered invalid inputs.

### Set shooter's power: `upgrade LEVEL`
`LEVEL` refers to the power level the player possesses, which affects the quality of the shot. The higher the power level, the more accurate the shot will be.
Levels range from 0 to 2, with 0 indicating beginner, 1 indicating medium, and 2 indicating expert.
Format: `upgrade 2`

### Updrade Command: `uprade`
The upgrade command is a powerful feature designed to boost your player's abilities, offering a strategic advantage in the game. This command allows you to elevate your player's power level, making it easier to overcome challenges and succeed in your endeavors.

#### Usage

To use the upgrade command, follow the syntax below:

upgrade [power level]

[power level]: A numeric value indicating the desired power level to which you want to upgrade. Valid inputs are:

- 0 - Low power level

- 1 - Medium power level

- 2 - High power level

#### Expected Outcome

The user inputs `upgrade 1` in this example:

```
--------Player Info--------
Name: Bruno
Number of match played: 0
Coins: 100
Power: ### ###     Level-Medium
Skill: ###         Level-Beginner
---------------------------
--------Player Info--------
Name: Mars
Number of match played: 0
Power: ### ###     Level-Medium
Skill: ###         Level-Beginner
---------------------------
Your power level has been upgraded to 1
```

#### Additional Notes

- The `upgrade` command is only available during the penalty shootout phase.
- Make sure to observe the AI's pattern to improve your chances of saving the penalty.
- The command is case-sensitive, so `save 1` is considered a valid command, but `Save 1` and `SAVE 1` are considered invalid inputs.

### Difficulty Setting Command: `easy`, `medium` or `hard`

#### Overview

The game offers three difficulty settings to cater to a wide range of player skills and preferences: `easy`, `medium`, and `hard`. These settings adjust the game's challenge level, affecting aspects such as AI behavior and enemy strength, allowing for a personalized gameplay experience.

#### Usage

To set the game's difficulty, enter one of the following commands (at the main menu or during gameplay):

- For a more relaxed gameplay experience:

  `easy`

- For a balanced challenge:

  `medium`

- For the most challenging experience:

  `hard`

#### Expected Outcome

When the user inputs `easy`:

```
Difficulty level set to EASY
```

When the user inputs `medium`:

```
Difficulty level set to MEDIUM
```

When the user inputs `hard`:

```
Difficulty level set to HARD
```

#### Additional Notes

- The `upgrade` command is only available during the penalty shootout phase.
- Make sure to observe the AI's pattern to improve your chances of saving the penalty.
- The command is case-sensitive, so `save 1` is considered a valid command, but `Save 1` and `SAVE 1` are considered invalid inputs.

### Restarts a match after a match: `yes`
When one match ends, you will be asked whether to have a new match or not. Type `yes` for a new match.

Format: `yes`

#### Does not restart a match after a match: `no`
When one match ends, you will be asked whether to have a new match or not. Type `no` for not having a new match, and
exits the game directly.

Format: `no`

### Post Game Decision Command: `yes` or `no`

#### Overview

At the conclusion of a match, players are given the choice to either start a new game or exit. This decision is facilitated through the use of simple `yes` or `no` commands, ensuring a smooth transition based on the player's preference.

#### Usage 

Once a game ends, you will be prompted with the question "Want a new match?". Respond with one of the following commands based on your decision:

- To start a new game:

  `yes`

- To exit:

  `no`

#### Expected Outcome

If the user inputs `yes` (user just finished their first game in this example):

```
Match 2
Round 1
_______________________________
|    0    |    1    |    2    |
|         |         |         |
|_________|_________|_________|
|         |         |         |
|    3    |    4    |    5    |
|         |         |         |

Select direction to shoot : [0-5]
```

If the user inputs `no`:

```
------------------------------------------------------------
                See you next time on court!
------------------------------------------------------------
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

* Restarts a match after a match `yes`
* Does not restart a match after a match `no`
