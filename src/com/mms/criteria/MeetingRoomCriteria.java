/**
 * 
 */
package com.mms.criteria;

/**
 * @author H
 * 
 */
public class MeetingRoomCriteria extends Criteria {

	private String address;
	private Integer maxCount;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

}
