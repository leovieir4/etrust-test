package br.com.etrust.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.etrust.exceptions.IncorrectDaysException;
import br.com.etrust.exceptions.IncorrectMonthException;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	private static final int MAX_RANGE = 12;
	private static final int MIN_RANGE = 0;
	
	private static final int BI_YEAR = 366;
	private static final int NORMAL_YEAR = 365;
	
	private int numberDayOfYear;
	
	private static final Map<Integer, Integer> MONTHS = new HashMap<Integer, Integer>(){
		{
		  put(2, 28);
		  put(4, 30);
		  put(6, 30);
		  put(9, 30);
		  put(11, 30);
		}
	};

	public Date(int year, int month, int day) throws Exception {
		
		Date.validMonth(month);
		Date.validDay(day, month);

		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
		this.setNumberDayOfYear(year);
	}
	
	public static int getDiffBetweenDates(Date d1, Date d2) {
	  int diffDaysToEndYear = Date.getDaystoEndYear(d1);
	  
	  diffDaysToEndYear = Date.getDaystoEndYear(d1);
	  diffDaysToEndYear += d2.getNumberDayOfYear() - Date.getDaystoEndYear(d2);
	  
	  for(int year = d1.getYear() + 1; year < d2.getYear(); year ++) {
		  diffDaysToEndYear += Date.calcDaysOfYear(year);
	  }
	  
	  return diffDaysToEndYear;
	}
	
	public static int getDaystoEndYear(Date date) {
		  int diffDaysToEndYear = Date.getDaysToEndMonth(date.getMonth(), date.getDay(), date.getYear());
		  for(int month = date.getMonth() + 1; month <= 12 ; month++) {
			  diffDaysToEndYear += Date.getTotalDaysOfMonth(month, date.getYear());
		  }
		  return diffDaysToEndYear;
	}
	
	public static int getDaysToEndMonth(int month, int initialDay, int year) {
		int daysMonth = Date.getTotalDaysOfMonth(month, year);
		return (daysMonth - initialDay) + 1;
	}
	
	public static int getTotalDaysOfMonth(int month, int year) {
		int days = (Date.MONTHS.get(month) != null) ? Date.MONTHS.get(month) : 31;;
		if(month == 2) days += (Date.calcDaysOfYear(year) == Date.BI_YEAR) ? 1 : 0;
		return days;
	}
	
	public static void validMonth(int month) {
		if(month > MAX_RANGE || month < MIN_RANGE) throw new IncorrectMonthException("Incorrect Month, range [1,12]");
	}
	
	public static void validDay(int day, int month) {
		int dayRange = (MONTHS.get(month) !=null ) ? MONTHS.get(month) : 31;
		if(MONTHS.get(month) != null && day > MONTHS.get(month) || day == 0 || day > 31) throw new IncorrectDaysException("Incorrect day to this month, range [1, " + dayRange + "]");
	}

	public int getDay() {
		return day;
	}

	private void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	private void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	private void setYear(int year) {
		this.year = year;
	}

	public int getNumberDayOfYear() {
		return numberDayOfYear;
	}

	private void setNumberDayOfYear(int year) {
		this.numberDayOfYear = Date.calcDaysOfYear(year);
	}
	
	private static int calcDaysOfYear(int year) {
		return (year % 4 == 0) ? Date.BI_YEAR : Date.NORMAL_YEAR;
	}
	
}
