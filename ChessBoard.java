import java.util.*;
import Exceptions.*;
/**
 * Write a description of class ChessBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessBoard
{
    private Visualize visualize;
    private Coordinate2D coordinate2D;
    ChessBoard(ArrayList threateningPiece1,ArrayList threateningPiece2){
        visualize=new Visualize();
        coordinate2D = new Coordinate2D(threateningPiece1,threateningPiece2);
        visualize.print(coordinate2D.getPieceArray());
    }
    public boolean printCoordinate(int x1,int x2,int y1,int y2,int sequence) {
        if(coordinate2D.getPieceArray()[y1][x1]==null){
              System.out.println("we have no piece on this cooridnate!!!");
        }else if((sequence==0 && coordinate2D.getPieceArray()[y1][x1].getSide().getSide().equals("black")) || (sequence==1 && coordinate2D.getPieceArray()[y1][x1].getSide().getSide().equals("white"))){
              coordinate2D.movePiece(x1,x2,y1,y2);
              visualize.print(coordinate2D.getPieceArray());
              return true;
        }
        else{
            System.out.println("You have pick the wrong turn");
        }
        return false;
    }
}