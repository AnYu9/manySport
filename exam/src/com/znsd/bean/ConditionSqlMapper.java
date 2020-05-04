package com.znsd.bean;

public abstract class ConditionSqlMapper {
	private String fieldName;
	private ConditionType mapperType;
	private int valueLength;
	private String conditionSql;
	
	public ConditionSqlMapper() {}
	
	public ConditionSqlMapper(String fieldName,ConditionType mapperType) {
		super();
		this.fieldName = fieldName;
		this.mapperType=mapperType;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getConditionSql() {
		return conditionSql;
	}

	public void setConditionSql(String conditionSql) {
		this.conditionSql = conditionSql;
	}

	public int getValueLength() {
		return valueLength;
	}

	public void setValueLength(int valueLength) {
		this.valueLength = valueLength;
	}

	public ConditionType getMapperType() {
		return mapperType;
	}

	public void setMapperType(ConditionType mapperType) {
		this.mapperType = mapperType;
	}
	
}
