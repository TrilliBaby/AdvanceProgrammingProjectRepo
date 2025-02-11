package javaEntertainment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.Serializable;

public class DateTime implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(DateTime.class);
	private int seconds;
	private int minutes;
	private int hours;
	private int day;
	private int month;
	private int year;

	public DateTime() {
		this(0, 0, 0, 1, 1, 2000);
	}

	public DateTime(int seconds, int minutes, int hours, int day, int month, int year) {
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if (seconds >= 0 && seconds < 60) {
			this.seconds = seconds;
		} else {
			logger.warn("User entered invalid second");
			throw new IllegalArgumentException("Seconds must be between 0 and 59.");
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if (minutes >= 0 && minutes < 60) {
			this.minutes = minutes;
		} else {
			logger.warn("User entered invalid minute");
			throw new IllegalArgumentException("Minutes must be between 0 and 59.");
		}
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if (hours >= 0 && hours < 24) {
			this.hours = hours;
		} else {
			logger.warn("User entered invalid hour");
			throw new IllegalArgumentException("Hours must be between 0 and 23.");
			
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day >= 1 && day <= 31) { 
			this.day = day;
		} else {
			logger.warn("User entered invalid day");
			throw new IllegalArgumentException("Day must be between 1 and 31.");
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			logger.warn("User entered invalid month");
			throw new IllegalArgumentException("Month must be between 1 and 12.");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year >= 1900) {
			this.year = year;
		} else {
			logger.warn("User entered invalid year");
			throw new IllegalArgumentException("Year must be 1900 or later.");
		}
	}

	@Override
	public String toString() {
		return String.format(
			"Date: %02d/%02d/%04d\nTime: %02d:%02d:%02d",
			day, month, year, hours, minutes, seconds
		);
	}
}
