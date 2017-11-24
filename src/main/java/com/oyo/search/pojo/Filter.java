package com.oyo.search.pojo;

import java.util.List;
import java.util.Map;

public class Filter {
		int property_type;
		String hotel_name;
		String oyo_id;
		int hotel_type;
		Map<String, Integer> room_pricing;
		String[] amenities;
		Map<String, String> coordinates;
		Map<String, String> restrictions;
		Map<String, List<String>> tags;
		
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