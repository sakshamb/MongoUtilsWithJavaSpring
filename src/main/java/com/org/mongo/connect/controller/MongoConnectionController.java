package com.org.mongo.connect.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.mongo.connect.model.StartupModel;
import com.org.mongo.connect.service.MongoService;

@RestController
public class MongoConnectionController {

	@Autowired
	MongoService service;
	
	/**
	 * Get the startup information based on the defined attributes in the model
	 * @return
	 */
	@GetMapping("/startupInformation")
	@ResponseBody
	public List<StartupModel> fetchAll() {
		return service.fetchAllMongoEntries();
	}
	
	/**
	 * Get the startup information based on all the attributes.
	 * This approach can be further refined in scenarios when the collection has docuemnts with disparate structures.
	 * Example: Mandatorily fetch the name and organization of employee along with all other available attributes.
	 * @return
	 */
	@GetMapping("/startupInfoWithAttributes")
	public List<Map<String, Object>> fetchLowAttributes(){
		return service.fetchAllWithSpecificAttributes();
	}
	
}
