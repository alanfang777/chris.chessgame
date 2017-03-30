package Exceptions;


/**
 * Write a description of class InvalidMoveException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvalidMoveException extends Exception
{
   public InvalidMoveException()
   {
       super();
       System.out.println("the piece doesn't exist");
   }
}
