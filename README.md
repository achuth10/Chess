# Chess



A simple chess game using OOP concepts.


Extra Classes contained :

1) Piece - A class depicting a  piece on the board (Knight)
2) Chessboard - A class depicting the chessboard


Unit tests : 

The unit tests are carried out in the makeMove function and the following are checked - 

1) If the given input is syntactically correct.

2) If a move is valid or not depending on the piece.

3) If the entered location is within the bounds of the chessboard.

4) If the piece to be moved is currently owned by the player who is playing.


Check condition is carried out by the checkCheck function that checks if either of the kings are currently in check


The large chunk of commented code is the code responsible for determining if either of the kings is check mated and to stop the game automatically(It currently stops when either player loses all his pieces).


I was not able to get the condition to work consistently in time for the deadline today,hence I commented out the code.


You can see the running code over here at - https://repl.it/repls/DetailedValuableBackups

Or by copying the 3 java files and compiling Main.java in the console.

I have included screenshots of the game over here - https://drive.google.com/open?id=1QOYdz3VHTiZ5OqOm3Rd0i_PXoCfn2wDH


