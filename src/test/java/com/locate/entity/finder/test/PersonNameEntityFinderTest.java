package com.locate.entity.finder.test;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.locate.entity.finder.PersonNameEntityFinder;
import com.locate.tokenize.Tokenizer;
import com.locate.utils.Utils;

public class PersonNameEntityFinderTest {
	
private static final Logger log = LoggerFactory.getLogger(PersonNameEntityFinderTest.class);
	
	private static final String TRAINING_MODEL_FILE = "en-ner-person.train";
	
	private static PersonNameEntityFinder nameEntityFinder;
	
	private static Tokenizer tokenizer;
	
	@BeforeClass
	public static void init() throws Exception {
		tokenizer = new Tokenizer();
		nameEntityFinder = new PersonNameEntityFinder();
		
		// Train model.
		PersonNameEntityFinder.train(Utils.getTrainerAsFile(TRAINING_MODEL_FILE));
		
	}
	
	
	
	@Test
	public void findEntity() {
		Arrays.asList(
				"Where is Charlie and Mike.", 
				"Who is John Doe ?",
				"My name Pierre Vinken and my friend is Binay Mishra.")
				.forEach(line -> {
					log.info("{} : {} ", line, nameEntityFinder.findEntity(tokenizer.tokenize(line)));
				});
		
	}

}
