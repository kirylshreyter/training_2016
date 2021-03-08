package com.kirylshreyter.hotel.daoxml.impl;

import com.kirylshreyter.hotel.daoapi.IRoomDetailsDao;
import com.kirylshreyter.hotel.datamodel.RoomDetails;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Repository
public class RoomDetailsDaoXmlImpl implements IRoomDetailsDao {
    @Inject
    private Common common;

    @Override
    public Long create(RoomDetails entity) {
        List<RoomDetails> allRoomDetails = readCollection(entity);
        Long id = getNextId(allRoomDetails);

        allRoomDetails.add(entity);

        entity.setId(id);

        writeCollection(allRoomDetails);
        return id;
    }

    @Override
    public RoomDetails read(Long id) {
        return null;
    }

    @Override
    public Boolean update(RoomDetails entity) {
        return null;
        // TODO Auto-generated method stub

    }

    @Override
    public Integer delete(Long id) {
        return null;
    }

    @Override
    public List<RoomDetails> getAll() {
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
