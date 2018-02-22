package com.locate.tokenize.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.locate.tokenize.Tokenizer;
import com.locate.utils.Utils;

public class TokenizerTest {
	
	private static final Logger log = LoggerFactory.getLogger(TokenizerTest.class);
	
	private static final String MODEL_FILE = "en-token.bin";
	
	private static Tokenizer tokenizer;
	
	@BeforeClass
	public static void init() throws Exception{
		log.debug("Token model file = {}", MODEL_FILE);
		tokenizer = new Tokenizer(Utils.getModelAsFile(MODEL_FILE));
	}
	
	@Test
	public void tokenize() {
		final String input = "Apache OpenNLP Developer Documentation";
		log.debug("tokenizing input = {}", input);
		String[] output = tokenizer.tokenize(input);
		log.debug("output= {}", Arrays.toString(output));
		Assert.assertTrue(output.length == 4);
	}

}
