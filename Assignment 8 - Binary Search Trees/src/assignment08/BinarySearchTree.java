package assignment08;

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
	
	private class BinaryNode<E> {

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
		if (size == 0){
			root.item = item;
			size++;
			return true;
		}
		
		// Find the parent node that will link to the new node
		BinaryNode<T> parentNode = BSTsearch(root, item);
		
		// If the item is less than the parent node, put it into the left child node
		if (item.compareTo(parentNode.item) < 0){
			parentNode.leftChild = new BinaryNode<>();
			parentNode.leftChild.item = item;
			size++;
			return true;
		}
		
		// If the item is greater than the parent node, put it into the right child node
		if (item.compareTo(parentNode.item) > 0){
			parentNode.rightChild = new BinaryNode<>();
			parentNode.rightChild.item = item;
			size++;
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method call.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
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
		return null;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted order.
	 */
	@Override
	public ArrayList<T> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private BinaryNode<T> BSTsearch (BinaryNode<T> node, T item){
		
		// If the item equals the specified node
		if (item.equals(node.item)){
			return node;
		}
		
		// If the item is less than the specified node
		if (item.compareTo(node.item) < 0){
			if (node.leftChild != null){
				return BSTsearch(node.leftChild, item);
			}
			else{
				return node;
			}
		}
		
		// If the item is greater than the specified node
		else if (item.compareTo(node.item) > 0){
			
			if (node.leftChild != null){
				return BSTsearch(node.leftChild, item);
			}
			
			else{
				return node;
			}
		}
		
		else{
			return node;
		}
	}

}
