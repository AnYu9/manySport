package com.znsd.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.znsd.service.ISendWechatMsg;
 
/**
 * 发送飞鸽快信
 *	第一次
 */
@Service
public class SendWechatMsgImpl implements ISendWechatMsg{
	
	/**
	 * 
	 * @param title  消息头
	 * @param content  内容
	 * @param remark  内容补充
	 * @throws Exception
	 */
    public  String sendMsg(String title,String content,String remark) throws Exception {
        // 创建一个httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建一个post对象
        HttpPost post = new HttpPost("http://u.ifeige.cn/api/send_message");
        // 创建一个Entity，模拟表单数据
        List<NameValuePair> formList = new ArrayList<NameValuePair>();
        // 添加表单数据  
        formList.add(new BasicNameValuePair("secret", "7ad25e4ce04b564858e650f4dec54b7e"));
        formList.add(new BasicNameValuePair("token", "ad9715f092fb461f85d27b04ce1ee4ae"));
        formList.add(new BasicNameValuePair("key", "notice"));
        formList.add(new BasicNameValuePair("title", title));
        formList.add(new BasicNameValuePair("content", content));
        formList.add(new BasicNameValuePair("remark", remark));
       
        
        // 包装成一个Entity对象
        StringEntity entity = new UrlEncodedFormEntity(formList, "utf-8");
        // 设置请求的内容
        post.setEntity(entity);
        // 设置请求的报文头部的编码
        // post.setHeader(new BasicHeader("Content-Type",
        // "application/x-www-form-urlencoded; charset=utf-8"));
        // 设置期望服务端返回的编码
        // post.setHeader(new BasicHeader("Accept",
        // "text/plain;charset=utf-8"));
        // 执行post请求
        CloseableHttpResponse response = client.execute(post);
        // 获取响应码
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            // 获取数据
            String resStr = EntityUtils.toString(response.getEntity());
            // 输出
            System.out.println(resStr);
            return resStr;
        } else {
            // 输出
            System.out.println(statusCode);
            return statusCode+"";
        }
    }
    
}
