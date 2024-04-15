# Ymir Meddeb - Project Portfolio Page

# Project: NUSFC24

## Overview

NUSFC 24 is an association football-themed game app. It is played via a Command Line Interface (CLI). The game simulates penalty shoot-out for football only. It is written in Java, and has about 3 kLoC.

## Summary of Contributions

### Code Contributed

[Link to my code](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=ymirmeddeb&tabRepo=AY2324S2-CS2113-F15-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

#### Enhancements Implemented

New feature: Save

- What it does:Enhances the game's interactivity by allowing players to defend against AI attacks using a save command. Players select a direction to attempt a save, influenced by their skill level and the game's difficulty setting, mirroring the unpredictability and tactics of real-life penalty shootouts.

- Justification: Critical for a realistic and immersive gameplay experience. This feature deepens the strategic aspect of the game, challenging players to anticipate and counter AI moves, thus enhancing the simulation of actual penalty shootouts.

- Highlights: Integrates closely with the game's AI to offer a dynamic and varied challenge, ensuring each save attempt feels authentic and impactful. The feature's implementation required careful consideration of game flow, player feedback, and maintaining balance between offense and defense to keep the game engaging and fair.

New feature: Help

- What it does: Provides players with instant access to a comprehensive list of available commands and their functions at any point in the game. Tailored to the game's context—whether at the start, during a match, or post-match—the help command ensures players are never lost or unsure of their next move.

- Justification: Essential for enhancing user accessibility and engagement. By offering guidance on command usage, the feature empowers players to fully explore and interact with the game, improving their overall experience and satisfaction.

- Highlights: The help command dynamically adapts to the game's state, offering relevant instructions and support. Its implementation involved integrating with the game's various phases and actions, ensuring a seamless and intuitive user experience that supports players as they navigate through the game's challenges.

#### Project management:

- Removed all logging to make the output to the user more readable

- Helped maintain the issue tracker by assigning issues to myself and adding them to target milestones

- Managed the whole `Commands` segment of the User Guide

- Helped to fix a major bug where the player is able to shoot even when not in a game

- Found and fixed a bug where if the user inputs a non-integer value in the customization menu, an error was returned and the program was exited

#### Community

- Reported a serious bug where the player is able to shoot even when not in a game

- Helped other members of the team when they needed help or clarification

- Reported bugs and raised issues for the team assigned to me in the PE Dry Run