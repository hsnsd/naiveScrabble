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
public class ScoreHasher {
    static final int[] scores = new int[]{1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,1,10 };

   
    
    public static int getScore(char letter){
        
        return scores[(int)letter%65];
    }
}
