package com.znsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.bean.Note;
import com.znsd.dao.IDiaryDao;
import com.znsd.dao.impl.DiaryDaoimpl;

@Controller
@RequestMapping("diaryController")
public class DiaryController {
	
	@Autowired
	IDiaryDao diaryDao;
	
	/**
	 * 获取笔记
	 * @return 返回当前用户的所用笔记数据
	 */
	@RequestMapping(value = "/diaryController/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public List<Note> getDiary(@PathVariable("userId") String userId) {
		 
		return diaryDao.queryNote(userId);
	}
	
	/**
	 * 每次提交所有笔记     先删除所有笔记   在进行添加笔记
	 */
	@RequestMapping(value = "diaryController/{userId}/{bj}", method=RequestMethod.GET)
	public String SetDiary(@PathVariable("userId") String userId, @PathVariable("bj") String bj) {
		
		String[] split = bj.split("@@");
		
		for(int x = 0; x<split.length; x++) {
			
			String[] split2 = split[x].split("#");
			diaryDao.saveDleNote(userId);
			diaryDao.saveAddNote(new Note(split2[1],userId,split2[0]));
			
		}
		
		return null;
		
	}
	
	
}
