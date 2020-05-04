package com.znsd.bean;

/**
 * 题库bean
 * @author baishui
 *
 */
public class QuestionBean {
	private Integer topId;//题目编号
	private String title;//题目内容
	private String a;//a选项
	private String b;//b选项
	private String c;//c选项
	private String d;//d选项
	private String result;//正确答案
	private String subjectName;//所属科目
	private String difficulty;//题目难度
	private String type;//题目类型
	private String explanation;//题目说明
	private Integer score;//试题分数
	
	public Integer gettopId() {
		return topId;
	}

	public void settopId(Integer topId) {
		this.topId = topId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}


	public String getC() {
		return c;
	}


	public void setC(String c) {
		this.c = c;
	}


	public String getD() {
		return d;
	}


	public void setD(String d) {
		this.d = d;
	}

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public QuestionBean(String a, String b, String c, String d,String difficulty,String result,int score,String subjectName,String title,String type) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.difficulty = difficulty;
		this.result = result;
		this.score=score;
		this.subjectName=subjectName;
		this.title=title;
		this.type=type;
	}
	
	public QuestionBean() {
	}
	public QuestionBean(Integer topId,String title, String a, String b, String c, String d, String result, String subjectName,
			String difficulty, String type, int score) {
		super();
		this.topId=topId;
		this.title = title;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.result = result;
		this.subjectName = subjectName;
		this.difficulty = difficulty;
		this.type = type;
		this.score = score;
	}
	@Override
	public String toString() {
		return "QuestionBean [topId=" + topId + ", title=" + title + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d
				+ ", result=" + result + ", subjectName=" + subjectName + ", difficulty=" + difficulty + ", type="
				+ type + ", explanation=" + explanation + ", score=" + score + "]";
	}

}
