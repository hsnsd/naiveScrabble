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
public class Scrabble {

    /**
     * @param args the command line arguments
     */
    static Board board = new Board();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        WordBag bag = new WordBag();
        WordList list = new WordList();
        System.out.println("Welcome to Scrabble. Please enter the number of players playing");
        int size = scan.nextInt();
        HumanPlayer[] players = new HumanPlayer[size];
        for(int i=0; i<size; i++){
            System.out.println("Enter player " + i+1+ "name:");
            players[i] = new HumanPlayer(scan.next());
        }
        System.out.println("Enter the maximum number of turns per player before the game ends"); //game over criterion
        int max = scan.nextInt();
        System.out.println("Initializing board");
        board.display();
        int currIndex = 0;
        max = max*size;
        while(bag.remainingTiles()!=0 && max!=0){
            System.out.println(players[currIndex].getName() +"'s turn");
            System.out.println("These are your tiles:");
            players[currIndex].showTiles();
            System.out.println("Press 1 to play a word /n Press 2 to exchange letters /n Press 3 to pass your turn");
            int choice = scan.nextInt();
            if(choice == 1){
                players[currIndex].playWord();
                currIndex = (currIndex+1)%size;
            }
            else if(choice == 2){
                System.out.println("Enter the number of tiles you want to exchange");
                int num = scan.nextInt();
                System.out.println("Enter the index of tiles from your racks"); //0 indexing
                Tile[] arr = new Tile[num];
                for(int i=0; i<num; i++)
                    arr[i] = players[currIndex].rack.get(scan.nextInt());
                players[currIndex].exchangeLetters(num, arr);
                currIndex = (currIndex+1)%size;
            }
            else if(choice == 3){
                currIndex = (currIndex+1)%size;
            }
            
            System.out.println("Current ScoreBoard:");
            for(int i=0; i<size; i++){
                players[i].display();
            }
            
            System.out.println("Current Board");
            board.display();
            
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Final ScoreBoard:");
        int high = 0;
        for(int i=0; i<size; i++){
                if(players[high].getScore()>players[i].getScore())
                    high = i;
                players[i].display();
            }
        System.out.print("Winner is ");
        players[high].display();
        
        
        //bag.display();
        //HumanPlayer player = new HumanPlayer("Hassan");
        //bag.display();
        //player.showTiles();
        //Tile[] arr = {player.rack.get(0),player.rack.get(1),player.rack.get(2)};
        //player.exchangeLetters(3, arr);
        //player.showTiles();
        //bag.display();
        //ScoreHasher hash = new ScoreHasher();
        //System.out.println(hash.getScore('k'))
        /*System.out.println(ScoreHasher.getScore('Z'));
        
        HumanPlayer player = new HumanPlayer("Hassan");
        int turns = 15;
        while(turns--!=0){
        player.showTiles();
        player.playWord();
        System.out.println(player.getScore());
        board.display();
        }
        */
        //WordBag bag = new WordBag();
        //bag.display();
        //bag.takeTile();
        //bag.display();
        //WordList list = new WordList();
        
    }
    
}
