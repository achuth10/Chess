
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        String [][]chessBoard = new  String[8][8];
        init(chessBoard);
        System.out.println("Welcome to two player chess");
        display(chessBoard);
        System.out.println();
        System.out.println("To play ,enter the chess piece followed by the location , Eg P,2a,4a (Piece,current pos,new pos)");
        boolean ChessCondition = true;

        int player =1;
        while (ChessCondition) {
            String move;
            System.out.println("Player " + player + "- enter your move");
            move = in.next();
            if(move.equals("q"))
                System.exit(0);
            String[] moves;
            moves = move.split(",");
            if(makemove(moves,chessBoard));
                display(chessBoard);

            ChessCondition = true;
        }



    }
    private static boolean makemove(String[] moves, String[][] chessBoard) {
        clearScreen();
        for (String move : moves) {
            System.out.println(move);
        }
    String piece =moves[0];
    String  currPos = moves[1];
    String  newPos = moves[2];

    Integer currPosRow = Integer.parseInt(String.valueOf(currPos.charAt(0)))-1;
    Integer newPosRow = Integer.parseInt(String.valueOf(newPos.charAt(0)))-1;

    Integer currPosCol = col(String.valueOf(currPos.charAt(1)));
    Integer newPosCol = col(String.valueOf(newPos.charAt(1)));

//
//        System.out.println("P is " + piece);
//        System.out.println(newPosRow);

    switch (piece)
    {
        case "P":
            chessBoard[newPosRow][newPosCol]=chessBoard[currPosRow][currPosCol];
            chessBoard[currPosRow][currPosCol]=" ";
            break;
    }
    display(chessBoard);
    return true;
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


    private static void init(String[][] chessBoard) {
        for (int i = 0; i <8; i++) {
            for(int j = 0 ;j<8;j++)
            {
                chessBoard[i][j]="";
            }
        }
        chessBoard[0][0]="C";
        chessBoard[0][1]="H";
        chessBoard[0][2]="B";
        chessBoard[0][3]="K";
        chessBoard[0][4]="Q";
        chessBoard[0][5]="B";
        chessBoard[0][6]="H";
        chessBoard[0][7]="C";

        chessBoard[1][0]="P";
        chessBoard[1][1]="P";
        chessBoard[1][2]="P";
        chessBoard[1][3]="P";
        chessBoard[1][4]="P";
        chessBoard[1][5]="P";
        chessBoard[1][6]="P";
        chessBoard[1][7]="P";


        chessBoard[7][0]="C";
        chessBoard[7][1]="H";
        chessBoard[7][2]="B";
        chessBoard[7][3]="K";
        chessBoard[7][4]="Q";
        chessBoard[7][5]="B";
        chessBoard[7][6]="H";
        chessBoard[7][7]="C";

        chessBoard[6][0]="P";
        chessBoard[6][1]="P";
        chessBoard[6][2]="P";
        chessBoard[6][3]="P";
        chessBoard[6][4]="P";
        chessBoard[6][5]="P";
        chessBoard[6][6]="P";
        chessBoard[6][7]="P";
    }

    private static void display(String[][] chessBoard) {
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
               if(chessBoard[i][j].equals(""))
                   System.out.print("  ");
               else
                System.out.print(chessBoard[i][j]+" ");
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
