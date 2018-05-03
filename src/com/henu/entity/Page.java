package com.henu.entity;

/**
 * 用于分页显示的类
 */
public class Page {
	/** 总页数 */
	private int totalPage;
	/** 当前页码 */
	private int currentPage;
	/** 是否需要分页显示 少于2页记录时不分页 */
	private boolean flag;
//	/** 是否需要显示省略号 少于5页记录时显示*/
//	private boolean isMorePage;
	/** 每页显示记录数 */
	private int offset;
	/** 总记录数 */
	private int count;

	public Page(int count, int index, int offset) {
		// 保证除数不为0
		if (0 == offset) {
			offset = 20;
		}
		this.count = count;
		this.offset = offset;

		int n = count % offset;
		if (0 == n) {
			this.totalPage = count / offset;
		} else {
			this.totalPage = count / offset;
		}
		
		if (index < 1) {
			index = 1;
		}else if(index > this.totalPage) {
			index = this.totalPage;
		}		
		this.currentPage = index;
		
		if(totalPage > 2){
			this.flag = true;
		}else {
			this.flag = false;
		}

//		if (totalPage > 5) {
//			setMorePage(true);
//			isPage = true;
//		} else if(totalPage > 2){
//			setMorePage(false);
//			isPage = true;
//		}else {
//			setMorePage(false);
//			isPage = false;
//		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
