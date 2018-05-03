package com.henu.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.Page;
import com.henu.entity.Post;
import com.henu.entity.Reply;
import com.henu.entity.User;
import com.henu.service.PostService;
import com.henu.service.ReplyService;
import com.henu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUserInfo extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private UserService us = new UserService();
	private PostService ps = new PostService();
	private ReplyService rs = new ReplyService();

	/**
	 * 要从链接中取出用户名 还有 参数 index 可选 默认为1 如果分页显示时表示页码 参数 part 默认为1 1 表示显示 用户发的贴子 2 表示显示
	 * 用户的回复
	 */
	public String showInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String indexStr = request.getParameter("index");
		String partStr = request.getParameter("part");
		int index = 0, part = 1;
		try {
			index = Integer.parseInt(indexStr);
		} catch (Exception e) {
			index = 0;
		}
		try {
			part = Integer.parseInt(partStr);
		} catch (Exception e) {
			part = 0;
		}
		String[] url = request.getRequestURI().split("/");
		String name = url[url.length - 1];
		String username = null;		
		try {
			username = URLDecoder.decode(name, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return ERROR;
		}
		if(username.endsWith(".action")) {
			username = username.substring(0, username.indexOf(".action"));			
		}
		User user = us.findByName(username);
		if (user == null) {
			return ERROR;
		}
		// 判断是不是当前登录用户
		boolean isLogin = false;
		User login_user = (User) request.getSession().getAttribute("user");
		if (login_user != null) {
			if (login_user.getUserId() == user.getUserId()) {
				isLogin = true;
			}
		}
		Page page = null;
		if (2 == part) {
			int size = rs.sizeOfUser(user.getUserId());

			page = new Page(size, index, 10);
			List<Reply> replies = null;
			if (page.isFlag()) {
				replies = rs.findURByPage(user.getUserId(), page.getCurrentPage(), page.getOffset());
			} else {
				replies = new ArrayList<>(rs.listOfUser(user.getUserId()));
			}
			for (Reply reply : replies) {
				reply.setPost(rs.getPost(reply.getRid()));
			}
			request.setAttribute("replies", replies);

		} else {
			part = 1;
			int size = ps.sizeOfUser(user.getUserId());

			page = new Page(size, index, 10);
			List<Post> posts = null;
			if (page.isFlag()) {
				posts = ps.findTPByPage(user.getUserId(), page.getCurrentPage(), page.getOffset());
			} else {
				posts = new ArrayList<>(ps.listOfUser(user.getUserId()));
			}
			for (Post post : posts) {
				post.setTopic(ps.getTopic(post.getPid()));
				post.setSize(ps.sizeOfReply(post.getPid()));
			}
			request.setAttribute("posts", posts);
		}
		request.setAttribute("part", part);
		request.setAttribute("isLogin", isLogin);
		request.setAttribute("me", user);
		request.setAttribute("page", page);
		return SUCCESS;
	}

}
