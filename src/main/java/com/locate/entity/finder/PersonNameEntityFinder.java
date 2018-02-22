package com.locate.entity.finder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.locate.utils.Utils;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import opennlp.tools.util.TrainingParameters;

/**
 * @author Binay Mishra
 *
 */
public class PersonNameEntityFinder  extends NameFinderME implements EntityFinder<String[], List<String>>{
	
	private static final String MODEL_FILE_NAME = "en-ner-person.bin";
	
	final static Charset charset = Charset.forName("UTF-8");
	
	public PersonNameEntityFinder() throws Exception {
		super(new TokenNameFinderModel(Utils.getModelAsInputStream(MODEL_FILE_NAME)));
	}

	public PersonNameEntityFinder(File modelFile) throws IOException {
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
	
	public static void train(File trainingFile) throws IOException{
	    ObjectStream<String> in = new PlainTextByLineStream(new MarkableFileInputStreamFactory(trainingFile), charset);
	    ObjectStream<NameSample> samples = new NameSampleDataStream(in);
	    TokenNameFinderModel model;
	    try{
	      model = NameFinderME.train("en", "person", samples, TrainingParameters.defaultParams(),new TokenNameFinderFactory());
	    }finally {
	      samples.close();
	      in.close();
	    }

	    BufferedOutputStream modelOut = new BufferedOutputStream(new FileOutputStream(Utils.getModelAsFile(MODEL_FILE_NAME), true));
	    try{
	      model.serialize(modelOut);
	    }finally {
	      modelOut.flush();
	      modelOut.close();
	    }
	}

}
