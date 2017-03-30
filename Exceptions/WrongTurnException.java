package Exceptions;


/**
 * Write a description of class WrongTurnException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WrongTurnException extends Exception
{
    public WrongTurnException()
    {
        super();
        System.out.println("The piece that you've selected is not your side");
    }
}
