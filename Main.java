/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Class: Main driver that reads 100hashtags file, inserts that into a binary search tree, and interacts with user
 * to see if a hashtags exists in the binary search tree created.
 * Date: 3/30/16
 */
package Project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args){
		//line for reading
		String line = "";
		
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
	
		try{
			FileReader fr = new FileReader("100hashtags.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null){
				String[] temp = line.split(",");
				
				tree.insertNode(temp[1].trim());
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Create scanner for user input
		Scanner scanner = new Scanner(System.in);
		
		boolean exit = true;
		
		//Loop for prompting user to enter tweets
		while(exit == true){
			System.out.println("Enter a tweet: ");
			String tweet = scanner.nextLine();
			
			//Find hashtag
			String hashtag = tree.findHashTag(tweet);
			
			//Look for hashtag in binary search tree
			if(tree.getTweetsFound(tree, hashtag) == true){
				System.out.println("1:" + hashtag);
			}
			else
				System.out.println("0:" + hashtag);
			
			//See if user would like to enter another tweet
			System.out.println("Would you like to enter another tweet? y/n");
			String answer = scanner.nextLine();
			
			if(answer.equals("y"))
				exit = true;
			else
				exit = false;
		}	
	}
}
