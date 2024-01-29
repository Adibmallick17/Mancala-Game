Project Title
Mancala Game

Description
The MancalaGame class respresents the game logic. The Board class represents the set of 12 Pits and two Stores. The Store class holds the set of captured pieces for a Player.

Getting Started

Dependencies

Describe any prerequisites, libraries, OS version, etc., needed before installing and running your program.


Executing program

Gradle Build
Gradle Echo
java -jar build/libs/mancala.jar 

Include the expected output

Welcome to Mancala!
Player1 name:A
Player2 name:B
Current board: 
Player Two's Store
   4 4 4 4 4 4 
[0] --- --- --- --- --- --- [0]
   4 4 4 4 4 4 
Player One's Store

It's A's turn.
Enter the pit number to move from (1-6): 1
A moved 1 stones.

Current board: 
Player Two's Store
   4 4 4 4 4 4 
[0] --- --- --- --- --- --- [1]
   4 0 5 5 5 5 
Player One's Store

It's B's turn.
Enter the pit number to move from (1-6): 8
B moved 1 stones.

Current board: 
Player Two's Store
   5 5 5 0 4 4 
[1] --- --- --- --- --- --- [1]
   4 0 5 5 5 5 
Player One's Store


Limitations
What isn't done? What things cause errors?

Author Information
Mohammad Adib Mallick
Student ID: 1250929
Email: mallick@uoguelph.ca

Development History

Board Class:
AI-generated: The Board class includes methods for capturing stones, distributing stones, initializing the board, checking if a side is empty, moving stones, and other utility methods.
My Version: My Board class includes similar functionalities, such as capturing stones, distributing stones, initializing and resetting the board, setting up pits and stores, and methods to get the number of stones in pits and stores. The implementation of methods differs in terms of logic and handling of game rules.

MancalaGame Class:
AI-generated: The MancalaGame class manages the game flow, handling player turns, determining the winner, checking if the game is over, and switching players.
My Version: My MancalaGame class serves a similar purpose, managing player turns, determining the winner, checking game over conditions, and handling the movement of stones between pits and stores. However, the implementation of rules and player switching might vary.

Player, Store, and Pit Classes:
AI-generated: These classes seem to manage player details, store stones, and handle operations related to pits (adding, removing stones).
My Version: My implementation also includes these classes to manage player details, store stones, and handle pit operations, but the logic might differ in how stones are managed or how player-related functionalities are implemented.

TextUI Class:
AI-generated: The AI-generated TextUI class initiates and manages the game through text-based interactions with players, allowing moves and displaying the board.
My Version: My TextUI class performs a similar function, interacting with players to start the game, take inputs for moves, display the board, and declare the winner.

Logic and Game Rules:
The AI-generated version seems to implement the game rules, stone movement, capturing, and distribution differently than my version.
The AI-generated code is focused on managing game mechanics and board interactions, while my version seems to have a distinct logic flow and handling of player actions.

Code Style and Structure:
The AI-generated code and my version might vary in code structure, method implementations, error handling, and adherence to specific programming paradigms or design patterns.

Overall, both versions aim to implement the Mancala game, but they might differ in how they handle game mechanics, implement rules, manage player actions, and structure the code. Understanding the specific logic and rules implemented in each version would provide more insights into the differences.



0.2

Various bug fixes and optimizations
See commit change or See release history



0.1

Initial Release




Acknowledgments
Inspiration, code snippets, etc.

awesome-readme
[simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)
