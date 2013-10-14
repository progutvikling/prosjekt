
package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import dal.admin.KeywordsStore;


public class KeywordsStoreTest {
	
	KeywordsStore store;
	
	@Before
	public void initDatabaseConnection() {
		store = new KeywordsStore();
	}
	
	@Test
	public void addKeywordTest() {
		assertTrue("Should return true if added", store.addKeyword("Adding"));
	}
	
	@Test
	public void deleteKeywordTest() {
	    String randomKeyword = String.valueOf(UUID.randomUUID());

		assertFalse("Should return false if the keyword doesn't exist.",
					store.deleteKeyword(randomKeyword));
		
		store.addKeyword(randomKeyword);
		assertTrue("Should successfully delete the existing keyword. (this depends on addKeyword working well)",
				   store.deleteKeyword(randomKeyword));
	}

	@Test
	public void getKeywords() {
		ArrayList<String> randomKeywords = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			String random = String.valueOf(UUID.randomUUID());
			randomKeywords.add(random);
			store.addKeyword(random);
		}

		ArrayList<String> keywords = store.getKeywords();
		for (String random : randomKeywords) {
			assertTrue("Should retrieve the keywords added (depends on addKeyword).",
					   keywords.contains(random));
			store.deleteKeyword(random);
		}
	}
}
