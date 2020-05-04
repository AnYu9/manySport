package test.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.dao.TsetDao;

@Repository
public class DaoImp implements TsetDao {
	
	@Autowired
	JdbcTemplate jdbc;
	@Override
	public void daotest(String i) {
		jdbc.update("insert into user values(?,?)",i,"hhh");
		
	}
	
}
