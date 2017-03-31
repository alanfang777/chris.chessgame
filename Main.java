import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
     public static void main(String[] orgs){
         int x1=0;
         int x2=0;
         int y1=0;
         int y2=0;
         Scanner in = new Scanner(System.in);
         boolean works = true;
        System.out.println("Welcome to alan.chessgame v1.0.0");
           ChessBoard chessboard=new ChessBoard();
           PlayerInput palyerinput= new PlayerInput();
             System.out.println("Please enter the first player's name");
             String name1= in.nextLine();
             System.out.println("Please enter the second player's name");
             String name2=in.nextLine();
             int sequence = 0;
         while(works)
         {
             if(sequence==0)
             {
                 sequence++;
                 System.out.println("Now it's "+name1+"'s turn");
             }
             else if(sequence==1)
             {
                 sequence--;
                 System.out.println("Now it's "+name2+"'s turn");
             }
             System.out.println("Now please input your piece and destination"); 
             System.out.println("The right command is: goto/quit");
             String input = in.nextLine();
             if(input.substring(0,4).equals("goto"))
             {
                 if(input.charAt(5)>=65 && input.charAt(5)<=72)
                 {
                    x1=input.charAt(5)-65;
                 }
                 if(input.charAt(6)>=49 && input.charAt(6)<=56)
                 {
                     y1=input.charAt(6)-49;
                 }
                 {
                     x2=input.charAt(8)-65;
                 }
                 if(input.charAt(9)>=49 && input.charAt(9)<=56)
                 {
                     y2=input.charAt(9)-49;
                 }
             }
             else if(input.equals("quit"))
             {
                 works=false;
             }
             chessboard.printCoordinate(x1,x2,y1,y2);
        }
      }
}
