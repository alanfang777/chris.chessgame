import java.util.*;
import Exceptions.*;
/**
 * Write a description of class Coordinate2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinate2D
{
    private Piece[][] piece;
    Coordinate2D(ArrayList threateningPiece1,ArrayList threateningPiece2)
    {
        Side white = new Side("white");
        Side black = new Side("black");
        piece = new Piece[8][8];
<<<<<<< HEAD
        int y=0;
        while(y<8){
            if(y==0){
                piece[y][0] = new Rook(black,piece,threateningPiece2);
                piece[y][1] = new Knight(black,piece,threateningPiece2);
                piece[y][2] = new Bishop(black,piece,threateningPiece2);
                piece[y][3] = new Queen(black,piece,threateningPiece2);
                piece[y][4] = new King(black,piece,threateningPiece2);
                piece[y][5] = new Bishop(black,piece,threateningPiece2);
                piece[y][6] = new Knight(black,piece,threateningPiece2);
                piece[y][7] = new Rook(black,piece,threateningPiece2);
                y++;
            }else if(y==1){
                for(int x=0;x<8;x++){
                     piece[y][x] = new Pawn(black,piece,threateningPiece2);
                }
                y++;
            }else if(y==6){
                for(int x=0;x<8;x++){
                    piece[y][x] = new Pawn(white,piece,threateningPiece1);
                }
                y++;
            }else if(y==7){
                piece[y][0] = new Rook(white,piece,threateningPiece1);
                piece[y][1] = new Knight(white,piece,threateningPiece1);
                piece[y][2] = new Bishop(white,piece,threateningPiece1);
                piece[y][3] = new Queen(white,piece,threateningPiece1);
                piece[y][4] = new King(white,piece,threateningPiece1);
                piece[y][5] = new Bishop(white,piece,threateningPiece1);
                piece[y][6] = new Knight(white,piece,threateningPiece1);
                piece[y][7] = new Rook(white,piece,threateningPiece1);
                y++;
            }else if(y>1&&y<6){
                for(int t=2;t<6;t++){
                    for(int i=0;i<8;i++){
                        piece[t][i] = null;
                    }
                }
                y=6;
            }
        }
        }
=======
        piece[7][0]= new Rook(white,piece);
        piece[0][0]= new Rook(black,piece);
        }
>>>>>>> origin/master
    public Piece[][] getPieceArray(){
        return piece;
    }
    public boolean movePiece(int x1,int x2,int y1,int y2)
    {
<<<<<<< HEAD
        try{
            piece[y1][x1].isAllowed(x1,x2,y1,y2);
        }
        catch(InvalidMoveException e){
            System.out.println("This is not a valid move");
        }
        if(piece[y1][x1].isPieceInBetween(x1,x2,y1,y2) == null){
            if(piece[y2][x2]==null || !piece[y1][x1].getSide().getSide().equals(piece[y2][x2].getSide().getSide())){
                piece[y2][x2] = piece[y1][x1];
                piece[y1][x1] = null;
                try{
                        piece[y2][x2].isKingBeenThreaten();
                    }
                    catch(InvalidMoveException e){
                        System.out.println("King is Threaten!");
                         piece[y1][x1] = piece[y2][x2];
                         piece[y2][x2] = null;
                         return false;
=======
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
>>>>>>> origin/master
            }
        }
       return true;
    }
    return false;
    }
}
