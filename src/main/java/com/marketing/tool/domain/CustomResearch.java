package com.marketing.tool.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CustomResearch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
	private Integer id;

	@NotNull
	@Column(nullable = false)
	private String researchType;
	
	@NotNull
	@Column(nullable = false)
	private String companyTile;
	
	@NotNull
	@Column(nullable = false)
	private String webLink;
	
	@NotNull
	@Column(nullable = false)
	private String industryTitle;
	
	@NotNull
	@Column(nullable = false)
	private String description;
	
	@NotNull
	@Column(nullable = false)
	private String reqSkillSet;
	
	@NotNull
	@Column(nullable = false)
	private String paymentType;
	
	@NotNull
	@Column(nullable = false)
    private Double paymentAmnt;
    
	@NotNull
	@Column(nullable = false)
    private String turnArndTime;
    
	@NotNull
	@Column(nullable = true)
    private String analyst;

	public String getResearchType() {
		return researchType;
	}

	public void setResearchType(String researchType) {
		this.researchType = researchType;
	}

	public String getCompanyTile() {
		return companyTile;
	}

	public void setCompanyTile(String companyTile) {
		this.companyTile = companyTile;
	}

	public String getWebLink() {
		return webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	public String getIndustryTitle() {
		return industryTitle;
	}

	public void setIndustryTitle(String industryTitle) {
		this.industryTitle = industryTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReqSkillSet() {
		return reqSkillSet;
	}

	public void setReqSkillSet(String reqSkillSet) {
		this.reqSkillSet = reqSkillSet;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Double getPaymentAmnt() {
		return paymentAmnt;
	}

	public void setPaymentAmnt(Double paymentAmnt) {
		this.paymentAmnt = paymentAmnt;
	}

	public String getTurnArndTime() {
		return turnArndTime;
	}

	public void setTurnArndTime(String turnArndTime) {
		this.turnArndTime = turnArndTime;
	}

	public String getAnalyst() {
		return analyst;
	}

	public void setAnalyst(String analyst) {
		this.analyst = analyst;
	}
	
	
	
	
}