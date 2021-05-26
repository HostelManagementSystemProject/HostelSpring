package com.mph.service;

import java.util.List;

import com.mph.entity.Room;

public interface RoomService {
	public void addRoom(Room room);
	public List<Room> getRoomList();
	public Room getRoom(Room room);
	public List<Room> updateRoom(Room room);
	public List<Room> deleteRoom(int room_id);
	public Room searchRoom(int room_id);
	public Room getRoomById(int room_id);
}
