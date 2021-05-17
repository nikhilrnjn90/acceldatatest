package com.acceldata.acceldatatest.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.acceldata.acceldatatest.model.KeyValueModel;


@Repository
public class KeyValueRepository {
	
	private static final Map<String,String> memoryMap=new HashMap<>();
	private static final String LOCATION="D:\\test\\key_value.txt";
	private static final String NULL_VALUE="null";
	private static final String EMPTY_STRING="";
	
	
	static {
		memoryMap.clear();
		populateMmemoryMap(memoryMap);
	}


	private static void populateMmemoryMap(Map<String, String> memoryMap) {
		
		File file=new File(LOCATION);
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String line=null;
			while((line=br.readLine()) != null) {
				String[] linearr=line.split("_");
				String key=linearr[0];
				String value=linearr[1];
				if(!value.equalsIgnoreCase((NULL_VALUE)) && !value.equals(EMPTY_STRING)) {
					memoryMap.put(key, value);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException ioexcep) {
			ioexcep.printStackTrace();
		}finally {
			try {
				if(br!=null) {
					br.close();
				}
				if(fr!=null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	public String getValue(String key) {
		if(memoryMap.containsKey(key))
			return memoryMap.get(key);
		return null;
	}


	public boolean create(KeyValueModel kv) {
		boolean created=false;
		FileWriter fw=null;
		try {
			File file=new File(LOCATION);
			if(file.exists()) {
				fw=new FileWriter(file,true);
				fw.write(kv.toString());
				fw.flush();
				memoryMap.put(kv.getKey(), kv.getValue());
				created=true;
			}
		} catch (IOException e) {
			created=false;
		}finally {
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		return created;
	}


	public void delete(String key) {
		this.create(new KeyValueModel(key,""));
	}

}
