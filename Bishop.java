import java.util.*;
import Exceptions.*;
/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends Piece
{
    Bishop(Side side,Piece[][] coordinate,ArrayList threateningPiece){
        super(side,coordinate,threateningPiece);
    }
    public String toString()
    {
        if(super.getSide()==null){
        }else{
            if(super.getSide().getSide().equals("Black")||super.getSide().getSide().equals("black"))
            {
                return "[BBp]";
            }else if(super.getSide().getSide().equals("White")||super.getSide().getSide().equals("white")){
                return "[WBp]";
            }
        }
        return null;
    }
    public boolean isAllowed(int x1,int x2,int y1,int y2) throws InvalidMoveException{
        if(isSlantMovementValid(x1,x2,y1,y2)){
            return true;
        }
        else {
            throw new InvalidMoveException();
        }
        
    }
    private boolean isSlantMovementValid(int x1,int x2,int y1,int y2){
        return Math.abs(x1-x2)==Math.abs(y1-y2);
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        int x=x1;
        int y=y1;
        while(x1<8&&y1<8){
            x1++;
            y1++;
        }
        setEatablePieceOrThreateningPiece(isPieceInBetween(x,x1,y,y1),x,y,eatablePiece);
        x1=x;
        y1=y;
        while(x1<8&&y1>-1){
            x1++;
            y1--;
        }
        setEatablePieceOrThreateningPiece(isPieceInBetween(x,x1,y,y1),x,y,eatablePiece);
        x1=x;
        y1=y;
        while(x1>-1&&y1>-1){
            x1--;
            y1--;
        }
        setEatablePieceOrThreateningPiece(isPieceInBetween(x,x1,y,y1),x,y,eatablePiece);
        x1=x;
        y1=y;
        while(x1>-1&&y1<8){
            x1--;
            y1++;
        }
        setEatablePieceOrThreateningPiece(isPieceInBetween(x,x1,y,y1),x,y,eatablePiece);
        x1=x;
        y1=y;
    }
}
