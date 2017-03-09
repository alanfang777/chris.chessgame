import java.util.*;
/**
 * Write a description of class StoreChess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoreChess
{
    //This is an ArrayList of the object chess
    ArrayList<Chess> chessarray;
    StoreChess(){
        Side white = new Side("white");
        Side black = new Side("black");
        Pawn wpawn1 = new Pawn(white);
        Pawn wpawn2 = new Pawn(white);
        Pawn wpawn3 = new Pawn(white);
        Pawn wpawn4 = new Pawn(white);
        Pawn wpawn5 = new Pawn(white);
        Pawn wpawn6 = new Pawn(white);
        Pawn wpawn7 = new Pawn(white);
        Pawn wpawn8 = new Pawn(white);
        
        Rook wrook1 = new Rook(white);
        Knight wknight1 = new Knight(white);
        Bishop wbishop1 = new Bishop(white);
        Knight wknight2=new Knight(white);
        King wking1 = new King(white);
        Queen wqueen1 = new Queen(white);
        Rook wrook2 = new Rook(white);
        Bishop wbishop2 = new Bishop(white);
        
        Pawn bpawn1 = new Pawn(black);
        Pawn bpawn2 = new Pawn(black);
        Pawn bpawn3 = new Pawn(black);
        Pawn bpawn4 = new Pawn(black);
        Pawn bpawn5 = new Pawn(black);
        Pawn bpawn6 = new Pawn(black);
        Pawn bpawn7 = new Pawn(black);
        Pawn bpawn8 = new Pawn(black);
        
        
        
        Knight bknight1=new Knight(black);
        King bking1 = new King(black);
        Queen bqueen1 = new Queen(black);
        Rook brook1 = new Rook(black);
        Bishop bbishop1 = new Bishop(black);
        Knight bknight2 = new Knight(black);
        Rook brook2 = new Rook(black);
        Bishop bbishop2 = new Bishop(black);
        
        
        
        chessarray = new ArrayList();
        chessarray.add(wrook1);
        chessarray.add(wknight1);
        chessarray.add(wbishop1);
        chessarray.add(wqueen1);
        chessarray.add(wking1);
        chessarray.add(wbishop2);
        chessarray.add(wknight2);
        chessarray.add(wrook2);
        
        chessarray.add(wpawn1);
        chessarray.add(wpawn2);
        chessarray.add(wpawn3);
        chessarray.add(wpawn4);
        chessarray.add(wpawn5);
        chessarray.add(wpawn6);
        chessarray.add(wpawn7);
        chessarray.add(wpawn8);
        
        chessarray.add(bpawn8);
        chessarray.add(bpawn7);
        chessarray.add(bpawn6);
        chessarray.add(bpawn5);
        chessarray.add(bpawn4);
        chessarray.add(bpawn3);
        chessarray.add(bpawn2);
        chessarray.add(bpawn1);
        
        
        chessarray.add(brook2);
        chessarray.add(bknight2);
        chessarray.add(bbishop2);
        chessarray.add(bking1);
        chessarray.add(bqueen1);
        chessarray.add(bbishop1);
        chessarray.add(bknight1);
        chessarray.add(brook1);
    }
    public boolean pieceBehavior(int origin, int destination){
        return chessarray.get(origin).behavior(origin, destination);
    }
}
