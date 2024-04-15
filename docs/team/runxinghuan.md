# Run Xinghuan - Project Portfolio Page

## Overview

NUSFC 24 is an association football-themed game app. It is played via a Command Line Interface (CLI). The game simulates
penalty shoot-out for football only. It is written in Java, and has about 3 kLoC.

### Summary of Contributions
- Code contributed: [Link of my code](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=runxinghuan&breakdown=true)


- Enhancements implemented:
  1. New Feature: Added the MatchStat class
     - What it does: Records stats of matches (round count, match count, player score, Ai score, etc.) Then decides 
     whether a match ends based on actual penalty shoot-out rules (Best-of-five Kicks and Sudden Death). When a match 
     ends, it asks the user whether to restart a new match.
     - Justification: This feature improves the product significantly. As we are trying to simulate penalty shoot-out,
     simulating its rule should be our basic feature. If we do not have this feature. The game is much less realistic.
     - Highlights: This feature controls the overall flow of a match in the game. Hence, I need to integrate other 
     commands (shoot and save) for this feature. I also need to ensure that when it's player's turn to shoot, he cannot 
     enter "save" command, vice versa.
  2. New Feature: Added coin toss feature
     - What it does: Before each match, asks the user to guess the outcome of a coin toss. If the user guesses it 
     correctly, he can shoot first. Else, Ai shoots first.
     - Justification: This feature is another attempt to make the game more realistic.


- Contributions to team-based tasks: 
   - Created all the necessary labels and milestones in the issue tracker
   - Managed releases `v1.0` and `v2.0` on GitHub (converted v2.0 UG to pdf)
   - Updated the "Introduction" and "Quick Start" parts of UG [#88](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/88)
   - Updated the "Command Summary" part of UG [#189](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/189)
   - Updated the "Instructions for manual testing" part of DG [#188](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/188)
   - Created `Style.puml` file which corrects the style of UML diagrams added
  [#164](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/164)
   - Edited 'gradle.yml' to remove text ui test [#61](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/61)
   - Communicated with other team members about the deadline and workflow each week
   - Submitted the final deliverables


- Review/mentoring contributions: 
    - PRs reviewed (with non-trivial review comments): [#65](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/65),
[#82](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/82),
[#92](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/92)


- Contributions to the UG: 
    - Added penalty shoot-out rules (Best-of-five Kicks and Sudden Death) 
  [#88](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/88)
    - Added documentation for the restarting feature with commands `yes` and `no`
  [#88](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/88)


- Contributions to the DG: 
    - Added implementation details of the `MatchStat` class [#91](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/91)
    - Diagrams added: ![MatchStatClassDiagram.png](..%2Fdiagrams%2FMatchStatClassDiagram.png)
  ![MatchStatSequential.png](..%2Fdiagrams%2FMatchStatSequential.png)
    - Added implementation details of the `CoinToss` component [#187](https://github.com/AY2324S2-CS2113-F15-3/tp/pull/187)
    - Diagrams added: ![CoinTossClassDiagram.png](..%2Fdiagrams%2FCoinTossClassDiagram.png)
  ![CoinTossSequential.png](..%2Fdiagrams%2FCoinTossSequential.png)
