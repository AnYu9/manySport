package com.znsd.bean;

import org.springframework.stereotype.Component;

//测试题属性类
@Component
public class AnswerBean {
	private Integer topId;// 编号
	private String title;// 内容
	private String options;// 选项
	private String result;// 答案
	private Integer subjectName;// 科目编号
	private String difficulty;// 难度等级
	private Integer type;// 题目类型
	private String explanation;// 说明
	private Integer score;// 分数

	public AnswerBean() {
		super();
	}

	

	public Integer getTopId() {
		return topId;
	}

	public void setTopId(Integer topId) {
		this.topId = topId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public AnswerBean(Integer topId, String title, String options, String result, Integer subjectName,
			String difficulty, Integer type, String explanation, Integer score) {
		super();
		this.topId = topId;
		this.title = title;
		this.options = options;
		this.result = result;
		this.subjectName = subjectName;
		this.difficulty = difficulty;
		this.type = type;
		this.explanation = explanation;
		this.score = score;
	}



	public Integer getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(Integer subjectName) {
		this.subjectName = subjectName;
	}



	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
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

}
