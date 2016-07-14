package com.marketing.tool.domain;

import java.util.List;
import java.util.Map;

import com.marketing.tool.vo.ReportVo;

public class AuthorReportsResp {

	List<ReportVo> pulishedReports;
	List<ReportVo> repList;
	
	Map<Integer,List<Integer>> publishedChartsData;
	
	
	
	
	long pubRepCount;
	long otherrepCount;
	
	
	

	public Map<Integer, List<Integer>> getPublishedChartsData() {
		return publishedChartsData;
	}

	public void setPublishedChartsData(Map<Integer, List<Integer>> publishedChartsData) {
		this.publishedChartsData = publishedChartsData;
	}

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
