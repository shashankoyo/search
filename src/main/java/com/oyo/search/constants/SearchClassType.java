package com.oyo.search.constants;

public enum SearchClassType {
		HOTEL("hotel") {
			@Override
			public String url() {
				return "http://localhost:8081/test";
			}
		}, HOTEL_AGGREGATED_DATA("Hotel_aggregated_data") {
			@Override
			public String url() {
				return "hotel_aggregated_data_url";
			}
		};
		private String value;
		private SearchClassType(String value) {
			this.value = value;
		}
		public static SearchClassType findByValue(String value) {
			for (SearchClassType obj : SearchClassType.values()) {
				if (obj.value.equalsIgnoreCase(value))
					return obj;
			}
			return null;
		}
		public abstract String url();
	}