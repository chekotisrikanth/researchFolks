package com.marketing.tool.domain;

import java.util.HashMap;
import java.util.Map;

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
import javax.persistence.Transient;

@Entity
@Table(name="MASTERENTITY")
@Inheritance(strategy = InheritanceType.JOINED)
public class MasterEntity {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	protected MasterDataType masterDataType;
	
	
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
		
	      KEYSKILLS(1),
	      COUNTRY(2),
	      ANALYSTPREFERANCE(3),
	      COMPANYTITLE(4),
	      COMPANYTYPE(5),
	      CURRENCY(6),
	      INDUSTRY(7),
	      OCCUPATION(8),
	      RESEARCHTYPE(9),
	      TURNAROUNDTIME(10),
	      UNITS(11),
	      UPDATECYCLE(12);
		
		private int typeid;
		
		public int getTypeid() {
			return typeid;
		}

		public void setTypeid(int typeid) {
			this.typeid = typeid;
		}

		private MasterDataType(int typeid) {
			this.typeid = typeid;
		}
		
		 private final static Map<Integer, MasterDataType> REVERSE_MAP = new HashMap<>();
		
		static {
	        for (MasterDataType status: values()) {
	            REVERSE_MAP.put(status.typeid, status);
	        }
	    }

	    public static MasterDataType getMasterDataType(int id) {
	        return REVERSE_MAP.get(id);
	    }
	}
	
	 
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        MasterEntity that = (MasterEntity) obj;
        return id.equals(that.id);
    }
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
	
}
