package com.znsd.bean;

/**
 * 班级bean
 * @author Administrator
 *
 */
public class GradeBean {
	private Integer classId;//班级编号
	private String className;//班级名称
	private String classDes;//班级描述
	private Integer num;//班级人数
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassDes() {
		return classDes;
	}
	public void setClassDes(String classDes) {
		this.classDes = classDes;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public GradeBean(Integer classId, String className, String classDes, Integer num) {
		this.classId = classId;
		this.className = className;
		this.classDes = classDes;
		this.num = num;
	}
	public GradeBean() {}
	@Override
	public String toString() {
		return "GradeBean [classId=" + classId + ", className=" + className + ", classDes=" + classDes + ", num=" + num
				+ "]";
	}
	
	
	
}
