package com.znsd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.ConditionSqlMapper;
import com.znsd.bean.PaperBean;
import com.znsd.bean.QuestionBean;
import com.znsd.bean.TopicType;
import com.znsd.dao.PaperDao;
import com.znsd.service.PaperService;
import com.znsd.util.ConditionSqlMapperFactory;


/**
 * 试卷模块;业务层实现类:PaperServiceImp
 * @author baishui
 *
 */
@Service
public class PaperServiceImp implements PaperService{
	
	@Autowired
	PaperDao paperDao;

	@Override
	public PaperBean findPaperById(String id) {
		return paperDao.findPaperById(id);
	}

	@Override
	public int remove(String id) {
		return paperDao.remove(id);
	}

	@Override
	public Integer total(PaperBean condition) {
		ConditionBean[] conditions = null;
		try {
			conditions=ConditionBean.beanToConditions(condition,null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return paperDao.total(conditions);
	}

	@Override
	public Map<String, List<QuestionBean>> assemble(Integer id) {
		return paperDao.assemble(id);
	}

	@Override
	public List<PaperBean> limitQueryAllPaper(PaperBean condition,int start, int end) {
		ConditionBean[] conditions = null;
		ConditionSqlMapper[] mapper=new ConditionSqlMapper[] {ConditionSqlMapperFactory.likeMapper("paperName")};
		try {
			conditions=ConditionBean.beanToConditions(condition,mapper);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return paperDao.limitQueryAllPaper(conditions,start, end);
	}

	@Override
	public List<TopicType> findTopicTypes() {
		return paperDao.findTopicTypes();
	}

	@Override
	public int paperAdd(PaperBean bean) {
		return paperDao.paperAdd(bean);
	}

	@Override
	public PaperBean findPaperByName(String name) {
		System.out.println(name+"=====");
		List<PaperBean> findAllQuestion = findAllQuestion();
		for (PaperBean paperBean : findAllQuestion) {
			System.out.println(paperBean.getPaperName());
			if(name.equals(paperBean.getPaperName())) {
				return paperBean;
			}
		}
		return null;
	}

	@Override
	public List<PaperBean> findAllQuestion() {
		return paperDao.findAllQuestion();
	}

	@Override
	public int paperUpdate(PaperBean bean) {
		try {
		ConditionBean[] setConditions=ConditionBean.beanToConditions(bean,null,"paperId");
		String sqlMapper=ConditionSqlMapperFactory.equalsMapper("userId").getConditionSql();
		ConditionBean paperIdCondition= new ConditionBean(sqlMapper,new Object[] {bean.getPaperId()});
		return paperDao.paperUpdate(setConditions, paperIdCondition);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
