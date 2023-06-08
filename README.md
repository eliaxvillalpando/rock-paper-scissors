# rock-paper-scissors
This Java program is an advanced implementation of the classic game Rock, Paper, Scissors. The game is played between the user and the computer, with additional functionalities like a scoring system and custom game options.

Upon running the program:

1. It first initializes a scanner for user input and a random number generator.

2. The program sets the default choices for the game as "rock", "paper", and "scissors". 

3. It also sets up a `HashMap` for score management. The program reads a file "rating.txt" to fetch any existing scores. The score of each player is stored against their name in the file.

4. The program then prompts the user to enter their name, and the user is greeted with a message. If the user's name exists in the score file, the score is fetched; otherwise, the user's score is initialized to zero.

5. The user is asked to enter game options. If the user provides options, the game choices are updated to these options. For instance, the user can add "lizard" and "spock" to play Rock, Paper, Scissors, Lizard, Spock.

6. The game begins with a loop that continues until the user chooses to exit. The user's choice is captured in each iteration. If the user enters "!exit", the game ends. If the user enters "!rating", their current score is displayed. 

7. The computer's choice is determined randomly from the game options. Then, a comparison is made between the user's choice and the computer's choice to determine the winner, loser, or a draw.

8. If the game ends in a draw, the user is awarded 50 points. If the user wins, the user is awarded 100 points and a winning message is displayed.

9. The user's choice and the score update continue until the user chooses to exit the game. 

The use of lists, maps, and random number generators make this a flexible and fun version of the classic game. Remember to prepare a "rating.txt" file and update it as needed to maintain user scores.
