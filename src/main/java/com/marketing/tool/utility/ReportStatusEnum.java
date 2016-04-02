package com.marketing.tool.utility;

public enum ReportStatusEnum {
	CREATED(1),
	REVIWER_PENDING(2),
	REVIWER_COMMENTS(3),
	PUBLISHER_PENDING(4),
	PUBLISHED(5);

	private final int value;

    ReportStatusEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { 
    	return value;
    }
    
    public static String fromValue(int value) throws IllegalArgumentException {
    	String  name = null;
        try{
        	ReportStatusEnum[] values  = ReportStatusEnum.values();        	
        	for (ReportStatusEnum reportStatusEnum : values) {
        		if(reportStatusEnum.getValue() == value) {
        			name =  reportStatusEnum.toString();
        			break;
        		}
			}        	
        }catch( ArrayIndexOutOfBoundsException e ) {
             throw new IllegalArgumentException("Unknown enum value :"+ value);
        }
		return name;
    }
}
