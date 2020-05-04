package com.znsd.bean;

import org.springframework.stereotype.Component;

@Component
public class Note {
	
	private Integer noteId;
	private String notedes;
	private String userId;
	private String date;
	
	
	public Note(String notedes, String userId, String date) {
		super();
		this.notedes = notedes;
		this.userId = userId;
		this.date = date;
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public String getNotedes() {
		return notedes;
	}
	public void setNotedes(String notedes) {
		this.notedes = notedes;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Note(Integer noteId, String notedes, String userId, String date) {
		super();
		this.noteId = noteId;
		this.notedes = notedes;
		this.userId = userId;
		this.date = date;
	}
	public Note() {
		super();
	}
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", notedes=" + notedes + ", userId=" + userId + ", date=" + date + "]";
	}
	
	
	
	

}
