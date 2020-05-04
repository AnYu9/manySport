package test.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.imp.DaoImp;
import test.service.TestService;

@Service
public class ServiceImp implements TestService{

	@Autowired
	DaoImp dao;
	
	@Override
	public void servicetest(String i) {
		dao.daotest(i);
		
	}

}
