package com.oyo.search.pojo;

public class TriggerDataModel extends DateRange {

	private static final long serialVersionUID = 7687078979133662759L;

	int[] hotel_ids;
	boolean delete;
	String type;
	String log_type;
	String source;
	String data_unique_id;
	DateRange dates;
	Data[] data;

	public Data[] getData() {
		return data;
	}

	public void setData(Data[] data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public String getData_unique_id() {
		return data_unique_id;
	}

	public void setData_unique_id(String data_unique_id) {
		this.data_unique_id = data_unique_id;
	}

	public DateRange getDates() {
		return dates;
	}

	public void setDates(DateRange dates) {
		this.dates = dates;
	}

	static class Data {
		String field_name;
		String value;

		public String getField_name() {
			return field_name;
		}

		public void setField_name(String field_name) {
			this.field_name = field_name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Field name : " + field_name + ", value : " + value;
		}

	}

	@Override
	public String toString() {
		String hotelIds = "";
		for (int i : hotel_ids) {
			hotelIds = hotelIds + ", " + i;
		}
		String str = "Hotel ids : " + hotelIds.substring(2) + ", log type : " + log_type + ", source : " + source + ", type : " + type + ", delete : "
				+ delete + ", data unique id : " + data_unique_id;
		str = dates == null ? str : str + ", dates : " + dates.toString();
		if (data != null) {
			String data_str = "";
			for (Data curr_data : data) {
				data_str = data_str + "{ " + curr_data.toString() + " }, ";
			}
			str = data_str.length() < 3 ? str : str + ", data : [ " + data_str.substring(0, data_str.length() - 2) + " ]";
		}
		return str;
	}

}