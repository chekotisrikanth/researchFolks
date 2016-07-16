package com.marketing.tool.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.domain.ReportAssigners;
import com.marketing.tool.domain.ReportComments;
import com.marketing.tool.domain.ReportCommentsAlert;
import com.marketing.tool.domain.ReportCommentsVo;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.ReportHistory;
import com.marketing.tool.domain.ReportStatus;
import com.marketing.tool.domain.ReportWorkFlowStatus;
import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.domain.ViewReport;
import com.marketing.tool.domain.ViewReports;
import com.marketing.tool.repository.ReportAssignerRepository;
import com.marketing.tool.repository.ReportCommentsAlertRepository;
import com.marketing.tool.repository.ReportCommentsRepository;
import com.marketing.tool.repository.ReportRepository;
import com.marketing.tool.repository.ReportStatusRepository;
import com.marketing.tool.utility.DateUtills;
import com.marketing.tool.utility.FileUtils;
import com.marketing.tool.utility.ReportStatusEnum;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.vo.BasicResp;

@Service
@Validated
public class ReportServiceImpl implements ReportService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	private final ReportRepository repository;
	
	@Autowired
	private LoginUserService loginUserService;
	
	@Autowired
	ReportStatusService reportStatusService;
	
	 @Autowired
	private  ReportAssignerRepository reportAssignerRepository;
	 
	 @Autowired	 
	 private ReportCommentsRepository reportCommentsRepository; 
	 @Autowired
	 private ReportHistoryService reportHistoryService;
	 
	 @Autowired	 
	 private ReportStatusRepository reportStatusRepository;
	 
	 @Autowired	
		private ReportCommentsAlertRepository reportCommentsAlertRepository;
		
	 @Autowired
	 private ReportRepository reportRepository;
	 
	 
	@Inject
	public ReportServiceImpl(final ReportRepository repository) {
		this.repository = repository;
	}

	
	@Override
    @Transactional(readOnly = true)
	public List<ReportForm> getAllReports() {
		List<ReportForm> reports = repository.findAll();		
		//UpdateReportStatusString(reports);
		updateReportStatusByRole(reports, null, UserProfileType.ADMIN);
		return reports;
		
	}
	@Override
    @Transactional(readOnly = true)
	public EditReports getAllReports(Integer pageNumber,Integer results) {
		List<ReportForm> adminReports = null;
		final PageRequest page = new PageRequest(pageNumber, results);
		Page<ReportForm> reports = repository.findAll(page);		
		//UpdateReportStatusString(reports);
		
		adminReports = reports.getContent();
		updateReportStatusByRole(reports.getContent(), null, UserProfileType.ADMIN);
		//reports = null;
		EditReports editreports = new EditReports();
        editreports.setReports(adminReports);
        editreports.setTotalPages(reports.getTotalElements());
        reports = null;
		return editreports;
		
	}
	@Override
	public List<ReportForm> findByReportIdIn(List<Integer> reportIds) {
		return repository.findByReportIdIn(reportIds);
	}
	
	@Override
	public ReportForm findByReportId(Integer reportFormId) {
		return repository.findByReportId(reportFormId);
	}
	
	@Override
	@Transactional
	public void updateReports(ViewReports viewReports) {
		for(ViewReport viewReport : viewReports.getViewReportsList()) {
			ReportForm report = findByReportId(new Integer(viewReport.getReportId()));
			List<String> reviewers = viewReport.getReviewerIds();
			
			for(String emailId : reviewers) {
				User user = loginUserService.findByEmailId(emailId);
				/*ReportUserProfileId reportUserProfileId = new ReportUserProfileId(user.getId(),2,viewReport.getReportId());
				ReportUserProfile  reportUserProfile = new ReportUserProfile();
				reportUserProfile.setId(reportUserProfileId);
				reportUserProfile.setReport(report);
				reportUserProfile.setUser(user);*/
				
				ReportStatus reportStatus = new ReportStatus();
				reportStatus.setReport(report);
				reportStatus.setStatus(ReportWorkFlowStatus.REVIEWPENDING.toString());
				reportStatus.setUser(user);
				reportStatus.setUserType(UserProfileType.REVIEWER.toString());
				
				/*UserProfile profile = new UserProfile();
				profile.setId(2);
				profile.setType(UserProfileType.REVIEWER.toString());
				reportUserProfile.setUserProfile(profile);*/
				reportStatusService.save(reportStatus);
			}
			
			//List<ReportUserProfile> reportUserProfiles = report.getReportUserProfiles();
			//reportUserProfiles.add(reportUserProfile);
			
		}
		//List<ReportForm> reports = reportService.findByReportIdIn(reportIds);
		
	}
	
	
	@Override
	@Transactional
	public void assignReports(List<ReportAssigners> assigners) {
			
			Map<Integer,ReportAssigners> map = new HashMap<>();
			//check already have assignments for the reportIds
			for (ReportAssigners reportAssigners : assigners) {
				map.put(reportAssigners.getReportId(), reportAssigners);
				//reportIds.add(reportAssigners.getReportId());
			}
			
			List<ReportAssigners> existingAssigners = reportAssignerRepository.getAssignersForReports(map.keySet());
			List<ReportAssigners> assignerModified = null;
			if(!CollectionUtils.isEmpty(existingAssigners)) {				
				 assignerModified = new ArrayList<>();
				for (ReportAssigners reportAssigners : existingAssigners) {
					ReportAssigners newOne = map.get(reportAssigners.getReportId());
					if(!(newOne.getReviwerId().equals(reportAssigners.getReviwerId()) 
							&& newOne.getPublisherId().equals(reportAssigners.getPublisherId()))) {
						reportAssigners.setActive("N");						
						assignerModified.add(reportAssigners);
						
					}else {
						map.remove(reportAssigners.getReportId()); //avoid already existing ones
					}
				}
				assignerModified.addAll(map.values()); //add modified one with new ones
				if(!CollectionUtils.isEmpty(assignerModified)) {
					reportAssignerRepository.save(assignerModified);
				}
			} else {
				reportAssignerRepository.save(assigners);
			}
			
			//save new assigners
			//reportAssignerRepository.save(assigners); //save  new assigners
			//List<Integer> reportIds = new ArrayList<>();
			//update report status
			
			reportStatusService.updateAll(ReportStatusEnum.REVIWER_PENDING.getValue(), map.keySet());
    }


	@Override
	public EditReports getReviwerReports(int userId,Integer pageNumber,Integer results) {
		// TODO Auto-generated method stub
		final PageRequest page = new PageRequest(pageNumber, results);
		List<ReportForm> adminReports = null;
		Page<ReportForm> reports = repository.findReviwerReports(userId,page);
		adminReports = reports.getContent();
		updateReportStatusByRole(adminReports, null, UserProfileType.REVIEWER);
		//reports = null;
		EditReports editreports = new EditReports();
        editreports.setReports(adminReports);
        editreports.setTotalPages(reports.getTotalElements());
           //comments alert -pre data
      		Map<Integer,ReportCommentsAlert>  repMpa = null;
      		//get Records for lastSeenDate
      		List<ReportCommentsAlert> alertRecords  = reportCommentsAlertRepository.findByUserId(userId);
      		if(!CollectionUtils.isEmpty(alertRecords)) {
      			repMpa = new HashMap<>();
      			for (ReportCommentsAlert reportCommentsAlert : alertRecords) {
      				repMpa.put(reportCommentsAlert.getReportId(),reportCommentsAlert);
      			}
      		}
      		
      		setCommentsAlert(editreports.getReports(), repMpa,userId);
		/*List<ReportVo> pubReVo =ReportsSearchResponseBuilder.buildReports(adminReports, repMpa,true);
		editreports.setReportsList(pubReVo);*/
        reports = null;
		return editreports;
		
		
	}
	
	public static void setCommentsAlert(List<ReportForm> pubReVoList, Map<Integer,ReportCommentsAlert>  repMap, int userId) {
		
		for (ReportForm pubReVo : pubReVoList) {
			Integer reportId = pubReVo.getReportId();
			List<ReportComments> commentsList= pubReVo.getReportComments();
			List<ReportComments> comments = new ArrayList<>();
			if(!CollectionUtils.isEmpty(commentsList)) {
				for (ReportComments reportComments : commentsList) {
					if(reportComments.getUserId().intValue() != userId ) {
						comments.add(reportComments);
					}
				}
			}//if
			
			
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
					
				
			}//if
				
				
	}//for	
		
		
		
	}
	
	@Override
	public EditReports getPublisherReports(int userId,Integer pageNumber,Integer results) {
		// TODO Auto-generated method stub
		List<Integer> ids = new ArrayList<>();
		ids.add(ReportStatusEnum.PUBLISHER_PENDING.getValue());
		ids.add(ReportStatusEnum.PUBLISHED.getValue());
		final PageRequest page = new PageRequest(pageNumber, results);
		List<ReportForm> adminReports = null;
		//get totalCount
		
		Page<ReportForm> reports=  repository.findPublisherReports(userId, ids,page);
		adminReports = reports.getContent();
		updateReportStatusByRole(adminReports, null, UserProfileType.PUBLISHER);
		//reports = null;
		EditReports editreports = new EditReports();
        editreports.setReports(adminReports);
        editreports.setTotalPages(reports.getTotalElements());
        reports = null;
		return editreports;
	}

	
	private void UpdateReportStatusString(List<ReportForm> reports) {
		for (ReportForm reportForm : reports) {
			List<ReportStatus> status =reportForm.getReportStatuses();
			   for (ReportStatus reportStatus : status) {
				   reportStatus.setStatus(ReportStatusEnum.fromValue(reportStatus.getStatusId()));
			}
		}
	}
	@Override
	@Transactional
	public BasicResp saveReportComments(ReportCommentsVo reportComments) throws IOException {
		
		BasicResp resp = new BasicResp();
		
		String email = reportComments.getEmailId();
		try {
			List<ReportComments> comments = reportComments.getReports();
			for (ReportComments reportComments2 : comments) {
				//validate reviwer for reports 
				
				Integer userId = null;
				 if(reportComments.getRole().equals(UserProfileType.REVIEWER)) {
					 userId = 	reportAssignerRepository.getUserIdForReport(reportComments2.getReportId(), email);
				 } else if(reportComments.getRole().equals(UserProfileType.AUTHOR)) {
					 userId = reportStatusRepository.findUserIdByReportId(reportComments2.getReportId(), email);
				 }
				
				if(userId ==null) {
					continue;
				}
				
				//get Report Status
				int cnt =0;
				//update report status 
				if(reportComments2.getAssignee() != null) {
					if(reportComments2.getAssignee()==1) {
						cnt= reportStatusService.update(ReportStatusEnum.PUBLISHER_PENDING.getValue(), reportComments2.getReportId());

					}else if(reportComments2.getAssignee()==2){
						
						cnt= reportStatusService.update(ReportStatusEnum.REVIWER_COMMENTS.getValue(), reportComments2.getReportId());
						/*
						 if(!StringUtils.hasText(reportComments2.getComment())) {
							 // if it is reviwer comments and comments empty then throw exception
							 
						 }*/
					}else {
						LOGGER.warn("some thing wrong for reportId {}  and userId {}",reportComments2.getReportId(),userId);
						continue;
					}
				}
				
				//save commnets if required
				 if(reportComments2.getReportFile() != null) {
					 long time= Calendar.getInstance().getTimeInMillis();
					 FileUtils.saveFiles(reportComments2.getReportFile(),String.valueOf(reportComments2.getReportId()+""+time),SharedConstants.FILE_PATH);
						reportComments2.setFilePath(SharedConstants.FILE_PATH+String.valueOf(reportComments2.getReportId()+""+time)+SharedConstants.DOT+reportComments2.getReportFile().getOriginalFilename().split("\\.")[1]);
				}
				 if(StringUtils.hasText(reportComments2.getComment()) || reportComments2.getReportFile() != null) {
					 reportComments2.setUserId(userId);
					 reportComments2.setInsertedDate(DateUtills.getCurrentDate());					 
					 reportCommentsRepository.save(reportComments2);
				 }
				 
				 
				// make entry in transaction
				ReportHistory hs= new ReportHistory();			
				hs.setReportId(reportComments2.getReportId());
				hs.setUserId(userId);
				hs.setStatusId(1);
				hs.setInsertedDate(Calendar.getInstance().getTime());
				reportHistoryService.save(hs);
			}
			resp.setRespCode(0000);
			resp.setMessage(SharedConstants.SUCCESS);
			// make entry in transaction
		}catch(IOException ioexp) {
			resp.setRespCode(0020);
			resp.setMessage("Failed To Save Report File");
		}catch(Exception exp) {
			resp.setRespCode(0001);
			resp.setMessage("System Failure");
			
			LOGGER.error("System Failure While Saving  Report Comments For id {} cause {}",  email,exp);
		}
		
		
		return resp;
	}


	@Override
	@Transactional
	public int publishReports(List<Integer> reportIds, String email) {
		//validation all reports assigned for publisher
		int cnt = 0;
		int cnt1 = 0;
		try {
			for (Integer id : reportIds) {
				Integer userId = reportAssignerRepository.getUserIdForReportForPublisher(id, email);
				
				if(userId ==null) {
					throw new RuntimeException("Some Reports Not Assigned For User");
				}
			}
			cnt1 = reportRepository.updatePublishedDateForReports(DateUtills.getCurrentDate(), reportIds);
			cnt = reportStatusService.updateAll(ReportStatusEnum.PUBLISHED.getValue(), reportIds);
		}catch(Exception exp) {
			LOGGER.error("Entry methodName {} recCnt {} recCnt1 {} ","publishReports",cnt,cnt1);
			throw  new RuntimeException(exp.getMessage());
		}
		
		// TODO Auto-generated method stub
		return cnt;
	}
	
	private void updateReportStatusByRole(List<ReportForm> reports,Integer userId,UserProfileType type) {
		
		LOGGER.debug("Entry methodName {} ","updateReportStatusByRole");
		List<Integer> reporIds = new ArrayList<>();
		//step :1 update report Status
		for (ReportForm reportForm : reports) {
			reportForm.getCountryObj().getCountryName();
			List<ReportStatus> status =reportForm.getReportStatuses();
			   for (ReportStatus reportStatus : status) {
				   reportStatus.setStatus(ReportStatusEnum.fromValue(reportStatus.getStatusId()));
				  
			}
			   reporIds.add(reportForm.getReportId());
		}
		//step2: getAssigners or Comments  IF Exists
		List<ReportAssigners> assigners = null;
		Map<Integer,ReportAssigners>  reportWiseAssigners = new HashMap<>();
		 switch(type) {
		   case ADMIN: 
			   //get assigned reporties
			   assigners = reportAssignerRepository.getAssignersForReports(reporIds);
			   if(!CollectionUtils.isEmpty(assigners)) {
				   for (ReportAssigners reportAssigners : assigners) {
					   reportWiseAssigners.put(reportAssigners.getReportId(),reportAssigners);
				}
			   }
			   break;
		   
		  default : 
			  break;
		   }
			//step3: Populate assigners and publishers if exisist

	 if(!CollectionUtils.isEmpty(reportWiseAssigners)) {
		 for (ReportForm reportForm : reports) {
			 Integer reportId= reportForm.getReportId();
			 ReportAssigners key =  reportWiseAssigners.get(reportId);
			 if(key != null) {
				 reportForm.setReporterId(key.getReviwerId());
				 reportForm.setPublisherId(key.getPublisherId());
			 }
		}
	 }
	
	 //log final objects here
	 LOGGER.debug("Exit methodName {} ","updateReportStatusByRole");
	 
	}	

	@Override
	public List<ReportForm> findReportsByProfileType(String profileType) {
		return repository.findByProfileTypeOrderByPublishingDate(profileType,new PageRequest(0,10));
	}


	
}
