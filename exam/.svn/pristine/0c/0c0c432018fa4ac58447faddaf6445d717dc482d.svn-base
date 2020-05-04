package com.znsd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.bean.MessageBean;

//学生测试题所选答案
@Controller
@RequestMapping(value = "AnswerController")
public class AnswerController {
	// 判断所选答案是否正确
	@RequestMapping(value = "AnswerRest/{stuAnswer}", method = RequestMethod.GET)
	@ResponseBody
	public Object QueryAnswerController(@PathVariable("stuAnswer") String stuAnswer, Integer num) {
		String str[] = stuAnswer.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 1; i < str.length; i++) {
			String str2[] = str[i].split("-");
			if (num == Integer.parseInt(str2[0])) {
				map.put(str2[0], str2[1]);
			}
		}
		// 获取map里面最后一个map键值对
		String KeyValue = map.toString();
		if (map.toString() != "{}") {
			return KeyValue.split("=")[1].split("}")[0];
		}
		return "-1";
	}

	@RequestMapping(value = "AnswerRest/{stuAnswerMessage}/{ExerCount}", method = RequestMethod.PUT)
	@ResponseBody
	public ArrayList UpdateAnswerController(@PathVariable("stuAnswerMessage") String stuAnswerMessage, @PathVariable("ExerCount") Integer ExerCount) {
		System.out.println("stuAnswerMessage=="+stuAnswerMessage);
		System.out.println("ExerCount=="+ExerCount);
		ArrayList<MessageBean> arrayList = new ArrayList<MessageBean>();
		MessageBean messageBean = null;
		String str[] = stuAnswerMessage.split(",");
		for (int i = 1; i < str.length; i++) {
			String str2[] = str[i].split("-");
			for (int j = i; j < str.length; j++) {
				String str3[] = str[j].split("-");
				if (str2[0].equals(str3[0])) {
					str2[0] = str3[0];
					str2[1] = str3[1];
				}
			}
			messageBean = new MessageBean(str2[0], str2[1]);
			arrayList.add(messageBean);
			System.out.println("messageBean="+messageBean);
		}
		for(int i = 0; i<arrayList.size(); i++) {
			System.out.println("Key-Value："+arrayList.get(i).getKey()+"——"+arrayList.get(i).getValue());
		}
		if (arrayList.size() >= ExerCount) {
			return arrayList;
		}else {
			ArrayList<String> arrayList2 = new ArrayList<String>();
			arrayList2.add("a");
			return arrayList2;
		}
	}
}
