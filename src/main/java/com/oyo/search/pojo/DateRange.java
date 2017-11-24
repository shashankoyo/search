package com.oyo.search.pojo;

import java.time.LocalDate;

/**
 * A simple POJO with from and to LocalDates
 * @author riteshthounaojam
 */
public class DateRange extends AbstractPojo {

    private static final long serialVersionUID = 6235280271500903135L;

    private LocalDate from;

    private LocalDate to;

    public LocalDate getFrom() {
	return from;
    }

    public DateRange setFrom(LocalDate from) {
	this.from = from;
	return this;
    }

    public LocalDate getTo() {
	return to;
    }

    public DateRange setTo(LocalDate to) {
	this.to = to;
	return this;
    }

    @Override
    public String toString() {
	return "DateRange [from=" + from + ", to=" + to + "]";
    }

}
