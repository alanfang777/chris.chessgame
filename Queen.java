import java.util.*;
/**
 * Write a description of class Queen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queen extends Piece
{
    Queen(Side side,Piece[][] coordinate){
        super(side,coordinate);
    }
    @Override
    public String toString()
    {
        if(super.getSide()==null){
        }else{
            if(isBlack())
            {
                return "[BQn]";
            }else if(isWhite()){
                return "[WQn]";
            }
        }
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if(isHorizontalOrVerticalMovementValid(x1,x2,y1,y2)){
            return true;
        }else if(isSlantMovementValid(x1,x2,y1,y2)){
            return true;
        }
        return false;
    }
    private boolean isHorizontalOrVerticalMovementValid(int x1,int x2,int y1,int y2){
        return x1==x2||y1==y2;
    }
    private boolean isSlantMovementValid(int x1,int x2,int y1,int y2){
        return Math.abs(x1-x2)==Math.abs(y1-y2);
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        eatablePiece.add(isPieceInBetween_2(x1,x1+8,y1,y1+8));
        eatablePiece.add(isPieceInBetween_2(x1,x1-8,y1,y1+8));
        eatablePiece.add(isPieceInBetween_2(x1,x1-8,y1,y1-8));
        eatablePiece.add(isPieceInBetween_2(x1,x1+8,y1,y1-8));
        eatablePiece.add(isPieceInBetween_2(x1,x1,y1,-1));
        eatablePiece.add(isPieceInBetween_2(x1,-1,y1,y1));
        eatablePiece.add(isPieceInBetween_2(x1,x1,y1,8));
        eatablePiece.add(isPieceInBetween_2(x1,8,y1,y1));
    }
}
