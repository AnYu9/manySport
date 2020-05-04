package com.znsd.util;

import com.znsd.bean.ConditionType;
import com.znsd.bean.ConditionSqlMapper;

public class ConditionSqlMapperFactory {

	public static ConditionSqlMapper mapperByType(String name,ConditionType type,int valueLength) {
		if(type==ConditionType.EQUALS) {
			return equalsMapper(name);
		}else if(type==ConditionType.IN) {
			return inMapper(name, valueLength);
		}else if(type==ConditionType.LIKE) {
			return likeMapper(name);
		}else if(type==ConditionType.INTERVAL) {
			return intervalMapper(name);
		}else if(type==ConditionType.START) {
			return startMapper(name);
		}else if(type==ConditionType.END) {
			return endMapper(name);
		}else if(type==ConditionType.NOTEQUALS) {
			return notEqualsMapper(name);
		}
		return null;
	}
	
	public static ConditionSqlMapper equalsMapper(String name) {
		ConditionSqlMapper mapper=new ConditionSqlMapper(name,ConditionType.EQUALS) {
			{
				String startStr=" ";
				this.setConditionSql(startStr+name+" = ?");
			}
		};
		return mapper;
	}
	
	public static ConditionSqlMapper likeMapper(String name) {
		ConditionSqlMapper mapper=new ConditionSqlMapper(name,ConditionType.LIKE) {
			{
				String startStr=" ";
				this.setConditionSql(startStr+name+" like ?");
			}
		};
		return mapper;
	}
	

	public static ConditionSqlMapper inMapper(String name,int valueLength) {
		ConditionSqlMapper mapper=new ConditionSqlMapper(name,ConditionType.IN) {
			{
				String startStr=" ";
				StringBuilder paramStr=new StringBuilder(" in (");
				for(int i=0;i<valueLength;i++) {
					paramStr.append("?");
					if(i!=valueLength-1) {
						paramStr.append(", ");
					}else {
						paramStr.append(")");
					}
				}
				this.setConditionSql(startStr+name+paramStr);
			}
		};
		return mapper;
	}
	
	public static ConditionSqlMapper intervalMapper(String name) {
		ConditionSqlMapper mapper=new ConditionSqlMapper(name,ConditionType.INTERVAL) {
			{
				String startStr=" ";
				this.setConditionSql(startStr+name+" between ? and ?");
			}
		};
		return mapper;
	}
	
	public static ConditionSqlMapper startMapper(String name) {
		ConditionSqlMapper mapper=new ConditionSqlMapper(name,ConditionType.START) {
			{
				String startStr=" ";
				this.setConditionSql(startStr+name+" >= ?");
			}
		};
		return mapper;
	}
	
	public static ConditionSqlMapper endMapper(String name) {
		ConditionSqlMapper mapper=new ConditionSqlMapper(name,ConditionType.END) {
			{
				String startStr=" ";
				this.setConditionSql(startStr+name+" =< ?");
			}
		};
		return mapper;
	}
	

	public static ConditionSqlMapper notEqualsMapper(String name) {
		ConditionSqlMapper mapper=new ConditionSqlMapper(name,ConditionType.NOTEQUALS) {
			{
				String startStr=" not ";
				this.setConditionSql(startStr+name+" = ?");
			}
		};
		return mapper;
	}
}
