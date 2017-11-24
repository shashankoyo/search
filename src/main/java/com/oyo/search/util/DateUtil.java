package com.oyo.search.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.oyo.search.constants.Constants;
import com.oyo.search.pojo.DateRange;
import com.oyo.search.pojo.DateRangeStringFromDB;

public class DateUtil {

	/**
	 * Returns {@link LocalDate currentDate} with default time zone
	 * @return {@link LocalDate}
	 */
	public static LocalDate today() {
		return LocalDate.now(Constants.DEFAULT_ZONE_ID);
	}

	/**
	 * Returns {@link LocalDateTime currentDateTime} with default time zone
	 * @return {@link LocalDateTime}
	 */
	public static LocalDateTime now() {
		return LocalDateTime.now(Constants.DEFAULT_ZONE_ID);
	}

	/**
     * Returns max of the two dates
     * @param d1 - {@link LocalDate}
     * @param d2 - {@link LocalDate}
     * @return {@link LocalDate}
     */
    public static LocalDate max(LocalDate d1, LocalDate d2) {
	return MathUtil.max(d1, d2);
    }

	/**
	 * Returns min of the two dates
	 * @param d1 - {@link LocalDate}
	 * @param d2 - {@link LocalDate}
	 * @return {@link LocalDate}
	 */
	public static LocalDate min(LocalDate d1, LocalDate d2) {
		return MathUtil.min(d1, d2);
	}

	/**
	 * Returns number of days in between [d1, d2)
	 * @param d1 - {@link LocalDate} - Inclusive
	 * @param d2 - {@link LocalDate} - Exclusive
	 * @return {@link int} - number of days
	 */
	public static int diffDays(LocalDate d1, LocalDate d2) {
		return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
	}

	/**
	 * Returns number of minutes in between [d1, d2)
	 * @param d1 - {@link LocalDate} - Inclusive
	 * @param d2 - {@link LocalDate} - Exclusive
	 * @return {@link int} - number of minutes
	 */
	public static int diffMinutes(LocalDateTime d1, LocalDateTime d2) {
		return (int) Math.abs(ChronoUnit.MINUTES.between(d1, d2));
	}

	/**
	 * Returns number of days in between [d1, d2]
	 * @param d1 - {@link LocalDate} - Inclusive
	 * @param d2 - {@link LocalDate} - Inclusive
	 * @return {@link int} - number of days
	 */
	public static int totalDaysInclusive(LocalDate d1, LocalDate d2) {
		return diffDays(d1, d2) + 1;
	}

	/**
	 * Converts String date to LocalDate
	 * @param dateStr - {@link String} - can be of format
	 *            <strong>'d-M-yyyy'</strong> or <strong>'yyyy-M-d'</strong>
	 * @return {@link LocalDate}
	 */
	public static LocalDate toDate(String dateStr) {
		LocalDate date = null;
		if (dateStr != null) {
			dateStr = dateStr.replaceAll("/", "-");
			if (dateStr.matches("[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}")) {
				date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("d-M-yyyy"));
			} else {
				date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-M-d"));
			}
		}
		return date;
	}

	/**
	 * Converts String date to LocalDate with default format
	 * @param date - {@link LocalDate}
	 * @return {@link String} - formatted with default format as
	 *         <strong>'yyyy-MM-dd'</strong>
	 */
	public static String toString(LocalDate date) {
		return toString(date, "yyyy-MM-dd");
	}

	/**
	 * Converts String date to LocalDate with provided format
	 * @param date - {@link LocalDate}
	 * @param dateFormat - {@link String} - eg. <strong>'yyyy-MM-dd'</strong>
	 * @return {@link String} - formatted in provided format
	 */
	public static String toString(LocalDate date, String dateFormat) {
		String dateStr = null;
		if (date != null) {
			dateStr = date.format(DateTimeFormatter.ofPattern(dateFormat));
		}
		return dateStr;
	}

	/**
	 * Converts a {@link List} of {@link DateRangeStringFromDB} to a
	 * {@link List} of {@link DateRange}
	 * @param dateRangeStrList - {@link List} of {@link DateRangeStringFromDB}
	 * @return {@link List} of {@link DateRange}
	 */
	public static List<DateRange> transformDateRangeList(List<DateRangeStringFromDB> dateRangeStrList) {
		List<DateRange> dateRangeList = null;
		if (dateRangeStrList != null) {
			dateRangeList = new ArrayList<DateRange>();
			for (DateRangeStringFromDB dateRangeStr : dateRangeStrList) {
				dateRangeList.add(transformDateRange(dateRangeStr));
			}
		}
		return dateRangeList;

	}

	/**
	 * Converts a {@link DateRangeStringFromDB} to a {@link DateRange}
	 * @param dateRangeStr - {@link DateRangeStringFromDB}
	 * @return {@link DateRange}
	 */
	public static DateRange transformDateRange(DateRangeStringFromDB dateRangeStr) {
		DateRange dateRange = null;
		if (dateRangeStr != null) {
			dateRange = new DateRange();
			dateRange.setFrom(toDate(dateRangeStr.getFrom()));
			dateRange.setTo(toDate(dateRangeStr.getTo()));
		}
		return dateRange;
	}

	/**
	 * @param dr - {@link DateRange}
	 * @param date - {@link LocalDate}
	 * @return {@link boolean} - <strong>true</strong> if the {@link LocalDate
	 *         date} lies in the range {@link DateRange dr}, both ends
	 *         <strong>inclusive</strong>, else <strong>false</strong>
	 */
	public static boolean inRangeInclusive(DateRange dr, LocalDate date) {
		if (dr != null && dr.getFrom() != null && dr.getTo() != null && date != null) {
			return (!date.isBefore(dr.getFrom()) && !date.isAfter(dr.getTo()));
		}
		return false;
	}

	/**
	 * Returns the full day name of the {@link LocalDate date} provided. Eg.
	 * <strong>Friday</strong>
	 * @param date - {@link LocalDate}
	 * @return {@link String}
	 */
	public static String dayName(LocalDate date) {
		if (date != null) {
			return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}
		return null;
	}

	public static Integer toInteger(LocalDate date) {
		if (date != null) {
			return Integer.parseInt(toString(date, "yyyyMMdd"));
		}
		return null;
	}

	public static LocalDate fromIntegerToDate(Integer date) {
		if (date != null) {
			return LocalDate.parse(String.valueOf(date), DateTimeFormatter.ofPattern("yyyyMMdd"));
		}
		return null;
	}

	public static List<LocalDate> transformDateList(LocalDate from, LocalDate to) {
		List<LocalDate> dateList = new ArrayList<>();
		LocalDate start = from;
		LocalDate end = to;
		while (!start.isAfter(end)) {
			dateList.add(start);
			start = start.plusDays(1);
		}
		return dateList;
	}
}
