package com.mph.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mph.dao.RoomDao;

public class RoomTest {
	static RoomDao roomDao;
    
    @BeforeClass
    public static void setup()
    {
        System.out.println("from setup");
        ApplicationContext context=new ClassPathXmlApplicationContext("dispserv-servlet.xml");
        roomDao =(RoomDao) context.getBean("roomDao");
    }
    @Test
    public void testgetRoomList()
    {
        assertTrue((roomDao.getRoomList()).size()>=1);
    }
    @AfterClass
    public static void tearDown()
    {
        System.out.println("from tearDown");
        
    }
}
