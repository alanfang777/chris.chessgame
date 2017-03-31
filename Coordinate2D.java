import java.util.*;
/**
 * Write a description of class Coordinate2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinate2D
{
    private Piece[][] piece;
    Coordinate2D()
    {
        Side white = new Side("white");
        Side black = new Side("black");
        piece = new Piece[8][8];
        piece[7][0]= new Rook(white,piece);
        piece[0][0]= new Rook(black,piece);
        }
    public Piece[][] getPieceArray(){
        return piece;
    }
    public boolean movePiece(int x1,int x2,int y1,int y2)
    {
        if(piece[y1][x1].isAllowed(x1,x2,y1,y2) && piece[y1][x1].isPieceInBetween(x1,x2,y1,y2) == null){
            if(piece[y2][x2]==null){
                piece[y2][x2] = piece[y1][x1];
                piece[y1][x1] = null;
                piece[y2][x2].getEatablePiece(x1,y1);
                return true;
            }else{
                piece[y2][x2] = piece[y1][x1];
                 piece[y1][x1] = null;
                 piece[y2][x2].getEatablePiece(x1,y1);
                 return true;
            }
        }
        System.out.println("fail to move the piece");
        return false;
    }
}