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
	
	
	/**
	 * This method is used to add room
	 * @author Chandrika
	 * @param room this is the parameter used to create room
	 */
	@Override
	public void addRoom(Room room) {
		roomDao.addRoom(room);
		
	}
	
	
	/**
	 * This method is used to get the list of rooms
	 * @author Chandrika
	 * @param none no parameters are used in this method
	 * @return returns the list of rooms
	 */
	@Override
	public List<Room> getRoomList() {
		return roomDao.getRoomList();
	}
	
	
	/**
	 * This method is used to get any single room based on ID
	 * @author Chandrika
	 * @param room this is the parameter used to get a room
	 * @return returns a specific room
	 */
	@Override
	public Room getRoom(Room room) {
		return roomDao.getRoom(room);
	}
	
	
	/**
	 * This method is used to update the details of room
	 * @author Chandrika
	 * @param room this is the parameter used to get a room
	 * @return returns the list of rooms
	 */
	@Override
	public List<Room> updateRoom(Room room) {
		return roomDao.updateRoom(room);
	}
	
	
	/**
	 * This method is used to delete the room based on ID
	 * @author Chandrika
	 * @param room_no this is the parameter used to delete the room
	 * @return returns the list of rooms
	 */
	@Override
	public List<Room> deleteRoom(int room_id) {
		return roomDao.deleteRoom(room_id);
	}
	
	
	/**
	 * This method is used to search the room based on ID
	 * @author Chandrika
	 * @param room_no this is the parameter used to search the room
	 * @return returns a specific room
	 */
	@Override
	public Room searchRoom(int room_id) {
		return roomDao.searchRoom(room_id);
	}
	
	
	/**
	 * This method is used to get the room based on ID
	 * @author Chandrika
	 * @param room_no this is the parameter used to get the room
	 * @return returns a specific room
	 */
	@Override
	public Room getRoomById(int room_id) {
		return roomDao.getRoomById(room_id);
	}
}
