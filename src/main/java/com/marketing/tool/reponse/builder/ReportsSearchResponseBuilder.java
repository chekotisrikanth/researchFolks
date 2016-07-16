package com.marketing.tool.reponse.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.marketing.tool.domain.ReportComments;
import com.marketing.tool.domain.ReportCommentsAlert;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.utility.ServiceConstants;
import com.marketing.tool.vo.ReportVo;

public class ReportsSearchResponseBuilder {
	
	
	
	/**
	 * @param reports
	 * @return
	 */
	public static List<ReportVo> buildReports(Collection<ReportForm> reports,Map<Integer,ReportCommentsAlert>  repMap,boolean flag ) {
		List<ReportVo> rep = null;
		
		if(CollectionUtils.isEmpty(reports)) {
			rep=new ArrayList<>(0);
		} else {
			rep=new ArrayList<>();
			for (ReportForm reportForm : reports) {
				ReportVo vo = new ReportVo();
				vo.setCountry(reportForm.getCountryObj().getCountryName().toString());
				vo.setReportId(reportForm.getReportId());
				vo.setIndustry(reportForm.getIndustry());
				vo.setReportTitle(reportForm.getReportTitle());
				vo.setUserName(reportForm.getReportStatuses().get(0).getUser().getLastName()+" "+reportForm.getReportStatuses().get(0).getUser().getFirstName() );
				vo.setUserId(reportForm.getReportStatuses().get(0).getUser().getId());
				vo.setComIntl(reportForm.getComIntl());
				if(vo.getComIntl().equals(1)) {
					vo.setComIntlString(ServiceConstants.COMPANY_REPORT);
				}else {
					vo.setComIntlString(ServiceConstants.COMPANY_DATABASE);
				}
				vo.setPublishingDate(reportForm.getPublishingDate().toString());
				List<ReportComments> comments = reportForm.getReportComments();
				if(flag) {
					setCommentsAlert(vo, repMap, comments);
				}	
				rep.add(vo);
			}
		}
		
		
		return rep;

    }
	
public static void setCommentsAlert(ReportVo pubReVo, Map<Integer,ReportCommentsAlert>  repMap,List<ReportComments> commentsList) {
	
	Integer reportId = pubReVo.getReportId();
	List<ReportComments> comments = new ArrayList<>();
	if(!CollectionUtils.isEmpty(commentsList)) {
		for (ReportComments reportComments : commentsList) {
			if(reportComments.getUserId().intValue() != pubReVo.getUserId().intValue() ) {
				comments.add(reportComments);
			}
		}
	}
	
	
	if(!CollectionUtils.isEmpty(comments) && repMap == null) {
		if(!CollectionUtils.isEmpty(comments)) {
			pubReVo.setHaveComments("Y");
			pubReVo.setComntCnt(comments.size());
		}
	} else if(!CollectionUtils.isEmpty(comments) && repMap != null) {
		
			ReportCommentsAlert comment  = repMap.get(reportId);
			if(comment == null) {
				pubReVo.setHaveComments("Y");
				pubReVo.setComntCnt(comments.size());
			} else {
				int commentsCnt = 0;
				Date lastSeenDate = comment.getLastSeenDate();
				for (ReportComments reportComments : comments) {
					
					Date cmtDate = reportComments.getInsertedDate();				
					if( cmtDate.getTime() > lastSeenDate.getTime()) {
						commentsCnt++;
					}
				}
				if(commentsCnt>0) {
					pubReVo.setHaveComments("Y");
					pubReVo.setComntCnt(commentsCnt);
				}
			}
			
		
	}
		
		
	}	
	
}



