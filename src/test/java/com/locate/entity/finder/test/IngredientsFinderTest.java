package com.locate.entity.finder.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.locate.entity.finder.IngredientsFinder;
import com.locate.tokenize.Tokenizer;
import com.locate.utils.Utils;

public class IngredientsFinderTest {
	
	private static final String model 			= "en-ingredients-finder.bin";
	//private static final String train 			= "en-ingredients-finder.train";
	private static final String tokenizerModel 	= "en-token.bin";
	
	private static IngredientsFinder finder;
	private static Tokenizer tokenizer;
	
	@BeforeClass
	public static void init() throws Exception {
		//IngredientsFinder.train(Utils.getTrainerAsFile(train), Utils.getModelAsFile(model));
		
		tokenizer 	= new Tokenizer(Utils.getModelAsFile(tokenizerModel));
		finder 		= new IngredientsFinder(Utils.getModelAsInputStream(model));
		
	}
	
	
	@Test
	public void findEntity() {
		String input = "Make the shortbread - cream the butter and sugar, mix in the flour, and then press into the "
				+ "bottom of a lined baking tray\n\nFor the caramel, gently melt all ingredients except "
				+ "rosemary in a pan, once melted add the rosemary and stir through, heat for two to "
				+ "three minutes\n\nLeave the caramel to stand for another 10 minutes or so, "
				+ "whilst the shortbread cools\n\nPoor the caramel through a sieve to remove the "
				+ "rosemary pieces, pour caramel onto the cooled shortbread\n\nPlace the caramel "
				+ "topped shortbread in the fridge to cool for another 20 minutes\n\nMelt the chocolate "
				+ "in the microwave on a low power settings (will take a couple of minutes), once it is smooth, "
				+ "pour on top of the caramel shortbread and put back in the fridge to set. "
				//my input
				+ " salt required almost all the food";
		
		finder.findEntity(tokenizer.tokenize(input))
			.forEach(System.out::println);
	}

}
