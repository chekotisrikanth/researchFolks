package com.marketing.tool.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.marketing.tool.validator.Email;

@Entity  
@Table(name = "user")  
@Inheritance(strategy=InheritanceType.JOINED)  
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)  
    @Column(name = "id", nullable = false, updatable = false)
    private Integer  id;

	@NotEmpty
    @Size(max = 10)
    @Column(name = "password", nullable = false)
    private String password;
	
   /* @Size(max = 50)
    @Column(name = "accountType", nullable = false)*/
    private String accountType;  
   
	
	
	//@Column(name="userstatus", nullable=false)
	private String userstatus=UserStatus.ACTIVE.getState();
	
	@NotNull
    @Size(max = 3)
    @Column(name = "title", nullable = false)
	protected String title;
    
    @NotEmpty
    @Size(max = 20)
    @Column(name = "firstName", nullable = false)
	protected String firstName;
    
    @Size(max = 20)
    @Column(name = "lastName", nullable = true)
    private String lastName;
    
   // @Size(min=10) @Phone
   // @Column(name = "mobileNo", nullable = true)
   
    
    @NotEmpty
    @Size(max = 50)
    @Email
    @Column(name = "emailId", nullable = false)
	protected String emailId;
    
     @Transient
	 private String reTypePwd;
	 
     
     @Size(max = 50)
     @Column(name = "userName", nullable = false)    
     private String userName;
	 
     
     @Column(name = "isAgreedTc", nullable = false)
	    private boolean agreedTc;
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<ReportStatus> reportStatuses = new HashSet<ReportStatus>(0);
	
	
	public Set<ReportStatus> getReportStatuses() {
		return this.reportStatuses;
	}

	public void setReportStatuses(Set<ReportStatus> reportStatuses) {
		this.reportStatuses = reportStatuses;
	}*/

	
   /* public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
*/
   
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
   private List<PurchaseOrder> orders;
     

	public List<PurchaseOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<PurchaseOrder> orders) {
		this.orders = orders;
	}

	public String getReTypePwd() {
		return reTypePwd;
	}

	public void setReTypePwd(String reTypePwd) {
		this.reTypePwd = reTypePwd;
	}

	
    
   public Integer  getId() {
		return id;
	}

	public void setId(Integer  id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	


	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	
		
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	 
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(Integer  id) {
		super();
		this.id = id;
	}
	
	

	

	public boolean isAgreedTc() {
		return agreedTc;
	}

	public void setAgreedTc(boolean agreedTc) {
		this.agreedTc = agreedTc;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", password=");
		builder.append(password);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", userstatus=");
		builder.append(userstatus);
		builder.append(", title=");
		builder.append(title);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(", reTypePwd=");
		builder.append(reTypePwd);
		builder.append("]");
		return builder.toString();
	}
    
}
