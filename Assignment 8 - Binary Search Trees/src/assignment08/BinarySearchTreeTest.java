package assignment08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTreeTest {

	ArrayList<Integer> rightHeavy; //@Before cases makes this an array of 1 - 1000
	ArrayList<Integer> leftHeavy; //@Before cases makes this an array of 1000-1
	ArrayList<Integer> randomArray; //@Before cases makes this an array of randomly placed values 1-1000 
	ArrayList<Integer> emptyArray; //@Before cases sets this to be empty
	ArrayList<Integer> randomValues; //@Before cases sets this array to contain 100, 200, 300, 400 and 500 for containsAll and removeAll
	BinarySearchTree<Integer> testTree; //@Before cases generates testTree as an emptyTree
	BinarySearchTree<Integer> randomTree; //@Before cases generates randomTree as a tree with values inserted randomly
	
	
	@Before
	public void generateRightHeavySize1000() {
 	   	rightHeavy = new ArrayList<Integer>();
    	for (int i = 1; i <= 1000; i++){
    		rightHeavy.add(i);
    	}
	}
	
	@Before
	public void generateLeftHeavySize1000() {
    	leftHeavy = new ArrayList<Integer>();
    	for (int i = 1000; i >= 1; i--){
    		leftHeavy.add(i);
    	}
	}
	
	@Before
	public void generateRandomArraySize1000() {
    	randomArray = new ArrayList<Integer>();
    	randomArray = leftHeavy;
    	Collections.shuffle(randomArray);
	}
	
	@Before
	public void generateEmptyArray() {
		emptyArray = new ArrayList<Integer>();
	}
	
	@Before
	public void generateArrayRandomValues(){
		randomValues = new ArrayList<Integer>();
		randomValues.add(100);
		randomValues.add(200);
		randomValues.add(300);
		randomValues.add(400);
		randomValues.add(500);	
	}
	
	@Before
	public void generateEmptyBSTTreeTypeInt() {
		testTree = new BinarySearchTree<Integer>();
	}
	
	@Before
	public void generateRandomBSTTreeTypeInt() {
		randomTree = new BinarySearchTree<Integer>();
    	ArrayList<Integer> tempRandomArray = new ArrayList<Integer>();
    	ArrayList<Integer> tempLeftHeavy = new ArrayList<Integer>();
    	for (int i = 1000; i >= 1; i--){
    		tempLeftHeavy.add(i);
    	}  	
    	tempRandomArray = tempLeftHeavy;
    	Collections.shuffle(tempRandomArray);
		randomTree.addAll(tempRandomArray);
	}
	
	@Test
	public void testAddCollectionRightHeavy(){    	
		testTree.addAll(rightHeavy);
		
		assertEquals(1000, testTree.size());
		assertEquals(1, (int)testTree.first());
		assertEquals(true, testTree.contains(500));
		assertEquals(1000, (int)testTree.last());
	}
	
	@Test
	public void testAddCollectionLeftHeavy(){    	
		testTree.addAll(leftHeavy);
		
		assertEquals(1000, testTree.size());
		assertEquals(1, (int)testTree.first());
		assertEquals(true, testTree.contains(500));
		assertEquals(1000, (int)testTree.last());
	}
	
	public void testAddCollectionRandomAddition(){    	
		testTree.addAll(randomArray);
		
		assertEquals(1000, testTree.size());
		assertEquals(1, (int)testTree.first());
		assertEquals(true, testTree.contains(500));
		assertEquals(1000, (int)testTree.last());
	}
	
	@Test
	public void testAddSingleRightHeavyIntegers(){    	
		for(int i = 1; i <= 1000; i++)
		{
			testTree.add(i);
		}
		
		assertEquals(1000, testTree.size());
		assertEquals(1, (int)testTree.first());
		assertEquals(true, testTree.contains(500));
		assertEquals(1000, (int)testTree.last());
	}
	
	@Test
	public void testAddSingleRandom(){    	

		testTree.add(10);
		testTree.add(5);
		testTree.add(15);
		testTree.add(3);
		testTree.add(7);
		testTree.add(13);
		testTree.add(17);
		
		
		assertEquals(7, testTree.size());
		assertEquals(3, (int)testTree.first());
		assertEquals(false, testTree.contains(4));
		assertEquals(true, testTree.contains(3));
		assertEquals(17, (int)testTree.last());
	}
	
	@Test
	public void testAddOneItemGetFirstAndLast(){    	

		testTree.add(10);
				
		assertEquals(1, testTree.size());
		assertEquals(10, (int)testTree.first());
		assertEquals(false, testTree.contains(4));
		assertEquals(true, testTree.contains(10));
		assertEquals(10, (int)testTree.last());
	}
	
	
	
	@Test
	public void randomTreeToSortedArrayList(){    	

		ArrayList<Integer> randomResult = randomTree.toArrayList();
		
		assertEquals(1000, randomResult.size());
		
		for(int i = 0; i > 1000; i++){
		assertEquals(i+1, (int)randomResult.get(i));
		}
	}
	
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void randomTreeToSortedArrayListOutOfBounds(){    	

		ArrayList<Integer> randomResult = randomTree.toArrayList();

		randomResult.get(1000);
		
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void emptyTreeToArrayListOutOfBounds(){    	

		testTree.addAll(emptyArray);
		emptyArray = testTree.toArrayList();
		
		//throws exception
		System.out.println(emptyArray.get(0));
		
	}
	
	@Test 
	public void randomTreeRemoveAll1To1000(){    	

		randomTree.removeAll(rightHeavy);
		assertEquals(0, randomTree.size());
		assertEquals(true, randomTree.isEmpty());
		assertEquals(true, randomTree.containsAll(emptyArray));
		
	}
	
	@Test 
	public void randomTreeRemoveAll1To999(){    	

		rightHeavy.remove(999);
		
		randomTree.removeAll(rightHeavy);
		assertEquals(1, randomTree.size());
		assertEquals(1000, (int)randomTree.first());
		assertEquals(1000, (int)randomTree.last());
		
	}
	
	@Test 
	public void testTreeAddingDuplicates(){    	

		testTree.add(10);
		testTree.add(10);
		testTree.add(10);
		
		assertEquals(1, testTree.size());	
		
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testTreeGetFirstWhileEmptyNoSuchElement(){
		
		assertEquals(0, testTree.size());
		
		testTree.first();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testTreeGetLastWhileEmptyNoSuchElement(){
		assertEquals(0, testTree.size());
		
		testTree.last();
		
	}
	
	@Test
	public void randomTreeContainsAllRandomValuesArray(){
		
		assertEquals(true, randomTree.containsAll(randomValues));
	}
	
	@Test
	public void randomTreeContainsAllRandomValuesArrayAfterRemove(){
		
		randomTree.removeAll(randomValues);
		assertEquals(false, randomTree.containsAll(randomValues));
		assertEquals(false, randomTree.contains(100));
		assertEquals(false, randomTree.contains(200));
		assertEquals(false, randomTree.contains(300));
		assertEquals(false, randomTree.contains(400));
		assertEquals(false, randomTree.contains(500));
		
	}
	
	@Test
	public void clearRandomTreeTreeIsItEmpty(){
		randomTree.clear();
		assertEquals(true, randomTree.isEmpty());
	}
	
	
}
