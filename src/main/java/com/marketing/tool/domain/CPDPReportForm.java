package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class CPDPReportForm extends ReportForm{
	

		@NotNull
		@Column(name="stock_exchange_id" , nullable=true)
		private Integer stockExchageId;
		
		@NotEmpty
		@Column(name="ticker" , nullable=true)
		private String ticker;
		
		
		@NotEmpty
		@Column(name="currency")
		private String currency;
		
		
		@NotNull
		@Column(name="company_intl_type" , nullable=true)
		private Integer comIntl;
		
		@NotEmpty
		@Column(name="revenue" , nullable=false)
		private String revenue;
		
		
		@NotNull
		@Column(name="units" , nullable=true)
		private Integer units;
		
		@NotNull
		@Column(name="reportType" , nullable=true)
		private Integer reportType;
		

		@NotNull
		@Column(name="headcount" , nullable=true)
		private Integer headcount;
		@Transient
		private String reportImage;
		
		

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



		public Integer getHeadcount() {
			return headcount;
		}



		public void setHeadcount(Integer headcount) {
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
