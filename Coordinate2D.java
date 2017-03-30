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
        int y=0;
        while(y<8){
            if(y==0){
                piece[y][0] = new Rook(black);
                piece[y][1] = new Knight(black);
                piece[y][2] = new Bishop(black);
                piece[y][3] = new King(black);
                piece[y][4] = new Queen(black);
                piece[y][5] = new Bishop(black);
                piece[y][6] = new Knight(black);
                piece[y][7] = new Rook(black);
                y++;
            }else if(y==1){
                for(int x=0;x<8;x++){
                     piece[y][x] = new Pawn(black,piece);
                }
                y++;
            }else if(y==6){
                for(int x=0;x<8;x++){
                    piece[y][x] = new Pawn(white,piece);
                }
                y++;
            }else if(y==7){
                piece[y][0] = new Rook(white);
                piece[y][1] = new Knight(white);
                piece[y][2] = new Bishop(white);
                piece[y][3] = new Queen(white);
                piece[y][4] = new King(white);
                piece[y][5] = new Bishop(white);
                piece[y][6] = new Knight(white);
                piece[y][7] = new Rook(white);
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
    public Piece[][] getPieceArray(){
        return piece;
    }
    public boolean movePiece(int x1,int x2,int y1,int y2)
    {
        if(piece[y1][x1].isAllowed(x1,x2,y1,y2) && piece[y2][x2].isPieceInBetween(x1,x2,y1,y2) == null){
            if(piece[y2][x2]==null){
                piece[y2][x2] = piece[y1][x1];
                piece[y1][x1] = null;
                return true;
            }else{
                piece[y2][x2] = piece[y1][x1];
                 piece[y1][x1] = null;
                 return true;
            }
        }
        System.out.println("fail to move the piece");
        return false;
    }
}