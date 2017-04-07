import java.util.ArrayList;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//main
public class Main
{
     public static void main(){
         /*
         Scanner in = new Scanner(System.in);
         boolean works = true;
          System.out.println("Welcome to alan.chessgame v1.0.0");
           ChessBoard chessboard=new ChessBoard();
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
                 if(input.charAt(6)>=48 && input.charAt(6)<=55)
                 {
                     y1=input.charAt(6)-49;
                 }
                 if(input.charAt(8)>=65 && input.charAt(8)<=72)
                 {
                     x2=input.charAt(8)-65;
                 }
                 if(input.charAt(9)>=48 && input.charAt(9)<=55)
                 {
                     y2=input.charAt(9)-49;
                 }
             }
             else if(input.equals("quit"))
             {
                 works=false;
             }
             if(sequence==1 && chessboard.coordinate2D.getCoordinate(x1,y1).getChess().getSide().equals("white")){
             chessboard.PrintCoordinate(convertion(x1,y1),convertion(x2,y2));
            }
            else if(sequence==0 && chessboard.coordinate2D.getCoordinate(x1,y1).getChess().getSide().equals("black")){
             chessboard.PrintCoordinate(convertion(x1,y1),convertion(x2,y2));
            }
            else{
                System.out.println("This is not the piece of your side");
                if(sequence==1)
                {
                    sequence=0;
                }
                else if(sequence==0)
                {
                    sequence=1;
                }
            }
        }
      }
         public static int convertion(int x, int y ) {
         return x+y*8;
     }
     */
     ConsoleManager.console();
   }
}