package com.znsd.bean;

//测试题答案
public class MessageBean {
	private String key;
	private String value;

	public MessageBean() {
		super();
	}

	public MessageBean(String key, String value) {
		super();
		this.key = key;
		this.value = value;
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

}
