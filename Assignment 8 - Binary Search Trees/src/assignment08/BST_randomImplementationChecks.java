package assignment08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BST_randomImplementationChecks {

	public static <E> void main(String[] args){
		

		//this is more or less what Spell
		List<String> myArray = readFile(new File("dictionary.txt"));
		BinarySearchTree<String> dictionary = new BinarySearchTree<String>();
		dictionary.addAll(myArray);
		
		List<Integer> myIntArray = new ArrayList<Integer>();
		myIntArray.add(14);
		myIntArray.add(7);
		myIntArray.add(21);
		myIntArray.add(3);
		myIntArray.add(10);
		myIntArray.add(17);
		myIntArray.add(24);
		myIntArray.add(1);
		myIntArray.add(5);
		myIntArray.add(2);
		myIntArray.add(4);
		myIntArray.add(6);
		myIntArray.add(9);
		myIntArray.add(8);
		myIntArray.add(12);
		myIntArray.add(11);
		myIntArray.add(13);
		myIntArray.add(15);
		myIntArray.add(20);
		myIntArray.add(16);
		myIntArray.add(18);
		myIntArray.add(19);
		myIntArray.add(23);
		myIntArray.add(22);
		myIntArray.add(30);
		myIntArray.add(27);
		myIntArray.add(28);
		myIntArray.add(29);
		myIntArray.add(14);
		myIntArray.add(25);
	
		
		BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		intTree.addAll(myIntArray);
		
		/*
		 * If implemented correctly, these prints should return:
		 * Theif
		 * macrosimulation
		 * Yawning
		 * Luck
		 * Salesperson
		 * Dagger
		 * Macaroon
		 */
		
		System.out.println(dictionary.size());
		System.out.println(dictionary.getRoot().item); //returning thief - correct.
		System.out.println(dictionary.getRoot().getLeftChild().item); //returning macrosimulation - correct
		System.out.println(dictionary.getRoot().getRightChild().item); //returning null incorrect, should return yawn
		System.out.println(dictionary.getRoot().getLeftChild().getLeftChild().item); //returning luck - correct
		System.out.println(dictionary.getRoot().getLeftChild().getRightChild().item); //returning null - incorrect, should return salesperson
		System.out.println(dictionary.getRoot().getLeftChild().getLeftChild().getLeftChild().item); //returning dagger - correct
		System.out.println(dictionary.getRoot().getLeftChild().getLeftChild().getRightChild().item); //returning null - incorrect should return macaroon

		dictionary.clear();
		
		
		//test writing a tree of size 20 to see what it looks like as a dot graph
		intTree.writeDot("intExample2-1.dot");
		
		intTree.remove(14);
		
		intTree.writeDot("intExample2-2.dot");
		/*
		System.out.println(intTree.getRoot().item);
		System.out.println(intTree.getRoot().leftChild.item);
		System.out.println(intTree.getRoot().leftChild.rightChild.item);
		System.out.println(intTree.getRoot().leftChild.leftChild.item);
		*/
	}
	
	
	private static List<String> readFile(File file) {
		ArrayList<String> words = new ArrayList<String>();
		
		try (Scanner fileInput = new Scanner(file)) {
			/*
			 * Java's Scanner class is a simple lexer for Strings and primitive
			 * types (see the Java API, if you are unfamiliar).
			 */

			/*
			 * The scanner can be directed how to delimit (or divide) the input.
			 * By default, it uses whitespace as the delimiter. The following
			 * statement specifies anything other than alphabetic characters as
			 * a delimiter (so that punctuation and such will be ignored). The
			 * string argument is a regular expression that specifies "anything
			 * but an alphabetic character". You need not understand any of this
			 * for the assignment.
			 */
			fileInput.useDelimiter("\\s*[^a-zA-Z]\\s*");

			while (fileInput.hasNext()) {
				String s = fileInput.next();
				if (!s.equals("")) {
					words.add(s.toLowerCase());
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("File " + file + " cannot be found.");
		}


		return words;
	}
	
    public static ArrayList<Integer> generateAverageCase(int size){
    	ArrayList<Integer> outputArray = generateBestCase(size);
    	Collections.shuffle(outputArray);
    	return outputArray;
    }
    
    public static ArrayList<Integer> generateBestCase(int size){
    	ArrayList<Integer> outputArray = new ArrayList<Integer>();
    	for (int i = 0; i < size; i++){
    		outputArray.add(i);
    	}
    	return outputArray;
    }
}
