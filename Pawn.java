import java.util.*;
<<<<<<< HEAD
import Exceptions.*;
=======
>>>>>>> origin/master
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece
{
<<<<<<< HEAD
    Pawn(Side side,Piece[][] piece,ArrayList threateningPiece){
        super(side,piece,threateningPiece);
=======
    Pawn(Side side,Piece[][] piece){
        super(side,piece);
>>>>>>> origin/master
    }
    public String toString()
    {
        if(super.getSide()==null){
        }else{
<<<<<<< HEAD
            if(isBlack())
            {
                return "[BPn]";
            }else if(isWhite()){
                return "[WPn]";
            }
        }
        return null;
    }
    public boolean isAllowed( int x1,int x2,int y1,int y2) throws InvalidMoveException{
        if(isBlack()){
            if(y1==y2-1){
                return true;
            }else if(y1==y2-2 && y1==1){
                return true;
            }
            return false;
        }else if(isWhite()){
            if(y1==y1+1){
                return true;
            }else if(y1==y2+2 && y1==6){
                return true;
=======
            if(super.getSide().getSide().equals("Black")||super.getSide().getSide().equals("black"))
            {
                return "[BPn]";
            }else if(super.getSide().getSide().equals("White")||super.getSide().getSide().equals("white")){
                return "[WPn]";
>>>>>>> origin/master
            }
            return false;
        }
<<<<<<< HEAD
        else{
            throw new InvalidMoveException();
        }
       
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        if(isBlack()){
            setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1-2,y1,y1+2),x1,y1,eatablePiece);
            setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1+2,y1,y1+2),x1,y1,eatablePiece);
        }else{
            setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1-2,y1,y1-2),x1,y1,eatablePiece);
            setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1+2,y1,y1-2),x1,y1,eatablePiece);
        }
=======
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
        
>>>>>>> origin/master
    }
}
