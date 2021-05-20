package com.mph.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Room;
import com.mph.service.RoomService;

@RestController
public class RoomRestController {
	@Autowired
	RoomService roomService;
	
	@PostMapping("/addroom")
	public Room addRoom(@RequestBody Room room) {
		roomService.addRoom(room);
		return room;
	}
	
	@GetMapping("/allrooms")
	public ResponseEntity<List<Room>> allRooms()
	{
		List<Room> roomlist=roomService.getRoomList();
		System.out.println("Room List" +roomlist);
		if(roomlist.isEmpty())
		{
			return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Room>>(roomlist,HttpStatus.OK);
		
	}
	@PutMapping("/updateroom")
	public ResponseEntity<List<Room>> updateRoom(@RequestBody Room room) {
		List<Room> roomlist = roomService.updateRoom(room);
		System.out.println("Room List : " + roomlist);
		if (roomlist.isEmpty()) {
			return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Room>>(roomlist, HttpStatus.OK);

	}
	@DeleteMapping("/deleteroom/{id}")
	public  ResponseEntity<List<Room>> deleteRoom(@PathVariable("id") int room_id) {
		
		List<Room> li =roomService.deleteRoom(room_id);
		System.out.println("User List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Room>>(li,HttpStatus.OK);
		
	}
	
	@GetMapping("/searchroom/{id}")
	public ResponseEntity<Room> getEmployee(@PathVariable("id") int room_no) {
		Room room=roomService.searchRoom(room_no);
		System.out.println("Room : " + room);
		return new ResponseEntity<Room>(room, HttpStatus.OK);

	}
}
