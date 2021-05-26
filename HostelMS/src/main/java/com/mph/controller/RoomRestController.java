package com.mph.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Room;
import com.mph.service.RoomService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/room")
public class RoomRestController {
	@Autowired
	RoomService roomService;
	
	
	/**
	 * This method creates the room
	 * @author Chandrika
	 * @param room this is the parameter used to create room
	 * @return returns room
	 */
	@PostMapping("/addroom")
	public Room addRoom(@RequestBody Room room) {
		roomService.addRoom(room);
		return room;
	}
	
	
	/**
	 * This method gets the list of rooms
	 * @author Chandrika
	 * @return returns the list of rooms
	 */
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
	
	/**
	 * This method is used to update room details
	 * @author Chandrika
	 * @param room this is the parameter used to update room
	 * @return returns the list of rooms
	 */
	@PutMapping("/updateroom")
	public ResponseEntity<List<Room>> updateRoom(@RequestBody Room room) {
		List<Room> roomlist = roomService.updateRoom(room);
		System.out.println("Room List : " + roomlist);
		if (roomlist.isEmpty()) {
			return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Room>>(roomlist, HttpStatus.OK);

	}
	
	/**
	 * This method delete a specific room
	 * @author Chandrika
	 * @param room_id this is the parameter used to delete room
	 * @return returns the list of rooms
	 */
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
	
	/**
	 * This method is used to search room details
	 * @author Chandrika
	 * @param room_no this is the parameter used to search room
	 * @return returns room
	 */
	@GetMapping("/searchroom/{id}")
	public ResponseEntity<Room> searchRoom(@PathVariable("id") int room_no) {
		Room room=roomService.searchRoom(room_no);
		System.out.println("Room : " + room);
		return new ResponseEntity<Room>(room, HttpStatus.OK);

	}
	
	
	/**
	 * This method is used to get room details by ID
	 * @author Chandrika
	 * @param room_no this is the parameter used to get room
	 * @return returns room
	 */
	@GetMapping("/getroombyid/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable("id") int room_no) {
		Room room=roomService.getRoomById(room_no);
		System.out.println("Room : " + room);
		return new ResponseEntity<Room>(room, HttpStatus.OK);

	}
}
