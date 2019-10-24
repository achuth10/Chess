public class Piece {
    String p;
    int owner;
    boolean initial;
    Piece()
    {
initial= false;
    }

    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    Piece(String p , int owner,boolean initial)
    {
        this.p=p;
        this.owner=owner;
        this.initial= initial;
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
    public boolean checkSameOwner(int owner)
    {
        return this.owner==owner;
    }
}
