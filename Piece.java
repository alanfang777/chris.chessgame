import java.util.*;
import Exceptions.*;
/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Piece
{
    private Side side;
    private int intact;
    private Piece[][] coordinate;
    private ArrayList<Piece> eatablePiece;
    private ArrayList<String> threateningPiece;
    Piece(Side side, Piece[][] coordinate,ArrayList threateningPiece){
        this.side = side;
        this.coordinate = coordinate;
        eatablePiece = new ArrayList();
        this.threateningPiece = threateningPiece;
    }
    public String toString(){
        return null;
    }
    public abstract boolean isAllowed(int x1,int x2,int y1,int y2) throws InvalidMoveException;
    public Side getSide(){
        return side;
    }
    public Piece[][] getCoordinate(){
        return coordinate;
    }
    public boolean isBlack(){
        return side.getSide().equals("Black") || side.getSide().equals("black");
    }
    public boolean isWhite(){
        return side.getSide().equals("White") || side.getSide().equals("white");
    }
    public int getIntact(){
        return intact;
    }
    public void setIntact(int intact){
        this.intact=intact;
    }
    public void setEatablePiece(){
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(coordinate[y][x]!=null){
                    coordinate[y][x].addingEatablePiece(x,y,eatablePiece);
                }
            }
        }
    }
    public ArrayList getEatablePiece(){
        return eatablePiece;
    }
    public boolean isKingBeenThreaten() throws InvalidMoveException{
        setEatablePiece();
        for(int t=0;t<eatablePiece.size();t++){
            if(eatablePiece.get(t)!=null){
                if(eatablePiece.get(t).toString().equals("[WKg]")||eatablePiece.get(t).toString().equals("BKg")){
                    if(isKingBeenCompletelyThreaten(eatablePiece.get(t).getSide().getSide())){
                        System.out.println("Game Over!!!");
                        return false;
                    }
                    eatablePiece.clear();
                    return true;
                }
            }
        }
        eatablePiece.clear();
        return false;
    }
    private boolean isKingBeenThreaten_2(){
        setEatablePiece();
        for(int t=0;t<eatablePiece.size();t++){
            if(eatablePiece.get(t)!=null){
                if(eatablePiece.get(t).toString().equals("[WKg]")||eatablePiece.get(t).toString().equals("WKg")){
                    eatablePiece.clear();
                    return true;
                }
            }
        }
        eatablePiece.clear();
        return false;
    }
    private boolean isKingBeenCompletelyThreaten(String side) throws InvalidMoveException{
        int xOfKing=0;
        int yOfKing=0;
        Piece king;
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(coordinate[y][x]!=null && coordinate[y][x].getSide().getSide().equals(side) && isKing(coordinate[y][x])){
                    xOfKing=x;
                    yOfKing=y;
                    king = coordinate[y][x];
                    if(movePiece(x,x+1,y,y) || movePiece(x,x-1,y,y) || movePiece(x,x,y,y+1) || movePiece(x,x,y,y-1) || movePiece(x,x+1,y,y+1) || movePiece(x,x-1,y,y+1) || movePiece(x,x-1,y,y-1) || movePiece(x,x+1,y,y-1)){
                    }else {
                        int xOfThreateningPiece;
                        int yOfThreateningPiece;
                        for(int t=0;t<threateningPiece.size();t++){
                            xOfThreateningPiece=convertStringToCoordinate(threateningPiece.get(t).substring(1,2));
                            yOfThreateningPiece=convertStringToCoordinate(threateningPiece.get(t).substring(0,1));
                            if(coordinate[yOfThreateningPiece][xOfThreateningPiece]!=null && coordinate[yOfThreateningPiece][xOfThreateningPiece].isPieceInBetween(xOfThreateningPiece,xOfKing,yOfThreateningPiece,yOfKing,side)){
                                
                                return false;
                            }else{
                                return true;
                            }
                        }
                    }
                }
            }
        }
        threateningPiece.clear();
        return false;
    }
    private boolean movePiece(int x1,int x2,int y1,int y2)
    {
       try{
           coordinate[y1][x1].isAllowed(x1,x2,y1,y2);
       }
       catch(InvalidMoveException e)
       {
           System.out.println("This is not a valid move");
           return false;
       }
       if(coordinate[y1][x1].isPieceInBetween(x1,x2,y1,y2) == null && x2>=0 &&x2<8 && y2<=0 && y2>8){
            if(coordinate[y2][x2]==null || !coordinate[y1][x1].getSide().getSide().equals(coordinate[y2][x2].getSide().getSide())){
                coordinate[y2][x2] = coordinate[y1][x1];
                coordinate[y1][x1] = null;
                if(coordinate[y1][x1].isKingBeenThreaten_2()){
                    coordinate[y1][x1] = coordinate[y2][x2];
                    coordinate[y2][x2] = null;
                    return false;
                }
                coordinate[y1][x1] = coordinate[y2][x2];
                coordinate[y2][x2] = null;
                return true;
            }
        }
        return false;
    }
    private int convertStringToCoordinate(String num){
        return Integer.valueOf(num);
    }
    public boolean isKing(Piece piece){
        if(piece.toString().equals("[WKg]")||piece.toString().equals("[BKg]")){
            return true;
        }
        return false;
    }
    public Piece isPieceInBetween(int x1,int x2,int y1,int y2){
        x2=isCoordinateOutOfBound(x2);
        y2=isCoordinateOutOfBound(y2);
        if(y1==y2){
            if(x1<x2){
                return isPieceInFrontOrSide(x1,x2,y1,false);
            }else{
                return isPieceInFrontOrSide_2(x1,x2,y1,false);
            }
        }else if(x1==x2){
            if(y1<y2){
                return isPieceInFrontOrSide(y1,y2,x1,true);
            }else{
                return isPieceInFrontOrSide_2(y1,y2,x1,true);
            }
        }else if(Math.abs(x1-x2)==Math.abs(y1-y2)){
            if(x1<x2&&y1<y2){
                return isPieceInSlantTrajectory(x1,x2,y1,y2);
            }else if(x1>x2&&y1<y2){
                return isPieceInSlantTrajectory(true,x1,x2,y1);
            }else if(x1<x2&&y1>y2){
                return isPieceInSlantTrajectory(false,x1,x2,y1);
            }else if(x1>x2&&y1>y2){
                return isPieceInSlantTrajectory(x2,x1,y2,y1);
            }
        }
        return null;
    }
    private int isCoordinateOutOfBound(int num){
        if(num>7){
            return 8;
        }else if(num<0){
            return -1;
        }
        return num;
    }
    private Piece isPieceInSlantTrajectory(boolean isx1biggerthanx2,int x1,int x2,int y1){
        int x;
        int y;
        if(x1>x2 && isx1biggerthanx2){
            x=x1-1;
            y=y1+1;
            while(x>x2){
                 if(coordinate[y][x]!=null){
                     return coordinate[y][x];
                 }
                 x--;
                 y++;
            }
        }else if(x1<x2 && (!isx1biggerthanx2)){
            x=x1+1;
            y=y1-1;
            while(x<x2){
                if(coordinate[y][x]!=null){
                    return coordinate[y][x];
                }
                x++;
                y--;
            }
        }
        return null;
    }
    private Piece isPieceInSlantTrajectory(int min_x, int max_x, int min_y,int max_y){
        int x=min_x+1;
        int y=min_y+1;
        while(x<max_x){
            if(coordinate[y][x]!=null){
                return coordinate[y][x];
            }
            x++;
            y++;
        }
        return null;
    }
    private Piece isPieceInFrontOrSide(int min, int max,int fix,boolean isFront){
        for(int i=min+1;i<max;i++){
            if(fix<8 && fix>-1 && isFront && coordinate[i][fix] != null){
                return coordinate[i][fix];
            }else if(fix!=8 && fix>-1 && !isFront && coordinate[fix][i] != null){
                return coordinate[fix][i];
            }
        }
        return null;
    }
    private Piece isPieceInFrontOrSide_2(int max,int min,int fix, boolean isFront){
        for(int i=max-1;i>min;i--){
            if(fix<8 && fix>-1 && isFront && coordinate[i][fix] != null){
                return coordinate[i][fix];
            }else if(fix<8 && fix>-1 && !isFront && coordinate[fix][i] != null){
                return coordinate[fix][i];
            }
        }
        return null;
    }
    private void isAllowedToSpecificCoordinate(String side,int x2,int y2){
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(!coordinate[y][x].getSide().getSide().equals(side)){
                    movePiece(x,x2,y,y2);
                }
            }
        }
    }
    abstract void addingEatablePiece(int x1,int y1,ArrayList eatablepiece);
    public void setThreateningPiece(String piece){
       threateningPiece.add(piece);
    }
    public boolean isBelongToMe(Side side){
       return this.side.getSide().equals(side.getSide());
    }
    public void setEatablePieceOrThreateningPiece(Piece piece,int x1,int y1,ArrayList eatablePiece){
        if(piece !=null && !piece.getSide().getSide().equals(getCoordinate()[y1][x1].getSide().getSide())){
            eatablePiece.add(piece);
            if(isKing(piece)){
                setThreateningPiece(y1+""+x1);
            }
        }
    }
    public boolean isPieceInBetween(int x1,int x2,int y1,int y2,String side) throws InvalidMoveException{
        x2=isCoordinateOutOfBound(x2);
        y2=isCoordinateOutOfBound(y2);
        if(y1==y2){
            if(x1<x2){
                return isPieceInFrontOrSide(x1,x2,y1,false,side);
            }else{
                return isPieceInFrontOrSide_2(x1,x2,y1,false,side);
            }
        }else if(x1==x2){
            if(y1<y2){
                return isPieceInFrontOrSide(y1,y2,x1,true,side);
            }else{
                return isPieceInFrontOrSide_2(y1,y2,x1,true,side);
            }
        }else if(Math.abs(x1-x2)==Math.abs(y1-y2)){
            if(x1<x2&&y1<y2){
                return isPieceInSlantTrajectory(x1,x2,y1,y2,side);
            }else if(x1>x2&&y1<y2){
                return isPieceInSlantTrajectory(true,x1,x2,y1,side);
            }else if(x1<x2&&y1>y2){
                return isPieceInSlantTrajectory(false,x1,x2,y1,side);
            }else if(x1>x2&&y1>y2){
                return isPieceInSlantTrajectory(x2,x1,y2,y1,side);
            }
        }
        return false;
    }
    private boolean isPieceInSlantTrajectory(boolean isx1biggerthanx2,int x1,int x2,int y1,String side) throws InvalidMoveException{
        int x;
        int y;
        if(x1>x2 && isx1biggerthanx2){
            x=x1-1;
            y=y1+1;
            while(x>x2){
                 if(isImpede(x,y,side))
                 return true;
                 x--;
                 y++;
            }
        }else if(x1<x2 && (!isx1biggerthanx2)){
            x=x1+1;
            y=y1-1;
            while(x<x2){
                if(isImpede(x,y,side))
                 return true;
                x++;
                y--;
            }
        }
        return false;
    }
    private boolean isPieceInSlantTrajectory(int min_x, int max_x, int min_y,int max_y,String side) throws InvalidMoveException{
        int x=min_x+1;
        int y=min_y+1;
        while(x<max_x){
            if(isImpede(x,y,side))
                 return true;
            x++;
            y++;
        }
        return false;
    }
    private boolean isPieceInFrontOrSide(int min, int max,int fix,boolean isFront,String side) throws InvalidMoveException {
        for(int i=min+1;i<max;i++){
            if(fix<8 && fix>-1 && isFront){
                if(isImpede(fix,i,side))
                return true;
            }else if(fix!=8 && fix>-1 && !isFront){
                if(isImpede(i,fix,side))
                return true;
            }
        }
        return false;
    }
    private boolean isPieceInFrontOrSide_2(int max,int min,int fix, boolean isFront,String side) throws InvalidMoveException{
        for(int i=max-1;i>min;i--){
            if(fix<8 && fix>-1 && isFront){
                if(isImpede(fix,i,side))
                return true;
            }else if(fix<8 && fix>-1 && !isFront){
                if(isImpede(i,fix,side))
                return true;
            }
        }
        return false;
    }
    private boolean isImpede(int x2,int y2,String side) throws InvalidMoveException{
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(coordinate[y][x] != null && coordinate[y][x].isAllowed(x,x2,y,y2) && coordinate[y][x].getSide().getSide().equals(side) && coordinate[y][x].isPieceInBetween(x,x2,y,y2) == null && !isKing(coordinate[y][x])){
                    return true;
                }
            }
        }
        return false;
    }
}