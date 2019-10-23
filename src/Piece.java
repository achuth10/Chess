public class Piece {
    String p;
    int owner;
    Piece()
    {

    }
    Piece(String p , int owner)
    {
        this.p=p;
        this.owner=owner;
    }

    public Piece(String s) {
        this.p = s;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
