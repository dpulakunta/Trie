/* ClassName : TrieStructure
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * To create the structure of the node
 * It contains the setters and getters
 * 
 * Class variables: 
 * link stores the next character in the Trie
 * linkCharacter is the character that is stored in the node
 * leaf is a boolean to say if it is the last node in the tree
 * nodeChildren is a map which connects the characters and the nodes for each character very imp
 * 
 */
package com.sdsu.assignment1;

import java.util.HashMap;
import java.util.Map;

public class TrieStructure {
	private Character linkChar;
    private TrieStructure link;
    private boolean leafNode;
    private Map<Character, TrieStructure> nodeChildren = new HashMap<Character, TrieStructure>();
    
  //Setter and getter for linkCharacter
    public Character getLinkChar() {
		return linkChar;
	}
	public void setLinkChar(Character nodeKey) {
		this.linkChar = nodeKey;
	}
	
	//Setter and getter for link
	public TrieStructure getLink() {
		return link;
	}
	public void setLink(TrieStructure nodeValue) {
		this.link = nodeValue;
	}
	
	//Setter and getter for leafNode
	public boolean isLeafNode() {
		return leafNode;
	}
	public void setLeafNode(boolean leafNode) {
		this.leafNode = leafNode;
	}
	
	//Setter and getter for nodeChildren
	public Map<Character, TrieStructure> getNodeChildren() {
		return nodeChildren;
	}
	public void setNodeChildren(Map<Character, TrieStructure> nodeChildren) {
		this.nodeChildren = nodeChildren;
	}

}
