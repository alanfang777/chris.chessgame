
/**
 * Write a description of class Chess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Chess
{
    Side side;
    
    public String toString()
    {
        return null;
    }
    public abstract boolean behavior(int origin, int destination);
    public String getSide()
    {
        return side.getSide();
    }
}
