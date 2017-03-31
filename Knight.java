import java.util.*;
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Piece
{
    Knight(Side side,Piece[][] coordinate){
        super(side,coordinate);
    }
    public String toString()
    {
        if(isBlack()){
            return "[BKt]";
        }else if(isWhite()){
            return "[WKt]";
        }
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if(isSlantMovementValid(x1,x2,y1,y2)){
            return true;
        }
        return false;
    }
    private boolean isSlantMovementValid(int x1,int x2,int y1,int y2){
        return (Math.abs(x1-x2)==2&&Math.abs(y1-y2)==1) || (Math.abs(y1-y2)==2&&Math.abs(x1-x2)==1);
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        eatablePiece.add(isPieceInBetween_2(x1,x1+3,y1,y1+2));
        eatablePiece.add(isPieceInBetween_2(x1,x1-3,y1,y1-2));
        eatablePiece.add(isPieceInBetween_2(x1,x1+3,y1,y1-2));
        eatablePiece.add(isPieceInBetween_2(x1,x1-3,y1,y1+2));
        eatablePiece.add(isPieceInBetween_2(x1,x1+2,y1,y1-3));
        eatablePiece.add(isPieceInBetween_2(x1,x1-2,y1,y1+3));
        eatablePiece.add(isPieceInBetween_2(x1,x1+2,y1,y1+3));
        eatablePiece.add(isPieceInBetween_2(x1,x1-2,y1,y1-3));
    }
}
