public class ChessBoard {
    Piece p ;
    int white,black,owner;
    ChessBoard()
    {
        p = new Piece();
        white=0;
        black=0;
        owner=0;
    }
    ChessBoard(String p ,int white,int black)
    {
        this.p = new Piece(" ");
        this.white=white;
        this.black=black;
    }

    public ChessBoard(int white, int black) {
        this.white=white;
        this.black=black;

    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public Piece getP() {
        return p;
    }

    public void setP(Piece p) {
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
