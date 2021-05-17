package com.acceldata.acceldatatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acceldata.acceldatatest.model.KeyValueModel;
import com.acceldata.acceldatatest.service.KeyValueService;

@RestController
public class KeyValueController {
	
	@Autowired
	private KeyValueService keyvalueService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/values/{key}",method=RequestMethod.GET)
	public String get(@PathVariable String key) {
		String value= keyvalueService.getValue(key);
		return value;
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/values",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody KeyValueModel kv) throws Exception {
		keyvalueService.create(kv);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/values/{key}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestParam String key,@RequestBody KeyValueModel kv) throws Exception {
		keyvalueService.update(key,kv);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/values/{key}",method=RequestMethod.DELETE)
	public void delete(@RequestParam String key) throws Exception {
		keyvalueService.delete(key);
	}
	

}
