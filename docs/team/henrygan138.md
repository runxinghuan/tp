# Gan Jiahao - Project Portfolio Page

## Project: NUSFC24
### Overview
NUSFC 24 is an association football-themed game app. It is played via a Command Line Interface (CLI). The game simulates penalty shoot-out for football only. It is written in Java, and has about 3 kLoC.

### Summary of Contributions
### Code Contributions
[Link to my code](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=HenryGan138&tabRepo=AY2324S2-CS2113-F15-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Enhancements Implemented

#### New Feature: Player Class Design and Implementation
- **What it does**:
    - Designs structure and implements functions through the parent `Player` class, and its inheritance for `BeginnerSkillPlayer`, `MediumSkillPlayer`, and `ExpertSkillPlayer`.
    - Develops the upgrade mechanism so that create differentiated user experiences.
- **Highlights**:
  - Utilizes Object-Oriented Programming and ArrayLists to manage dynamic data, offers a fundamental skeleton structure for NUSFC's other implementations
  - This feature improves the project development by providing a scalable and polymorphic approach to player management, and offering an interface for team's adding functions

#### New Feature: Shoot
- **What it does**:
  - Allows users to control the player and execute shooting actions via command line inputs.
  - Design player's attributes power and skills that impact the shooting mechanics through diverse shooting direction and different shooting quality
  - Integrates with the `AIGoalKeeper` and `Difficulty` functions to simulate varied gameplay challenges.
- **Highlights**:
  - This feature is essential for creating a realistic gameplay experience. It allows the game to simulate a true penalty shootout scenario, where user choices and player attributes affect each shot's outcome.
  - Provides users the ability to customize their players and tailor the gaming experience, using simplest commands to set game dynamics and difficulty.

#### Enhancement: UI Improvements for Goal Screen
- **What it does**:
    - Improve the goal screen's layout and design for better visual appeal and clarity.
- **Highlights**: Enhances player engagement by making game objectives clearer and the interface more intuitive. Addressing this required reimagining the UI to balance informative content with ease of understanding.

### Documentation
#### User Guide
- Detailed how users can control the shooter, demonstrating the role of player attributes in gameplay and how these parameters will affect shooting quality.
- Explained the player upgrade process, aiding users in gameplay planning.
- Refine the content in `shoot` command.

#### Developer Guide
- Added explanations on the design logic and implementation details for `Player` and `PlayerList`, and demonstrate how these two classes interact to support game functions. 
- Included a Class Diagram to illustrate the relationships between the `Player` and `PlayerList` classes.
- Provided a Sequence Diagram for the skill upgrade mechanism to clarify the process flow.
- Helped draft the Product Scope and compiled User Stories

### Project Management
- Manage the version 2.0 release on GitHub, including integrate members' code into a united program and deliver JAR file
- Actively participated in coding for all versions
- Compiled User Stories to guide the development process and clarify the target functionalities.
- Helped maintain the issue tracker by assigning issues
- Reported and fixed bugs and related issues for the team in the PE Dry Run