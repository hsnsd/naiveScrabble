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
public class HumanPlayer extends Player{
    Scanner scan = new Scanner(System.in);
    public HumanPlayer(String name) throws FileNotFoundException{
        super();
        this.name = name;
    }
    public void updateScore(int score){
        this.score += score;
    }
    public int getScore(){
        return score;
    }
    public void playWord(){
        boolean boardWasEmpty = false;
        String[] prevState;
        boolean wordPlayed = false;
        System.out.println("Enter the complete word you want to make");
        String word = scan.next();
        prevState = new String[word.length()];
        System.out.println("Enter the orientation of the word"); // horizontal or vertical
        String orientation = scan.next();
        //assume player makes no mistake in writing positions
        System.out.println("Enter the x-co-ordinate of the first letter"); //starting x-position of the word
        int x = scan.nextInt();
        System.out.println("Enter the y-co-ordinate of the first letter"); //starting y-position of the word
        int y = scan.nextInt();
        int fixX = x;// used for scoring
        int fixY = y;// ^same
        boolean valid = true; //used later to check validity
        boolean wordValid = true;
        ArrayList<String> usedTiles = new ArrayList();
        System.out.println("Playing " + word + " on the board");
        if(!WordList.wordList.contains(word)){
            System.out.println("Invalid Word. You will get a score of 0");
            updateScore(0);
            wordPlayed = false;
            wordValid = false;
        }
        else if(wordValid && orientation.equals("h")){
            int xTmp = x;
            valid = true;
            for(int i=0; i<word.length();i++){
                if((Scrabble.board.board[y][xTmp].equals("---") || Scrabble.board.board[y][xTmp].equals("T W")
                        || Scrabble.board.board[y][xTmp].equals("D W") || Scrabble.board.board[y][xTmp].equals("D L")
                        || Scrabble.board.board[y][xTmp].equals("T L"))){
                    
                    valid = false;
                }
                else{
                    valid = true;
                    break;
                }
                xTmp++;
            }
        }
        else if(wordValid && orientation.equals("v")){
            int yTmp = y;
            valid = true;
            for(int i=0; i<word.length();i++){
                //System.out.println(Scrabble.board.board[yTmp][x]);
                if(Scrabble.board.board[yTmp][x].equals("---") || Scrabble.board.board[yTmp][x].equals("T W")
                        || Scrabble.board.board[yTmp][x].equals("D W") || Scrabble.board.board[yTmp][x].equals("D L")
                        || Scrabble.board.board[yTmp][x].equals("T L") ){
                    valid = false;
                }
                else{
                    valid = true;
                    break;
                }
                yTmp++;
            }
        }
        if(wordValid && !wordPlayed && valid && Board.isEmpty){
            //System.out.println("HHEHEHEH");
                if(orientation.equals("v")){
                    Scrabble.board.board[y++][x] = " " + (word.charAt(0)+"").toUpperCase() + " ";
                    for(int i=1; i<word.length(); i++)
                        Scrabble.board.board[y++][x] = " " + (word.charAt(i)+"").toUpperCase() + " ";
                }
                else if(orientation.equals("h")){
                    Scrabble.board.board[y][x++] = " " + (word.charAt(0)+"").toUpperCase() + " ";
                    for(int i=1; i<word.length(); i++)
                        Scrabble.board.board[y][x++] = " " + (word.charAt(i)+"").toUpperCase() + " ";
                }
                wordPlayed = true;
                Board.isEmpty = false;
                boardWasEmpty = true;
        }
        else if(valid && wordValid && !wordPlayed){
            int aY = y;
            if(orientation.equals("v")){
                for(int i=0; i<word.length(); i++){
                    if(Scrabble.board.board[aY][x].equals("---") || Scrabble.board.board[aY][x].equals("T W")
                        || Scrabble.board.board[aY][x].equals("D W") || Scrabble.board.board[aY][x].equals("D L")
                        || Scrabble.board.board[aY][x].equals("T L") ){
                        Scrabble.board.board[aY][x] = " " + (word.charAt(i)+"").toUpperCase() + " ";
                        usedTiles.add((word.charAt(i)+"").toUpperCase());
                        
                    }
                    aY++;
                    /*else{
                        if(!Scrabble.board.board[y++][x].equals(word.charAt(i))){
                            System.out.println("You cheated. You will get a 0 score");
                            wordPlayed = false;
                        }
                    } */
                }
            }
            else if(orientation.equals("h")){
                int aX=x;
                for(int i=0; i<word.length(); i++){
                    if(Scrabble.board.board[y][aX].equals("---") || Scrabble.board.board[y][aX].equals("T W")
                        || Scrabble.board.board[y][aX].equals("D W") || Scrabble.board.board[y][aX].equals("D L")
                        || Scrabble.board.board[y][aX].equals("T L") ){
                        Scrabble.board.board[y][aX] = " " + (word.charAt(i)+"").toUpperCase() + " ";
                        usedTiles.add((word.charAt(i)+"").toUpperCase());
                        
                    }
                    aX++;
                    /*else{
                        if(!Scrabble.board.board[y][x++].equals(word.charAt(i))){
                            System.out.println("You cheated. You will get a 0 score");
                            wordPlayed = false;
                        }
                    } */
                }
            }
            wordPlayed = true;
        }
        
        if(!valid){
            System.out.println("Cant make a word here. You get a 0");
        }
        
        
        if(wordPlayed){//BUG: only counts the score of the new word played. Any word formed other than the user's mentioned word is not counted in the score
            int scoreMultiplier = 1;
            int currScore = 0;
            if(orientation.equals("v")){
                for(int i=0; i<word.length(); i++){
                    //String s = Board.lastBoard[fixY][fixX];
                    int varY = fixY;
                    int s =0;
                    if(varY<1){
                        s = 14*(varY) + fixX;
                    }
                    else{
                        s = 15*(varY) + fixX;
                    } 
                    varY++;
                    char c = Scrabble.board.board[fixY++][fixX].charAt(1);
                    switch (s){//BUG : it will repeat previously used score modifiers.
                        case 0: case 7: case 14: case 90: case 104: case 210: case 217: case 224:
                            scoreMultiplier *= 3;
                            currScore += ScoreHasher.getScore(c);
                            break;
                        case 3: case 11: case 36: case 38: case 45: case 52: case 59: case 92: case 96: case 98: case 102: case 108:  case 116: case 122: case 126: case 128: case 132: case 165: case 172: case 179: case 186: case 188: case 213: case 221:
                            //System.out.println("HIAMSDEASD");
                            currScore += ScoreHasher.getScore(c) + ScoreHasher.getScore(c);
                            break;
                        case 16: case 28: case 32: case 42: case 48: case 56: case 64: case 70: case 112: case 154: case 160: case 168: case 176: case 182: case 192: case 196: case 208:
                            currScore += ScoreHasher.getScore(c);
                            scoreMultiplier *= 2;
                            break;
                        case 20: case 24: case 76: case 80: case 84: case 88: case 136: case 140: case 144: case 148: case 200: case 204:
                            currScore += ScoreHasher.getScore(c) + ScoreHasher.getScore(c) +ScoreHasher.getScore(c);
                            break;
                        case 105:
                            scoreMultiplier *= 2;
                            currScore += ScoreHasher.getScore(c);
                            break;
                        default:
                            currScore += ScoreHasher.getScore(c);
                            break;
                    }
                            
                }
                //System.out.println("muktokeru" + scoreMultiplier);
                score += scoreMultiplier*currScore;
            }
            else if(orientation.equals("h")){
                for(int i=0; i<word.length(); i++){
                    //String s = Board.lastBoard[fixY][fixX];
                    int varX = fixX;
                    int s =0;
                    if(fixY<1){
                        s = 14*(fixY) + varX;
                    }
                    else{
                        s = 15*(fixY) + varX;
                    }
                    varX++;
                    char c = Scrabble.board.board[fixY][fixX++].charAt(1);
                    switch (s){//BUG : it will repeat previously used score modifiers.
                        case 0: case 7: case 14: case 90: case 104: case 210: case 217: case 224:
                            scoreMultiplier *= 3;
                            currScore += ScoreHasher.getScore(c);
                            break;
                        case 3: case 11: case 36: case 38: case 45: case 52: case 59: case 92: case 96: case 98: case 102: case 108: case 116: case 122: case 126: case 128: case 132: case 165: case 172: case 179: case 186: case 188: case 213: case 221:
                            //System.out.println("HIAMSDEASD");
                            currScore += ScoreHasher.getScore(c) + ScoreHasher.getScore(c);
                            break;
                        case 16: case 28: case 32: case 42: case 48: case 56: case 64: case 70: case 112: case 154: case 160: case 168: case 176: case 182: case 192: case 196: case 208:
                            currScore += ScoreHasher.getScore(c);
                            scoreMultiplier *= 2;
                            break;
                        case 20: case 24: case 76: case 80: case 84: case 88: case 136: case 140: case 144: case 148: case 200: case 204:
                            currScore += ScoreHasher.getScore(c) + ScoreHasher.getScore(c) +ScoreHasher.getScore(c);
                            break;
                        case 105:
                            scoreMultiplier *= 2;
                            currScore += ScoreHasher.getScore(c);
                            break;
                        default:
                            currScore += ScoreHasher.getScore(c);
                            break;
                    }
                            
                }
                //System.out.println("muktokeru" + scoreMultiplier);
                score += scoreMultiplier*currScore;
            }
            if(boardWasEmpty){
                Tile tmpX = null;
                for(int i=0; i<word.length(); i++){
                    for(int j=0; j<rack.size(); j++){
                        tmpX = rack.get(j).findTile(Character.toUpperCase(word.charAt(i)));
                        rack.remove(tmpX);
                    }
                }
            }
            
            if(!boardWasEmpty){
                System.out.println(usedTiles.get(0));
                Tile tmpX = null;
                for(int i=0; i<usedTiles.size(); i++){
                    for(int j=0; j<rack.size(); j++){
                        tmpX = rack.get(j).findTile(Character.toUpperCase(usedTiles.get(i).charAt(0)));
                        rack.remove(tmpX);
                    }
                }
            }
            for(int i=0; i<word.length(); i++)
                rack.add(WordBag.takeTile());
        }
    }
    
    public void showTiles(){
        for(int i=0; i<rack.size(); i++){
            System.out.print(rack.get(i) + " ");
        }
        System.out.println("");
    }
    public void exchangeLetters(int num, Tile[] arr){
        ArrayList<Tile> tmp = new ArrayList();
        Tile tmpT = null;
        for(int i=0; i<num; i++){
            tmpT = arr[i];
            rack.remove(tmpT);
            tmp.add(tmpT);
        }
        for(int i=0; i<num; i++)
                rack.add(WordBag.takeTile());
        for(int i=0; i<num; i++)
            WordBag.addTile(tmp.get(i));
    }
    public  void challenge(){} // autochallenge while playing
    public void display(){
        System.out.println("Player Name: " + name + " Score: " + score);
    }
    public String getName(){
        return name;
    }
}
