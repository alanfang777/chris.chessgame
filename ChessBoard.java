
/**
 * Write a description of class ChessBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessBoard
{
    Visualize visualize;
    StoreChess storechess;
    Coordinate2D coordinate2D;
    ChessBoard(){
        visualize=new Visualize();
        storechess = new StoreChess();
        coordinate2D = new Coordinate2D();
        visualize.print(coordinate2D.getStorechess());
    } 
    public void PrintCoordinate(int x,int y){
        coordinate2D.movement(x,y);
        visualize.print(coordinate2D.getStorechess());
    }
}
