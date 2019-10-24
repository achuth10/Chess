
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
            System.out.println();
            System.out.println("Player " + play + "- enter your move");
            move = in.next();
            if(move.equals("q"))
                System.exit(0);
            String[] moves;
            moves = move.split(",");
            if(moves.length==3) {
                if (!makemove(moves, chessBoard,play)) {
                    display(chessBoard);
                    System.out.println();
                    System.out.println("Invalid move !! ");
                    continue;
                }
                player = !player;
                ChessCondition = true;
            }
            else
                System.out.println("Invalid input");
        }



    }
    private static boolean makemove(String[] moves, ChessBoard[][] chessBoard,int player) {
        clearScreen();
        String piece = moves[0];
        piece = piece.toLowerCase();
        String currPos = moves[1];
        String newPos = moves[2];
        int currPosRow = 0;
        int newPosRow = 0;
        int currPosCol= 0;
        int newPosCol =0 ;


        try {
            currPosRow = Integer.parseInt(String.valueOf(currPos.charAt(0))) - 1;
            newPosRow = Integer.parseInt(String.valueOf(newPos.charAt(0))) - 1;
            currPosCol = col(String.valueOf(currPos.charAt(1)));
            newPosCol = col(String.valueOf(newPos.charAt(1)));

        }
        catch (NumberFormatException e )
        {
            e.printStackTrace();
        }
        if(currPosRow + currPosCol +newPosRow+newPosRow ==0)
        {
            return false;
        }
        if((currPosRow>=0 && currPosRow<=7)&&(newPosRow>=0 && newPosRow<=7)) { // Invalid row


            if (!(currPosCol == -1 || newPosCol == -1)) // invalid column
            {
                if (chessBoard[currPosRow][currPosCol].getP().getP().toLowerCase().equals(piece)) {
                if (!chessBoard[currPosRow][currPosCol].getP().getP().equals(" ")) {     // Np piece at current location
                    switch (piece) {
                        case "p": // If chose piece is a pawn
                            if ((newPosRow == currPosRow + 1 && newPosCol == currPosCol + 1)&& chessBoard[newPosRow][newPosCol].getP().getOwner()!=chessBoard[currPosRow][currPosCol].getP().getOwner()) {
                                if (!chessBoard[currPosCol + 1][currPosCol + 1].getP().getP().equals("")) {
                                    chessBoard[newPosRow][newPosCol].setP(chessBoard[currPosRow][currPosCol].getP());        // Pawn kill
                                    chessBoard[currPosRow][currPosCol].setP(new Piece(" ", 0));
                                } else {
                                    return false;
                                }
                                break;
                            } else if (newPosRow - currPosRow == 1) {
                                if (chessBoard[newPosRow][currPosCol].getP().getP().equals("")) {
                                    chessBoard[newPosRow][newPosCol].setP(chessBoard[currPosRow][currPosCol].getP());
                                    chessBoard[currPosRow][currPosCol].setP(new Piece(" ", 0));
                                } else {
                                    return false;
                                }
                                break;
                            } else if (Math.abs(newPosRow - currPosRow) == 2) {
                               // System.out.println("entred here");
                                if (chessBoard[newPosRow][currPosCol].getP().getP().equals(" ")) {
                                    chessBoard[newPosRow][newPosCol].setP(chessBoard[currPosRow][currPosCol].getP());
                                    chessBoard[currPosRow][currPosCol].setP(new Piece(" ", 0));
                                } else {
                                    return false;
                                }
                                break;
                            }
                              break;
                        case "c":
                            boolean changed = false;


                            if ((currPosCol == newPosCol) || (currPosRow == newPosRow)) {


//going straight ahead
                                if (currPosCol == newPosCol) {
                                    // look ahead
                                    if (currPosRow > newPosRow) {

                                        for (int i = currPosRow - 1; i > newPosRow; i--) {
                                                //System.out.println("piece is " +  chessBoard[i][currPosCol].getP().getP() + "----");
                                                if (chessBoard[i][currPosCol].getP().getP().equals(" ")) {
                                                    //System.out.println("entered first if and piece is " + chessBoard[i][currPosCol].getP().getP() + "----");
                                                } else {
                                                    //System.out.println("entered second if ");
                                                    if (chessBoard[i][currPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) {
//                                                        System.out.println("entered inside second if ");
//                                                        System.out.println("i is " + i);
//                                                        System.out.println("Owner is " + chessBoard[i][currPosCol].getP().getOwner());
//                                                        System.out.println("Player is " + player);
                                                        chessBoard[i][currPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][currPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                       // System.out.println("Owner is " + chessBoard[i][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece ");
                                                        return false;
                                                    }
                                                }

                                        }
                                    } else if (currPosRow < newPosRow) {
                                        for (int i = currPosRow+1; i < newPosRow; i++) {
                                               // System.out.println("piece is " + chessBoard[i][currPosCol].getP().getP() + "----");
                                                if (chessBoard[i][currPosCol].getP().getP().equals(" ")) {
                                                   // System.out.println("entered first if and piece is " + chessBoard[i][currPosCol].getP().getP() + "----");
                                                } else {
                                                 //   System.out.println("entered second if ");
                                                    if (chessBoard[i][currPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) {
//                                                        System.out.println("entered inside second if ");
//                                                        System.out.println("i is " + i);
//                                                        System.out.println("Owner is " + chessBoard[i][currPosCol].getP().getOwner());
//                                                        System.out.println("Player is " + player);
                                                        chessBoard[i][currPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][currPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece ");
                                                        return false;
                                                    }
                                                }
                                        }
                                    }
                                }

//going laterally
                                else if (currPosRow==newPosRow){


                                    // look ahead

                                    if (currPosCol > newPosCol) {



                                        for (int i = currPosCol - 1; i > newPosCol; i--) {
                                                //System.out.println("piece is " + chessBoard[currPosRow][i].getP().getP() + "i is " + i + "new col is" + newPosCol);
                                                if (chessBoard[currPosRow][i].getP().getP().equals(" ")) {
                                                   // System.out.println("entered first if and piece is " + chessBoard[currPosRow][i].getP().getP() + "----");
                                                } else {
                                                    //System.out.println("entered second if ");
                                                    if (chessBoard[currPosRow][i].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) {
//                                                        System.out.println("entered inside second if ");
//                                                        System.out.println("i is " + i);
//                                                        System.out.println("Owner is " + chessBoard[i][currPosCol].getP().getOwner());
//                                                        System.out.println("Player is " + player);
                                                        chessBoard[currPosRow][i].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[currPosRow][i].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece ");
                                                        return false;
                                                    }
                                                }
                                        }
                                    } else {
                                        for (int i = currPosCol + 1; i < newPosCol; i++) {
                                                //System.out.println("piece is " + chessBoard[currPosRow][i].getP().getP() + "i is " + i + "new col is" + newPosCol);
                                                if (chessBoard[currPosRow][i].getP().getP().equals(" ")) {
                                                  //   System.out.println("entered first if and piece is " + chessBoard[currPosRow][i].getP().getP() + "----");
                                                } else {
                                                      // System.out.println("entered second if ");
                                                    if (chessBoard[currPosRow][i].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) {
//                                                        System.out.println("entered inside second if ");
//                                                        System.out.println("i is " + i);
//                                                        System.out.println("Owner is " + chessBoard[i][currPosCol].getP().getOwner());
//                                                        System.out.println("Player is " + player);
                                                        chessBoard[currPosRow][i].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[currPosRow][i].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece  ");
                                                        return false;
                                                    }
                                                }
                                        }
                                    }
                                }
                                }

//                            System.out.println("changed is  " + changed);
//                            System.out.println(" new is "+ chessBoard[newPosRow][newPosCol].getP().getOwner());
//                            System.out.println("old is "+ chessBoard[currPosRow][currPosCol].getP().getOwner());
                                if (!changed && (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[ currPosRow][currPosCol].getP().getOwner()) )
                                     {
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                }


                            else {
                                return false;
                            }
                            break;



                        case "b":
                            boolean changed2=false;
                            if((newPosRow==currPosRow) || (newPosCol==currPosCol))
                                return false;
                            else
                            {
                                            if(currPosCol>newPosCol)
                                            {
                                               if(currPosRow<newPosRow) {

                                                   int i = currPosRow ;
                                                   int j = currPosCol ;
                                                   while (i < newPosRow && j > newPosCol) {
                                                       if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                           if (i != currPosRow && j != currPosCol) {
                                                               if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                                   chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                                   chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                                   chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                                   chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                                   changed2 = true;
                                                               }
                                                               else {
                                                                   System.out.println("Cannot kill one's own piece  ");
                                                                   return false;
                                                               }
                                                           }
                                                       }
                                                       i++;
                                                       j--;


                                                   }
                                               }

                                               else if (currPosRow>newPosRow)
                                               {
                                                   int i = currPosRow;
                                                   int j = currPosCol;
                                                   while(i>newPosRow && j>newPosCol)
                                                   {
                                                       if(!chessBoard[i][j].getP().getP().equals(" ")) {
                                                           if (i != currPosRow && j != currPosCol) {
                                                               if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                                   chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                                   chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                                   chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                                   chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                                   changed2 = true;
                                                               }
                                                               else {
                                                                   System.out.println("Cannot kill one's own piece  ");
                                                                   return false;
                                                               }
                                                           }
                                                       }
                                                       i--;
                                                       j--;

                                                   }
                                               }
                                            }
                                            else if (currPosCol<newPosCol)
                                            {
                                                if(currPosRow<newPosRow)
                                                {

                                                    int i = currPosRow ;
                                                    int j = currPosCol ;
                                                    while (i < newPosRow && j < newPosCol) {
                                                        if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                            if (i != currPosRow && j != currPosCol) {
                                                                if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                                    chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                                    chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                                    changed2 = true;
                                                                }
                                                                else {
                                                                    System.out.println("Cannot kill one's own piece  ");
                                                                    return false;
                                                                }
                                                            }
                                                        }
                                                        i++;
                                                        j++;


                                                    }


                                                }


                                                else if (currPosRow>newPosRow)
                                                {
                                                    int i = currPosRow ;
                                                    int j = currPosCol ;
                                                    while (i > newPosRow && j < newPosCol) {
                                                        if(i!=currPosRow && j!=currPosCol) {
                                                            if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                                if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                                    chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                                    chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                                    changed2 = true;
                                                                }
                                                                else {
                                                                    System.out.println("Cannot kill one's own piece  ");
                                                                    return false;
                                                                }
                                                            }
                                                        }
                                                            i--;
                                                            j++;


                                                    }
                                                }
                                            }

                                if (!changed2 && (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[ currPosRow][currPosCol].getP().getOwner()) )
                                {
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                }
                                else
                                    return false;
                            }




                            break;
                    }
                    display(chessBoard);
                    return true;
                }
                else
                    return false;
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
        chessBoard[0][0].setP( new Piece("C",2));
        chessBoard[0][1].setP( new Piece("H",2));
        chessBoard[0][2].setP( new Piece("B",2));
        chessBoard[0][3].setP( new Piece("K",2));
        chessBoard[0][4].setP( new Piece("Q",2));
        chessBoard[0][5].setP( new Piece("B",2));
        chessBoard[0][6].setP( new Piece("H",2));
        chessBoard[0][7].setP( new Piece("C",2));

        chessBoard[1][0].setP( new Piece("P",2));
        chessBoard[1][1].setP( new Piece("P",2));
        chessBoard[1][2].setP( new Piece("P",2));
        chessBoard[1][3].setP( new Piece("P",2));
        chessBoard[1][4].setP( new Piece("P",2));
        chessBoard[1][5].setP( new Piece("P",2));
        chessBoard[1][6].setP( new Piece("P",2));
        chessBoard[1][7].setP( new Piece("P",2));


        chessBoard[7][0].setP( new Piece("C",1));
        chessBoard[7][1].setP( new Piece("H",1));
        chessBoard[7][2].setP( new Piece("B",1));
        chessBoard[7][3].setP( new Piece("K",1));
        chessBoard[7][4].setP( new Piece("Q",1));
        chessBoard[7][5].setP( new Piece("B",1));
        chessBoard[7][6].setP( new Piece("H",1));
        chessBoard[7][7].setP( new Piece("C",1));

        chessBoard[6][0].setP( new Piece(" ",0));
        chessBoard[6][1].setP( new Piece("P",1));
        chessBoard[6][2].setP( new Piece("P",1));
        chessBoard[6][3].setP( new Piece("P",1));
        chessBoard[6][4].setP( new Piece("P",1));
        chessBoard[6][5].setP( new Piece("P",1));
        chessBoard[6][6].setP( new Piece("P",1));
        chessBoard[6][7].setP( new Piece("P",1));
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
               if(chessBoard[i][j].getP().getP().equals(""))
                   System.out.print("  ");
               else
                System.out.print(chessBoard[i][j].getP().getP()+" ");
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
