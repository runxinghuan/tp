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
- **Customize Your Power (0-2)**: You can set your player's power freely during the middle of the match, allowing you to strategize your gameplay based on your preferred playing style.

By incorporating these attributes into our game, we aim to provide an immersive experience that closely aligns with the real challenges and achievements of football. As you progress, you’ll find that the journey from a beginner to an expert is not just about winning matches but about honing your skills and strategy to truly master the art of the game.

## Quick Start

1. Ensure that you have Java 11 or above installed in your laptop.
2. Download the latest version of `NUSFC 24` from [here](https://github.com/AY2324S2-CS2113-F15-3/tp/releases/tag/v2.1).
3. Copy the file to the folder where you want to play the game.
4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar tp.jar` command to run
the application.
5. Type the command in the terminal and press Enter to execute it. e.g. typing `shoot 0` and pressing Enter will shoot a
penalty at direction 0 shown in the goal.\
Some example commands you can try:
   * `shoot 0`: Shoot a penalty at direction 0 shown in the goal.
   * `save 0`: Make a save at direction 0 shown in the goal.
   * `setpower 2`: Set your player to the expert power level.
   * `yes`: Restarts a match after a match ends.
   * `no`: Does not restart a match after a match ends, and exits the game.
   * `bye`: Exits the game.  

6. Refer to the Commands section of this User Guide for details on each command.

## Commands

### Command Summary

* Exit the program `bye`
* Help command `help`
* Guess head in the coin toss `head`
* Guess tail in the coin toss `tail`
* Shoot a penalty `shoot int`
* Save a penalty `save int`
* Set shooter's power `setpower int`
* Set difficulty `easy`, `medium` or `hard`
* Customize player's settings `customization`
* [coming soon] Customize saver's settings `customization`
* Restart a match after a match `yes`
* Do not restart a match after a match `no`

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
    setpower[power level] - Set the power level of your player.
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

Before each match, there is a coin toss. If the player guesses the result of the coin toss correctly. He can shoot first.
If not, AI shoots first.

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

shoot [direction] - Choose a direction to take a shot. Directions are represented by numbers (e.g., 0 for left, 1 for center, and 2 for right --> for beginners).

#### Difficulty Settings

The game's difficulty setting also affects the shoot command's effectiveness. You can adjust the difficulty at any time using the following commands:

- `easy` - Sets the game to an easier difficulty, increasing shot success rates.

- `medium` - Offers a balanced difficulty setting for an average challenge.

- `hard` - Sets the game to the hardest difficulty, testing your skills with the most challenging shooting scenarios.

#### Expected Outcome

If the goal is not scored:

```
----AFTER SHOT ANALYSIS----
Your shoot aims at: [-]
---------------------------
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
----AFTER SHOT ANALYSIS----
Your shoot aims at: [-]
---------------------------
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
----AFTER SHOT ANALYSIS----
Your shoot aims at: [-]
---------------------------
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

If the goal is scored as an expert player (direction is 6 in this example)

```
----AFTER SHOT ANALYSIS----
Your shoot aims at: [-]
---------------------------
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
|    0    |    1    |    2    |
|---------|---------|---------|
|    3    |    4    |    5    |
|---------|---------|---------|
|    6    |    7    |  *   *  |
```

If the input is above the maximum input allowed for the current expertise level but less than 9, your shot will be considered missed the target (beginner inputs 5 and goal is not scored in this example):

```
----------WARNING----------
Oops! Remember, beginners can only start with directions 0, 1, and 2. 
You failed to shot on target.
Practice makes perfect. Keep playing to unlock more kicks!
---------------------------
0 coins added to your balance. Current balance: [-]
Performance Coins earned: 0
_______________________________
\         \         \         \
 \         \         \         \
  \         \         \         \
   \         \         \         \
    \         \         \         \
no goal :((((

```

If the input direction is above 8, your input is considered invalid, and an error will be returned. You need to input again:

```
     SyntaxAnalyser: SHOOT expects the 1st argument to be integer between 0 to 8
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

save [direction] - Choose a direction to attempt a save. Directions are represented by numbers (e.g., 0 for left, 1 for center, and 2 for right --> for beginners).

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
----AFTER SAVE ANALYSIS----
Your save aims at: [-]
Shooter's cover range: [-]
---------------------------
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
----AFTER SAVE ANALYSIS----
Your save aims at: [-]
Shooter's cover range: [-]
---------------------------
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
----AFTER SAVE ANALYSIS----
Your save aims at: [-]
Shooter's cover range: [-]
---------------------------
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
----AFTER SAVE ANALYSIS----
Your save aims at: [-]
Shooter's cover range: [-]
---------------------------
10 coins added to your balance. Current balance: [-]
Performance Coins earned: 10
_______________________________
|    0    |    1    |    2    |
|---------|---------|---------|
|    3    |    4    |    5    |
|---------|---------|---------|
|    6    |    7    |  SAVED  |
```

If the input is above the maximum input allowed for the current expertise level, the game will play for you (beginner inputs 5 in this example):

```
----------WARNING----------
Oops! Remember, beginner saver can only save with direction between 0 to 2.
You failed to save the shot.
Practice makes perfect. Keep playing to unlock more saves!"
---------------------------
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

### Updrade Power Command: `setpower`
The setpower command is a powerful feature designed to boost your player's abilities, offering a strategic advantage in the game. This command allows you to elevate your player's power level, making it easier to overcome challenges and succeed in your endeavors.

#### Usage

To use the `setpower` command, follow the syntax below:

setpower [power level]

[power level]: A numeric value indicating the desired power level to which you want to set to your player. Valid inputs are:

- 0 - Low power level

- 1 - Medium power level

- 2 - High power level

#### Expected Outcome

The user inputs `setpower 1` in this example:

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
Your power level has been set to 1
```

#### Additional Notes

- The `setpower` command is only available during the penalty shootout phase.
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

### Customization Command: `customization`

#### Overview

The customization feature allows players to personalize their in-game character to better reflect their playing style and preferences. This feature is accessible at various points in the game, such as at start up, during a game, or before starting a new match.

#### Usage

To use the `customization` command, follow the syntax below:

customization 

A Customization Menu will be displayed. Enter the number of the customization you would like to purchase.

#### Expected Outcome

The user inputs `customization`:

```
Customization Menu:
1. Purchase Customizations
2. View Coin Balance
3. Exit
Enter your choice:
```

If the user inputs `1`:

```
Available Customization Items:
1. Power Boost - Cost: 150 coins
2. Skill Boost - Cost: 200 coins
3. Fancy Uniform - Cost: 100 coins
Enter the number of the customization item you want to purchase: 2
```

- If the user then inputs 1 (they have enough coins to make the purchase):

```
150 coins deducted from your balance. Current balance: [-]
You have purchased the Power Boost customization!
Power increased by 1! Current Power: [-]
```

- If the user then inputs 2 (they do not have enough coins to make the purchase):

```
Insufficient coins to purchase the Skill Boost customization.
```

- If the user then inputs 3 [coming soon]:

```
Invalid choice. Purchase canceled.
```

If the user inputs 2:

```
Your current coin balance is: [-]
```

If the user inputs 3:

```
Exiting Customization Menu.
```

If the user inputs an integer above 3:

```
Invalid choice. Please try again.
```

If the user inputs a non-integer value:

```
Invalid input. Please enter a number.
```

#### Additional Notes

- The `customization` command is available at any point during the game.
- The `customization` command is currently only available for your player. Customizations for the saver will be implemented in later iterations.
- The command is case-sensitive, so `customization` is considered a valid command, but `Customization` and `CUSTOMIZATIOM` are considered invalid inputs.


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

