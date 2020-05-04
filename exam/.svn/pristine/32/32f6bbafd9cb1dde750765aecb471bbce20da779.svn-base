package com.znsd.bean;

/**
 * 科目bean
 * @author baishui
 *
 */
public class SubjectBean {
	private int subjectId;//科目编号
	private String subjectName;//科目名称
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public SubjectBean(int subjectId, String subjectName) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}
	
	public SubjectBean(String subjectName) {
		super();
		this.subjectName = subjectName;
	}
	public SubjectBean() {}
	@Override
	public String toString() {
		return "SubjectBean [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectBean other = (SubjectBean) obj;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	
}
