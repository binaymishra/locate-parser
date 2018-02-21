package com.locate.tokenize;

import java.io.File;
import java.io.IOException;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 * @author Binay Mishra
 *
 */
public class Tokenizer extends TokenizerME{
	
	public Tokenizer(File modelFile) throws IOException {
		super(new TokenizerModel(modelFile));
	}
	
	@Override
	public String[] tokenize(String line) {
		return super.tokenize(line);
	}
}
