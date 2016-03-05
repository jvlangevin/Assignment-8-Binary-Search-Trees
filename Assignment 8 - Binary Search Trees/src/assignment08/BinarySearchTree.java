package assignment08;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * A binary search tree consisting of generic elements.
 * 
 * @author
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {

	private BinaryNode<T> root;
	private int size;

	/**
	 * Helper class that defines a binary node in the binary search tree. Each node contains an item and can have a leftChild
	 * child node and/or a rightChild child node.
	 *
	 * @param <E>
	 */
	private class BinaryNode<E> {

		E item;
		BinaryNode<E> leftChild;
		BinaryNode<E> rightChild;

		public BinaryNode(E item){
			this.item = item;
			this.leftChild = null;
			this.rightChild = null;
		}

		/**
		 * 
		 * @param node
		 *            - A binary node
		 * @return True if the specified node is a leaf node (i.e. if the node does not have any child nodes), returns
		 *         false otherwise.
		 */
		public boolean isLeaf() {
			return (this.leftChild == null && this.rightChild == null);
		}
	}

	public BinarySearchTree(){
		this.root = new BinaryNode<T>(null);
		this.size = 0;
	}

	@Override
	public boolean add(T item) {

		// If there are no items currently in the tree, assign the item to the root node
		if (this.size == 0) {
			this.root.item = item;
			this.size++;
			return true;
		}

		else {

			// Searches the tree for the parent node that will link to the new item
			BinaryNode<T> parentNode = BSTsearch(root, item);

			// If the item is less than the parent node, put it into the leftChild child node
			if (item.compareTo(parentNode.item) < 0) {
				parentNode.leftChild = new BinaryNode<T>(item);
				size++;
				return true;
			}

			// If the item is greater to the parent node, put it into the rightChild child node
			else if (item.compareTo(parentNode.item) >= 0) {
				parentNode.rightChild = new BinaryNode<T>(item);
				size++;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> items) {
		
		int startSize = size; // The initial size of the tree

		for (T item : items) {
			this.add(item);
		}

		// If the size of the tree changed (i.e. one or more items were added to the tree)
		if (size != startSize) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		root.leftChild = null;
		root.rightChild = null;
		root.item = null;
		size = 0;
	}

	@Override
	public boolean contains(T item) {
		
		if (size == 1 && item == root.item) {
			return true;
		}
		
		if (item == BSTsearch(root, item).item){
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends T> items) {

		for (T item : items){
			if (!this.contains(item)){
				return false;
			}
		}
		return true;
	}

	@Override
	public T first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public T last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		
		if (size == 1 && root.item == item) {
			this.clear();
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Recursive helper method for toArrayList method. Copies the elements of a binary search tree to an ArrayList by
	 * performing a depth-first, in-order traversal of the tree to ensure that the elements are added to the ArrayList
	 * in the correct order.
	 * 
	 * @param list
	 *            - The ArrayList that will contain the elements of the binary search tree
	 * @param node
	 *            - The root node of a tree or subtree
	 */
	private void addToArrayList(ArrayList<T> list, BinaryNode<T> node) {

		if (node == null) {
			return;
		}

		addToArrayList(list, node.leftChild);
		list.add(node.item);
		addToArrayList(list, node.rightChild);
	}

	@Override
	public ArrayList<T> toArrayList() {

		ArrayList<T> list = new ArrayList<>();
		addToArrayList(list, this.root);

		return list;
	}

	private BinaryNode<T> BSTsearch(BinaryNode<T> node, T item) {

		if (item.compareTo(node.item) < 0) {
			
			if (node.leftChild != null) {
				return BSTsearch(node.leftChild, item);
			} 
			
			else {
				return node;
			}
		}

		else if (item.compareTo(node.item) > 0) {
			
			if (node.rightChild != null) {
				return BSTsearch(node.rightChild, item);
				
			} 
			
			else {
				return node;
			}
		}

		return node;
	}
	
	// Driver for writing this tree to a dot file
		public void writeDot(String filename)
		{
			try {
				// PrintWriter(FileWriter) will write output to a file
				PrintWriter output = new PrintWriter(new FileWriter(filename));
				
				// Set up the dot graph and properties
				output.println("digraph BST {");
				output.println("node [shape=record]");
				
				if(root != null)
					writeDotRecursive(root, output);
				// Close the graph
				output.println("}");
				output.close();
			}
			catch(Exception e){e.printStackTrace();}
		}

		
		// Recursive method for writing the tree to  a dot file
		private void writeDotRecursive(BinaryNode<T> n, PrintWriter output) throws Exception
		{
			output.println(n.item + "[label=\"<L> |<D> " + n.item + "|<R> \"]");
			if(n.leftChild != null)
			{
				// write the leftChild subtree
				writeDotRecursive(n.leftChild, output);
				
				// then make a link between n and the leftChild subtree
				output.println(n.item + ":L -> " + n.leftChild.item + ":D" );
			}
			if(n.rightChild != null)
			{
				// write the leftChild subtree
				writeDotRecursive(n.rightChild, output);
				
				// then make a link between n and the rightChild subtree
				output.println(n.item + ":R -> " + n.rightChild.item + ":D" );
			}
			
		}

	public static void main(String args[]) {
		BinarySearchTree<String> bst = new BinarySearchTree<>();
		bst.add("a");
		bst.add("c");
		bst.add("b");
		bst.add("d");
		bst.add("e");
		bst.add("f");

		bst.writeDot("bst.dot.dot");


	}
}
