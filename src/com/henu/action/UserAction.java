package com.henu.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.User;
import com.henu.exception.UserExistException;
import com.henu.exception.UserNotExistException;
import com.henu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	/**
	 * 模型驱动
	 */
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	public String Update() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User login_user = (User) session.getAttribute("user");
		if (login_user == null) {
			return ERROR;
		}
		String synopsis = user.getSynopsis();
		if (synopsis != null && synopsis.trim().length() > 0) {
			login_user.setSynopsis(user.getSynopsis());
		}
		login_user.setEmail(user.getEmail());
		login_user.setGender(user.getGender());
		login_user.setPhone(user.getPhone());
		if (userService.save(login_user)) {
			session.setAttribute("user", login_user);
		}
		return SUCCESS;
	}

	public String exit() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("user") == null) {
			return ERROR;
		} else {
			session.removeAttribute("user");
			return SUCCESS;
		}
	}

	public String resetPwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String tip = null;
		if (username == null) {
			tip = "请输入用户名！！";
		} else if (phone == null) {
			tip = "请输入手机号！！";
		} else if (password == null) {
			tip = "请输入新密码！！";
		} else {
			try {
				userService.resetPassword(username, phone, password);
			} catch (UserNotExistException e) {
				tip = "用户名或手机号不正确！！";
			}
		}
		if (tip == null) {// 没有错误信息，表示修改成功
			return SUCCESS;
		} else {
			request.setAttribute("tip", tip);
			return ERROR;
		}
	}

	public String register() {
		Map<String, String> errors = new HashMap<String, String>();
		HttpServletRequest request = ServletActionContext.getRequest();
		boolean b = isTokenValid(request);
		if (!b) {
			errors.put("token", "请不要重复提交数据！！");
			request.setAttribute("errors", errors);
			request.setAttribute("form", user);
			return ERROR;
		} else {
			// 移除校验码
			request.getSession().removeAttribute("token");
		}
		try {
			userService.register(user);
		} catch (UserExistException e) {
			errors.put("user", e.getMessage());
			request.setAttribute("errors", errors);
			request.setAttribute("form", user);
			return ERROR;
		} catch (Exception e) {
			errors.put("unknown", e.getMessage());
			request.setAttribute("errors", errors);
			request.setAttribute("form", user);
			return ERROR;
		}
		return SUCCESS;
	}

	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		boolean b = isCodeValid(request);
		String tip = null;
		if (!b) {
			tip = "请输入验证码！";
			request.setAttribute("tip", tip);
			return ERROR;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = null;
		if (username == null || username.isEmpty()) {// 检查用户名是否为空
			tip = "用户名不能为空！！！";
		} else if (password == null || password.isEmpty()) {// 检查密码是否为空
			tip = "密码不能为空！！！";
		} else { // 用户名与密码不为空，提交service层登录
			try {
				u = userService.login(username, password);
			} catch (UserNotExistException e) {
				tip = "用户名或密码错误！！！";
			} catch (Exception e) {
				tip = e.getMessage();
			}
		}
		if (tip != null) {
			request.setAttribute("tip", tip);
			return ERROR;
		} else if (u != null) {
			request.getSession().setAttribute("user", u);
			return SUCCESS;
		}
		return ERROR;
	}

	private boolean isCodeValid(HttpServletRequest request) {
		String client_code = request.getParameter("code");
		if (client_code == null) {
			return false;
		}
		String server_code = (String) request.getSession().getAttribute("code");
		if (server_code == null) {
			return false;
		}
		if (!client_code.equals(server_code)) {
			return false;
		}
		return true;
	}

	private boolean isTokenValid(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		if (client_token == null) {
			return false;
		}
		String server_token = (String) request.getSession().getAttribute("token");
		if (server_token == null) {
			return false;
		}
		if (!client_token.equals(server_token)) {
			return false;
		}
		return true;
	}
}
