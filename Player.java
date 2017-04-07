import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
   String name;
   final Side side;
   private ArrayList threateningPiece;
    public Player(String name,String color)
   {
       this.name=name;
       side = new Side(color);
       this.threateningPiece=new ArrayList();
   }
   public void setSide(Side side)
   {
//       this.side = side;
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
   public ArrayList getThreateningPiece(){
       return threateningPiece;
   }
   public void setThreateningPiece(Piece piece){
       threateningPiece.add(piece);
    }
   public boolean isBelongToMe(Side side){
       return this.side.getSide().equals(side.getSide());
    }
}
