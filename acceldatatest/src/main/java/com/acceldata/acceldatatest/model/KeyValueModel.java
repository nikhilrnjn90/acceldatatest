package com.acceldata.acceldatatest.model;

public class KeyValueModel {
	
	private String key;
	private String value;
	
	public KeyValueModel() {
		
	}
	
	public KeyValueModel(String key2, String string) {
		this.key=key;
		this.value=value;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return ""+ key + "_" + value + "";
	}
	
	
	
}
