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

For example, there are two teams team A and team B playing a penalty shoot-out. Both teams have taken three kicks. Team 
A has scored 3 goals, while team B has scored 0 goal. Now both teams are left with two kicks. As the goal difference 
between team A and team B (3) is larger than the number of kicks left for team B (2). The game ends immediately, with 
team A being the winner.


#### Sudden Death

If after five rounds of kicks, the teams have scored an equal number of goals (or neither team has scored any goals), 
additional rounds of one kick each are used until one team scores and the other misses.

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
* `upgrade 2`: Upgrade your player to the medium skill level.
* `yes`: Restarts a match after a match ends.
* `no`: Does not restart a match after a match ends, and exits the game.
* `bye`: Exits the game.  

6. Refer to the Features below for details of each command.

## Features

### Restarts a match after a match: `yes`
When one match ends, you will be asked whether to have a new match or not. Type `yes` for a new match.

Format: `yes`

### Does not restart a match after a match: `no`
When one match ends, you will be asked whether to have a new match or not. Type `no` for not having a new match, and 
exits the game directly.

Format: `no`

### Save Command: `save`

#### Overview

The `save` command is an integral part of the game's penalty shootout mechanics, allowing the player to attempt to save a penalty by choosing one of the available directions. This command pits the player's choice against the AI's shot direction, determining whether the penalty is saved or not.

#### Usage

To use the `save` command, enter the command followed by a space and then the direction number where you predict the AI will shoot. The direction options are:

- `0`: Left
- `1`: Center
- `2`: Right

#### Example: save 1

This command will execute the player's save attempt towards the center.

Command Structure
`save <direction>`: Executes the save attempt where `<direction>` is the direction you choose to save.

#### Expected Outcome

Upon executing the save command, one of two outcomes will occur:

- If your chosen direction matches the AI's shot direction, you successfully save the penalty, and the game will display a message: 

```
You saved the penalty!
```

- If your chosen direction does not match the AI's shot direction, the penalty is not saved, and the game will display a message: 

```
You failed to save the penalty!
```

The game will then update the match statistics accordingly.

#### Input Validation
If an invalid direction is entered (anything other than `0`, `1`, or `2`), the game will prompt you to enter a valid direction by displaying the message: 

```
Invalid direction! Please enter 0, 1, or 2."
```

#### Example of Command Flow

```
Select direction to save : [0-2] 
save 1
You saved the penalty!
```

Or, in case of an invalid input:

```
Select direction to save : [0-2] 
save 4
SyntaxAnalyser: SAVE expects the 1st argument to be ^[0-2]$
	 Ui: Bad Token Error, please check your arguments
	 Ui: Command could not be executed 
	 Try again
Select direction to save : [0-2]
```

#### Additional Notes
- The `save` command is only available during the penalty shootout phase.
- Make sure to observe the AI's pattern to improve your chances of saving the penalty.
- The command is case-sensitive, so `save 1` is considered a valid command, but `Save 1` and `SAVE 1` are considered invalid inputs.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

* Restarts a match after a match `yes`
* Does not restart a match after a match `no`
