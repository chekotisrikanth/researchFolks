package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CPDPReportForm extends ReportForm{
	

		//@NotNull
		@Column(name="stock_exchange_id" , nullable=true)
		private Integer stockExchageId;
		
		//@NotEmpty
		@Size(max=20)
		@Column(name="ticker" , nullable=true)
		private String ticker;
		
		
		//@NotEmpty
		@Column(name="currency")
		private String currency;
		
		
		@NotNull
		@Column(name="company_intl_type" , nullable=true)
		private Integer comIntl;
		
		
		@Column(name="revenue" , nullable=false)
		@Size(max=20)
		private String revenue;
		
		
		//@NotNull
		@Column(name="units" , nullable=true)
		private Integer units;
		
		@NotNull
		@Column(name="reportType" , nullable=true)
		private Integer reportType;
		

		
		@Column(name="headcount" , nullable=true)
		@Size(max=20)
		private String headcount;
		
		@Transient
		private String reportImage;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "report_id", insertable = false, updatable = false)
		private ReportForm report;
		

		public ReportForm getReport() {
			return report;
		}



		public void setReport(ReportForm report) {
			this.report = report;
		}



	public Integer getStockExchageId() {
			return stockExchageId;
		}



		public void setStockExchageId(Integer stockExchageId) {
			this.stockExchageId = stockExchageId;
		}



		public String getTicker() {
			return ticker;
		}



		public void setTicker(String ticker) {
			this.ticker = ticker;
		}



		public String getCurrency() {
			return currency;
		}



		public void setCurrency(String currency) {
			this.currency = currency;
		}



		public Integer getComIntl() {
			return comIntl;
		}



		public void setComIntl(Integer comIntl) {
			this.comIntl = comIntl;
		}



		public String getRevenue() {
			return revenue;
		}



		public void setRevenue(String revenue) {
			this.revenue = revenue;
		}



		public Integer getUnits() {
			return units;
		}



		public void setUnits(Integer units) {
			this.units = units;
		}



		public Integer getReportType() {
			return reportType;
		}



		public void setReportType(Integer reportType) {
			this.reportType = reportType;
		}



		
		public String getHeadcount() {
			return headcount;
		}



		public void setHeadcount(String headcount) {
			this.headcount = headcount;
		}



		public String getReportImage() {
			return reportImage;
		}
		public void setReportImage(String reportImage) {
			this.reportImage = reportImage;
		}
	
		
		/*	 @Transient
		     @Phone
		    private String phone;
			 @Transient
		     @Email
		    private String email;
			 
			 
		 

	       public String getEmail() {
				return email;
			}



			public void setEmail(String email) {
				this.email = email;
			}



		public String getPhone() {
				return phone;
			}



			public void setPhone(String phone) {
				this.phone = phone;
			}*/



	@Override
	public String toString() {
		return super.toString();
	}


	
	
	
}
