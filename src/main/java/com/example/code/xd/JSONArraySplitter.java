package com.example.code.xd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@MessageEndpoint
public class JSONArraySplitter {

	@Autowired
	private ObjectMapper mapper;
	
	@Splitter(inputChannel="input",outputChannel="output")
	public List<String> splitAndTransform(String payload) throws Exception {
		List<String> results = new ArrayList<String>();
		//convert
		List<Map<String,Object>> values = mapper.readValue(payload, new TypeReference<List<Map<String,Object>>>() {});
		for (Map<String,Object> value : values) {
			results.add(mapper.writeValueAsString(value));
		}//end for
		//return
		return results;
	}
	
}
