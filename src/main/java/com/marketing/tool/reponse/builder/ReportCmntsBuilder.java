package com.marketing.tool.reponse.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.marketing.tool.domain.ReportComments;
import com.marketing.tool.domain.User;
import com.marketing.tool.utility.DateUtills;
import com.marketing.tool.vo.ReportCommentsHistory;
import com.marketing.tool.vo.ReportCommentsHistoryList;

/**
 * @author Anilkumar Ravula
 *
 */
public class ReportCmntsBuilder {

	
	public static ReportCommentsHistoryList buildRePortComments(List<ReportComments> comments)  {
		ReportCommentsHistoryList commentsList = null;;
		if(CollectionUtils.isEmpty(comments)) {
			return commentsList;
		}
		List<ReportCommentsHistory> historyList = new ArrayList<>();
		for (ReportComments reportComments : comments) {
			
			ReportCommentsHistory history = new ReportCommentsHistory();
			history.setComment(reportComments.getComment());
			history.setFilePath(reportComments.getFilePath());
			try {
				history.setDate(DateUtills.getStringFromDate(reportComments.getInsertedDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			User user = reportComments.getUser();
			history.setUserName(new StringBuilder().append(user.getLastName()).append(" "+user.getFirstName()).toString());
			history.setCmntId(reportComments.getId());
			historyList.add(history);
		}
		commentsList = new ReportCommentsHistoryList();
		commentsList.setReports(historyList);
		
		
		return commentsList;
	}
}
