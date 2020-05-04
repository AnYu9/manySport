package com.znsd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.znsd.bean.GradeBean;
import com.znsd.dao.GradeDao;

@Repository
public class GradeDaoImp implements GradeDao{
	@Autowired
	private JdbcTemplate jdbc;
	@Override
	public boolean save(GradeBean grade) {
		String sql = "insert into class (className,classdes) values (?,?)";
		return jdbc.update(sql,grade.getClassName(),grade.getClassDes())>0?true:false;
	}
	@Override
	public List<GradeBean> QueryAll(int start, int end) {
		List<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "SELECT class.*, COUNT(*) as num FROM class,class_user WHERE class.`classId`=class_user.`classId` GROUP BY class_user.`classId` limit ?,?";
		list = jdbc.query(sql, new BeanPropertyRowMapper<GradeBean>(GradeBean.class),start,end);
		return list;
	}
	@Override
	public int total() {
		String sql = "select count(*) from class";
		int total = jdbc.queryForObject(sql, Integer.class);
		return total;
	}
	@Override
	public boolean remove(int classId) {
		String sql = "delete from class where classId=?";
		return jdbc.update(sql,classId)>0?true:false;
	}
	@Override
	public boolean removeSelect(Integer[] classIds) {
		boolean ok = true;
		for (int i = 0; i < classIds.length; i++) {
			remove(classIds[i]);
			ok=false;
		}
		return ok;
	}
	@Override
	public boolean update(GradeBean grade) {
		String sql = "UPDATE class SET className=?,classdes=? WHERE classId=?";
		return jdbc.update(sql,grade.getClassName(),grade.getClassDes(),grade.getClassId())>0?true:false;
	}
	

}
