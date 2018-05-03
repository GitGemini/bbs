package com.henu.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.Post;
import com.henu.entity.Reply;
import com.henu.entity.User;
import com.henu.service.PostService;
import com.henu.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

public class ReplyAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private ReplyService rs = new ReplyService();
	private PostService ps = new PostService();
	
	private String content;
	private int pid;
	
	public String addReply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			return "toLogin";
		}
		String pidStr = request.getParameter("pid");
		int pid = 1;
		try {
			pid = Integer.parseInt(pidStr);
		} catch (Exception e) {
			pid = 1;
		}
		Post p = ps.findById(pid);
		if(p==null) {
			return ERROR;
		}
		this.setPid(pid);
		Reply r = new Reply();
		content.replace("\n", "<br/>");
		r.setContent(content);
		r.setReplyTime(new Date());
		r.setPost(p);
		r.setUser(user);
		rs.save(r);
		return SUCCESS;		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
}
