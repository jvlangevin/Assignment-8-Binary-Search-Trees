package assignment08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

import org.junit.Before;
import org.junit.Test;


/**
 * A JUnit test case for SpellChecker
 * @author Nathan
 *
 */
public class SpellCheckerTest {

	SpellChecker dictionaryFile;
	SpellChecker emptyDictionary;
	List<String> testList;
	//SpellChecker listDictionary;
	
	@Before
	public void constructDictionaryFromFile() {
		dictionaryFile = new SpellChecker(new File("dictionary.txt"));
	}
	

	@Before
	public void constructemptyDictionary() {
		emptyDictionary = new SpellChecker();
	} 

	@Before
	public void constructTestList() {
		testList = new ArrayList<String>();
		testList.add("this");
		testList.add("is");
		testList.add("only");
		testList.add("a");
		testList.add("test");
	} 
	
	@Test
	public void addAFewStringsToEmptyDictionary(){
		
		
		
		emptyDictionary.addToDictionary("this");
		emptyDictionary.addToDictionary("is");
		emptyDictionary.addToDictionary("only");
		emptyDictionary.addToDictionary("a");
		emptyDictionary.addToDictionary("test");
		emptyDictionary.addToDictionary("pfft");
		
		
		List<String> misspelledWords = emptyDictionary.spellCheck(new File("test.txt"));
		
		assertEquals("pffft", misspelledWords.get(0));
		
	}
	
	@Test
	public void addAFewStringsToEmptyDictionaryThenRemove(){
		
		
		
		emptyDictionary.addToDictionary("This");
		emptyDictionary.addToDictionary("is");
		emptyDictionary.addToDictionary("only");
		emptyDictionary.addToDictionary("a");
		emptyDictionary.addToDictionary("test");
		emptyDictionary.addToDictionary("pfft");
				
		emptyDictionary.removeFromDictionary("only");
		List<String> misspelledWords = emptyDictionary.spellCheck(new File("test.txt"));
		
			
		assertEquals("only", misspelledWords.get(0));
		assertEquals("pffft", misspelledWords.get(1));
		
	}

	
	@Test
	public void addListToEmptyDictionary(){
		
		SpellChecker testSC = new SpellChecker(testList);
		
		List<String> misspelledWords = testSC.spellCheck(new File("test.txt"));
		assertEquals("pffft", misspelledWords.get(0));
	}
	
	@Test 
	public void testDictionaryFromFile(){
		
		List<String> misspelledWords = dictionaryFile.spellCheck(new File("hello_world.txt"));
		assertEquals(true, misspelledWords.isEmpty());
		
	}
	
	@Test 
	public void testDictionaryFromFileRemoveWorld(){
		
		dictionaryFile.removeFromDictionary("world");
		List<String> misspelledWords = dictionaryFile.spellCheck(new File("hello_world.txt"));
		assertEquals(false, misspelledWords.isEmpty());
		assertEquals("world", misspelledWords.get(0));
		
	}

}
