
/**
 * Write a description of class Coordinate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinate
{
    Chess chess;
    Coordinate(){
        chess=null;
    }
    Coordinate(Chess chess){
        this.chess=chess;
    }
    public Chess getChess(){
        return chess;
    }
    public void setChess(Chess chess){
        this.chess=chess;
    }
}
