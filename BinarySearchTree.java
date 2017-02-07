/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Class: Binary Search Tree class, creates the binary search tree and implements 
 * inorder, preorder, and postorder traversals along with a method to find hashtag in tree
 * Date: 3/30/16
 */
package Project3;

public class BinarySearchTree<E> {

private Node<E> root;
	
	//Constructor 1: create an empty BST tree
	public BinarySearchTree(){
		root = null;
	}
	//Constructor 2: create a BST given a root
	public BinarySearchTree(Node<E> root){
		this.root = root;
	}
	//Constructor 3: create a BST given data root, left tree, and right tree
	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree){
		//create a root node for this tree
		this.root = new Node<E>(data);
		//connect the leftnode of the root with leftTree
		if(leftTree != null)
			this.root.leftNode = leftTree.root;
		//connect the rightNode of the root with rightTree
		if(rightTree != null)
			this.root.rightNode = rightTree.root;
	}
	
	//Method: insertNode (insert a value into a BST)
	public void insertNode(E insertValue){
		
		if(this.root == null)
			this.root = new Node<E>(insertValue);
		else
			this.root.insert(insertValue);
	}
	
	public BinarySearchTree<E> getLeftTree(){
		
		if(root != null && root.leftNode != null){
			return (new BinarySearchTree<E>(root.leftNode));
		}
		else
			return null;
	}
	
	public BinarySearchTree<E> getRightTree(){
		
		if(root != null && root.rightNode != null){
			return (new BinarySearchTree<E>(root.rightNode));
		}
		else
			return null;
	}
	
	//Method: returns the binary tree traversal of TreeLeft, root, then TreeRight
	public String getInorderTraversal(BinarySearchTree<E> tree){
		
		if(tree == null)
			return "";
		else
			return (getInorderTraversal(tree.getLeftTree()) + tree.root.toString() + " \n"
			+ getInorderTraversal(tree.getRightTree()));
	}
	
	//Method: returns the binary tree traversal of root, TreeLeft, then TreeRight
	public String getPreorderTraversal(BinarySearchTree<E> tree){
		
		if(tree == null)
			return "";
		else
			return (tree.root.toString() + " " + getPreorderTraversal(tree.getLeftTree())
			+ getPreorderTraversal(tree.getRightTree()));
	}
	
	//Method: returns the binary tree traversal of TreeLeft, TreeRight, then root 
	public String getPostorderTraversal(BinarySearchTree<E> tree){
		
		if(tree == null)
			return "";
		else
			return (getPostorderTraversal(tree.getLeftTree()) + getPostorderTraversal(tree.getRightTree())
			+ tree.root.toString() + " ");
	}
	
	/*
	 * This function returns true if tweet is found, and false if tweet is not found
	 */
	public boolean getTweetsFound(BinarySearchTree<E> tree, String value){
		
		if(tree == null)
			return false;
		else if(value.equals((String) tree.root.data))
			return true;
		else if (value.compareTo((String) tree.root.data) <0)
			return getTweetsFound(tree.getLeftTree(), value);
		else if(value.compareTo((String) tree.root.data) >0) 
			return getTweetsFound(tree.getRightTree(), value);
		else
			return false;

	}
	
	/*
	 * findHashTag: takes tweet and returns hashtag in tweet
	 */
	public String findHashTag(String tweet){
		
		tweet.toLowerCase();
		
		//Get index of hashtag
		int index = tweet.indexOf("#");
		
		//Get index of last character in hashtag
		int index2 = tweet.indexOf(" ", index);
		
		//Now use substring to retrieve hashtag using indexes
		String hashtag = tweet.substring(index, index2);
		
		//trim
		hashtag.trim();
		
		return hashtag;
	}
}
