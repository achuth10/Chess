
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        ChessBoard [][]chessBoard = new  ChessBoard[8][8];
        init(chessBoard);
        System.out.println("Welcome to the chess game ");
        display(chessBoard);
        System.out.println();
        System.out.println("To play enter the chess piece followed by the location : Eg P,2a,4a (Piece,current pos,new pos)");
        System.out.println("Give q as the input to exit out of the game at any point ");
        boolean ChessCondition = true;

        boolean player =false;
        while (ChessCondition) {
            int play;
            if (!player)
                play=1;
            else
                play=2;
            String move;
            System.out.println("Player " + play + "- enter your move");
            move = in.next();
            if(move.equals("q"))
                System.exit(0);
            String[] moves;
            moves = move.split(",");
            if(!makemove(moves,chessBoard)) {
                display(chessBoard);
                System.out.println();
                System.out.println("Invalid move !! ");
                continue;
            }
            player =!player;
            ChessCondition = true;
        }



    }
    private static boolean makemove(String[] moves, ChessBoard[][] chessBoard) {
        clearScreen();
        String piece = moves[0];
        piece = piece.toLowerCase();
        String currPos = moves[1];
        String newPos = moves[2];

        Integer currPosRow = Integer.parseInt(String.valueOf(currPos.charAt(0))) - 1;

        Integer newPosRow = Integer.parseInt(String.valueOf(newPos.charAt(0))) - 1;

        Integer currPosCol = col(String.valueOf(currPos.charAt(1)));
        Integer newPosCol = col(String.valueOf(newPos.charAt(1)));

        if((currPosRow>=0 && currPosRow<=7)&&(newPosRow>=0 && newPosRow<=7)) { // Invalid row


            if (!(currPosCol == -1 || newPosCol == -1)) // invalid column
            {

                if (!chessBoard[currPosRow][currPosCol].getP().equals(" ")) {     // Np piece at current location
                    switch (piece) {
                        case "p":
                            if (newPosRow == currPosRow + 1 && newPosCol == currPosCol + 1) {
                                System.out.println("Entered here");
                                if (!chessBoard[currPosCol + 1][currPosCol + 1].getP().equals("")) {
                                    chessBoard[newPosRow][newPosCol].setP(chessBoard[currPosRow][currPosCol].getP());        // Pawn kill
                                    chessBoard[currPosRow][currPosCol].setP(" ");
                                } else {
                                    return false;
                                }
                                break;
                            } else if (newPosRow - currPosRow == 1) {
                                if (chessBoard[newPosRow][currPosCol].getP().equals("")) {
                                    chessBoard[newPosRow][newPosCol].setP(chessBoard[currPosRow][currPosCol].getP());
                                    chessBoard[currPosRow][currPosCol].setP(" ");
                                } else {
                                    return false;
                                }
                            } else if (Math.abs(newPosRow - currPosRow) == 2) {
                                if (chessBoard[newPosRow][currPosCol].getP().equals(" ")) {
                                    chessBoard[newPosRow][newPosCol].setP(chessBoard[currPosRow][currPosCol].getP());
                                    chessBoard[currPosRow][currPosCol].setP(" ");
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }

                    }
                    display(chessBoard);

                    return true;
                } else
                    return false;
            } else
                return false;
        }
        else
            return false;
    }

    private static Integer col(String value) {
        value= value.toLowerCase();
    switch (value)
    {
        case "a":
            return 0;
        case "b":
            return 1;
        case "c":
            return 2;
        case "d":
            return 3;
        case "e":
            return 4;
        case "f":
            return 5;
        case "g":
            return 6;
        case "h":
            return 7;
        default:return -1;
    }
    }


    private static void init(ChessBoard[][] chessBoard) {
        for (int i = 0; i <8; i++) {
            for(int j = 0 ;j<8;j++)
            {
                if((i+j)%2==0)
                chessBoard[i][j]=new ChessBoard(" ",1,0);
                else
                    chessBoard[i][j]=new ChessBoard(" ",0,1);
            }
        }
        chessBoard[0][0].setP("C");
        chessBoard[0][1].setP("H");
        chessBoard[0][2].setP("B");
        chessBoard[0][3].setP("K");
        chessBoard[0][4].setP("Q");
        chessBoard[0][5].setP("B");
        chessBoard[0][6].setP("H");
        chessBoard[0][7].setP("C");

        chessBoard[1][0].setP("P");
        chessBoard[1][1].setP("P");
        chessBoard[1][2].setP("P");
        chessBoard[1][3].setP("P");
        chessBoard[1][4].setP("P");
        chessBoard[1][5].setP("P");
        chessBoard[1][6].setP("P");
        chessBoard[1][7].setP("P");


        chessBoard[7][0].setP("C");
        chessBoard[7][1].setP("H");
        chessBoard[7][2].setP("B");
        chessBoard[7][3].setP("K");
        chessBoard[7][4].setP("Q");
        chessBoard[7][5].setP("B");
        chessBoard[7][6].setP("H");
        chessBoard[7][7].setP("C");

        chessBoard[6][0].setP("P");
        chessBoard[6][1].setP("P");
        chessBoard[6][2].setP("P");
        chessBoard[6][3].setP("P");
        chessBoard[6][4].setP("P");
        chessBoard[6][5].setP("P");
        chessBoard[6][6].setP("P");
        chessBoard[6][7].setP("P");
    }

    private static void display(ChessBoard[][] chessBoard) {
        System.out.println();
System.out.print("   ");
        for(char c = 'a'; c <= 'h'; ++c)
        {
            System.out.print(c+" ");
        }

        for (int i = 0; i <8; i++) {
            System.out.println();
            System.out.print(i+1+"| ");
            for(int j = 0 ;j<8;j++)
            {
               if(chessBoard[i][j].getP().equals(""))
                   System.out.print("  ");
               else
                System.out.print(chessBoard[i][j].getP()+" ");
            }

            System.out.print("|" + (i+1));

        }
        System.out.println();
        System.out.print("   ");

        for(char c = 'a'; c <= 'h'; ++c)
        {
            System.out.print(c+" ");
        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
