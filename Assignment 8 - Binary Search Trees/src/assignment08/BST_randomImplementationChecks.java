package assignment08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BST_randomImplementationChecks {

	public static <E> void main(String[] args){
		

		//this is more or less what Spell
		List<String> myArray = readFile(new File("dictionary.txt"));
		BinarySearchTree<String> dictionary = new BinarySearchTree<String>();
		dictionary.addAll(myArray);
		
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
		System.out.println(dictionary.size());
		System.out.println(dictionary.getRoot().item); //returning null after clear
		System.out.println(dictionary.getRoot().getLeftChild()); //returning null after clear
		System.out.println(dictionary.getRoot().getRightChild()); //returning null after clear
		
		dictionary.add("Jello");
		dictionary.add("WhatTheWhat");
		dictionary.add("Apple");
		
		
		//Should now be Jello, Apple, WhatTheWhat
		
		System.out.println(dictionary.getRoot().item);
		System.out.println(dictionary.getRoot().leftChild);
		System.out.println(dictionary.getRoot().rightChild.item);
		System.out.println(dictionary.getRoot().rightChild.leftChild);
		System.out.println(dictionary.getRoot().rightChild.rightChild.item);
		
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
}
