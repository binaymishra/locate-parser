package com.locate.entity.finder.test;

import java.io.File;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.locate.entity.finder.NameEntityFinder;
import com.locate.tokenize.Tokenizer;

public class NameEntityFinderTest {
	
private static final Logger log = LoggerFactory.getLogger(NameEntityFinderTest.class);
	
	private static final String MODEL_FILE 		 = "en-ner-person.bin";
	private static final String TOKEN_MODEL_FILE = "en-token.bin";
	
	private static NameEntityFinder nameEntityFinder;
	
	private static Tokenizer tokenizer;
	
	@BeforeClass
	public static void init() throws Exception {
		log.debug("Token model file = {}", TOKEN_MODEL_FILE);
		tokenizer = new Tokenizer(new File(TOKEN_MODEL_FILE));
		log.debug("Person model file = {}", MODEL_FILE);
		nameEntityFinder = new NameEntityFinder(new File(MODEL_FILE));
	}
	
	@Test
	public void findEntity() {
		Arrays.asList(
				"Where is Charlie and Mike.", 
				"Who is John Doe ?",
				"My name is Binay Mishra.")
				.forEach(line -> {
					log.info("{} : {} ", line, nameEntityFinder.findEntity(tokenizer.tokenize(line)));
				});
		
	}

}
