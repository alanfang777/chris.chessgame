
/**
 * Write a description of class PlayerInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerInput
{
    private static int maxPlayerNumber;
    private Player player1;
    private Player player2;
    public PlayerInput(Player player1,Player player2)
    {
        this.player1=player1;
        this.player2=player2;
        maxPlayerNumber++;     
    }
    public void setName(String name1,String name2)
    {
        player1.setName(name1);
        player2.setName(name2);
    }
    public void getPlayerName(int playerNumber)
    {
        if(playerNumber==1)
            player1.getName();
        else if(playerNumber==2)
            player2.getName();
    }
}
