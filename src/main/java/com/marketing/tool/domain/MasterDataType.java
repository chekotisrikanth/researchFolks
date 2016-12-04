package com.marketing.tool.domain;

import java.util.HashMap;
import java.util.Map;

import com.marketing.tool.domain.master.AnalystPreference;
import com.marketing.tool.domain.master.CompanyTitle;
import com.marketing.tool.domain.master.CompanyType;
import com.marketing.tool.domain.master.Country;
import com.marketing.tool.domain.master.Currency;
import com.marketing.tool.domain.master.Industry;
import com.marketing.tool.domain.master.Keyskills;
import com.marketing.tool.domain.master.Occupation;
import com.marketing.tool.domain.master.ResearchType;
import com.marketing.tool.domain.master.TurnAroundTime;
import com.marketing.tool.domain.master.Units;
import com.marketing.tool.domain.master.UpdateCycle;

public enum MasterDataType {
	
    KEYSKILLS(1,Keyskills.class),
    COUNTRY(2,Country.class),
    ANALYSTPREFERANCE(3,AnalystPreference.class),
    COMPANYTITLE(4,CompanyTitle.class),
    COMPANYTYPE(5,CompanyType.class),
    CURRENCY(6,Currency.class),
    INDUSTRY(7,Industry.class),
    OCCUPATION(8,Occupation.class),
    RESEARCHTYPE(9,ResearchType.class),
    TURNAROUNDTIME(10,TurnAroundTime.class),
    UNITS(11,Units.class),
    UPDATECYCLE(12,UpdateCycle.class);
	
	private int typeid;
	private Class domainClass;
	
	
	
	public Class getDomainClass() {
		return domainClass;
	}

	public void setDomainClass(Class domainClass) {
		this.domainClass = domainClass;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	private MasterDataType(int typeid,Class domainClass) {
		this.typeid = typeid;
		this.domainClass = domainClass;
	}
	
	 private final static Map<Integer, MasterDataType> REVERSE_MAP = new HashMap<>();
	
	static {
      for (MasterDataType type: values()) {
          REVERSE_MAP.put(type.typeid, type);
      }
  }

  public static MasterDataType getMasterDataType(Integer id) {
      return REVERSE_MAP.get(id.intValue());
  }
  
  public static Class getMasterDomainClassById(Integer id) {
      return REVERSE_MAP.get(id.intValue()).getDomainClass();
  }
}
