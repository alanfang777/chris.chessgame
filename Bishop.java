 
/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends Piece
{
    Bishop(Side side){
        super(side);
    }
    public String toString()
    {
        if(isBlack())
        {
            return "[BBp]";
        }else if(isWhite()){
            return "[WBp]";
        }
        
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if(validateMovement(x1,x2,y1,y2)){
            return true;
        }
        return false;
    }
    public boolean validateMovement(int x1,int x2,int y1,int y2)
    {
        return Math.abs(x1-x2)==Math.abs(y1-y2);
    }
}
