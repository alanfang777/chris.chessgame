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
    ChessBoard(){
        visualize=new Visualize();
        coordinate2D = new Coordinate2D();
        visualize.print(coordinate2D.getPieceArray());
    }
    public void printCoordinate(int x1,int x2,int y1,int y2){
        if(coordinate2D.getPieceArray()[y1][x1]!=null){
            coordinate2D.movePiece(x1,x2,y1,y2);
            visualize.print(coordinate2D.getPieceArray());
        }else{
            System.out.println("we have no piece on this cooridnate!!!");
        }
    }
}