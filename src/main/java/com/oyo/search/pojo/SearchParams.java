package com.oyo.search.pojo;

import java.util.List;
import java.util.Map;

public class SearchParams {
	private Filters filters;
	public Filters getFilters() {
		return filters;
	}

	public void setFilters(Filters filters) {
		this.filters = filters;
	}

	String[] fields;
	String shortlist_id;
	String shared_shortlist_id;
	Map<String, String> available_room_count;
	String user_currency_code;
	String[] additional_fields;
	Map<String, Map<String, String>> format_response;
	
	public Map<String, Map<String, String>> getFormat_response() {
		return format_response;
	}

	public void setFormat_response(Map<String, Map<String, String>> format_response) {
		this.format_response = format_response;
	}
	
	public String getShortlist_id() {
		return shortlist_id;
	}

	public void setShortlist_id(String shortlist_id) {
		this.shortlist_id = shortlist_id;
	}

	public String getShared_shortlist_id() {
		return shared_shortlist_id;
	}

	public void setShared_shortlist_id(String shared_shortlist_id) {
		this.shared_shortlist_id = shared_shortlist_id;
	}

	public Map<String, String> getAvailable_room_count() {
		return available_room_count;
	}

	public void setAvailable_room_count(Map<String, String> available_room_count) {
		this.available_room_count = available_room_count;
	}

	public String getUser_currency_code() {
		return user_currency_code;
	}

	public void setUser_currency_code(String user_currency_code) {
		this.user_currency_code = user_currency_code;
	}

	public String[] getAdditional_fields() {
		return additional_fields;
	}

	public void setAdditional_fields(String[] additional_fields) {
		this.additional_fields = additional_fields;
	}
	
	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	public static class Filters {
		int property_type;
		String hotel_name;
		String oyo_id;
		int hotel_type;
		String incentive_type;
		Map<String, Integer> room_pricing;
		String[] amenities;
		Map<String, String> coordinates;
		Map<String, String> restrictions;
		Map<String, List<String>> tags;
		
		public String getIncentive_type() {
			return incentive_type;
		}

		public void setIncentive_type(String incentive_type) {
			this.incentive_type = incentive_type;
		}
		
		public Map<String, List<String>> getTags() {
			return tags;
		}

		public void setTags(Map<String, List<String>> tags) {
			this.tags = tags;
		}

		public int getProperty_type() {
			return property_type;
		}

		public void setProperty_type(int property_type) {
			this.property_type = property_type;
		}

		public String getHotel_name() {
			return hotel_name;
		}

		public void setHotel_name(String hotel_name) {
			this.hotel_name = hotel_name;
		}

		public String getOyo_id() {
			return oyo_id;
		}

		public void setOyo_id(String oyo_id) {
			this.oyo_id = oyo_id;
		}

		public int getHotel_type() {
			return hotel_type;
		}

		public void setHotel_type(int hotel_type) {
			this.hotel_type = hotel_type;
		}

		public Map<String, Integer> getRoom_pricing() {
			return room_pricing;
		}

		public void setRoom_pricing(Map<String, Integer> room_pricing) {
			this.room_pricing = room_pricing;
		}

		public String[] getAmenities() {
			return amenities;
		}

		public void setAmenities(String[] amenities) {
			this.amenities = amenities;
		}

		public Map<String, String> getCoordinates() {
			return coordinates;
		}

		public void setCoordinates(Map<String, String> coordinates) {
			this.coordinates = coordinates;
		}

		public Map<String, String> getRestrictions() {
			return restrictions;
		}

		public void setRestrictions(Map<String, String> restrictions) {
			this.restrictions = restrictions;
		}

		
	}
	
}