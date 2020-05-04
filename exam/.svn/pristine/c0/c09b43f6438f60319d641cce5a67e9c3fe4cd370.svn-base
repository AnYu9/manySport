package com.znsd.dao;

import java.util.List;
import java.util.Map;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.PaperBean;
import com.znsd.bean.QuestionBean;
import com.znsd.bean.TopicType;

/**
 * 试卷模块;持久层接口:PaperDao
 * @author baishui
 *
 */
public interface PaperDao {
	
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
	 * 分页查询所有试卷
	 * @param start
	 * @param end
	 * @return List<PaperBean>
	 */
	public List<PaperBean> limitQueryAllPaper(ConditionBean[] conditions,int start,int end);
	
	/**
	 * 为分页查询提供的查询所有试卷数量
	 * @return Integer
	 */
	public Integer total(ConditionBean[] conditions);
	
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
	 * 删除一张试卷
	 * @param id
	 * @return boolean
	 */
	public int remove(String  id);
	
	/**
	 * 试卷信息修改
	 *
	 *@param：@param bean
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月14日上午9:41:35
	 */
	int paperUpdate(ConditionBean[] setConditions,ConditionBean... whereConditions);
	
	/**
	 * -跟据试卷id组成题目
	 * @param id
	 * @return Map<题目类型, 题目>
	 */
	public Map<String, List<QuestionBean>> assemble(Integer id);
	
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
