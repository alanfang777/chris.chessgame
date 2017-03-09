
/**
 * Write a description of class Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook extends Chess
{
    Side side;
    Rook(Side side){
        this.side = side;
    }
    public String toString()
    {
        if(side==null){
        }else{
            if(side.getSide().equals("Black")||side.getSide().equals("black"))
            {
                return "[BRk]";
            }else if(side.getSide().equals("White")||side.getSide().equals("white")){
                return "[WRk]";
            }
        }
        return null;
    }
    public boolean behavior(int origin ,int destination){
        if(origin%8==destination%8||origin/8==destination/8){
            return true;
        }
        return false;
    }
     public String getSide()
    {
        return side.getSide();
    }
}
