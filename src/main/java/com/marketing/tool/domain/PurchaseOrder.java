package com.marketing.tool.domain;
// Generated Jul 9, 2016 6:23:47 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "purchaseorder")
public class PurchaseOrder  {

	private int txnid;
	private Date purchsedate;
	private User customer;
	
	public PurchaseOrder() {
	}

	public PurchaseOrder(int txnid) {
		this.txnid = txnid;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "txnid", unique = true, nullable = false,length=10)
	public int getTxnid() {
		return this.txnid;
	}

	public void setTxnid(int txnid) {
		this.txnid = txnid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "purchsedate")
	public Date getPurchsedate() {
		return this.purchsedate;
	}

	public void setPurchsedate(Date purchsedate) {
		this.purchsedate = purchsedate;
	}

	private Set<ReportForm> reports=new HashSet<ReportForm>(0);;
	
	@OneToMany
	@JoinColumn(name="purchaseId", referencedColumnName="txnId",nullable=true)
	public Set<ReportForm> getReports() {
		return reports;
	}

	public void setReports(Set<ReportForm> reports) {
		this.reports = reports;
	}

	@ManyToOne
	@JoinColumn(name = "customerId")
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	
}
