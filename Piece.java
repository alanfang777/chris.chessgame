
/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Piece
{
    private Side side;
    private Piece[][] coordinate;
    Piece(Side side){
        this(side,null);
    }
    Piece(Side side, Piece[][] coordinate){
        this.side = side;
        this.coordinate = coordinate;
    }
    public String toString()
    {
        return null;
    }
    public abstract boolean isAllowed(int x1,int x2,int y1,int y2);
    public boolean isThereEnemy(int x2,int y2)
    {
        return !(coordinate[x2][y2]==null);
    }
    public Side getSide(){
        return side;
    }
    public Piece[][] getCoordinate(){
        return coordinate;
    }
    public boolean isBlack()
    {
        return side.getSide().equals("Black");
    }
    public boolean isWhite()
    {
        return side.getSide().equals("White");
    }
    //public abstract boolean validateMovement();
}
