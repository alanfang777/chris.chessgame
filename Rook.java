import java.util.*;
/**
 * Write a description of class Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook extends Piece
{
    int intact;
    Rook(Side side,Piece[][] coordinate){
        super(side,coordinate);
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
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if(isHorizontalOrVerticalMovementValid(x1,x2,y1,y2)){
            return true;
        }
        return false;
    }
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        if(isPieceInBetween_2(x1,x1,y1,y1-8)!=null){
            System.out.println(getSide().getSide()+" 1");
            System.out.println(isPieceInBetween_2(x1,x1,y1,y1-8).toString());
            eatablePiece.add(isPieceInBetween_2(x1,x1,y1,y1-8).toString());
        }else if(isPieceInBetween_2(x1,x1-8,y1,y1)!=null){
            System.out.println(getSide().getSide()+" 2");
            System.out.println(isPieceInBetween_2(x1,x1-8,y1,y1).toString());
            eatablePiece.add(isPieceInBetween_2(x1,x1-8,y1,y1).toString());
        }else if(isPieceInBetween_2(x1,x1,y1,y1+8)!=null){
            System.out.println(getSide().getSide()+" 3");
            System.out.println(isPieceInBetween_2(x1,x1,y1,y1+8).toString());
            eatablePiece.add(isPieceInBetween_2(x1,x1,y1,y1+8).toString());
        }else if(isPieceInBetween_2(x1,x1+8,y1,y1)!=null){
            System.out.println(getSide().getSide()+" 4");
            System.out.println(isPieceInBetween_2(x1,x1+8,y1,y1).toString());
            eatablePiece.add(isPieceInBetween_2(x1,x1+8,y1,y1).toString());
        }
    }
    private boolean isHorizontalOrVerticalMovementValid(int x1,int x2,int y1,int y2){
        return x1==x2||y1==y2;
    }
}
