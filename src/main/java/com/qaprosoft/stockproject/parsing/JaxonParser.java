package com.qaprosoft.stockproject.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JaxonParser {
	
	private static final Logger logger = LogManager.getLogger();
	private static final String PATH = "src\\main\\resources\\data.json";
	private static final String PATH_TO_READ = "src\\main\\resources\\dataRead.json";
	private ObjectMapper om = new ObjectMapper();
	
	public void writeToJson() {
		ClassForJaxB temp = new ClassForJaxB(1);
		try {
			om.writeValue(new File(PATH), temp);
		} catch (JsonGenerationException e) {
			logger.log(Level.ERROR, "JsonGenerationException: " + e);
		} catch (JsonMappingException e) {
			logger.log(Level.ERROR, "JsonMappingException: " + e.getMessage());
		} catch (IOException e) {
			logger.log(Level.ERROR, "IOException: " + e);
		}
	}
	
	public ClassForJaxB readFromJson() {
		InputStream is = null;
		ClassForJaxB temp = new ClassForJaxB();
		try {
			is = new FileInputStream(PATH_TO_READ);
			temp = om.readValue(is, ClassForJaxB.class);
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, "FileNotFoundException: " + e.getMessage());
		} catch (JsonParseException e) {
			logger.log(Level.ERROR, "JsonParseException: " + e.getMessage());
		} catch (JsonMappingException e) {
			logger.log(Level.ERROR, "JsonMappingException: " + e.getMessage());
		} catch (IOException e) {
			logger.log(Level.ERROR, "IOException: " + e);
		} finally {
			IOUtils.closeQuietly(is);
		} 
		return temp;
	}
	
	
	
	

}
