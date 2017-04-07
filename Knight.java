import java.util.*;
import Exceptions.*;
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Piece
{
    Knight(Side side,Piece[][] coordinate,ArrayList threateningPiece){
        super(side,coordinate,threateningPiece);
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
    public boolean isAllowed(int x1,int x2,int y1,int y2) throws InvalidMoveException{
        if(isSlantMovementValid(x1,x2,y1,y2)){
            return true;
        }
        else
        {
            throw new InvalidMoveException();
        }
    }
    private boolean isSlantMovementValid(int x1,int x2,int y1,int y2){
        return (Math.abs(x1-x2)==2&&Math.abs(y1-y2)==1) || (Math.abs(y1-y2)==2&&Math.abs(x1-x2)==1);
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(x1,y1,eatablePiece);
    }
    private void setEatablePieceOrThreateningPiece(int x1,int y1,ArrayList eatablePiece){
        try{
            if(getCoordinate()[y1+2][x1+1] !=null && !getCoordinate()[y1+2][x1+1].getSide().getSide().equals(getCoordinate()[y1][x1].getSide().getSide())){
                eatablePiece.add(getCoordinate()[y1+2][x1+1]);
                if(isKing(getCoordinate()[y1+2][x1+1])){
                    setThreateningPiece(y1+""+x1);
                }
            }
        }catch(IndexOutOfBoundsException e){
        }
    }
}
