
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Chess
{
    Side side;
    Pawn(Side side){
        this.side = side;
    }
    public String toString()
    {
        if(side==null){
        }else{
            if(side.getSide().equals("Black")||side.getSide().equals("black"))
            {
                return "[BPn]";
            }else if(side.getSide().equals("White")||side.getSide().equals("white")){
                return "[WPn]";
            }
        }
        return null;
    }
    public boolean behavior(int origin,int destination){
        //unfinished fragment: the tilt movement of the pawn
        if(side.getSide()=="white"){
            if(origin/8<=4){
                if(destination/8>=origin/8-2){
                    return true;
                }else{
                    if(destination/8>=origin/8-1){
                        return true;
                    }
                }
            }
        }else{
            if(origin/8>=5){
                if(destination/8<=origin/8-2){
                    return true;
                }else{
                    if(destination/8<=origin/8-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
     public String getSide()
    {
        return side.getSide();
    }
}
