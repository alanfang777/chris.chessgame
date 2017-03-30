
/**
 * Write a description of class Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook extends Piece
{
    Rook(Side side){
        super(side);
    }
    public String toString()
    {
        if(isBlack())
        {
           return "[BRk]";
        }else if(isWhite()){
           return "[WRk]";
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
        return x1==x2&&y1==y2;
    }
}

