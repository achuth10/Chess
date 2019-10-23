public class ChessBoard {
    String p ;
    int white,black;
    ChessBoard()
    {
        p=" ";
        white=0;
        black=0;
    }
    ChessBoard(String p ,int white,int black)
    {
        this.p = p;
        this.white=white;
        this.black=black;
    }

    public ChessBoard(int white, int black) {
        this.white=white;
        this.black=black;

    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public int getWhite() {
        return white;
    }

    public void setWhite(int white) {
        this.white = white;
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }
}
