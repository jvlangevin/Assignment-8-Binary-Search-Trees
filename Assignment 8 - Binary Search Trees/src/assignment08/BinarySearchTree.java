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

	public class BinaryNode<E> {

		E item;
		BinaryNode<E> leftChild;
		BinaryNode<E> rightChild;

		public BinaryNode(){
			item = null;
		}

		/**
		 * 
		 * @return True if the specified node is a leaf node (i.e. does not have any child nodes), returns false
		 *         otherwise
		 */
		public boolean isLeaf() {
			return (leftChild == null && rightChild == null);
		}

		/**
		 * helper class to check if items are being loaded correctly. to be deleted later
		 * 
		 * @return
		 */

		public BinaryNode<E> getLeftChild() {
			return this.leftChild;
		}

		public BinaryNode<E> getRightChild() {
			return this.rightChild;
		}
	}

	/**
	 * Helper method for viewing the binary tree info in testing, to be deleted later
	 * 
	 * @return
	 */
	public BinaryNode<T> getRoot() {
		return this.root;
	}

	/**
	 * Constructor
	 */
	public BinarySearchTree(){
		root = new BinaryNode<>();
	}

	@Override

	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item
	 *            - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if the input item was actually
	 *         inserted); otherwise, returns false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	public boolean add(T item) {

		// If there are no items currently in the tree, put the item into the root node
		if (size == 0) {
			this.root.item = item;
			size++;
			return true;
		}

		// Find the parent node that will link to the new node
		BinaryNode<T> parentNode = BSTsearch(root, item);

		// If the item is less than the parent node, put it into the left child node
		if (item.compareTo(parentNode.item) < 0) {

			parentNode.leftChild = new BinaryNode<>();
			parentNode.leftChild.item = item;
			this.size++;
			return true;
		}

		// If the item is greater than the parent node, put it into the right child node
		else if (item.compareTo(parentNode.item) > 0) {

			parentNode.rightChild = new BinaryNode<>();
			parentNode.rightChild.item = item;
			this.size++;
			return true;
		}

		return false;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items
	 *            - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if any item in the input collection
	 *         was actually inserted); otherwise, returns false
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean addAll(Collection<? extends T> items) {
		for (T item : items) {
			if (!this.add(item)) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method call.
	 */
	@Override
	public void clear() {
		root.item = null;

		BinaryNode<T> nothingLeft = null;
		BinaryNode<T> nothingRight = null;
		root.leftChild = nothingLeft;
		root.rightChild = nothingRight;
		this.size = 0;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified item.
	 * 
	 * @param item
	 *            - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item; otherwise, returns false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean contains(T item) {

		BinaryNode<T> parentNode = BSTsearch(this.root, item);

		// if the item is in the parent node - cover case of root containing item
		if (item.equals(parentNode.item)) {
			return true;
		}

		// if the item is in the left node
		if (parentNode.leftChild != null && item.equals(parentNode.leftChild.item)) {
			return true;
		}

		// if the item is in the right node
		if (parentNode.rightChild != null && item.equals(parentNode.rightChild.item)) {
			return true;
		}

		// if not contained
		return false;
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in this set that is equal to it.
	 * 
	 * @param items
	 *            - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item in this set that is equal to it;
	 *         otherwise, returns false
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean containsAll(Collection<? extends T> items) {

		for (T item : items) {
			if (!this.contains(item)) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public T first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		
		if (this.isEmpty()){
			throw new NoSuchElementException();
		}
		
		if (size == 1){
			return root.item;
		}
		
		BinaryNode<T> firstNode = root;
		
		while (root.leftChild != null){
			
		}
		return null;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public T last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item
	 *            - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if the input item was actually
	 *         removed); otherwise, returns false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ensures that this set does not contain any of the items in the specified collection.
	 * 
	 * @param items
	 *            - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if any item in the input collection
	 *         was actually removed); otherwise, returns false
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean removeAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Recursive helper method for toArrayList method. Performs a depth-first, in-order traversal
	 * of the tree to ensure that items are added to the ArrayList in the proper order.
	 * 
	 * @param list - The ArrayList that the items will be added to
	 * @param node - The root node of a tree or subtree
	 */
	private void addToArrayList(ArrayList<T> list, BinaryNode<T> node){
		
		if (node == null){
			return;
		}
		
		addToArrayList(list, node.leftChild);
		list.add(node.item);
		addToArrayList(list, node.rightChild);
	}
	
	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted order.
	 */
	@Override
	public ArrayList<T> toArrayList() {

		ArrayList<T> list = new ArrayList<>();
		addToArrayList(list, root);
		return list;
	}

	/**
	 * Helper method designed to search through a binary search tree (bst) and return a specific node This allows for
	 * easier implementation of the add and contains method
	 * 
	 * @param node
	 *            - the node to start at
	 * @param item
	 *            - the item we will either be adding or checking to see if it is contained
	 * @return - return a BinaryNode that we will either be adding a node after or returning if item is contained
	 */
	private BinaryNode<T> BSTsearch(BinaryNode<T> node, T newItem) {

		// if it's contained in the root, return root
		if (newItem.equals(this.root.item)) {
			return root;
		}

		// If the item is found in either of the child nodes, return this parent.
		if (node.leftChild != null && node.rightChild != null) {
			if (newItem.equals(node.leftChild.item) || newItem.equals(node.rightChild.item)) {

				return node;
			}
		}

		// If the item is less than the specified node
		if (newItem.compareTo(node.item) < 0) {

			if (node.leftChild != null) {

				return BSTsearch(node.leftChild, newItem);
			} else {

				return node;
			}
		}

		// If the item is greater than the specified node
		else if (newItem.compareTo(node.item) > 0) {

			if (node.rightChild != null) {

				return BSTsearch(node.rightChild, newItem);
			}

			else {

				return node;
			}
		}

		else {
			return node;
		}
	}

	// Driver for writing this tree to a dot file
	public void writeDot(String filename) {
		try {
			// PrintWriter(FileWriter) will write output to a file
			PrintWriter output = new PrintWriter(new FileWriter(filename));

			// Set up the dot graph and properties
			output.println("digraph BST {");
			output.println("node [shape=record]");

			if (root != null)
				writeDotRecursive(root, output);
			// Close the graph
			output.println("}");
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Recursive method for writing the tree to a dot file
	private void writeDotRecursive(BinaryNode<T> node, PrintWriter output) throws Exception {
		output.println(node.item + "[label=\"<L> |<D> " + node.item + "|<R> \"]");
		if (node.leftChild != null) {
			// write the left subtree
			writeDotRecursive(node.leftChild, output);

			// then make a link between n and the left subtree
			output.println(node.item + ":L -> " + node.leftChild.item + ":D");
		}
		if (node.rightChild != null) {
			// write the left subtree
			writeDotRecursive(node.rightChild, output);

			// then make a link between n and the right subtree
			output.println(node.item + ":R -> " + node.rightChild.item + ":D");
		}

	}

	

}
