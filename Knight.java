
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Piece
{
    Knight(Side side){
        super(side);
    }
    public String toString()
    {
        if(isBlack())
        {
           return "[BKt]";
        }else if(isWhite()){
           return "[WKt]";
        }  
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if(validateForwardMovement(x1,x2,y1,y2)){
            return true;
        }else if(validateHorizontalMovement(x1,x2,y1,y2)){
            return true;
        }
        return false;
    }
    private boolean validateForwardMovement(int x1,int x2,int y1,int y2)
    {
        return (Math.abs(x1-x2)==2&&Math.abs(y1-y2)==1);
    }
    public boolean validateHorizontalMovement(int x1,int x2,int y1,int y2)
    {
        return (Math.abs(y1-y2)==2&&Math.abs(y1-y2)==1);
    }
}
