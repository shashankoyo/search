package com.oyo.search.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The {@code TimeUtil} is a utility class for time.
 */
public class TimeUtil {

	/**
	 * Converts {@link LocalDateTime} to Long value.
	 * @param timestamp
	 * @return {@link Long} value
	 */
	public static Long toLong(LocalDateTime timestamp) {
		if (timestamp != null) {
			return Long.parseLong(TimeUtil.toString(timestamp, "yyyyMMddHHmmss"));
		}
		return null;
	}

	/**
	 * Converts {@code LocalDateTime}
	 * @param timestamp
	 * @param format
	 * @return
	 */
	public static String toString(LocalDateTime timestamp, String format) {
		String timestampString = null;
		if (timestamp != null) {
			timestampString = timestamp.format(DateTimeFormatter.ofPattern(format));
		}
		return timestampString;

	}

	public static LocalDateTime fromLongToLocalDateTime(Long timestamp) {
		if (timestamp != null) {
			return LocalDateTime.parse(String.valueOf(timestamp), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		}
		return null;
	}

}
