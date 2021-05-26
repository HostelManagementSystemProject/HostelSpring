package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Room;

@Repository
public class RoomDaoImpl implements RoomDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
		
	}
	@Override
	public void addRoom(Room room) {
	
		getSession().saveOrUpdate(room);
		System.out.println("Room stored succesfully");
	}

	@Override
	public List<Room> getRoomList() {
		Query query = getSession().createQuery("select rooms from ROOM_HMS rooms");
		List<Room> roomlist=query.list();
		return roomlist;
	}

	@Override
	public Room getRoom(Room room) {
		Criteria c=getSession().createCriteria(Room.class);
		c.add(Restrictions.eq("room_no",room.getRoom_no()));
		Room rooms=(Room) c.uniqueResult();
		return rooms;
	}

	@Override
	public List<Room> updateRoom(Room room) {
		Query query = getSession().createQuery("update ROOM_HMS room set room_type=:room_type,vacancy=:vacancy,total_rooms=:total_rooms where room_no=:room_no");
		query.setParameter("room_no",room.getRoom_no());
		query.setParameter("room_type",room.getRoom_type());
		query.setParameter("vacancy",room.getVacancy());
		query.setParameter("total_rooms",room.getTotal_rooms());
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Updated successfully");
		}
		
		return getRoomList();
		
	}

	@Override
	public List<Room> deleteRoom(int room_no) {
		Query query = getSession().createQuery("delete from ROOM_HMS where room_no=:room_no");
		query.setParameter("room_no",room_no);
		int noofrows=query.executeUpdate();
		if(noofrows>0)
		{
			System.out.println("Deleted successfully");
		}
		
		return getRoomList();
	}
	@Override
	public Room searchRoom(int room_no) {
		Criteria c=getSession().createCriteria(Room.class);
		c.add(Restrictions.eq("room_no",room_no));
		Room room=(Room) c.uniqueResult();
		return room;
	}
	@Override
	public Room getRoomById(int room_no) {
		Criteria c=getSession().createCriteria(Room.class);
		c.add(Restrictions.eq("room_no",room_no));
		Room room=(Room) c.uniqueResult();
		return room;
	}
}
