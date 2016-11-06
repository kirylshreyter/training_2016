package com.kirylshreyter.training.hotel.daodb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Repository;

@Repository
public class DateConverters {

	public Date stringToDateConverter(String convertedDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date finish = null;
		try {
			finish = sdf.parse(convertedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return finish;
	}

	public String dateToStringConverter(Date convertedDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

		String newDate = sdf.format(convertedDate);

		return newDate;
	}

}
