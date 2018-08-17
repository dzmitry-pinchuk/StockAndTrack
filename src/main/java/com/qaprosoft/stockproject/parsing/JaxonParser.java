package com.qaprosoft.stockproject.parsing;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JaxonParser {
	
	private static final Logger logger = LogManager.getLogger();
	private static final String PATH = "src\\main\\resources\\data.json";
	private ObjectMapper om = new ObjectMapper();
	
	public void writeToJson() {
		ClassForJaxB temp = new ClassForJaxB();
		try {
//			om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

			om.writeValue(new File(PATH), temp);
		} catch (JsonGenerationException e) {
			logger.log(Level.ERROR, "JsonGenerationException: " + e);
		} catch (JsonMappingException e) {
			logger.log(Level.ERROR, "JsonMappingException: " + e.getMessage());
		} catch (IOException e) {
			logger.log(Level.ERROR, "IOException: " + e);
		}
	}
	
	public void readFromJson() {
		throw new UnsupportedOperationException("method not create");
	}
	
	
	
	

}
