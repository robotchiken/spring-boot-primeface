package com.test;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TestAdjuster {

	@Test
	public void test() {
		LocalDate localDate = LocalDate.of(2018, 8, 1);
	    TemporalAdjuster temporalAdjuster = t -> t.plus(Period.ofWeeks(8));
	    LocalDate result = localDate.with(temporalAdjuster);
	     
	    String fourteenDaysAfterDate = "2018-09-26";
	     
	    assertEquals(fourteenDaysAfterDate, result.toString());
	}
	@Test
	public void whenAdjust_thenNextWorkingDay() {
	    LocalDate localDate = LocalDate.of(2018, 8, 3);
	    TemporalAdjuster temporalAdjuster = NEXT_WORKING_DAY;
	    LocalDate result = localDate.with(temporalAdjuster);
	 
	    assertEquals("2018-08-06", result.toString());
	}
	static TemporalAdjuster NEXT_WORKING_DAY = TemporalAdjusters.ofDateAdjuster(date -> {
	    DayOfWeek dayOfWeek = date.getDayOfWeek();
	    int daysToAdd;
	    if (dayOfWeek == DayOfWeek.FRIDAY)
	        daysToAdd = 3;
	    else if (dayOfWeek == DayOfWeek.SATURDAY)
	        daysToAdd = 2;
	    else
	        daysToAdd = 1;
	    return date.plusDays(daysToAdd);
	});
}
