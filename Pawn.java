import java.util.*;
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece
{
    Pawn(Side side,Piece[][] piece){
        super(side,piece);
    }
    public String toString()
    {
        if(super.getSide()==null){
        }else{
            if(super.getSide().getSide().equals("Black")||super.getSide().getSide().equals("black"))
            {
                return "[BPn]";
            }else if(super.getSide().getSide().equals("White")||super.getSide().getSide().equals("white")){
                return "[WPn]";
            }
        }
        return null;
    }
    public boolean isAllowed( int x1,int x2,int y1,int y2){
        // you can use super.getCoordinate to get the Coordinate();
        // Only pawn can use it by calling getCoordinate();
        // example
        // 别忘了写Pawn变身的功能;
        /*Visualize visualize = new Visualize();
        visualize.print(super.getCoordinate());
        if(super.isPieceInBetween(x1,x2,y1,y2)==null){
            return true;
        }*/
        return true;
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        
    }
}
