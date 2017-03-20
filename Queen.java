
/**
 * Write a description of class Queen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queen extends Piece
{
    Queen(Side side){
        super(side);
    }
    @Override
    public String toString()
    {
        if(isBlack())
        {
            return "[BQn]";
        }else if(isWhite()){
            return "[WQn]";
        }
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if(validateStraightLineMovement(x1,x2,y1,y2)){
            return true;
        }else if(validateDiagonalMovement(x1,x2,y1,y2)){
            return true;
        }
        return false;
    }
    public boolean validateStraightLineMovement(int x1,int x2,int y1,int y2)
    {
        return x1==x2||y1==y2;
    }
    public boolean validateDiagonalMovement(int x1,int x2,int y1,int y2)
    {
        return Math.abs(x1-x2)==Math.abs(y1-y2);
    }
}
