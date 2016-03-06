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
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T>
{
	
	/**
	 * Constructor
	 */
	public BinarySearchTree()
	{
		// TODO Auto-generated constructor stub
	}
	@Override
	
  /**
   * Ensures that this set contains the specified item.
   * 
   * @param item
   *          - the item whose presence is ensured in this set
   * @return true if this set changed as a result of this method call (that is,
   *         if the input item was actually inserted); otherwise, returns false
   * @throws NullPointerException
   *           if the item is null
   */
	public boolean add(T item)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
  /**
   * Ensures that this set contains all items in the specified collection.
   * 
   * @param items
   *          - the collection of items whose presence is ensured in this set
   * @return true if this set changed as a result of this method call (that is,
   *         if any item in the input collection was actually inserted);
   *         otherwise, returns false
   * @throws NullPointerException
   *           if any of the items is null
   */
	@Override
	public boolean addAll(Collection<? extends T> items)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
  /**
   * Removes all items from this set. The set will be empty after this method
   * call.
   */
	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		
	}

	
  /**
   * Determines if there is an item in this set that is equal to the specified
   * item.
   * 
   * @param item
   *          - the item sought in this set
   * @return true if there is an item in this set that is equal to the input
   *         item; otherwise, returns false
   * @throws NullPointerException
   *           if the item is null
   */
	@Override
	public boolean contains(T item)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
  /**
   * Determines if for each item in the specified collection, there is an item
   * in this set that is equal to it.
   * 
   * @param items
   *          - the collection of items sought in this set
   * @return true if for each item in the specified collection, there is an item
   *         in this set that is equal to it; otherwise, returns false
   * @throws NullPointerException
   *           if any of the items is null
   */
	@Override
	public boolean containsAll(Collection<? extends T> items)
	{
		// TODO Auto-generated method stub
		return false;
	}

  /**
   * Returns the first (i.e., smallest) item in this set.
   * 
   * @throws NoSuchElementException
   *           if the set is empty
   */
	@Override
	public T first() throws NoSuchElementException
	{
		// TODO Auto-generated method stub
		return null;
	}

  /**
   * Returns true if this set contains no items.
   */
	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	
  /**
   * Returns the last (i.e., largest) item in this set.
   * 
   * @throws NoSuchElementException
   *           if the set is empty
   */
	@Override
	public T last() throws NoSuchElementException
	{
		// TODO Auto-generated method stub
		return null;
	}

  /**
   * Ensures that this set does not contain the specified item.
   * 
   * @param item
   *          - the item whose absence is ensured in this set
   * @return true if this set changed as a result of this method call (that is,
   *         if the input item was actually removed); otherwise, returns false
   * @throws NullPointerException
   *           if the item is null
   */
	@Override
	public boolean remove(T item)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
  /**
   * Ensures that this set does not contain any of the items in the specified
   * collection.
   * 
   * @param items
   *          - the collection of items whose absence is ensured in this set
   * @return true if this set changed as a result of this method call (that is,
   *         if any item in the input collection was actually removed);
   *         otherwise, returns false
   * @throws NullPointerException
   *           if any of the items is null
   */
	@Override
	public boolean removeAll(Collection<? extends T> items)
	{
		// TODO Auto-generated method stub
		return false;
	}

  /**
   * Returns the number of items in this set.
   */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

  /**
   * Returns an ArrayList containing all of the items in this set, in sorted
   * order.
   */
	@Override
	public ArrayList<T> toArrayList()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
