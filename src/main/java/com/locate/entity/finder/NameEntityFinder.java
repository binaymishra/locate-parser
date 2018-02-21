package com.locate.entity.finder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

/**
 * @author Binay Mishra
 *
 */
public class NameEntityFinder  extends NameFinderME implements EntityFinder<String[], List<String>>{

	public NameEntityFinder(File modelFile) throws IOException {
		super(new TokenNameFinderModel(modelFile));
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
