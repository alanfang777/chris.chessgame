import java.util.*;
<<<<<<< HEAD
import Exceptions.*;
=======
>>>>>>> origin/master
/**
 * Write a description of class King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends Piece
{
<<<<<<< HEAD
    King(Side side,Piece[][] coordinate,ArrayList threateningPiece){
        super(side,coordinate,threateningPiece);
=======
    King(Side side,Piece[][] coordinate){
        super(side,coordinate);
>>>>>>> origin/master
        super.setIntact(0);
    }
    public String toString()
    {
        if(isBlack())
        {
           return "[BKg]";
        }else if(isWhite()){
           return "[WKg]";
        }   
        return null;
    }
<<<<<<< HEAD
    public boolean isAllowed(int x1,int x2,int y1,int y2) throws InvalidMoveException{
        if((isHorizontalMovementValid(x1,x2) || isVerticalMovementValid(y1,y2))){
            if(getCoordinate()[y1][x1].isPieceInBetween(x1,x2,y1,y2) == null){
                setIntact(1);
            }
            return true;
        }else if(isSlantMovementValid(x1,x2,y1,y2) ){
            if(getCoordinate()[y1][x1].isPieceInBetween(x1,x2,y1,y2) == null){
                setIntact(1);
            }
=======
    public boolean isAllowed(int x1,int x2,int y1,int y2){
        if((isHorizontalMovementValid(x1,x2) || isVerticalMovementValid(y1,y2))){
            setIntact(1);
            return true;
        }else if(isSlantMovementValid(x1,x2,y1,y2) ){
            setIntact(1);
            return true;
        }else if(super.isItCastling(x1,x2,y1,y2,super.getSide())){
            setIntact(1);
>>>>>>> origin/master
            return true;
        }else if(isCastling(x1,x2,y1,y2,getSide())){
                getCoordinate()[y1][x1]=getCoordinate()[y2][x2];
                getCoordinate()[y2][x2]=null;
                getCoordinate()[y1][x1].setIntact(1);
                return true;
        }
        else
        {
            throw new InvalidMoveException();
        }
           
        }
    
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1+2,y1,y1+2),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1+2,y1,y1-2),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1-2,y1,y1-2),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1-2,y1,y1+2),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1+2,y1,y1),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1,y1,y1+2),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1-2,y1,y1),x1,y1,eatablePiece);
        setEatablePieceOrThreateningPiece(isPieceInBetween(x1,x1,y1,y1-2),x1,y1,eatablePiece);
    }
<<<<<<< HEAD
=======
    public void addingEatablePiece(int x1,int y1,ArrayList eatablePiece){
        eatablePiece.add(isPieceInBetween_2(x1,x1+2,y1,y1+2));
        eatablePiece.add(isPieceInBetween_2(x1,x1+2,y1,y1-2));
        eatablePiece.add(isPieceInBetween_2(x1,x1-2,y1,y1+2));
        eatablePiece.add(isPieceInBetween_2(x1,x1-2,y1,y1-2));
        eatablePiece.add(isPieceInBetween_2(x1,x1+2,y1,y1));
        eatablePiece.add(isPieceInBetween_2(x1,x1-2,y1,y1));
        eatablePiece.add(isPieceInBetween_2(x1,x1,y1,y1+2));
        eatablePiece.add(isPieceInBetween_2(x1,x1,y1,y1-2));
    }
>>>>>>> origin/master
    private boolean isHorizontalMovementValid(int x1,int x2){
        return Math.abs(x1-x2)==1;
    }
    private boolean isVerticalMovementValid(int y1,int y2){
        return Math.abs(y1-y2)==1;
    }
    private boolean isSlantMovementValid(int x1,int x2,int y1,int y2){
        return (Math.abs(y1-y2)==1 && Math.abs(x1-x2)==1);
<<<<<<< HEAD
    }
    private boolean isCastling(int x1,int x2,int y1,int y2,Side side) throws InvalidMoveException{
        if(getCoordinate()[y1][x1].getIntact()==0){
            if(y2==7){
                    if(x2==2 && getCoordinate()[7][4] != null && getCoordinate()[7][4].toString().equals("[WKg]") && getCoordinate()[7][0].getIntact()==0 && getCoordinate()[7][0]!=null && getCoordinate()[7][1]==null && getCoordinate()[7][2]==null && getCoordinate()[7][3]==null){
                        getCoordinate()[y2][x2]=getCoordinate()[y1][x1];
                        getCoordinate()[y1][x1]=null;
                        getCoordinate()[7][3]=getCoordinate()[7][0];
                        getCoordinate()[7][0]=null;
                        if(isKingBeenThreaten()){
                            getCoordinate()[y1][x1]=getCoordinate()[y2][x2];
                            getCoordinate()[y2][x2]=null;
                            getCoordinate()[7][0]=getCoordinate()[7][3];
                            getCoordinate()[7][3]=null;
                        }else{
                            getCoordinate()[7][3].setIntact(1);
                            return true; 
                        }
                    }
                    if(x2==6 && getCoordinate()[7][0]!=null && getCoordinate()[7][7].toString().equals("[WRk]") && getCoordinate()[7][7].getIntact()==0 && getCoordinate()[7][5]==null && getCoordinate()[7][6]==null){
                        getCoordinate()[y2][x2]=getCoordinate()[y1][x1];
                        getCoordinate()[y1][x1]=null;
                        getCoordinate()[7][5]=getCoordinate()[7][7];
                        getCoordinate()[7][7]=null;
                        if(isKingBeenThreaten()){
                            getCoordinate()[y1][x1]=getCoordinate()[y2][x2];
                            getCoordinate()[y2][x2]=null;
                            getCoordinate()[7][7]=getCoordinate()[7][5];
                            getCoordinate()[7][5]=null;
                        }else{
                            getCoordinate()[7][5].setIntact(1);
                            return true;
                        }
                    }
            }else if(y2==0){
                    if(x2==2 && getCoordinate()[0][0]!=null && getCoordinate()[0][0].toString().equals("[BRk]") && getCoordinate()[0][0].getIntact()==0 && getCoordinate()[0][1]==null && getCoordinate()[0][2]==null && getCoordinate()[0][3]==null){
                        getCoordinate()[y2][x2]=getCoordinate()[y1][x1];
                        getCoordinate()[y1][x1]=null;
                        getCoordinate()[0][3]=getCoordinate()[0][0];
                        getCoordinate()[0][0]=null;
                        if(isKingBeenThreaten()){
                            getCoordinate()[y1][x1]=getCoordinate()[y2][x2];
                            getCoordinate()[y2][x2]=null;
                            getCoordinate()[0][0]=getCoordinate()[0][3];
                            getCoordinate()[0][3]=null;
                        }else{
                            getCoordinate()[0][3].setIntact(1);
                            return true;
                        }
                    }
                    if(x2==6 && getCoordinate()[0][7]!=null && getCoordinate()[0][7].toString().equals("[BRk]") && getCoordinate()[0][7].getIntact()==0 && getCoordinate()[7][5]==null && getCoordinate()[7][6]==null){
                        getCoordinate()[y2][x2]=getCoordinate()[y1][x1];
                        getCoordinate()[y1][x1]=null;
                        getCoordinate()[0][5]=getCoordinate()[0][7];
                        getCoordinate()[0][7]=null;
                        if(isKingBeenThreaten()){
                            getCoordinate()[y1][x1]=getCoordinate()[y2][x2];
                            getCoordinate()[y2][x2]=null;
                            getCoordinate()[0][7]=getCoordinate()[0][5];
                            getCoordinate()[0][5]=null;
                        }else{
                            getCoordinate()[0][5].setIntact(1);
                            return true;
                        }
                    }
            }
        }
        return false;
=======
>>>>>>> origin/master
    }
}