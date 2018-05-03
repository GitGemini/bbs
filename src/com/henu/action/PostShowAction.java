package com.henu.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.Page;
import com.henu.entity.Post;
import com.henu.entity.Reply;
import com.henu.service.PostService;
import com.henu.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

public class PostShowAction extends ActionSupport{

private static final long serialVersionUID = 1L;
	
	private PostService ps = new PostService();
	private ReplyService rs = new ReplyService();
	
	/**
	 * 这里用帖子id
	 */
	public String toPost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pidStr = request.getParameter("pid");
		String indexStr = request.getParameter("index");
		int pid = 1, index=1;
		try {
			pid = Integer.parseInt(pidStr);
		}catch (Exception e) {
			pid = 1;
		}
		try {
			index = Integer.parseInt(indexStr);
		}catch (Exception e) {
			index = 0;
		}
		
		Post post = ps.findById(pid);
		post.setUser(ps.sender(pid));
		int size = ps.sizeOfReply(pid);
		Page page = new Page(size, index, 10);
		List<Reply> replies = null;
		if(page.isFlag()) {
			replies = rs.findPRByPage(pid, page.getCurrentPage(), page.getOffset());			
		}else {
			replies = new ArrayList<>(rs.listOfPost(pid));
		}		
		for (Reply reply : replies) {
			reply.setUser(rs.sender(reply.getRid()));
		}
		request.setAttribute("post", post);
		request.setAttribute("replies", replies);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
