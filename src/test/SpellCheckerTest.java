package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	@Test
	void test() {
		// create the object to be tested
		SpellChecker checker = new SpellChecker();
		// call the method being tested
		int words = checker.getNumberOfWords();
		// use assertion to validate
		assertEquals(0, words);
	}

	@Test
	void testAddWord() {
		SpellChecker checker = new SpellChecker();
		int currentWords = checker.getNumberOfWords();
		assertEquals(0, currentWords);
		// every time a new word is added, the number of words should increase by 1
		checker.addWord("hello");
		currentWords++;
		assertEquals(currentWords, checker.getNumberOfWords());
	}

	@Test
	void testDuplicate() {
		SpellChecker checker = new SpellChecker();
		int words = checker.getNumberOfWords();
		assertEquals(0, words);
		// if a word is added twice, the number of words should not increase
		checker.addWord("hello");
		checker.addWord("hello");
		assertEquals(1, checker.getNumberOfWords());
		// if i add a different word, the number of words should increase by 1
		checker.addWord("world");
		assertEquals(2, checker.getNumberOfWords());

	}

	@Test
	void testCorrectSpelling() {
		SpellChecker checker = new SpellChecker();
		// if a word is spelled correctly, it should be added and indicated that its spelled correctly
		checker.addWord("hello");
		assertTrue(checker.isSpelledCorrectly("hello"));
		assertFalse(checker.isSpelledCorrectly("world"));
		checker.addWord("world");
		assertTrue(checker.isSpelledCorrectly("world"));
	}

	@Test
	void testIncorrectSpelling() {
		SpellChecker checker = new SpellChecker();
		// if a word is spelled incorrectly, it should be added and indicated that its not spelled correctly
		checker.addWord("hello");
		assertFalse(checker.isSpelledCorrectly("hhello"));

	}

	@Test
	void testIgnoreCase() {
		SpellChecker checker = new SpellChecker();
		// if a word is added in a certain case, it should be recognized as correct regardless of the case
		checker.addWord("hello");
		assertTrue(checker.isSpelledCorrectly("Hello"));
		assertTrue(checker.isSpelledCorrectly("HELLO"));
	}

	@Test
	void testRecommend() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("hello");
		// if a word is misspelled, the spell checker should recommend the correct spelling
		assertEquals("hello", checker.recommend("hhello"));
	}
	
	@Test
	void testRecommendWord(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("hello");
		// if we ask to suggest a word that it already properly spelled, it should return the word
		assertEquals("hello", checker.recommend("hello"));
	}

	@Test
	void testRecommendNoMatch() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("hello");
		// if we ask to suggest a word that has no close match, it should return null
		assertNull(checker.recommend("nkjdewnklf"));
	}

	@Test
	void testEmptyWord() {
		SpellChecker checker = new SpellChecker();
		// if we add an empty word, it should not be added and the number of words should not increase
		checker.addWord("hello");
		assertNull(checker.recommendWord("");
	}
	

}

