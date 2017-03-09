import java.util.*;
/**
 * Write a description of class Visualize here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Visualize
{
    public void print(Coordinate[][] arr){
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(arr[y][x]==null){
                    System.out.print("[   ]");
                }else{
                    System.out.print(arr[y][x].getChess().toString());
                }
            }
            System.out.println();
        }
    }
}
