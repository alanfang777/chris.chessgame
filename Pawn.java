
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece
{
    boolean isFirstStep=true;
    Pawn(Side side){
        super(side);
    }
    public String toString()
    {
        if(isBlack())
        {
             return "[BPn]";
        }else if(isWhite()){
             return "[WPn]";
        } 
        return null;
    }
    public boolean isAllowed( int x1,int x2,int y1,int y2){
        if(isFirstStep)
        {
            if(validateFirstMovement(x1,x2,y1,y2))
            {
                return true;
            }
        }
        else if(validateMovement(x1,x2,y1,y2))
        {
            return true;
        }
       else if(isThereEnemy(x2,y2))
       {
           if(validateEenemyTerminatingMovement(x1,x2,y1,y2))
           {
               return true;
           }
       }
       return false;
    }
    private boolean validateFirstMovement(int x1,int x2,int y1,int y2)
    {
        return (Math.abs(x1-x2)==0 && (Math.abs(y1-y2)==2 || Math.abs(y1-y2)==1));
    }
    private boolean validateMovement(int x1,int x2,int y1,int y2)
    {
        return (Math.abs(x1-x2)==0 && Math.abs(y2-y1)==1);
    }
    private boolean validateEenemyTerminatingMovement(int x1,int x2,int y1,int y2)
    {
        return (Math.abs(y2-y1)==1 && Math.abs(x2-x1)==1);
    }
}
