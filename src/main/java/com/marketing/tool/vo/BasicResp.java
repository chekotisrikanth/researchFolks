package com.marketing.tool.vo;

import java.io.Serializable;
/**
 * @author Anilkumar Ravula
 *
 */
public class BasicResp implements Serializable{

	
	private Integer respCode = 0;
	private Integer unsuccessfull = 0;
	private String  result;
	
	private String message;

	
	public Integer getRespCode() {
		return respCode;
	}

	public void setRespCode(Integer respCode) {
		this.respCode = respCode;
	}

	public Integer getUnsuccessfull() {
		return unsuccessfull;
	}

	public void setUnsuccessfull(Integer unsuccessfull) {
		this.unsuccessfull = unsuccessfull;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
