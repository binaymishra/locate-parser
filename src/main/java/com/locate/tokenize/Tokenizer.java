package com.locate.tokenize;

import java.io.File;
import java.io.IOException;

import com.locate.utils.Utils;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 * @author Binay Mishra
 *
 */
public class Tokenizer extends TokenizerME{
	
	private static final String TOKEN_MODEL_FILE    = "en-token.bin";
	
	public Tokenizer() throws Exception {
		super(new TokenizerModel(Utils.getModelAsInputStream(TOKEN_MODEL_FILE)));
	}
	
	public Tokenizer(File modelFile) throws IOException {
		super(new TokenizerModel(modelFile));
	}
	
	@Override
	public String[] tokenize(String line) {
		return super.tokenize(line);
	}
}
