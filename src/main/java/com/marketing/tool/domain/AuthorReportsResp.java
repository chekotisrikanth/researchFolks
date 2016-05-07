package com.marketing.tool.domain;

import java.util.List;

import com.marketing.tool.vo.ReportVo;

public class AuthorReportsResp {

	List<ReportVo> pulishedReports;
	List<ReportVo> repList;

	long pubRepCount;
	long otherrepCount;
	

	public List<ReportVo> getPulishedReports() {
		return pulishedReports;
	}

	public void setPulishedReports(List<ReportVo> pulishedReports) {
		this.pulishedReports = pulishedReports;
	}

	

	public List<ReportVo> getRepList() {
		return repList;
	}

	public void setRepList(List<ReportVo> repList) {
		this.repList = repList;
	}

	public long getPubRepCount() {
		return pubRepCount;
	}

	public void setPubRepCount(long pubRepCount) {
		this.pubRepCount = pubRepCount;
	}

	public long getOtherrepCount() {
		return otherrepCount;
	}

	public void setOtherrepCount(long otherrepCount) {
		this.otherrepCount = otherrepCount;
	}

	
	
	
	
}
