package com.znsd.bean;

/**
 * 错误反馈Bean
 * @author baishui
 *
 */
public class ErrorBean {
	private Integer errorId;//错误编号
	private Integer topicId;//报错题目编号
	private Integer paperId;//报错试卷编号
	private String userId;//用户编号
 	private String errordes;//错误详细
 	private String status;//错误状态
	
	public ErrorBean() {}

	public ErrorBean(Integer errorId, Integer topicId, Integer paperId, String userId, String errordes,
			String status) {
		this.errorId = errorId;
		this.topicId = topicId;
		this.paperId = paperId;
		this.userId = userId;
		this.errordes = errordes;
		this.status = status;
	}

	public Integer getErrorId() {
		return errorId;
	}

	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getErrordes() {
		return errordes;
	}

	public void setErrordes(String errordes) {
		this.errordes = errordes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErrorBean [errorId=" + errorId + ", topicId=" + topicId + ", paperId=" + paperId + ", userId=" + userId
				+ ", errordes=" + errordes + ", status=" + status + "]";
	}
	
 	
}
