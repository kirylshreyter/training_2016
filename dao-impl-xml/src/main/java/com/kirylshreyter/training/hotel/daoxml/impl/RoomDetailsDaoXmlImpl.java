package com.kirylshreyter.training.hotel.daoxml.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IRoomDetailsDao;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

@Repository
public class RoomDetailsDaoXmlImpl implements IRoomDetailsDao {

	@Inject
	private Common common;

	@Override
	public RoomDetails get(Long id) {
		List<RoomDetails> allRoomDetails = readCollection(new RoomDetails());
		for (RoomDetails roomDetails : allRoomDetails) {
			if (roomDetails.getId().equals(id)) {
				return roomDetails;
			}
		}
		return null;
	}

	@Override
	public Long insert(RoomDetails entity) {
		List<RoomDetails> allRoomDetails = readCollection(entity);
		Long id = getNextId(allRoomDetails);

		allRoomDetails.add(entity);

		entity.setId(new Long(id));

		writeCollection(allRoomDetails);
		return id;
	}

	@Override
	public Boolean update(RoomDetails entity) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
		

	}

	@Override
	public List<RoomDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<RoomDetails> readCollection(RoomDetails entity) {
		try {
			common.intialize(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<RoomDetails>) Common.xstream.fromXML(Common.file);
	}

	private void writeCollection(List<RoomDetails> newList) {
		try {
			Common.xstream.toXML(newList, new FileOutputStream(Common.file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<RoomDetails> allRoomDetails) {
		return allRoomDetails.isEmpty() ? 1l : allRoomDetails.get(allRoomDetails.size() - 1).getId() + 1;
	}

}
