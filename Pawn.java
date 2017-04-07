import java.util.*;
import Exceptions.*;
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece
{
    Pawn(Side side,Piece[][] piece,ArrayList threateningPiece){
        super(side,piece,threateningPiece);
    }
    public String toString()
    {
        if(super.getSide()==null){
        }else{
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
            }
            return false;
        }
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
    }
}
