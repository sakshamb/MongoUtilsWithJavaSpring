package com.org.mongo.connect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.org.mongo.connect.model.StartupModel;
import com.org.mongo.connect.repo.TimeRepository;

@Service
public class MongoService {

	@Autowired
	TimeRepository repository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	/**
	 * fetch all entries based on a model
	 * @return
	 */
	public List<StartupModel> fetchAllMongoEntries() {
		
		List<StartupModel> allStartupValue = repository.findAll();
		System.out.println(allStartupValue);
		return allStartupValue;
	}
	
	public List<Map<String, Object>> fetchAllWithSpecificAttributes(){
		List<Document> docs = mongoTemplate.findAll(Document.class,"startup_log");
		List<Map<String, Object>> allValues=new ArrayList<>();
		docs.forEach(doc->allValues.add(doc.keySet().stream().collect(Collectors.toMap(Function.identity(),e-> doc.get(e)))));
		return allValues;
	}
}
