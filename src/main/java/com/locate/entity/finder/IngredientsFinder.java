package com.locate.entity.finder;

import java.io.File;
import java.io.InputStream;

public class IngredientsFinder extends NamedEntityFinder{
	
	public IngredientsFinder(InputStream model) throws Exception {
		super(model);
	}
	
	public static void train(File trainingFile, File modelFile) throws Exception {
		NamedEntityFinder.train(trainingFile, modelFile);
	}

}
