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

### Player Attributes Overview

Welcome to our real penalty simulator game, designed to immerse you in the authentic thrills of competition and the journey of skill enhancement in sports. As you navigate through the game, you will experience a realistic learning curve, just like in actual sports training.

In our game, each player is defined by two critical attributes: **Skill** and **Power**. These attributes are reflective of a real-life player's capabilities and play a pivotal role in determining the quality of your shots.

#### Skill: Your Path to Mastery

Skill determines the range of directions available to you for shooting. As you progress in the game, your ability to choose from a wider array of shooting directions improves, mirroring your player's growing expertise.

- **Beginner**: Initially, your shooting options are limited to left, middle, and right, corresponding to directions 0, 1, and 2, respectively. This limited choice represents the initial phase of your sports journey.
- **Medium**: As you dedicate time and effort to the game, your skills will sharpen. You'll unlock the ability to choose from an expanded range of directions, from 0 to 5, offering more nuanced control over your shots.
- **Expert**: Reaching higher skill levels means even greater control. You'll be able to select from an impressive array of directions, 0 through 8, allowing for precision and creativity in your shots. An illustrative graph below showcases this progression:

  ![Skill Level Progression Graph](photoUg%2FBeforeShot.png)

#### Power: The Force Behind Your Shots

In addition to skill, power is a crucial factor in the game. It influences the precision and overall quality of your shots, adding a layer of strategy to your gameplay.

- **Building Power**: The power attribute reflects the force behind your shots. A higher power level means increased shot accuracy, allowing you to challenge opponents with confidence.
- **Customization Freedom**: We believe in giving players control over their game experience. Therefore, you can freely set your player's power level anywhere from 0 to 2, tailoring your approach to matches according to your strategic preferences.

Embrace the challenge of growing your player's attributes, and enjoy the journey towards becoming a master of the sport. Remember, every match is a step forward in your virtual sports career. Good luck!

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
* `upgrade 2`: Upgrade your player to the medium power level.
* `yes`: Restarts a match after a match ends.
* `no`: Does not restart a match after a match ends, and exits the game.
* `bye`: Exits the game.  

6. Refer to the Features below for details of each command.

## Features
### Choose shoot direction: `shoot DIRECTION`
`DIRECTION` refers to the direction the player wants the shot to follow as displayed on the graph.
Format: `shoot 2`

### Set shooter's power: `upgrade LEVEL`
`LEVEL` refers to the power level the player possesses, which affects the quality of the shot. The higher the power level, the more accurate the shot will be.
Levels range from 0 to 2, with 0 indicating beginner, 1 indicating medium, and 2 indicating expert.
Format: `upgrade 2`

### Restarts a match after a match: `yes`
When one match ends, you will be asked whether to have a new match or not. Type `yes` for a new match.

Format: `yes`

### Does not restart a match after a match: `no`
When one match ends, you will be asked whether to have a new match or not. Type `no` for not having a new match, and 
exits the game directly.

Format: `no`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

* Restarts a match after a match `yes`
* Does not restart a match after a match `no`
