public class Test {
	public static void main (String args[]) {
		System.out.println(SearchClassType.findByValue("hotel").url());
		System.out.println("2 " + SearchClassType.findByValue("hotel1").url());
	}
	
	public enum SearchClassType {
		HOTEL("hotel") {
			@Override
			public String url() {
				return "url2";
			}
		}, HOTEL_AGGREGATED_DATA("hotel_aggregated_data") {
			@Override
			public String url() {
				return "url1";
			}
		};
		private String value;
		private SearchClassType(String value) {
			this.value = value;
		}
		public static SearchClassType findByValue(String value) {
			for (SearchClassType obj : SearchClassType.values()) {
				if (obj.value == value)
					return obj;
			}
			return null;
		}
		public abstract String url();
	}
	
}