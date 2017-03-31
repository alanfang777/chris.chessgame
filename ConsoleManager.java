import java.util.Scanner;
/**
 * Write a description of class ConsoleManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConsoleManager
{
    public static void console()
    {
        ChessBoard chessBoard=new ChessBoard();
        Scanner in=new Scanner(System.in);
        String name1;
        String name2;
        int sequence=0;
        boolean keepGaming=true;
        gameConsoleStarter();
        System.out.println("Please eneter player1's name:");
        name1=in.nextLine();
        System.out.println("Please eneter player2's name:");
        name2=in.nextLine();
        while(keepGaming)
        {
            int x1=0;
            int x2=0;
            int y1=0;
            int y2=0;
            if(sequence==0)
            {
                 System.out.println("This is "+name1+"'s turn");
                 sequence++;
            }
            else if(sequence==1)
            {
                System.out.println("This is "+name2+"'s turn");
                sequence--;
            }     
            System.out.println("Please enter your origin and destination");
            System.out.println("The right command is goto/quit");
            String command=in.nextLine();
            if(command.equals("quit"))
            {
                keepGaming=false;
            }
            else if(command.substring(0,3).equals("goto"))
            {
                if(isCoordinateInRange(command.charAt(5),"x"))
                     x1=convertToAscii(command.charAt(5));
                if(isCoordinateInRange(command.charAt(6),"y"))
                     y1=convertToAscii(command.charAt(6));
                if(isCoordinateInRange(command.charAt(8),"x"))
                     x2=convertToAscii(command.charAt(8));
                if(isCoordinateInRange(command.charAt(9),"y"))
                     y2=convertToAscii(command.charAt(9));
            }
            chessBoard.printCoordinate(x1,y1,x2,y2);
        }
    }
    public static void gameConsoleStarter()
    {
        System.out.println("Welcome to Alan's chessgame v1.0.1");
        System.out.println("**********************************");
        System.out.println("Console construction complete!");       
    }
    public static int convertToAscii(char coordinate)
    {
        if(coordinate>=65 && coordinate <=72)
            return coordinate-65;
        else if(coordinate>=49 && coordinate<=55) 
            return coordinate-49;
        
        return 0;
    }
    public static boolean isCoordinateInRange(char coordinate,String axis)
    {
        if(coordinate>=65 && coordinate<=72 && axis.equals("x"))
             return true;
       else if(coordinate>=48 && coordinate<=55 && axis.equals("y"))
            return true;
            
       return false;     
    }
    
}
