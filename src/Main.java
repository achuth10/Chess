
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
public class Main {
static int p1Piece,p2Piece,k1x,k1y,k2x,k2y;
    private static boolean king1_checkmate,king2_checkmate,king1_check,king2_check;

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        ChessBoard [][]chessBoard = new  ChessBoard[8][8];
        init(chessBoard);
        System.out.println("        Welcome to Chess");
        display(chessBoard);
        System.out.println();
        System.out.println("To play enter the chess piece followed by the location : Eg P,2a,4a (Piece,current pos,new pos)");
        System.out.println("Enter q as the input to exit out of the game at any point ");

        boolean ChessCondition = true;

        boolean player =false;
        while (ChessCondition) {
            king1_checkmate=king2_checkmate=king1_check=king2_check=false;
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
                if (!makemove(moves, chessBoard, play)) {
                    display(chessBoard);
                    System.out.println();
                    System.out.println("Invalid move !! ");
                    continue;
                }
                checkCheck(k1x, k1y, k2x, k2y, chessBoard,play);
                if (king1_checkmate) {
                    System.out.println("Player 2 wins");
                    ChessCondition = false;
                } else if (king2_checkmate) {
                    System.out.println("Player 1 wins");
                    ChessCondition = false;
                }
                 if (king1_check && play==1) {

                    System.out.println("Warning Player 1 is under check");
                    System.out.println("Redo Move !");
                }
                 if (king2_check && play==2) {
                    System.out.println("Warning Player 2 is under check");
                    System.out.println("Redo Move !");
                }
                    else
                 {
                     if(king1_check)
                         System.out.println("Warning Player 1 is under check");
                     else  if (king2_check)
                         System.out.println("Warning Player 2 is under check");
                    player = !player;
                    ChessCondition = true;
                }
            }
            else
                System.out.println("Invalid input");
        }



    }

    private static void checkCheck(int k1x, int k1y, int k2x, int k2y, ChessBoard[][] chessBoard,int play) {
        boolean checkk1,checkk2,checkk3,checkk4,checkk5,checkk6,checkk7,checkk8,checkk9,checkk10;
        boolean checkk21,checkk22,checkk23,checkk24,checkk25,checkk26,checkk27,checkk28,checkk29,checkk210;
        checkk1=checkk2=checkk3=checkk4=checkk5=checkk6=checkk7=checkk8=checkk21=checkk22=checkk23=checkk24=checkk25=checkk26=checkk27=checkk28=false;

        //King1



        for(int i = k1y;i<=7;i++)
        {
            if((chessBoard[k1x][i].getP().getP().contains("^")) && !(chessBoard[k1x][i].getP().getP().equals(chessBoard[k1x][k1y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[k1x][i].getP().getP().equals("Q*")) || (chessBoard[k1x][i].getP().getP().equals("C*"))) {
                checkk1 = true;
                break;
            }
        }



        for(int i = k1y;i>=0;i--)
        {
            //System.out.println("Element in q" + chessBoard[k1x][i].getP().getP());
            if((chessBoard[k1x][i].getP().getP().contains("^")) && !(chessBoard[k1x][i].getP().getP().equals(chessBoard[k1x][k1y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[k1x][i].getP().getP().equals("Q*")) || (chessBoard[k1x][i].getP().getP().equals("C*"))) {
                //System.out.println("Entered here at " +(chessBoard[k1x][i].getP().getP()));
                checkk2 = true;
                break;
            }
        }
        for(int i = k1x;i<7;i++)
        {
            if((chessBoard[i][k1y].getP().getP().contains("^")) && !(chessBoard[i][k1y].getP().getP().equals(chessBoard[k1x][k1y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[i][k1y].getP().getP().equals("Q*")) || (chessBoard[i][k1y].getP().getP().equals("C*"))) {
                checkk3 = true;
                break;
            }
        }
        for(int i = k1x;i>=0;i--)
        {
            if((chessBoard[i][k1y].getP().getP().contains("^")) && !(chessBoard[i][k1y].getP().getP().equals(chessBoard[k1x][k1y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[i][k1y].getP().getP().equals("Q*")) || (chessBoard[i][k1y].getP().getP().equals("C*"))) {
                checkk4 = true;
                break;
            }
        }

        int j =0;
        j=k1y;
        for(int i = k1x;i<7;i++)
        {
            if (j <= 7) {
                if ((chessBoard[i][j].getP().getP().contains("^")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k1x][k1y].getP().getP()))) {
                    break;
                }

                if ((chessBoard[i][j].getP().getP().equals("Q*")) || (chessBoard[i][j].getP().getP().equals("C*")) || (chessBoard[i][j].getP().getP().equals("B*"))) {
                    checkk5 = true;
                    break;
                }

                j++;
            }
            else
                break;
        }

        j=k1y;
        for(int i = k1x;i<=7;i++)
        {
            if(j>=0) {
                if ((chessBoard[i][j].getP().getP().contains("^")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k1x][k1y].getP().getP()))) {
                    break;
                }

                if ((chessBoard[i][j].getP().getP().equals("Q*")) || (chessBoard[i][j].getP().getP().equals("C*")) || (chessBoard[i][j].getP().getP().equals("B*"))) {
                    checkk6 = true;
                    break;
                }

                j--;
            }
            else break;
        }

        j=k1y;
        for(int i = k1x;i>=0;i--)
        {

            if(j>0) {
                if ((chessBoard[i][j].getP().getP().contains("^")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k1x][k1y].getP().getP()))) {
                    break;
                }
                if ((chessBoard[i][j].getP().getP().equals("Q*")) || (chessBoard[i][j].getP().getP().equals("C*")) || (chessBoard[i][j].getP().getP().equals("B*"))) {
                    checkk7 = true;
                    break;
                }

                j--;
            }
            else break;
        }
        j=k1y;
        for(int i = k1x;i>=0;i--)
        {
            if(j<=7) {
                if ((chessBoard[i][j].getP().getP().contains("^")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k1x][k1y].getP().getP()))) {
                    break;
                }

                if ((chessBoard[i][j].getP().getP().equals("Q*")) || (chessBoard[i][j].getP().getP().equals("C*")) || (chessBoard[i][j].getP().getP().equals("B*"))) {
                    checkk8 = true;
                    break;
                }

                j++;
            }
            else
                break;
        }


        //King2





        for(int i = k2y;i<=7;i++)
        {
            if((chessBoard[k2x][i].getP().getP().contains("*")) && !(chessBoard[k2x][i].getP().getP().equals(chessBoard[k2x][k2y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[k2x][i].getP().getP().equals("Q^")) || (chessBoard[k2x][i].getP().getP().equals("C^"))) {
                checkk21 = true;
                break;
            }
        }



        for(int i = k2y;i>=0;i--)
        {
            if((chessBoard[k2x][i].getP().getP().contains("*")) && !(chessBoard[k2x][i].getP().getP().equals(chessBoard[k2x][k2y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[k2x][i].getP().getP().equals("Q^")) || (chessBoard[k2x][i].getP().getP().equals("C^"))) {
                checkk22 = true;
                break;
            }
        }
        for(int i = k2x;i<7;i++)
        {
            if((chessBoard[i][k2y].getP().getP().contains("*")) && !(chessBoard[i][k2y].getP().getP().equals(chessBoard[k2x][k2y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[i][k2y].getP().getP().equals("Q^")) || (chessBoard[i][k2y].getP().getP().equals("C^"))) {
                checkk23 = true;
                break;
            }
        }
        for(int i = k2x;i>=0;i--)
        {
            if((chessBoard[i][k2y].getP().getP().contains("*")) && !(chessBoard[i][k2y].getP().getP().equals(chessBoard[k2x][k2y].getP().getP())))
            {
                break;
            }
            if ((chessBoard[i][k2y].getP().getP().equals("Q^")) || (chessBoard[i][k2y].getP().getP().equals("C^"))) {
                checkk24 = true;
                break;
            }
        }













        j=k2y;
        for(int i = k2x;i<7;i++)
        {
            if(j<=7) {
                if ((chessBoard[i][j].getP().getP().contains("*")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k2x][k2y].getP().getP()))) {
                    break;
                }

                if ((chessBoard[i][j].getP().getP().equals("Q^")) || (chessBoard[i][j].getP().getP().equals("C^")) || (chessBoard[i][j].getP().getP().equals("B^"))) {
                    checkk25 = true;
                    break;
                }

                j++;
            }
            else break;
        }

        j=k2y;
        for(int i = k2x;i<=7;i++) {
            if (j >= 0) {
                if ((chessBoard[i][j].getP().getP().contains("*")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k2x][k2y].getP().getP()))) {
                    break;
                }
                if ((chessBoard[i][j].getP().getP().equals("Q^")) || (chessBoard[i][j].getP().getP().equals("C^")) || (chessBoard[i][j].getP().getP().equals("B^"))) {
                    checkk26 = true;
                    break;
                }

                j--;
            }
            else break;
        }

        j=k2y;
        for(int i = k2x;i>=0;i--)
        {
            if(j>=0) {
            if ((chessBoard[i][j].getP().getP().contains("*")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k2x][k2y].getP().getP())))
            {
                break;
            }

                if ((chessBoard[i][j].getP().getP().equals("Q^")) || (chessBoard[i][j].getP().getP().equals("C^"))|| (chessBoard[i][j].getP().getP().equals("B^"))) {
                    checkk27 = true;
                    break;
                }
                j--;
            }
            else
                break;

        }
        j=k2y;
        for(int i = k2x;i>=0;i--)
        {
            if(j<=7) {
            if ((chessBoard[i][j].getP().getP().contains("*")) && !(chessBoard[i][j].getP().getP().equals(chessBoard[k2x][k2y].getP().getP())))
            {
                break;
            }

                if ((chessBoard[i][j].getP().getP().equals("Q^")) || (chessBoard[i][j].getP().getP().equals("C^"))|| (chessBoard[i][j].getP().getP().equals("B^"))) {
                    checkk28 = true;
                    break;
                }
                j++;
            }
            else
                break;

        }




//        if(checkk1&&checkk2&&checkk3&&checkk4&&checkk5&&checkk6&&checkk7&&checkk8)
//        {
//            king1_checkmate = true;
//        }
//        if(checkk21&&checkk22&&checkk23&&checkk24&&checkk25&&checkk26&&checkk27&&checkk28)
//        {
//            king2_checkmate = true;
//        }
        if(checkk1||checkk2||checkk3||checkk4||checkk5||checkk6||checkk7||checkk8)
        {
            king1_check = true;
        }

        if(checkk21||checkk22||checkk23||checkk24||checkk25||checkk26||checkk27||checkk28)
        {
            king2_check = true;
        }

        boolean r1,l1,d1,u1,dr1,dl1,ul1,ur1;
        r1=l1=d1=u1=dr1=dl1=ul1=ur1=false;

//        if(play==1) {
//            if (checkk1) // Right
//                    {
//                        if ( (k1y<7)&&chessBoard[k1x][k1y + 1].getP().getP().equals("Q*")) {
//                    if (  ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//                            || ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*")))))// Down left)
//                     {
//
//                    } else
//                        king1_checkmate = true;
//                } else if ( (k1y<7)&& chessBoard[k1x][k1y + 1].getP().getP().equals("C*")) {
//                    if (
//                            ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//
//                                    ||  ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//
//                                    || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))//Up
//
//                                    || (k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) //Down
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if (
//
//                        ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//
//                                ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//
//                                || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))//Up
//
//                                || (k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) ) //Down
//
//                                || (k1x > 0) &&  (k1y<7)&& (((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*"))))//Top right
//
//                                || (k1y<7)&& (chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) ||  (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) //Down right
//                {
//
//                } else
//                    king1_checkmate = true;
//            }
//
//
//            if (!king1_checkmate && checkk2) // left
//            {
//
//                if ((k1y > 0) && (chessBoard[k1x][k1y - 1].getP().getP().equals("Q*"))) {
//                    if ((k1x<7)&&(k1y<7)&&((chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) // Down right
//                            || (k1x > 0) &&  (k1y<7)&& (((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))))//Top right
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if ((k1y > 0) && (chessBoard[k1x][k1y - 1].getP().getP().equals("C*"))) {
//                    if (
//                            ((k1x > 0) &&  (k1y<7)&& (((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) ||  (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))))// Top right
//
//                                    || (k1y<7)&& ((chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) ||  (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) // Down right
//
//                                    || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))//Up
//
//                                    || (k1x<7)&&(((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) )//Down
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if (
//                        ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))//Up
//
//                                || ((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*"))) ) //Down
//                                || (k1x > 0) && (k1y<7)&& ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))//Top right
//                                || ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//                                ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//                                ||  (k1y<7)&&(chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) ||  (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) //Down right
//                {
//
//                } else
//                    king1_checkmate = true;
//            }
//
//
//            if (!king1_checkmate && checkk3) // Down
//            {
//
//                if (chessBoard[k1x + 1][k1y].getP().getP().equals("Q*")) {
//                    if (((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//                            || (k1x > 0) &&  (k1y<7)&& ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) ||   (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*"))))//Top right
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if (chessBoard[k1x + 1][k1y + 1].getP().getP().equals("C*")) {
//                    if (
//                            ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//                                    || (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//
//                                    || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//
//
//                                    || (k1x > 0) &&  (k1y<7)&& (((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))))// Top right
//
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if (
//
//                        ( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//
//                                || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//                                || ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//
//                                || (k1x > 0) && (k1y<7)&& ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) ||(chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))//Top right
//                                ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//
//                                || (chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) //Down right
//                {
//
//                } else
//                    king1_checkmate = true;
//            }
//
//
//            if (!king1_checkmate && checkk4) // Up
//            {
//
//                if ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals("Q*")))) {
//                    if ((k1x<7)&&(k1y<7)&&((chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) // Down right
//                            ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*")))))// Down left
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals("C*")))) {
//                    if (
//                            (k1x<7)&&(k1y<7)&&((chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) // Down right
//
//                                    ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//
//                                    || (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//
//                                    || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//
//
//                    ) {
//
//                    }
//                } else
//                    king1_checkmate = true;
//            } else if (
//
//                    (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//
//                            || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//                            || ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//
//                            || (k1x > 0) && (k1y<7)&& ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))//Top right
//                            ||   ((k1y > 0) && (k1x<7) && (((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//
//                            || (chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) //Down right
//            {
//
//            } else
//                king1_checkmate = true;
//
//
//            if (!king1_checkmate && checkk5) // Down Right
//            {
//
//                if ((chessBoard[k1x + 1][k1y + 1].getP().getP().equals("Q*"))) {
//                    if ((k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//
//                            || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*")))))//Up
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if ((chessBoard[k1x + 1][k1y + 1].getP().getP().equals("C*"))) {
//                    if (
//                            (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*"))//Left
//                                    || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*")))) // Up
//
//                                    || ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//
//                            )
//
//
//                    ) {
//
//                    }
//                } else
//                    king1_checkmate = true;
//            } else if (
//
//                    (k1y<7)&&(((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//                            || ((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) //Down
//                            || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//                            ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//                            || (k1x > 0) && ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))//Top right
//                            || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))//Up
//
//            ) {
//
//            } else
//                king1_checkmate = true;
//
//
//            if (!king1_checkmate && checkk6) // Down left
//            {
//
//
//                if ((k1y > 0) && (chessBoard[k1x + 1][k1y - 1].getP().getP().equals("Q*"))) {
//                    if ((k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//
//                            || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*")))))//Up
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if ((k1y > 0) && (chessBoard[k1x + 1][k1y - 1].getP().getP().equals("C*"))) {
//                    if (
//                            (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//                                    || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*")))) // Up
//                                    || (k1x > 0) && ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))//Top right
//
//                    ) {
//
//                    }
//                } else
//                    king1_checkmate = true;
//            } else if (
//                    (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//                            || ((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) //Down
//                            || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//                            || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))// up
//                            || ((k1x > 0) && ((k1y > 0) && ((chessBoard[k1x - 1][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y - 1].getP().getP().contains("*")))))// Top left
//                            || (k1x<7)&&(k1y<7)&&((chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*")))) // Down right     )
//            {
//
//            } else
//                king1_checkmate = true;
//
//
//            if (!king1_checkmate && checkk7) // Top left
//            {
//
//
//                if ((k1x > 0) && ((k1y > 0) && (chessBoard[k1x - 1][k1y - 1].getP().getP().equals("Q*")))) {
//                    if (((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) //Down
//                            || (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*")))))// Right
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if ((k1x > 0) && ((k1y > 0) && (chessBoard[k1x - 1][k1y - 1].getP().getP().equals("C*")))) {
//                    if (((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) //Down
//                            || (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//                            || (chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))) //Down right
//
//                    {
//
//                    }
//                } else
//                    king1_checkmate = true;
//            } else if (
//
//                    (k1y<7)&&( (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*"))))// Right
//                            || ((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) //Down
//                            || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//                            ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//                            || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))// up
//                            || (k1x > 0) && ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))//Top right
//            ) {
//
//            } else
//                king1_checkmate = true;
//
//            if (!king1_checkmate && checkk8) // Top right
//            {
//
//
//                if ((k1x > 0) && (chessBoard[k1x - 1][k1y + 1].getP().getP().equals("Q*"))) {
//                    if (((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )) //Down
//                            || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*"))))//Left)
//                    {
//
//                    } else
//                        king1_checkmate = true;
//                } else if ((k1x > 0) && (chessBoard[k1x - 1][k1y + 1].getP().getP().equals("C*"))) {
//                    if (
//                            (k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*")) )//Down
//                                    || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))
//                                    ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//                    ) {
//
//                    }
//                } else
//                    king1_checkmate = true;
//            } else if (
//
//                    (k1y<7)&&((chessBoard[k1x][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y + 1].getP().getP().contains("*")))// Right
//                            || ((k1x<7)&&((chessBoard[k1x + 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y].getP().getP().contains("*"))) ) //Down
//                            || (chessBoard[k1x + 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x + 1][k1y + 1].getP().getP().contains("*"))   //Down right
//                            || (k1x > 0) && ((chessBoard[k1x - 1][k1y + 1].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y + 1].getP().getP().contains("*")))//Top right
//                            || (k1y > 0) && ((chessBoard[k1x][k1y - 1].getP().getP().equals(" ")) || (chessBoard[k1x][k1y - 1].getP().getP().contains("*")))//Left
//                            ||   ((k1y > 0) && (k1x<7) &&(((chessBoard[k1x + 1][k1y - 1].getP().getP().equals(" "))) || (chessBoard[k1x + 1][k1y - 1].getP().getP().contains("*"))))// Down left
//                            || ((k1x > 0) && ((chessBoard[k1x - 1][k1y].getP().getP().equals(" ")) || (chessBoard[k1x - 1][k1y].getP().getP().contains("*"))))// up
//
//
//            ) {
//
//            } else
//                king1_checkmate = true;
//
//
//        }
//
//
//
//
//
//           King 2
//
//
//
//
//
//        else if (play ==2)
//        {
//            if (checkk21) // Right
//                    {
//                        if ( (k2y<7)&&chessBoard[k2x][k2y + 1].getP().getP().equals("Q*")) {
//                    if (  ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//                            || ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*")))))// Down left)
//                     {
//
//                    } else
//                        king2_checkmate = true;
//                } else if ( (k2y<7)&& chessBoard[k2x][k2y + 1].getP().getP().equals("C*")) {
//                    if (
//                            ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//
//                                    ||  ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//
//                                    || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))//Up
//
//                                    || (k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) //Down
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if (
//
//                        ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//
//                                ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//
//                                || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))//Up
//
//                                || (k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) ) //Down
//
//                                || (k2x > 0) &&  (k2y<7)&& (((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*"))))//Top right
//
//                                || (k2y<7)&& (chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) ||  (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) //Down right
//                {
//
//                } else
//                    king2_checkmate = true;
//            }
//
//
//            if (!king2_checkmate && checkk22) // left
//            {
//
//                if ((k2y > 0) && (chessBoard[k2x][k2y - 1].getP().getP().equals("Q*"))) {
//                    if ((k2x<7)&&(k2y<7)&&((chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) // Down right
//                            || (k2x > 0) &&  (k2y<7)&& (((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))))//Top right
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if ((k2y > 0) && (chessBoard[k2x][k2y - 1].getP().getP().equals("C*"))) {
//                    if (
//                            ((k2x > 0) &&  (k2y<7)&& (((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) ||  (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))))// Top right
//
//                                    || (k2y<7)&& ((chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) ||  (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) // Down right
//
//                                    || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))//Up
//
//                                    || (k2x<7)&&(((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) )//Down
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if (
//                        ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))//Up
//
//                                || ((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*"))) ) //Down
//                                || (k2x > 0) && (k2y<7)&& ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))//Top right
//                                || ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//                                ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//                                ||  (k2y<7)&&(chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) ||  (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) //Down right
//                {
//
//                } else
//                    king2_checkmate = true;
//            }
//
//
//            if (!king2_checkmate && checkk23) // Down
//            {
//
//                if (chessBoard[k2x + 1][k2y].getP().getP().equals("Q*")) {
//                    if (((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//                            || (k2x > 0) &&  (k2y<7)&& ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) ||   (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*"))))//Top right
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if (chessBoard[k2x + 1][k2y + 1].getP().getP().equals("C*")) {
//                    if (
//                            ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//                                    || (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//
//                                    || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//
//
//                                    || (k2x > 0) &&  (k2y<7)&& (((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))))// Top right
//
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if (
//
//                        ( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//
//                                || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//                                || ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//
//                                || (k2x > 0) && (k2y<7)&& ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) ||(chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))//Top right
//                                ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//
//                                || (chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) //Down right
//                {
//
//                } else
//                    king2_checkmate = true;
//            }
//
//
//            if (!king2_checkmate && checkk24) // Up
//            {
//
//                if ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals("Q*")))) {
//                    if ((k2x<7)&&(k2y<7)&&((chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) // Down right
//                            ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*")))))// Down left
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals("C*")))) {
//                    if (
//                            (k2x<7)&&(k2y<7)&&((chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) // Down right
//
//                                    ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//
//                                    || (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//
//                                    || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//
//
//                    ) {
//
//                    }
//                } else
//                    king2_checkmate = true;
//            } else if (
//
//                    (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//
//                            || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//                            || ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//
//                            || (k2x > 0) && (k2y<7)&& ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))//Top right
//                            ||   ((k2y > 0) && (k2x<7) && (((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//
//                            || (chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) //Down right
//            {
//
//            } else
//                king2_checkmate = true;
//
//
//            if (!king2_checkmate && checkk25) // Down Right
//            {
//
//                if ((chessBoard[k2x + 1][k2y + 1].getP().getP().equals("Q*"))) {
//                    if ((k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//
//                            || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*")))))//Up
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if ((chessBoard[k2x + 1][k2y + 1].getP().getP().equals("C*"))) {
//                    if (
//                            (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*"))//Left
//                                    || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*")))) // Up
//
//                                    || ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//
//                            )
//
//
//                    ) {
//
//                    }
//                } else
//                    king2_checkmate = true;
//            } else if (
//
//                    (k2y<7)&&(((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//                            || ((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) //Down
//                            || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//                            ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//                            || (k2x > 0) && ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))//Top right
//                            || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))//Up
//
//            ) {
//
//            } else
//                king2_checkmate = true;
//
//
//            if (!king2_checkmate && checkk26) // Down left
//            {
//
//
//                if ((k2y > 0) && (chessBoard[k2x + 1][k2y - 1].getP().getP().equals("Q*"))) {
//                    if ((k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//
//                            || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*")))))//Up
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if ((k2y > 0) && (chessBoard[k2x + 1][k2y - 1].getP().getP().equals("C*"))) {
//                    if (
//                            (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//                                    || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*")))) // Up
//                                    || (k2x > 0) && ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))//Top right
//
//                    ) {
//
//                    }
//                } else
//                    king2_checkmate = true;
//            } else if (
//                    (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//                            || ((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) //Down
//                            || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//                            || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))// up
//                            || ((k2x > 0) && ((k2y > 0) && ((chessBoard[k2x - 1][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y - 1].getP().getP().contains("*")))))// Top left
//                            || (k2x<7)&&(k2y<7)&&((chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*")))) // Down right     )
//            {
//
//            } else
//                king2_checkmate = true;
//
//
//            if (!king2_checkmate && checkk27) // Top left
//            {
//
//
//                if ((k2x > 0) && ((k2y > 0) && (chessBoard[k2x - 1][k2y - 1].getP().getP().equals("Q*")))) {
//                    if (((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) //Down
//                            || (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*")))))// Right
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if ((k2x > 0) && ((k2y > 0) && (chessBoard[k2x - 1][k2y - 1].getP().getP().equals("C*")))) {
//                    if (((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) //Down
//                            || (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//                            || (chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))) //Down right
//
//                    {
//
//                    }
//                } else
//                    king2_checkmate = true;
//            } else if (
//
//                    (k2y<7)&&( (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*"))))// Right
//                            || ((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) //Down
//                            || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//                            ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//                            || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))// up
//                            || (k2x > 0) && ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))//Top right
//            ) {
//
//            } else
//                king2_checkmate = true;
//
//            if (!king2_checkmate && checkk28) // Top right
//            {
//
//
//                if ((k2x > 0) && (chessBoard[k2x - 1][k2y + 1].getP().getP().equals("Q*"))) {
//                    if (((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )) //Down
//                            || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*"))))//Left)
//                    {
//
//                    } else
//                        king2_checkmate = true;
//                } else if ((k2x > 0) && (chessBoard[k2x - 1][k2y + 1].getP().getP().equals("C*"))) {
//                    if (
//                            (k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*")) )//Down
//                                    || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))
//                                    ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//                    ) {
//
//                    }
//                } else
//                    king2_checkmate = true;
//            } else if (
//
//                    (k2y<7)&&((chessBoard[k2x][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y + 1].getP().getP().contains("*")))// Right
//                            || ((k2x<7)&&((chessBoard[k2x + 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y].getP().getP().contains("*"))) ) //Down
//                            || (chessBoard[k2x + 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x + 1][k2y + 1].getP().getP().contains("*"))   //Down right
//                            || (k2x > 0) && ((chessBoard[k2x - 1][k2y + 1].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y + 1].getP().getP().contains("*")))//Top right
//                            || (k2y > 0) && ((chessBoard[k2x][k2y - 1].getP().getP().equals(" ")) || (chessBoard[k2x][k2y - 1].getP().getP().contains("*")))//Left
//                            ||   ((k2y > 0) && (k2x<7) &&(((chessBoard[k2x + 1][k2y - 1].getP().getP().equals(" "))) || (chessBoard[k2x + 1][k2y - 1].getP().getP().contains("*"))))// Down left
//                            || ((k2x > 0) && ((chessBoard[k2x - 1][k2y].getP().getP().equals(" ")) || (chessBoard[k2x - 1][k2y].getP().getP().contains("*"))))// up
//
//
//            ) {
//
//            } else
//                king2_checkmate = true;
//
//
//        }
//        }



    }

    private static boolean makemove(String[] moves, ChessBoard[][] chessBoard,int player) {
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
            try {
                currPosCol = col(String.valueOf(currPos.charAt(1)));
                newPosCol = col(String.valueOf(newPos.charAt(1)));
            }
            catch (StringIndexOutOfBoundsException e )
            {
               return false;
            }
        }
        catch (NumberFormatException e )
        {
           return false;
        }

        if(chessBoard[currPosRow][currPosCol].getP().getOwner()==player)
        {
        if(currPosRow + currPosCol +newPosRow+newPosRow ==0)
        {

            return false;
        }
        if((currPosRow>=0 || currPosRow<=7)||(newPosRow>=0 && newPosRow<=7)) { // Invalid row


            if (!(currPosCol == -1 || newPosCol == -1)) // invalid column
            {
                if (chessBoard[currPosRow][currPosCol].getP().getP().toLowerCase().substring(0,1).equals(piece)) {
                if (!chessBoard[currPosRow][currPosCol].getP().getP().equals(" ")) {     // Np piece at current location
                    switch (piece) {
                        case "p": // If chosen piece is a pawn
                            if (Math.abs(newPosRow - currPosRow) == 1 && Math.abs(newPosCol - currPosCol) == 1)
                            // && chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) {
                            {
                                if (!chessBoard[currPosCol + 1][currPosCol + 1].getP().getP().equals(" ")) {
                                    /// System.out.println("Entered kill cond");
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                    chessBoard[currPosRow][currPosCol].getP().setInitial(false);
                                    chessBoard[newPosRow][newPosCol].getP().setInitial(true);
                                    if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                        p2Piece--;
                                    else
                                        p1Piece--;
                                } else {
                                    return false;
                                }
                                break;
                            } else if (Math.abs(newPosRow - currPosRow) == 1) {
                                if (chessBoard[newPosRow][currPosCol].getP().getP().equals(" ")) {
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                    chessBoard[currPosRow][currPosCol].getP().setInitial(false);
                                    chessBoard[newPosRow][newPosCol].getP().setInitial(true);
                                } else {
                                    return false;
                                }
                                break;
                            } else if (Math.abs(newPosRow - currPosRow) == 2) {
                                // System.out.println("entered here");
                                if (!chessBoard[currPosRow][currPosCol].getP().isInitial()) {
                                    if (chessBoard[newPosRow][currPosCol].getP().getP().equals(" ")) {
                                        chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                        chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                        chessBoard[currPosRow][currPosCol].getP().setInitial(false);
                                        chessBoard[newPosRow][newPosCol].getP().setInitial(true);
                                    }
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
                                        for (int i = currPosRow + 1; i < newPosRow; i++) {
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
                                else if (currPosRow == newPosRow) {


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


//                            System.out.println("changed is  " + changed);
//                            System.out.println(" new is "+ chessBoard[newPosRow][newPosCol].getP().getOwner());
//                            System.out.println("old is "+ chessBoard[currPosRow][currPosCol].getP().getOwner());
                                if (!changed && (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                    if (!chessBoard[newPosRow][newPosCol].getP().getP().equals(" ")) {
                                        if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                            p2Piece--;
                                        else
                                            p1Piece--;
                                    }
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);

                                }
                            } else {
                                return false;
                            }
                            break;


                        case "h":
                            if ((currPosRow == newPosRow) || (currPosCol == newPosCol))
                                return false;
                            else {
                                if ((currPosCol + 2 == newPosCol) || (currPosCol - 2 == newPosCol)) {
                                    if ((currPosRow + 1 == newPosRow) || (currPosRow - 1 == newPosRow)) {
                                        if (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) {
                                            if (!chessBoard[newPosRow][newPosCol].getP().getP().equals(" ")) {
                                                if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                                    p2Piece--;
                                                else
                                                    p1Piece--;
                                            }
                                            chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                            chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                            chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                            chessBoard[currPosRow][currPosCol].getP().setOwner(0);

                                        } else {
                                            System.out.println("Cannot kill one's own piece  ");
                                            return false;
                                        }
                                    } else
                                        return false;
                                } else if ((currPosCol + 1 == newPosCol) || (currPosCol - 1 == newPosCol)) {
                                    if ((currPosRow + 2 == newPosRow) || (currPosRow - 2 == newPosRow)) {
                                        if (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) {
                                            if (!chessBoard[newPosRow][newPosCol].getP().getP().equals(" ")) {
                                                if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                                    p2Piece--;
                                                else
                                                    p1Piece--;
                                            }
                                            chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                            chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                            chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                            chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                        } else {
                                            System.out.println("Cannot kill one's own piece");
                                            return false;
                                        }
                                    } else
                                        return false;
                                }


                            }

                            break;

                        case "b":
                            boolean changed2 = false;
                            //eliminate wrong moves
                            if ((newPosRow == currPosRow) || (newPosCol == currPosCol))
                                return false;
                            else {
                                if (currPosCol > newPosCol) {
                                    if (currPosRow < newPosRow) {

                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i < newPosRow && j > newPosCol) {
                                            if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                if (i != currPosRow && j != currPosCol) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed2 = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece  ");
                                                        return false;
                                                    }
                                                }
                                            }
                                            i++;
                                            j--;


                                        }
                                    } else if (currPosRow > newPosRow) {
                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i > newPosRow && j > newPosCol) {
                                            if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                if (i != currPosRow && j != currPosCol) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed2 = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece  ");
                                                        return false;
                                                    }
                                                }
                                            }
                                            i--;
                                            j--;

                                        }
                                    }
                                } else if (currPosCol < newPosCol) {
                                    if (currPosRow < newPosRow) {

                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i < newPosRow && j < newPosCol) {
                                            if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                if (i != currPosRow && j != currPosCol) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed2 = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece  ");
                                                        return false;
                                                    }
                                                }
                                            }
                                            i++;
                                            j++;


                                        }


                                    } else if (currPosRow > newPosRow) {
                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i > newPosRow && j < newPosCol) {
                                            if (i != currPosRow && j != currPosCol) {
                                                if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed2 = true;
                                                    } else {
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

                                if (!changed2 && (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                    if (!chessBoard[newPosRow][newPosCol].getP().getP().equals(" ")) {
                                        if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                            p2Piece--;
                                        else
                                            p1Piece--;
                                    }
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);

                                } else
                                    return false;
                            }

                            break;
                        case "q":
                            boolean changed3 = false;

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
                                                    changed3 = true;
                                                } else {
                                                    System.out.println("Cannot kill one's own piece ");
                                                    return false;
                                                }
                                            }

                                        }
                                    } else if (currPosRow < newPosRow) {
                                        for (int i = currPosRow + 1; i < newPosRow; i++) {
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
                                                    changed3 = true;
                                                } else {
                                                    System.out.println("Cannot kill one's own piece ");
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }

//going laterally
                                else if (currPosRow == newPosRow) {


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
                                                    changed3 = true;
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
                                                    changed3 = true;
                                                } else {
                                                    System.out.println("Cannot kill one's own piece  ");
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }


//                            System.out.println("changed is  " + changed);
//                            System.out.println(" new is "+ chessBoard[newPosRow][newPosCol].getP().getOwner());
//                            System.out.println("old is "+ chessBoard[currPosRow][currPosCol].getP().getOwner());
                                if (!changed3 && (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                    if (!chessBoard[newPosRow][newPosCol].getP().getP().equals(" ")) {
                                        if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                            p2Piece--;
                                        else
                                            p1Piece--;
                                    }
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);

                                }
                            } else {
                                boolean changed4 = false;
                                if (currPosCol > newPosCol) {
                                    if (currPosRow < newPosRow) {

                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i < newPosRow && j > newPosCol) {
                                            if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                if (i != currPosRow && j != currPosCol) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed4 = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece  ");
                                                        return false;
                                                    }
                                                }
                                            }
                                            i++;
                                            j--;


                                        }
                                    } else if (currPosRow > newPosRow) {
                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i > newPosRow && j > newPosCol) {
                                            if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                if (i != currPosRow && j != currPosCol) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed4 = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece  ");
                                                        return false;
                                                    }
                                                }
                                            }
                                            i--;
                                            j--;

                                        }
                                    }
                                } else if (currPosCol < newPosCol) {
                                    if (currPosRow < newPosRow) {

                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i < newPosRow && j < newPosCol) {
                                            if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                if (i != currPosRow && j != currPosCol) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed4 = true;
                                                    } else {
                                                        System.out.println("Cannot kill one's own piece  ");
                                                        return false;
                                                    }
                                                }
                                            }
                                            i++;
                                            j++;


                                        }


                                    } else if (currPosRow > newPosRow) {
                                        int i = currPosRow;
                                        int j = currPosCol;
                                        while (i > newPosRow && j < newPosCol) {
                                            if (i != currPosRow && j != currPosCol) {
                                                if (!chessBoard[i][j].getP().getP().equals(" ")) {
                                                    if (!(chessBoard[i][j].getP().getOwner() == chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                                        chessBoard[i][j].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                                        chessBoard[i][j].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                                        chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                                        chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                                        changed4 = true;
                                                    } else {
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

                                if (!changed4 && (chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner())) {
                                    if (!chessBoard[newPosRow][newPosCol].getP().getP().equals(" ")) {
                                        if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                            p2Piece--;
                                        else
                                            p1Piece--;
                                    }
                                    chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                    chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                    chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                    chessBoard[currPosRow][currPosCol].getP().setOwner(0);

                                } else
                                    return false;
                            }

                            break;

                        case "k":

                            if ((chessBoard[newPosRow][newPosCol].getP().getOwner() != chessBoard[currPosRow][currPosCol].getP().getOwner()) && (
                                    (newPosCol == currPosCol + 1) && (currPosRow == newPosRow))
                                    || ((newPosCol == currPosCol + 1) && (currPosRow + 1 == newPosRow))
                                    || ((newPosCol == currPosCol) && (currPosRow + 1 == newPosRow))
                                    || ((newPosCol == currPosCol - 1) && (currPosRow + 1 == newPosRow))
                                    || ((newPosCol == currPosCol - 1) && (currPosRow == newPosRow))
                                    || ((newPosCol == currPosCol - 1) && (currPosRow - 1 == newPosRow))
                                    || ((newPosCol == currPosCol) && (currPosRow - 1 == newPosRow))
                                    || ((newPosCol == currPosCol + 1) && (currPosRow - 1 == newPosRow))
                                    || ((newPosCol == currPosCol + 1) && (currPosRow == newPosRow))
                            ) {
                                if (!chessBoard[newPosRow][newPosCol].getP().getP().equals(" ")) {
                                    if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1)
                                        p2Piece--;
                                    else
                                        p1Piece--;
                                }

                                chessBoard[newPosRow][newPosCol].getP().setP(chessBoard[currPosRow][currPosCol].getP().getP());
                                chessBoard[currPosRow][currPosCol].getP().setP(" ");
                                chessBoard[newPosRow][newPosCol].getP().setOwner(chessBoard[currPosRow][currPosCol].getP().getOwner());
                                chessBoard[currPosRow][currPosCol].getP().setOwner(0);
                                if (chessBoard[newPosRow][newPosCol].getP().getOwner() == 1) {
                                    k2x = newPosRow;
                                    k1y = newPosCol;
                                } else {
                                    k2x = newPosRow;
                                    k2y = newPosCol;
                                }
                            } else
                                return false;

                            break;
                    }
                    display(chessBoard);
                    return true;
                }
                else
                    return false;
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
        p1Piece=p2Piece=16;
        for (int i = 0; i <8; i++) {
            for(int j = 0 ;j<8;j++)
            {
                if((i+j)%2==0)
                chessBoard[i][j]=new ChessBoard(" ",1,0);
                else
                    chessBoard[i][j]=new ChessBoard(" ",0,1);
            }
        }
        chessBoard[0][0].setP( new Piece("C*",2,false));
        chessBoard[0][1].setP( new Piece("H*",2,false));
        chessBoard[0][2].setP( new Piece("B*",2,false));
        chessBoard[0][3].setP( new Piece("K*",2,false));
        k2x=0;
        k2y=3;
        chessBoard[0][4].setP( new Piece("Q*",2,false));
        chessBoard[0][5].setP( new Piece("B*",2,false));
        chessBoard[0][6].setP( new Piece("H*",2,false));
        chessBoard[0][7].setP( new Piece("C*",2,false));

        chessBoard[1][0].setP( new Piece("P*",2,false));
        chessBoard[1][1].setP( new Piece("P*",2,false));
        chessBoard[1][2].setP( new Piece("P*",2,false));
        chessBoard[1][3].setP( new Piece("P*",2,false));
        chessBoard[1][4].setP( new Piece("P*",2,false));
        chessBoard[1][5].setP( new Piece("P*",2,false));
        chessBoard[1][6].setP( new Piece("P*",2,false));
        chessBoard[1][7].setP( new Piece("P*",2,false));

        chessBoard[7][0].setP( new Piece("C^",1,false));
        chessBoard[7][1].setP( new Piece("H^",1,false));
        chessBoard[7][2].setP( new Piece("B^",1,false));
        chessBoard[7][3].setP( new Piece("K^",1,false));
        k1x=7;
        k1y=3;
        chessBoard[7][4].setP( new Piece("Q^",1,false));
        chessBoard[7][5].setP( new Piece("B^",1,false));
        chessBoard[7][6].setP( new Piece("H^",1,false));
        chessBoard[7][7].setP( new Piece("C^",1,false));

        chessBoard[6][0].setP( new Piece("P^",1,false));
        chessBoard[6][1].setP( new Piece("P^",1,false));
        chessBoard[6][2].setP( new Piece("P^",1,false));
        chessBoard[6][3].setP( new Piece("P^",1,false));
        chessBoard[6][4].setP( new Piece("P^",1,false));
        chessBoard[6][5].setP( new Piece("P^",1,false));
        chessBoard[6][6].setP( new Piece("P^",1,false));
        chessBoard[6][7].setP( new Piece("P^",1,false));
    }

    private static void display(ChessBoard[][] chessBoard) {
        System.out.println("          Player 2*("+p1Piece+")");
System.out.print("   ");
        for(char c = 'a'; c <= 'h'; ++c)
        {
            System.out.print("  " + c+" ");
        }
        System.out.println();
        System.out.print("   ");
        for(char c = 'a'; c <= 'q'; ++c)
        {
            System.out.print("__" );
        }
        for (int i = 0; i <8; i++) {
            System.out.println();
            System.out.print(i+1+"| ");
            for(int j = 0 ;j<8;j++)
            {
               if(chessBoard[i][j].getP().getP().equals(" ")) {
                       System.out.print("  - ");

               }else
                System.out.print(" " +chessBoard[i][j].getP().getP()+" ");
            }

            System.out.print("|" + (i+1));

        }
        System.out.println();
        System.out.print("   ");
        for(char c = 'a'; c <= 'q'; ++c)
        {
            System.out.print("__" );
        }

        System.out.println();
        System.out.print("   ");
        for(char c = 'a'; c <= 'h'; ++c)
        {
            System.out.print("  " + c+" ");
        }
        System.out.println();
        System.out.println("          Player 1^("+p2Piece+")");
    }
    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
