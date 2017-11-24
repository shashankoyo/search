package com.oyo.search.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RangeUtil {

    /**
     * Returns a {@link List} of {@link LocalDate dates} for the range provided,
     * with inclusive start and exclusive end
     * @param start - {@link LocalDate} - Inclusive
     * @param end - {@link LocalDate} - Exclusive
     * @return {@link List} of {@link LocalDate}
     */
    public static List<LocalDate> between(LocalDate start, LocalDate end) {
	List<LocalDate> dates = new ArrayList<LocalDate>();
	for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
	    dates.add(date);
	}
	return dates;
    }

    /**
     * Returns a {@link List} of {@link LocalDate dates} for the range provided,
     * with both ends inclusive
     * @param start - {@link LocalDate} - Inclusive
     * @param end - {@link LocalDate} - Inclusive
     * @return {@link List} of {@link LocalDate}
     */
    public static List<LocalDate> betweenInclusive(LocalDate start, LocalDate end) {
	return between(start, end.plusDays(1));
    }

}
