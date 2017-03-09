import java.util.*;
/**
 * Write a description of class Coordinate2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinate2D
{
    //This ArrayList stores the coordinate which is also object of the chessboard
    Coordinate[][] chess;
    StoreChess storechess;
    Coordinate2D()
    {
        storechess = new StoreChess();
        chess = new Coordinate[8][8];
        int x=0;
        int y=0;
        int num=31;
        while(num>=0){
            if(y<=1||y>=6){
                chess[y][x]=new Coordinate(storechess.chessarray.get(num));
                num--;
            }else{
                chess[y][x]=null;
            }
            x++;
            if(x==8){
                x=0;
                y++;
            }
            
        }
    }
    
    public Coordinate[][] getStorechess(){
        return chess;
    }
    public Coordinate getCoordinate(int x,int y)
    {
        return chess[x][y];
    }
    public void movement(int origin,int destination)
    {
        //if(impediment(origin, destination)||storechess.pieceBehavior(origin, destination)){
            if(chess[Main.y2][Main.x2]==null){
                Coordinate intermediate = chess[Main.y1][Main.x1];
                chess[Main.y1][Main.x1] = chess[Main.y2][Main.x2];
                chess[Main.y2][Main.x2] = intermediate;
            }else{
                chess[Main.y2][Main.x2] = chess[Main.y1][Main.x1];
                chess[Main.y1][Main.x1] = null;
            }
        //}else{
        //    System.out.println("You failed to change the coordinate of the piece");
        //}
    }
    /*public boolean impediment(int origin, int destination){
        int x1=origin%8;
        int x2=destination%8;
        int y1=origin/8;
        int y2=destination/8;
        if(y1==y2){
            return iteration(x1,x2,y1,false);
        }else if(x1==x2){
            return iteration(y1,y2,x1,true);
        }else if(Math.abs(x1-x2)==Math.abs(y1-y2)){
            int x;
            int y;
            if(x1<x2&&y1<y2){
                return iteration(x1,x2,y1,y2);
            }else if(x1>x2&&y1<y2){
                return iteration(x2,x1,y1,y2);
            }else if(x1<x2&&y1>y2){
                return iteration(x1,x2,y2,y1);
            }else if(x1>x2&&y1>y2){
                return iteration(x2,x1,y2,y1);
            }
        }
        return true;
    }*/
    /*private boolean iteration(int min_x, int max_x, int min_y,int max_y){
        int x=min_x;
        int y=min_y;
        while(x<max_x){
            x++;
            y++;
            if(chess[y][x]!=null){
                return false;
            }
        }
        return true;
    }
    private boolean iteration(int min, int max,int fix,boolean x_or_y){
        for(int i=min;i<max;i++){
            if(x_or_y&&chess.get(min*8+fix)!=null){
                return false;
            }else if(!x_or_y&&chess.get(min+fix*8)!=null){
                return false;
            }
        }
        return false;
    }*/
}