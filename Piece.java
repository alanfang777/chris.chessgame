import java.util.*;
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
    private ArrayList eatablePiece;
    Piece(Side side){
        this(side,null);
    }
    Piece(Side side, Piece[][] coordinate){
        this.side = side;
        this.coordinate = coordinate;
        eatablePiece = new ArrayList();
    }
    public String toString()
    {
        return null;
    }
    public abstract boolean isAllowed(int x1,int x2,int y1,int y2);
    public Side getSide(){
        return side;
    }
    public Piece[][] getCoordinate(){
        return coordinate;
    }
    public boolean isBlack()
    {
        return side.getSide().equals("Black") || side.getSide().equals("black");
    }
    public boolean isWhite()
    {
        return side.getSide().equals("White") || side.getSide().equals("white");
    }
    public int getIntact(){
        return intact;
    }
    public void setIntact(int intact){
        this.intact=intact;
    }
    public ArrayList getEatablePiece(int x1, int y1){
        System.out.println("EatablePiece:           ");
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(coordinate[y][x]!=null){
                    coordinate[y][x].addingEatablePiece(x1,y1,eatablePiece);
                }
            }
        }
        /*for(int t=0;t<eatablePiece.size();t++){
            if(eatablePiece.get(t)!=null){
                System.out.print(eatablePiece.get(t).toString());
            }
        }*/
        System.out.println();
        eatablePiece.clear();
        return eatablePiece;
    }
    public Piece isPieceInBetween(int x1,int x2,int y1,int y2){
        if(y1==y2){
            return isPieceInFrontOrSide(x1,x2,y1,false);
        }else if(x1==x2){
            return isPieceInFrontOrSide(y1,y2,x1,true);
        }else if(Math.abs(x1-x2)==Math.abs(y1-y2)){
            int x;
            int y;
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
    public Piece isPieceInBetween_2(int x1,int x2,int y1,int y2){
        if(x2>7){
            if(x2<14){
                x2=8;
            }else{
                return null;
            }
        }else if(x2<0){
            if(x2>-7){
                x2=-1;
            }else{
                return null;
            }
        }
        if(y2>7){
            if(y2<14){
                y2=8;
            }else{
                return null;
            }
        }else if(y2<0){
            if(y2>-7){
                y2=-1;
            }else{
                return null;
            }
        }
        if(y1==y2){
            return isPieceInFrontOrSide(x1,x2,y1,false);
        }else if(x1==x2){
            return isPieceInFrontOrSide(y1,y2,x1,true);
        }else if(Math.abs(x1-x2)==Math.abs(y1-y2)){
            int x;
            int y;
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
            if(isFront && coordinate[i][fix] != null){
                return coordinate[i][fix];
            }else if(!isFront && coordinate[fix][i] != null){
                return coordinate[fix][i];
            }
        }
        return null;
    }
    public boolean isItCastling(int x1,int x2,int y1,int y2,Side side){
        if(getCoordinate()[y1][x1].getIntact()==0){
            if(getCoordinate()[7][3].toString().equals("[WKg]")){
                if(getCoordinate()[7][0].toString().equals("[WRk]")&&x2==2&&y2==7&&getCoordinate()[7][0].getIntact()==0){
                    getCoordinate()[y1][x1].setIntact(1);
                    getCoordinate()[7][0].setIntact(1);
                    return true;
                }else if(getCoordinate()[7][7].toString().equals("[WRk]")&&x2==6&&y2==7){
                    getCoordinate()[y1][x1].setIntact(1);
                    getCoordinate()[7][7].setIntact(1);
                    return true;
                }
            }else if(getCoordinate()[7][4].toString().equals("[BKg]")){
                if(getCoordinate()[7][0].toString().equals("[BKg]")&&x2==2&&y2==0){
                    getCoordinate()[y1][x1].setIntact(1);
                    getCoordinate()[0][0].setIntact(1);
                    return true;
                }else if(getCoordinate()[7][0].toString().equals("[BKg]")&&x2==6&&y2==0){
                    getCoordinate()[y1][x1].setIntact(1);
                    getCoordinate()[0][7].setIntact(1);
                    return true;
                }
            }
        }
        return false;
    }
    abstract void addingEatablePiece(int x1,int y1,ArrayList eatablepiece);
}
