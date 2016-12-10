package com.kirylshreyter.training.hotel.daodb.util;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		DateConverter converter = new DateConverter();
		Date startDate = converter.stringToJavaUtilDateConverter("2015-01-01");
		Date endDate = converter.stringToJavaUtilDateConverter("2015-02-01");
		System.out.println(converter.getDiffTwoDate(startDate, endDate));
	}

}
