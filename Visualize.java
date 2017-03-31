import java.util.*;
/**
 * Write a description of class Visualize here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Visualize
{
    public void print(Piece[][] arr){
            int y=0;
            while(y<=7){
                horizontalPrintPiece(arr,y);
                y++;
            }
    }
    private void horizontalPrintPiece(Piece[][] arr,int y){
        for(int x=0;x<8;x++){
            if(arr[y][x]==null){
                System.out.print("[   ]");
            }else{
                System.out.print(arr[y][x].toString());
            }
            }
        System.out.println();
    }
}
