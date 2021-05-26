package com.mph.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mph.dao.RoomDao;
import com.mph.entity.Room;

public class RoomTest {
static RoomDao roomDao;
	
	@BeforeClass
	public static void setup() throws Exception
	{
		System.out.println("Before Class");
		ApplicationContext context=new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		 roomDao=(RoomDao)context.getBean("roomDao");
		
	}

	@Test
	public void testgetRoomList()
	{
		Room room1 =new Room(1,"2 beds",2,30);
		Room room2 =new Room(2,"2 beds",2,30);
		
		roomDao.addRoom(room1);
		roomDao.addRoom(room2);
		
		List<Room> room =roomDao.getRoomList();
		assertEquals(2,room.size());
	}
	
	@Test
	public void testupdateRoom()
	{
		Room r=new Room();
		r.setRoom_no(1);
		r.setRoom_type("3 beds");
		r.setVacancy(2);
		r.setTotal_rooms(30);
		
		List<Room> rooms=roomDao.updateRoom(r);
		assertEquals(rooms.get(0).getRoom_type(),"3 beds");
		
	}
	@AfterClass
	public static void tearDown()  throws Exception
	{
		System.out.println("from tearDown");
		
	}
}
