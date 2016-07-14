package com.marketing.tool.vo;

import java.io.Serializable;

//@MappedSuperclass
/**
 * @author anil
 *
 */

//@Inheritance(strategy=InheritanceType.JOINED)
public class ReportCommentsHistory implements Serializable{

	private String comment;
	
	private String date;

	private String userName;
	
	private String filePath;
	
	private Integer cmntId;
	
	
	
	

	public Integer getCmntId() {
		return cmntId;
	}

	public void setCmntId(Integer cmntId) {
		this.cmntId = cmntId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportCommentsHistory [comment=");
		builder.append(comment);
		builder.append(", date=");
		builder.append(date);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
		
	
}
