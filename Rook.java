import java.util.*;
import Exceptions.*;
/**
 * Write a description of class Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook extends Piece
{
    int intact;
    Rook(Side side,Piece[][] coordinate,ArrayList threateningPiece){
        super(side,coordinate,threateningPiece);
        intact=0;
    }
    public String toString()
    {
        if(isBlack()){
            return "[BRk]";
        }else if(isWhite()){
            return "[WRk]";
        }
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2) throws InvalidMoveException{
        if(isHorizontalOrVerticalMovementValid(x1,x2,y1,y2)){
            if(getCoordinate()[y1][x1].isPieceInBetween(x1,x2,y1,y2) == null){
                setIntact(1);
            }
            return true;
        }
        else{
            throw new InvalidMoveException();
        }
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1,y1,-1),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,-1,y1,y1),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1,y1,8),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,8,y1,y1),x1,y1,eatablePiece);
    }
    private boolean isHorizontalOrVerticalMovementValid(int x1,int x2,int y1,int y2){
        return x1==x2||y1==y2;
    }
}
