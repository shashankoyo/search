package com.oyo.search.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

import org.springframework.util.CollectionUtils;

public class MathUtil {

	private static Random random = new Random(System.currentTimeMillis());

	/**
	 * Returns the max using <strong>compareTo</strong> method of two
	 * {@link Comparable} objects
	 * @param d1 - <{@link T} extends {@link Comparable}>
	 * @param d2 - <{@link T} extends {@link Comparable}>
	 * @return {@link T} - the max using <strong>compareTo</strong> method
	 */
	public static <T extends Comparable<? super T>> T max(T d1, T d2) {
		if (d1.compareTo(d2) >= 0)
			return d1;
		return d2;
	}

	/**
	 * Returns the min using <strong>compareTo</strong> method of two
	 * {@link Comparable} objects
	 * @param d1 - <{@link T} extends {@link Comparable}>
	 * @param d2 - <{@link T} extends {@link Comparable}>
	 * @return {@link T} - the min using <strong>compareTo</strong> method
	 */
	public static <T extends Comparable<? super T>> T min(T d1, T d2) {
		if (d1.compareTo(d2) <= 0)
			return d1;
		return d2;
	}

	/**
	 * Returns the median {@link T} which is the left bound in case of even
	 * sized {@link List} of {@link T}
	 * @param list - {@link List} of {@link T}
	 * @return {@link T} - median
	 */
	public static <T> T median(List<T> list) {
		Integer size = list.size();
		Integer medianIndex = (size + 1) / 2;
		try {
			return list.get(medianIndex - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * Returns the closest {@link Integer multiple} of the {@link Integer
	 * factor}, which is less than or equal to the {@link Integer value}
	 * provided
	 * @param val - {@link Integer}
	 * @param factor - {@link Integer}
	 * @return {@link Integer}
	 */
	public static Integer roundTo(Integer val, Integer factor) {
		return (val + factor / 2) / factor * factor;
	}

	/**
	 * Returns the closest {@link Integer} ending with <strong>49</strong> or
	 * <strong>99</strong>, which is less than or equal to the {@link Integer
	 * value} provided
	 * @param val - {@link Integer}
	 * @return {@link Integer}
	 */
	public static Integer to99(Integer val) {
		return roundTo(val, 50) - 1;
	}

	/**
	 * Uses {@link Integer#parseInt(String)} after removing specific characters
	 * like [,], and gracefully handles <strong>null</strong> and other
	 * exceptions
	 * @param numberStr - {@link String}
	 * @return {@link Integer}
	 */
	public static Integer parseInt(String numberStr) {
		Integer number = null;
		numberStr = TransformUtil.removeExtraCharactersForNumber(numberStr);
		if (numberStr != null) {
			try {
				number = Integer.parseInt(numberStr);
			} catch (NumberFormatException e) {
				number = null;
			}
		}
		return number;
	}

	/**
	 * Uses {@link Double#parseDouble(String)} after removing specific
	 * characters like [,] and gracefully handles <strong>null</strong> and
	 * other exceptions
	 * @param numberStr - {@link String}
	 * @return {@link Double}
	 */
	public static Double parseDouble(String numberStr) {
		Double number = null;
		numberStr = TransformUtil.removeExtraCharactersForNumber(numberStr);
		if (numberStr != null) {
			try {
				number = Double.parseDouble(numberStr);
			} catch (NumberFormatException e) {
				number = null;
			}
		}
		return number;
	}

	/**
	 * Returns a <strong>positive</strong> random <strong>integer</strong>
	 * @return {@link int}
	 */
	public static int randomPositiveInt() {
		return Math.abs(random.nextInt()) + 1;
	}

	/**
	 * Returns the {@link double} number rounded off to the
	 * <strong>decimalPlaces</strong> provided
	 * @param number - {@link double}
	 * @param decimalPlaces - {@link int}
	 * @return {@link double}
	 */
	public static double round(double number, int decimalPlaces) {
		if (decimalPlaces < 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = new BigDecimal(number);
		bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	

	/**
	 * Returns sum of integers in a list
	 * @param list - {@link List}<{@link Integer}>
	 * @return {@link Integer}
	 */
	public static Integer sum(List<Integer> list) {
		if (CollectionUtils.isEmpty(list)) {
			return 0;
		}
		return list.stream().mapToInt(Integer::intValue).sum();
	}

}
