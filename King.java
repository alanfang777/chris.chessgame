
/**
 * Write a description of class King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends Piece
{
    King(Side side){
        super(side);
    }
    public String toString()
    {
        if(isBlack())
        {
                return "[BKg]";
        }else if(isWhite()){
                return "[WKg]";
        }   
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if(Math.abs(x1-x2)==1||Math.abs(y1-y2)==1){
            return true;
        }else if(Math.abs(y1-y2)==1&&Math.abs(x1-x2)==1){
            return true;
        }
        return false;
    }
    
}
