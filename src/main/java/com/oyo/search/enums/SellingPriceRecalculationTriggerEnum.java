package com.oyo.search.enums;

/**
 * The {@code SellingPriceRecalculationTriggerEnum} {@code enum} represents
 * triggers for calculating consumer price.
 */
public enum SellingPriceRecalculationTriggerEnum {

	HOTEL_ROOM_TYPE("HotelRoomType"), HOTEL_ROOM_TYPE_PRIORITY("HotelRoomTypePriority");

	String name;

	SellingPriceRecalculationTriggerEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
