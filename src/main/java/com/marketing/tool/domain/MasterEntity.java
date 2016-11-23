package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="MASTERENTITY")
@Inheritance(strategy = InheritanceType.JOINED)
public class MasterEntity {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private MasterDataType masterDataType;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public MasterDataType getMasterDataType() {
		return masterDataType;
	}

	public void setMasterDataType(MasterDataType masterDataType) {
		this.masterDataType = masterDataType;
	}



	public enum MasterDataType {
	      KEYSKILLS,
	      COUNTRY
	}
	
	
}
