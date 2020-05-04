package com.znsd.bean;

public class TopicType {

	private Integer typeId;
	private String type;
	
	public TopicType(Integer typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	public TopicType() {
		super();
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}