/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import java.util.ArrayList;

/**
 *
 * @author Hassan
 */
public class WordBag {
    protected static ArrayList<Tile> letterBag = new ArrayList();;
    
    public WordBag(){
        Tile aTile = new Tile('A', 1);
        Tile bTile = new Tile('B', 3);
        Tile cTile = new Tile('C', 3);
        Tile dTile = new Tile('D', 2);
        Tile eTile = new Tile('E', 1);
        Tile fTile = new Tile('F', 4);
        Tile gTile = new Tile('G', 2);
        Tile hTile = new Tile('H', 4);
        Tile iTile = new Tile('I', 1);
        Tile jTile = new Tile('J', 8);
        Tile kTile = new Tile('K', 5);
        Tile lTile = new Tile('L', 1);
        Tile mTile = new Tile('M', 3);
        Tile nTile = new Tile('N', 1);
        Tile oTile = new Tile('O', 1);
        Tile pTile = new Tile('P', 3);
        Tile qTile = new Tile('Q', 10);
        Tile rTile = new Tile('R', 1);
        Tile sTile = new Tile('S', 1);
        Tile tTile = new Tile('T', 1);
        Tile uTile = new Tile('U', 1);
        Tile vTile = new Tile('V', 4);
        Tile wTile = new Tile('W', 4);
        Tile xTile = new Tile('X', 8);
        Tile yTile = new Tile('Y', 4);
        Tile zTile = new Tile('Z', 10);
        Tile blankTile = new Tile('?', 0);
        
        
        //adding these tiles according to number of tiles
        //add 12 e tiles
        for (int i = 0; i < 12; i++) {
            letterBag.add(eTile);
        }

        //add 9 a and i tiles
        for (int i = 0; i < 9; i++) {
            letterBag.add(aTile);
            letterBag.add(iTile);
        }

        //add 8 o tiles
        for (int i = 0; i < 8; i++) {
            letterBag.add(iTile);
        }

        //add 6 n,r and t tiles
        for (int i = 0; i < 6; i++) {
            letterBag.add(nTile);
            letterBag.add(rTile);
            letterBag.add(tTile);
        }

        //add 4 l,s,u and d tiles
        for (int i = 0; i < 4; i++) {
            letterBag.add(lTile);
            letterBag.add(sTile);
            letterBag.add(uTile);
            letterBag.add(dTile);
        }

        //add 3 g tiles
        for (int i = 0; i < 3; i++) {
            letterBag.add(gTile);
        }

        //add 2 b,c,m,p,f,h,v,w,y and blank tiles
        for (int i = 0; i < 2; i++) {
            letterBag.add(bTile);
            letterBag.add(cTile);
            letterBag.add(mTile);
            letterBag.add(pTile);
            letterBag.add(fTile);
            letterBag.add(hTile);
            letterBag.add(vTile);
            letterBag.add(wTile);
            letterBag.add(yTile);
            letterBag.add(blankTile);
        }

        //add 1 k,j,x,q and z tiles
        letterBag.add(kTile);
        letterBag.add(jTile);
        letterBag.add(xTile);
        letterBag.add(qTile);
        letterBag.add(zTile);
    }
    public int remainingTiles(){
        return letterBag.size();
    }
    
    public static Tile takeTile(){
        int tmp = (int)(Math.random() * letterBag.size());
        Tile  temp = letterBag.get(tmp);
        letterBag.remove(tmp);
        return temp;
    }
    public static void removeTile(Tile t){
        letterBag.remove(t);
    }
    public static void addTile(Tile t){
        letterBag.add(t);
    }
    public int getTileScore(Tile tmp){
        return tmp.getScore();
    }
    
    public void display(){
        for(int i=0; i<letterBag.size(); i++){
            System.out.print(letterBag.get(i) + ", ");
        }
        System.out.println("");
    }
    
}
