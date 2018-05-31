/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hassan
 */
public class WordList {
    public  static ArrayList<String> wordList;
    public WordList() throws FileNotFoundException{
        wordList = new ArrayList();
        Scanner scan = new Scanner(new File("wordlist.dat"));
        while(scan.hasNext())
            wordList.add(scan.next());
        
    }
    
    public boolean contains(String word){
        if(wordList.contains(word.toLowerCase()))
            return true;
        else
            return false;
    }

}
