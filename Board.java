/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;
import java.util.*;
/**
 *
 * @author Hassan
 */
public class Board {
    public String[][] board;
    public static boolean isEmpty = true;
    private static final int[] TRIPLEWORDSCOREINDEXARRAY = {0, 7, 14, 90, 104, 210, 217, 224};
    private static final int[] DOUBLELETTERSCOREINDEXARRAY = {3, 11, 36, 38, 45, 52, 59, 92, 96, 98, 102, 108, 116, 122, 126, 128, 132, 165, 172, 179, 186, 188, 213, 221};
    private static final int[] DOUBLEWORDSCOREINDEXARRAY = {16, 28, 32, 42, 48, 56, 64, 70, 154, 160, 168, 176, 182, 192, 196, 208};
    private static final int[] TRIPLELETTERSCOREINDEXARRAY = {20, 24, 76, 80, 84, 88, 136, 140, 144, 148, 200, 204};
    
    public Board(){
        board = new String[15][15];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = "---";
            }
        }
        board[7][7] = "***";
        for(int i=0; i<TRIPLEWORDSCOREINDEXARRAY.length; i++){
            int index = TRIPLEWORDSCOREINDEXARRAY[i];
            if(index>14)
                board[index/15][index-15*(index/15)] = "T W";
            else
                board[index/15][index] = "T W";
        }
        for(int i=0; i<DOUBLELETTERSCOREINDEXARRAY.length; i++){
            int index = DOUBLELETTERSCOREINDEXARRAY[i];
            if(index>14)
                board[index/15][index-15*(index/15)] = "D L";
            else
                board[index/15][index] = "D L";
        }
        for(int i=0; i<DOUBLEWORDSCOREINDEXARRAY.length; i++){
            int index = DOUBLEWORDSCOREINDEXARRAY[i];
            if(index>14)
                board[index/15][index-15*(index/15)] = "D W";
            else
                board[index/15][index] = "D W";
        }
        for(int i=0; i<TRIPLELETTERSCOREINDEXARRAY.length; i++){
            int index = TRIPLELETTERSCOREINDEXARRAY[i];
            if(index>14)
                board[index/15][index-15*(index/15)] = "T L";
            else
                board[index/15][index] = "T L";
        }
        
        
    }
    public void display(){
        System.out.println("    0   1   2   3   4   5   6   7   8   9   10  11  12  13  14");
        for(int i=0; i<board.length; i++){
            if(i<=9)
                System.out.print(i + "  ");
            else
                System.out.print(i + " ");
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
