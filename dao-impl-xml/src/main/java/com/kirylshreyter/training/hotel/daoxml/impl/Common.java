package com.kirylshreyter.training.hotel.daoxml.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.thoughtworks.xstream.XStream;

@Repository
public class Common {
	public static File file;
	public static XStream xstream;
	@Value("${basePath}")
	private String basePath;

	public void intialize(Client entity) throws IOException {
		initialize(entity);
	}
	public void intialize(RoomDetails entity) throws IOException {
		initialize(entity);
	}

	public void initialize(Object object) throws IOException {
		xstream = new XStream();
		xstream.alias(object.getClass().getSimpleName().toLowerCase(), object.getClass());
		file = new File(basePath + "/" + object.getClass().getSimpleName().toLowerCase() + ".xml");
		if (!file.exists()) {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

}
