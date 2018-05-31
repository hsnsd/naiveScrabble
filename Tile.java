/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

/**
 *
 * @author Hassan
 */
public class Tile {
    private char letter;
    private int score;    
    
    public Tile(){
        letter = ' ';
        score = 0;
    }
    
    public Tile(char letter, int score){
        this.letter = letter;
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    public Tile findTile(char letter){
        
        if (this.letter == letter)
            return this;
        else
            return null;
    }
    public String toString(){
        return Character.toUpperCase(letter) + "";
    }
}
