/**
 * 
 */
package com.mms.util;

/**
 * @author H
 * 
 */
public class Pager {

	public static final int DEFAULT_NO = 1;
	public static final int DEFAULT_SIZE = 5;

	private int no;
	private int size;
	private int totalCount;

	public int getNo() {
		if (no > getTotalPage()) {
			this.no = getTotalPage();
		}
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return (int) Math.ceil(totalCount * 1.0 / size);
	}

	public int getFirstResult() {
		return (no - 1) * size;
	}

}
