package com.oyo.search.pojo;

public class TriggerDataModel extends DateRange {
	
	private static final long serialVersionUID = 7687078979133662759L;
	int[] hotel_ids;
	boolean delete;
	String type;
	String log_type;
	String source;
	DateRange dates;
	
	public int[] getHotel_ids() {
		return hotel_ids;
	}
	public void setHotel_ids(int[] hotel_ids) {
		this.hotel_ids = hotel_ids;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public DateRange getDates() {
		return dates;
	}
	public void setDates(DateRange dates) {
		this.dates = dates;
	}

}