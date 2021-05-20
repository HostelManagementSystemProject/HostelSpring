package com.mph.dao;

import java.util.List;

import com.mph.entity.Room;

public interface RoomDao {
	public void addRoom(Room room);
	public List<Room> getRoomList();
	public Room getRoom(Room room);
	public List<Room> updateRoom(Room room);
	public List<Room> deleteRoom(int room_id);
	public Room searchRoom(int room_id);
}
