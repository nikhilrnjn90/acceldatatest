package com.acceldata.acceldatatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acceldata.acceldatatest.exception.DataStoreExcpetion;
import com.acceldata.acceldatatest.exception.KeyNotFoundException;
import com.acceldata.acceldatatest.model.KeyValueModel;
import com.acceldata.acceldatatest.repository.KeyValueRepository;

@Service
public class KeyValueService {

	@Autowired
	private KeyValueRepository repository;
	
	public String getValue(String key) {
		return repository.getValue(key);
	}

	
	public boolean create(KeyValueModel kv) throws Exception {
		if(repository.getValue(kv.getKey()) == null )
			return repository.create(kv);
		else {
			throw new DataStoreExcpetion("key "+kv.getKey()+", Already exits");
		}
	}


	public void update(String key, KeyValueModel kv) throws Exception {
		if(!kv.getKey().equals(key)) {
			throw new Exception("key "+kv.getKey()+" Not matching with request Body");
		}
		String value=repository.getValue(key);
		if(value!= null) {
			repository.create(kv);
		}else {
			throw new Exception("key "+kv.getKey()+" does not exits");
		}
		
	}


	public void delete(String key) {
		if(repository.getValue(key) == null )
			throw new KeyNotFoundException("Key="+key+" Not Found.");
		repository.delete(key);
	}

}
