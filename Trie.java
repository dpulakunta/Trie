/* ClassName : Trie
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: Create the functionality of adding, finding and printing the words in Trie
 * Class variables: 
 * trieHead TrieStructure is the variable which is the node containing the elements
 * 
 * 
 */
package com.sdsu.assignment1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sdsu.assignment1.TrieStructure;


public class Trie {

	private TrieStructure trieHead = new TrieStructure();

	/* Function name: addWord
	 * 
	 * Input: key: string that needs to be added into the trie
	 * 
	 * Output: no return value
	 */

	public void addWord(String elementToInsert) {
		TrieStructure value = new TrieStructure();
		addNode(trieHead, elementToInsert, 0);

	}

	/* Function name: addNode
	 * 
	 * Input: 
	 * elementToInsert: string that needs to be added into the trie
	 * 
	 * Output: no return value
	 * 
	 * This is a recursive function call need to be careful
	 */
	private void addNode(TrieStructure currNode, String elementToInsert, int pos) {

		Character charToInsert = elementToInsert.charAt(pos);
		//getting the map containing all the characters in the present node
		TrieStructure nextNode = currNode.getNodeChildren().get(charToInsert);

		//if the character does not exist we create a new node and insert values
		if (nextNode == null) {
			nextNode = new TrieStructure();
			nextNode.setLinkChar(charToInsert);
			//Checking if it is the leaf node or not
			if (pos < elementToInsert.length() - 1) {
				//recursive call making the new node has the parent and calling addNode
				addNode(nextNode, elementToInsert, pos + 1);
			} else {
				nextNode.setLeafNode(true);
			}
			//adding the character and node into the map of the trie structure
			currNode.getNodeChildren().put(charToInsert, nextNode);
		} 
		//if the character already exists we traverse the tree
		else {

			//Checking if it is the leaf node or not
			if (pos < elementToInsert.length() - 1) {
				addNode(nextNode, elementToInsert, pos + 1);
			} else {
				nextNode.setLeafNode(true);
			}
		}
	}
	/* Function name: findWord
	 * 
	 * Input: searchString: string that needs to be found into the trie
	 * 
	 * Output: boolean : true if the key value is present and false incase absent
	 */
	public boolean findWord(String searchString) {
		return recursiveCallSearch(trieHead, searchString);
	}
	/* Function name: recursiveCallSearch
	 * 
	 * Input: 
	 *  currNode: present parent node
	 *  searchString: string that needs to be found into the trie
	 * 
	 * Output: boolean : true if the key value is present and false incase absent
	 */
	private boolean recursiveCallSearch(TrieStructure currNode, String searchString) {
		//taking the first character to search
		Character charToBeSearched = searchString.charAt(0);

		if (currNode.getNodeChildren().containsKey(charToBeSearched)) {
			//checking with all the children for the present parent
			TrieStructure nextNode = currNode.getNodeChildren().get(charToBeSearched);
			if (searchString.length() == 1) {
				//check if leafNode or not, if not leaf then traverse by recursion
				if (nextNode.isLeafNode()) {
					return true;
				}
			} else {
				//we are leaving the first character and calling the string to search
				return recursiveCallSearch(nextNode, searchString.substring(1));
			}
		}
		return false;
	}
	/* Function name: printWord
	 * 
	 * Input: 
	 *  
	 * 
	 * Return Value: 
	 * None
	 */
	public void printWord(){
		Set<String> elementsInTrie = new HashSet<String>();
		//this is call for the recursive function to traverse the nodes
		recursiveCallPrint(trieHead, "", elementsInTrie);
		//Print the elements in the trie
		//All the words will be stored in the set
		Iterator<String> elementsInTrieSet = elementsInTrie.iterator(); 
		System.out.println("Elements in the TRIE are:");
		while(elementsInTrieSet.hasNext()){
			System.out.println(elementsInTrieSet.next());
		}
	}
	/* Function name: recursiveCallPrint
	 * 
	 * Input: 
	 *  currNode: is the parent node we are looking in the recursive function
	 *  key: stores the entire string till now
	 *  elementsInTrie:is set which stores all the words in the Trie
	 * 
	 * Return Value: 
	 * None
	 */
	private void recursiveCallPrint(TrieStructure currNode, String key, Set elementsInTrie) {
		//adding only the words
		if (currNode.isLeafNode()) {
			elementsInTrie.add(key);
		}
		Map<Character, TrieStructure> children = currNode.getNodeChildren();
		Iterator childIter = children.keySet().iterator();

		while (childIter.hasNext()) {
			Character ch = (Character)childIter.next();
			TrieStructure nextNode = children.get(ch);
			//concating the strings
			String s = key + nextNode.getLinkChar();
			//to check for other nodes in the trie
			recursiveCallPrint(nextNode, s, elementsInTrie);

		}

	}
	/* Function name: searchForCK
	 * 
	 * Input: 
	 *  
	 * 
	 * Return Value: 
	 * None
	 * 
	 * this function finds only for ck
	 */
	public void searchForCK() {
		Set<String> trieContainingCKlist = new HashSet<String>();

		checkCInTheTrie(trieHead, "", trieContainingCKlist);
		//printing all the elements in the set using iterator
		Iterator<String> elementsInTrieSet = trieContainingCKlist.iterator(); 
		System.out.println("Elements in the TRIE are:");
		while(elementsInTrieSet.hasNext()){
			System.out.println(elementsInTrieSet.next());
		}

	}
	/* Function name: checkCInTheTrie
	 * 
	 * Input: 
	 *  currNode: is the parent node we are looking in the recursive function
	 *  key: stores the entire string till now
	 *  elementsInTrie:is set which stores all the words in the Trie
	 * 
	 * Return Value: 
	 * None
	 * similar to print but we are checking if 'c' is found
	 * the we check if the next char is 'k'
	 */
	private void checkCInTheTrie(TrieStructure currNode, String key, Set elementsInTrie) {

		Map<Character, TrieStructure> children = currNode.getNodeChildren();
		Iterator childIter = children.keySet().iterator();

		while (childIter.hasNext()) {
			Character ch = (Character)childIter.next();
			TrieStructure nextNode = children.get(ch);
			String traversingString = key + nextNode.getLinkChar();
			//checking if it is C if C then we check next is K
			if(ch=='c'){
				checkForK(nextNode,traversingString,elementsInTrie);
			}
			//else recursively checking through
			checkCInTheTrie(nextNode, traversingString, elementsInTrie);

		}
	}
	/* Function name: checkForK
	 * 
	 * Input: 
	 *  currNode: is the parent node we are looking in the recursive function
	 *  key: stores the entire string till now
	 *  elementsInTrie:is set which stores all the words in the Trie
	 * 
	 * Return Value: 
	 * None
	 * we check if the next character is K if it is true then we reach the node and print all 
	 * the nodes below it
	 * 
	 */
	private void checkForK(TrieStructure currNode, String key, Set elementsInTrie) {
		if (currNode.isLeafNode()) {
			elementsInTrie.add(key);
		}
		Map<Character, TrieStructure> children = currNode.getNodeChildren();
		Iterator childIter = children.keySet().iterator();
		//the are more nodes below then check for K
		if (childIter.hasNext()) {
			Character ch = (Character)childIter.next();
			TrieStructure nextNode = children.get(ch);
			String traversingString = key + nextNode.getLinkChar();
			//if the next node was K then call the print for all the nodes below
			if(ch=='k'){
				recursiveCallPrint(nextNode, traversingString, elementsInTrie);

			}
			//go back to check for C
			else{
				checkCInTheTrie(nextNode, traversingString, elementsInTrie);
			}
		}else{
			checkCInTheTrie(currNode, key, elementsInTrie);
		}
	}
}

