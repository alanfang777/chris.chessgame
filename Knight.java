
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Chess
{
    Side side;
    Knight(Side side){
        this.side = side;
    }
    public String toString()
    {
        if(side==null){
        }else{
            if(side.getSide().equals("Black")||side.getSide().equals("black"))
            {
                return "[BKt]";
            }else if(side.getSide().equals("White")||side.getSide().equals("white")){
                return "[WKt]";
            }
        }
        return null;
    }
    public boolean behavior(int origin,int destination){
        int x1=origin%8;
        int x2=destination%8;
        int y1=origin/8;
        int y2=destination/8;
        if(Math.abs(x1-x2)==2&&Math.abs(y1-y2)==1){
            return true;
        }else if((Math.abs(x1-x2)==1||Math.abs(y2-y1)==2)){
            return true;
        }
        return false;
    }
    public String getSide()
    {
        return side.getSide();
    }
}
