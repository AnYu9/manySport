package com.znsd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;


import com.znsd.bean.Note;
import com.znsd.dao.IDiaryDao;


@Repository
public class DiaryDaoimpl implements IDiaryDao{
	
	@Autowired
	JdbcTemplate jdbc;

	
	public List<Note> queryNote(String userid){
		System.out.println(userid);
		String sql = "SELECT * FROM `note` where userId = ?";
		
		return jdbc.query(sql,new BeanPropertyRowMapper<Note>(Note.class),userid);

		
	}
	
	
	public boolean saveAddNote(Note notes) {
	
		String sql = "insert into note(notedes,userId,date) value(?,?,?,?)";
		
		int update = jdbc.update(sql,notes.getNotedes(),notes.getUserId(),notes.getDate());
		if(update>0) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean saveDleNote(String userid) {
		
		String sql = "delete from note";
		
		int update = jdbc.update(sql);
		if(update>0) {
			return true;
		}
		
		
		return false;
	}

}
