/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Class: Node class that inserts nodes into the binary search tree correctly
 * Date: 3/30/16
 */
package Project3;

public class Node<E> {
	
	//Class variable declaration: leftNode, rightNode, and data
		protected Node<E> leftNode;
		protected Node<E> rightNode;
		protected E data;
		
		//Constructor
		public Node(E data){
			//Initialization of a node
			leftNode = rightNode = null;
			this.data = data;
		}
		
		//Method: toString
		public String toString(){
			return data.toString();
		}
		
		//Method: insert. Insert a node into a tree
		public void insert(E insertValue){
			if(((String) insertValue).compareTo(((String) this.data)) < 0){
				//add this node to the of the current node
				if(this.leftNode == null){
					this.leftNode = new Node<E>(insertValue);
				}
				else{
					this.leftNode.insert(insertValue);
				}
			}
			else if((((String) insertValue)).compareTo((((String) this.data))) > 0){
		        if (this.rightNode == null)
		        	this.rightNode = new Node<E>(insertValue);
		        else
		        	this.rightNode.insert(insertValue);
		    }
			
		}
}
