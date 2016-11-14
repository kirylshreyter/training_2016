package com.kirylshreyter.training.hotel.daodb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Repository;

@Repository
public class DateConverter {

	public Date stringToJavaUtilDateConverter(String nonConvertedDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date convertedDate = new Date();
		try {
			convertedDate = sdf.parse(nonConvertedDate);
		} catch (ParseException e) {
			throw new RuntimeException("Invalid date format. Can't parse the date.");

		}
		return convertedDate;
	}

	public java.sql.Date javaUtilDateToJavaSqlDateConverter(Date nonConvertedUtilDate) {
		try {
			java.sql.Date convertedSqlDate = new java.sql.Date(nonConvertedUtilDate.getTime());
			return convertedSqlDate;
		} catch (NullPointerException e) {
			throw new NullPointerException("Date shoud not be null.");
		}
	}

}