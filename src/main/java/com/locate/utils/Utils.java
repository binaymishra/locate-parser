package com.locate.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;

public final class Utils {
	
	private Utils() {
		
	}
	
	public static InputStream getModelAsInputStream(String modelFile) {
		return Utils.class.getResourceAsStream("/models/"+modelFile);
	}
	
	public static File getModelAsFile(String modelFile) {
		try {
			return new File(Utils.class.getResource("/models/"+modelFile).toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static InputStream getTrainerAsInputStream(String trainerFile) {
		return Utils.class.getResourceAsStream("/trainers/"+trainerFile);
	}
	
	public static File getTrainerAsFile(String trainerFile) {
		try {
			return new File(Utils.class.getResource("/trainers/"+trainerFile).toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
