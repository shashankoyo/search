package com.oyo.search.pojo;

/**
 * For mapping string format dates stored in DB json field
 * @author riteshthounaojam
 */
public class DateRangeStringFromDB extends AbstractPojo {

    private static final long serialVersionUID = -7233071122084895366L;

    private String from;

    private String to;

    public String getFrom() {
	return from;
    }

    public DateRangeStringFromDB setFrom(String from) {
	this.from = from;
	return this;
    }

    public String getTo() {
	return to;
    }

    public DateRangeStringFromDB setTo(String to) {
	this.to = to;
	return this;
    }

    @Override
    public String toString() {
	return "DateRangeString [from=" + from + ", to=" + to + "]";
    }

}
