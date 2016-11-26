package com.kirylshreyter.training.hotel.daodb.util;

import java.util.Date;

import com.kirylshreyter.training.hotel.datamodel.Client;

public class Test {

	public static void main(String[] args) {
		DateConverter converter = new DateConverter();
		Date startDate = converter.stringToJavaUtilDateConverter("2015-01-01");
		Date endDate = converter.stringToJavaUtilDateConverter("2015-02-01");
		System.out.println(converter.getDiffTwoDate(startDate, endDate));

		System.out.println(Client.class.toString());
		System.out.println(Client.class.getName());
		System.out.println(Client.class.getSimpleName()+".class");

	}

}
