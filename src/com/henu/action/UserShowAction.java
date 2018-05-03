package com.henu.action;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.henu.utils.UserUtil;

/**
 * User部分用来控制跳转的Action
 */
public class UserShowAction {	
	
	public String toRegister() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//设置防重复提交的token
		String token = TokenProcessor.getInstance().generateToken();
		request.getSession().setAttribute("token", token);				
		return "success";
	}
	
	public String toLogin() {
		return "success";
	}
	
	public String toHead() {
		return "success";
	}
	
	public String toEdit() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")!=null) {
			return "success";
		}else {
			return "error";
		}
	}
	
	public String toPwd() {
		return "success";
	}
	
	public String toCode() {
		return "success";
	}
}

class TokenProcessor {
	private static final TokenProcessor instance = new TokenProcessor();
	private TokenProcessor() {}
	
	public static TokenProcessor getInstance() {
		return instance;
	}
	
	//生成Token
	public String generateToken(){
		Random r = new Random();
		long str = r.nextInt()+System.currentTimeMillis();		
		return UserUtil.md5(str+"");
	}
}
