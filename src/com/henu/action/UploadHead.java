package com.henu.action;


import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.henu.entity.User;
import com.henu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UploadHead extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private File file;
	private String fileFileName;
	private String fileContentType;

	public String uploadHead(){
		HttpServletRequest request = ServletActionContext.getRequest();
		// 保存到 upload文件夹下
		String realpath = ServletActionContext.getServletContext().getRealPath("/headicon");
		if(fileContentType==null || !fileContentType.startsWith("image/")) {
			request.setAttribute("tip", "不接受这种类型的文件");
			return ERROR;
		}
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("tip", "请先登录！");
			return ERROR;
		}
		String filename = (new Date()).getTime() + "_" + fileFileName;
		if (file != null) {
			File saveDir = new File(realpath);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			File saveFile = new File(saveDir, filename);
			// 使用 commons-io 组件上传文件
			try {
				FileUtils.copyFile(file, saveFile);	
				//更新头像
				user.setUsericon(filename);
				UserService us = new UserService();
				us.save(user);
				request.getSession().setAttribute("user", user);
				return SUCCESS;
			} catch (Exception e) {
				request.setAttribute("tip", e.getMessage());
			}
		} else {
			request.setAttribute("tip", "上传失败！");
		}
		return ERROR;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
