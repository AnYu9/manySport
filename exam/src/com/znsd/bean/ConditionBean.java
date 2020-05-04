package com.znsd.bean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.znsd.util.ConditionSqlMapperFactory;
public class ConditionBean {
	private String name;
	private Object[] value;
	
	public ConditionBean() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object[] getValue() {
		return value;
	}

	public void setValue(Object[] value) {
		this.value = value;
	}

	public ConditionBean(String name, Object[] value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public static Object[] getCondtionsValues(ConditionBean[] conditions) {
		List<Object> values=new ArrayList<>();
		for(ConditionBean condition:conditions) {
			if(condition!=null) {
				Object[] value=condition.getValue();
				for(int i=0;i<value.length;i++) {
					if(value[i]!=null) {
						values.add(value[i]);
					}
				}
			}
		}
		return values.toArray();
	}
	
	/**
	 * 将指定的条件数组解析为条件SQL句柄
	 * @param conditions
	 * @param isStartWhere
	 * @return
	 */
	public static String getCondtionsSql(ConditionBean[] conditions,boolean isStartWhere) {
		StringBuilder conditionSql=new StringBuilder();
		if(conditions!=null) {
			for(int i=0;i<conditions.length;i++) {
				if(conditions[i]!=null) {
					if(i==0) {
						if(isStartWhere) {
							conditionSql.append(" where");
						}else {
							conditionSql.append(" and");
						}
					}
					String name=conditions[i].getName();
					if(name!=null) {
						conditionSql.append(name);
					}
					if(i!=conditions.length-1) {
						conditionSql.append(" and");
					}
				}
			}
		}
		return conditionSql.toString();
	}
	/**
	 * 将指定的条件数组以update语句中的set句柄解析
	 * @param conditions 指定的条件数组
	 * @param isStartSet 是否以' set'开头
	 * @return
	 */
	public static String getCondtionsUpdateSql(ConditionBean[] conditions,boolean isStartSet) {
		StringBuilder conditionSql=new StringBuilder();
		if(conditions!=null) {
			for(int i=0;i<conditions.length;i++) {
				if(conditions[i]!=null) {
					String name=conditions[i].getName();
					if(i==0) {
						if(isStartSet) {
							conditionSql.append(" set");
						}else {
							conditionSql.append(" ,");
						}
					}
					if(name!=null) {
						conditionSql.append(name);
					}
					if(i!=conditions.length-1) {
						conditionSql.append(", ");
					}
				}
			}
		}
		return conditionSql.toString();
	}
	
	/**
	 * 将指定bean中的属性转换为条件数组
	 * @param bean 需要转换的bean
	 * @param isStartWhere 是否需要使用' where'开头
	 * @param fieldMappers 设置指定字段的映射规则
	 * @param notUseFieldNames 不参与转换的字段名称
	 * @return 转换后的条件数组
	 * @throws IllegalArgumentException 反射安全异常
	 * @throws IllegalAccessException 反射错误异常
	 */
	public static ConditionBean[] beanToConditions(Object bean,ConditionSqlMapper[] fieldMappers,String... notUseFieldNames) throws IllegalArgumentException, IllegalAccessException {
		List<ConditionBean> conditions =new ArrayList<>();
		if(bean!=null) {
			Field[] fields=bean.getClass().getDeclaredFields();
			for(int i=0;i<fields.length;i++) {
				fields[i].setAccessible(true);
				if(fields[i].get(bean)!=null) {
					String fieldName=fields[i].getName();
					
					boolean isNotUse=false;
					for(String name:notUseFieldNames) {
						if(name.equals(fieldName)) {
							isNotUse=true;
						}
					}
					if(isNotUse) {
						continue;
					}
					
					ConditionBean condition=new ConditionBean();
					condition.setValue(new Object[] {fields[i].get(bean)});
					
					String sqlMapper="";
					ConditionSqlMapper fieldMapper=ConditionSqlMapperFactory.mapperByType(fieldName, ConditionType.EQUALS, 1);
					if(fieldMappers!=null) {
						for(ConditionSqlMapper mapper:fieldMappers) {
							if(mapper.getFieldName().equals(fieldName)) {
								fieldMapper=mapper;
								condition.getValue()[0]="%"+condition.getValue()[0]+"%";
							}
						}
					}
					sqlMapper+=fieldMapper.getConditionSql();
					
					condition.setName(sqlMapper);
					conditions.add(condition);
				}
			}
		}
		return conditions.toArray(new ConditionBean[] {});
	}
}
