/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author Hassan
 */
abstract class Player {
    protected String name;
    protected ArrayList<Tile> rack;
    protected int score;
    
    public Player() throws FileNotFoundException{
        rack = new ArrayList();
        for (int i=0; i<7; i++){
            rack.add(WordBag.takeTile());
        }
    }
    
    abstract void playWord();
    //abstract void passTurn();
    abstract void exchangeLetters(int num, Tile[] arr);
    abstract void challenge();
    abstract void updateScore(int score);
    abstract void showTiles();
    abstract int getScore();
    abstract void display();
    abstract String getName();
    
}
