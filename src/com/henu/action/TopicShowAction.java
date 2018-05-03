package com.henu.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.Page;
import com.henu.entity.Post;
import com.henu.entity.Topic;
import com.henu.service.PostService;
import com.henu.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

public class TopicShowAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private PostService ps = new PostService();
	private TopicService ts = new TopicService();

	/**
	 * 解析出url中的话题名字 
	 * 这里可以用话题id代替，更方便 
	 * 此处是为了在url中显示当前话题名字
	 */
	public String toTopic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String indexStr = request.getParameter("index");
		int index = 1;
		try {
			index = Integer.parseInt(indexStr);
		} catch (Exception e) {
			index = 1;
		}
		String[] url = request.getRequestURI().split("/");
		String name = url[url.length - 1];
		Topic topic = ts.findByName(name);
		if(topic==null) {
			return ERROR;
		}
		int size = ts.size(topic.getTid());

		Page page = new Page(size, index, 20);
		List<Post> posts = null;
		if (page.isFlag()) {
			posts = ps.findTPByPage(topic.getTid(), page.getCurrentPage(), page.getOffset());
		} else {
			posts = new ArrayList<>(ps.listOfTopic(topic.getTid()));
		}

		for (Post post : posts) {
			post.setSize(ps.sizeOfReply(post.getPid()));
			post.setUser(ps.sender(post.getPid()));
		}

		request.setAttribute("topic", topic);
		request.setAttribute("posts", posts);
		request.setAttribute("page", page);
		return SUCCESS;
	}

	public String toaaTopic() {
		return ERROR;
	}
}
