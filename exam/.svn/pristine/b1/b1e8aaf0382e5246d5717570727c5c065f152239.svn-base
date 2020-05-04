package com.znsd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.znsd.bean.SubjectBean;
import com.znsd.dao.SubjectDao;

/**
 * 科目模块;持久层实现类：SubjectDaoImp
 * 
 * @author baishui
 *
 */
@Repository
public class SubjectDaoImp implements SubjectDao {

	@Resource
	private JdbcTemplate jt;

	@Override
	public int subjectAdd(SubjectBean subject) {
		String sql = "insert into subject(subjectName) values(?)";
		int result = jt.update(sql, subject.getSubjectName());
		return result;
	}

	@Override
	public int subjectDel(String subjectId) {
		String sql = "DELETE FROM SUBJECT WHERE subjectId=?";
		int result = jt.update(sql, subjectId);
		return result;
	}

	@Override
	public int subjectUpdate(SubjectBean subject) {
		String sql = "UPDATE SUBJECT SET subjectName= ? WHERE subjectId= ?";
		int result = jt.update(sql, subject.getSubjectName(), subject.getSubjectId());
		return result;
	}

	@Override
	public List<SubjectBean> findSubject(int begin, int end) {
		String sql = "SELECT * FROM subject limit ?,?";
		RowMapper<SubjectBean> rowMapper = new BeanPropertyRowMapper<>(SubjectBean.class);
		List<SubjectBean> list = jt.query(sql, rowMapper, begin, end);

		return list;
	}

	public List<SubjectBean> findSubject() {
		String sql = "SELECT * FROM subject";
		RowMapper<SubjectBean> rowMapper = new BeanPropertyRowMapper<>(SubjectBean.class);
		List<SubjectBean> list = jt.query(sql, rowMapper);

		return list;
	}

	@Override
	public SubjectBean findSubjectById(String subjectId) {
		String sql = "select * from subject where subjectId=?";
		RowMapper<SubjectBean> rowMapper = new BeanPropertyRowMapper<>(SubjectBean.class);
		SubjectBean subject = jt.queryForObject(sql, rowMapper, subjectId);
		return subject;
	}

	@Override
	public SubjectBean findSubjectByName(String subjectName) {
		SubjectBean subject = null;
		List<SubjectBean> list = findSubject();
		for (int i = 0; i < list.size(); i++) {
			if (subjectName.equals(list.get(i).getSubjectName())) {
				subject=list.get(i);
				break;
			}
		}
		return subject;
	}

	@Override
	public List<SubjectBean> findSubjectLikeName(String subjectName) {
		List<SubjectBean> result = new ArrayList<>();
		List<SubjectBean> list = findSubject();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSubjectName().contains(subjectName)) {
				result.add(list.get(i));
			}
		}
		return result;
	}

	@Override
	public int findSubjectAllCount() {
		String sql = "SELECT COUNT(*) FROM `subject`";
		int count = jt.queryForObject(sql, Integer.class);
		return count;
	}

}
