package com.znsd.service;

import java.util.List;
import java.util.Map;

import com.znsd.bean.PaperBean;
import com.znsd.bean.QuestionBean;
import com.znsd.bean.TopicType;

/**
 * 试卷模块;业务层接口：PaperService
 * @author baishui
 *
 */
public interface PaperService {
	
	/**
	 * 试卷增加
	 *
	 *@param：@param bean
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月13日下午7:15:08
	 */
	public int paperAdd(PaperBean bean);
	
	/**
	 * 根据试卷Id查询试卷
	 * @param id
	 * @return
	 */
	PaperBean findPaperById(String id);
	
	/**
	 * 查詢所有試卷
	 *
	 *@param：@return
	 *@return：List<QuestionBean>
	 *@author：Liu
	 *2020年1月13日下午7:53:14
	 */
	List<PaperBean> findAllQuestion();
	
	/**
	 * 根据试卷名查询试卷
	 * @param id
	 * @return
	 */
	PaperBean findPaperByName(String name);
	
	/**
	 * 试卷信息修改
	 *
	 *@param：@param bean
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月14日上午9:41:35
	 */
	int paperUpdate(PaperBean bean);
	
	public int remove(String id);
	
	
	public Map<String, List<QuestionBean>> assemble(Integer id);
	/**
	 * 分页查询所有试卷
	 * @param start
	 * @param end
	 * @return List<PaperBean>
	 */
	public List<PaperBean> limitQueryAllPaper(PaperBean condition,int start,int end);
	
	/**
	 * 为分页查询提供的查询所有试卷数量
	 * @return Integer
	 */
	public Integer total(PaperBean condition);
	
	/**
	 * 查询所有试题类型
	 *
	 *@param：@return
	 *@return：List<TopicType>
	 *@author：Liu
	 *2020年1月12日下午3:55:55
	 */
	public List<TopicType> findTopicTypes();
}
