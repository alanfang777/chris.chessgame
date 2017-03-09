
/**
 * Write a description of class Queen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queen extends Chess
{
    Side side;
    Queen(Side side){
        this.side = side;
    }
    
    @Override
    public String toString()
    {
        if(side==null){
        }else{
            if(side.getSide().equals("Black")||side.getSide().equals("black"))
            {
                return "[BQn]";
            }else if(side.getSide().equals("White")||side.getSide().equals("white")){
                return "[WQu]";
            }
        }
        return null;
    }
    public boolean behavior(int origin, int destination){
        int x1=origin%8;
        int x2=destination%8;
        int y1=origin/8;
        int y2=destination/8;
        if(x1==x2||y1==y2){
            return true;
        }else if(Math.abs(x1-x2)==Math.abs(y1-y2)){
            return true;
        }
        return false;
    }
     public String getSide()
    {
        return side.getSide();
    }
}
