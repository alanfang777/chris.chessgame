
/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends Chess
{
    Side side;
    Bishop(Side side){
        this.side = side;
    }
    public String toString()
    {
        if(side==null){
        }else{
            if(side.getSide().equals("Black")||side.getSide().equals("black"))
            {
                return "[BBp]";
            }else if(side.getSide().equals("White")||side.getSide().equals("white")){
                return "[WBp]";
            }
        }
        return null;
    }
    public boolean behavior(int origin, int destination){
        int x1=origin%8;
        int x2=destination%8;
        int y1=origin/8;
        int y2=destination/8;
        if(Math.abs(x1-x2)==Math.abs(y1-y2)){
            return true;
        }
        return false;
    }
     public String getSide()
    {
        return side.getSide();
    }
}
