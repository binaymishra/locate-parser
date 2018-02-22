package com.locate.entity.finder;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class NamedEntityFinder extends NameFinderME implements EntityFinder<String[], List<String>>{
	
	final static Charset charset = Charset.forName("UTF-8");

	public NamedEntityFinder(InputStream model) throws Exception {
		super(new TokenNameFinderModel(model));
	}

	@Override
	public List<String> findEntity(String[] tokens) {
		Span[] spans = super.find(tokens);
		List<String> entities = new ArrayList<>(tokens.length);
		for(String entity: Span.spansToStrings(spans, tokens))
			entities.add(entity);
		return entities;
	}
}
