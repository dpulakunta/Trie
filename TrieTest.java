/* ClassName : TrieTest
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * To test the code of the Trie
 * I am creating a user interface: where i read the operation the user wants to do
 * and call that particular function
 * 
 * 
 * Class variables: 
 * None
 * 
 */
package com.sdsu.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TrieTest {
	public static void main(String[] args) {
		Trie myTrie = new Trie();
		String line=null;
		int userChoice=0;
		String readTheWord = null;
		String wordToSearchFor = null;

		System.out.println("We are creating a TRIE structure");
		for(;;){
			//Output statements to display the options the user can select from
			System.out.println("Choice the operation you want to perform");
			System.out.println("\t1.) Add the new words into the structure");
			System.out.println("\t2.) Find the word");
			System.out.println("\t3.) Check if the Trie contains:");
			System.out.println("\t4.) Print all the words");
			System.out.println("Please enter your choice:");

			//Reading the input from the user
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			try {
				line = is.readLine();
			} catch (IOException e) {
				System.out.println("The value entered is incorrect, program will exit");
				e.printStackTrace();
			}
			userChoice = Integer.parseInt(line);

			//we call the particular operation depending on the users choice
			switch (userChoice) {

			case 1:
				System.out.println("Enter the string you want to add:");
				try {
					readTheWord = is.readLine();
				} catch (IOException e) {
					System.out.println("The value entered is incorrect, program will exit");
					e.printStackTrace();
				}
				myTrie.addWord(readTheWord);
				break;

			case 2:
				System.out.println("Enter the string you want to find in the TRIE:");
				try {
					wordToSearchFor = is.readLine();
				} catch (IOException e) {
					System.out.println("The value entered is incorrect, program will exit");
					e.printStackTrace();
				}
				Boolean isWordFound = myTrie.findWord(wordToSearchFor);
				System.out.println("Is this word "+wordToSearchFor+" present in the Trie:"+isWordFound);
				break;
				
			case 3:
				System.out.println("The TRIE containing CK nodes:");
				myTrie.searchForCK();
				break;
				
			case 4:
				System.out.println("The TRIE contains:");
				myTrie.printWord();
				break;
			default:
				System.exit(1);
				break;
			}



		}
	}
}
