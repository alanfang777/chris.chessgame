import java.util.*;
<<<<<<< HEAD
import Exceptions.*;
=======
>>>>>>> origin/master
/**
 * Write a description of class Queen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queen extends Piece
{
<<<<<<< HEAD
    Queen(Side side,Piece[][] coordinate,ArrayList threateningPiece){
        super(side,coordinate,threateningPiece);
=======
    Queen(Side side,Piece[][] coordinate){
        super(side,coordinate);
>>>>>>> origin/master
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
<<<<<<< HEAD
    public boolean isAllowed(int x1,int x2,int y1,int y2) throws InvalidMoveException{
=======
    public boolean isAllowed(int x1,int x2,int y1,int y2){
>>>>>>> origin/master
        if(isHorizontalOrVerticalMovementValid(x1,x2,y1,y2)){
            return true;
        }else if(isSlantMovementValid(x1,x2,y1,y2)){
            return true;
        }
        else
        {
            throw new InvalidMoveException();
        }
        
    }
    private boolean isHorizontalOrVerticalMovementValid(int x1,int x2,int y1,int y2){
        return x1==x2||y1==y2;
    }
    private boolean isSlantMovementValid(int x1,int x2,int y1,int y2){
        return Math.abs(x1-x2)==Math.abs(y1-y2);
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
<<<<<<< HEAD
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
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1,y1,-1),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,-1,y1,y1),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1,y1,8),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,8,y1,y1),x1,y1,eatablePiece);
=======
        eatablePiece.add(isPieceInBetween_2(x1,x1+8,y1,y1+8));
        eatablePiece.add(isPieceInBetween_2(x1,x1-8,y1,y1+8));
        eatablePiece.add(isPieceInBetween_2(x1,x1-8,y1,y1-8));
        eatablePiece.add(isPieceInBetween_2(x1,x1+8,y1,y1-8));
        eatablePiece.add(isPieceInBetween_2(x1,x1,y1,-1));
        eatablePiece.add(isPieceInBetween_2(x1,-1,y1,y1));
        eatablePiece.add(isPieceInBetween_2(x1,x1,y1,8));
        eatablePiece.add(isPieceInBetween_2(x1,8,y1,y1));
>>>>>>> origin/master
    }
}
