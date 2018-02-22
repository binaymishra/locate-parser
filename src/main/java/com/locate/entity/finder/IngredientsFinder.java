package com.locate.entity.finder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

public class IngredientsFinder extends NamedEntityFinder{
	
	public IngredientsFinder(InputStream model) throws Exception {
		super(model);
	}
	

	public static void train(File trainingFile, File modelFile) throws Exception {

	    ObjectStream<String> in = new PlainTextByLineStream(new MarkableFileInputStreamFactory(trainingFile), charset);
	    ObjectStream<NameSample> samples = new NameSampleDataStream(in);
	    TokenNameFinderModel model;
	    try{
	      model = NameFinderME.train("en", "ingredient", samples, TrainingParameters.defaultParams(),new TokenNameFinderFactory());
	    }finally {
	      samples.close();
	      in.close();
	    }

	    BufferedOutputStream modelOut = new BufferedOutputStream(new FileOutputStream(modelFile, true));
	    try{
	      model.serialize(modelOut);
	    }finally {
	      modelOut.flush();
	      modelOut.close();
	    }
	}

}
