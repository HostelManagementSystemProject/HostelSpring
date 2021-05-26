package com.mph.service;

import java.util.List;

import com.mph.dao.RoomDao;
import com.mph.entity.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomDao roomDao;
	
	@Override
	public void addRoom(Room room) {
		roomDao.addRoom(room);
		
	}

	@Override
	public List<Room> getRoomList() {
		return roomDao.getRoomList();
	}

	@Override
	public Room getRoom(Room room) {
		return roomDao.getRoom(room);
	}

	@Override
	public List<Room> updateRoom(Room room) {
		return roomDao.updateRoom(room);
	}

	@Override
	public List<Room> deleteRoom(int room_id) {
		return roomDao.deleteRoom(room_id);
	}

	@Override
	public Room searchRoom(int room_id) {
		return roomDao.searchRoom(room_id);
	}

	@Override
	public Room getRoomById(int room_id) {
		return roomDao.getRoomById(room_id);
	}
}
