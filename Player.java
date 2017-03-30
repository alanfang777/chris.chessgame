
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
   String name;
   Side side;
   
    public Player(String name,Side side)
   {
       this.name=name;
       this.side=side;
   }
   public void setSide(Side side)
   {
       this.side = side;
   }
   public void setName(String name)
   {
       this.name=name;
   }
   public String getSide()
   {
       return side.getSide();
   }
   public String getName()
   {
       return name;
   }
}
