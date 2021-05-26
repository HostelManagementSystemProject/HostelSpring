package com.mph.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "USER_HMS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable{
	
	
	/**
	 * The user_id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userseq")
	@SequenceGenerator(name = "userseq", sequenceName = "userseq", initialValue = 1000, allocationSize = 100)
	private int user_id;
	
	
	/**
	 * The user_name
	 */
	private String user_name;
	
	
	/**
	 * The address
	 */
	@Embedded
	private Address address;
	
	
	/**
	 * The phone number
	 */
	@Size(min = 10, max = 10)
	private long phone_number;
	
	
	/**
	 * The email Id
	 */
	@NotNull(message = "Email Id cannot be Null")
	private String email_id;
	
	
	/**
	 * The password
	 */
	@NotNull(message = "Password cannot be Null")
	private String password;
	
	
	/**
	 * The gender
	 */
	private String gender;
	
	
	/**
	 * The date of birth
	 */
	private Date date_of_birth;
	
	
	/**
	 * The room
	 */
	@ManyToOne
	@JoinColumn(name = "room_no", referencedColumnName = "ROOM_NO")
	private Room room;
	
	
	/**
	 * Instantiates a new address
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param user_id
	 * @param user_name
	 * @param address
	 * @param phone_number
	 * @param email_id
	 * @param password
	 * @param gender
	 * @param date_of_birth
	 * @param room
	 */
	public User(int user_id, String user_name, Address address, long phone_number, String email_id, String password,
			String gender, Date date_of_birth, Room room) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.address = address;
		this.phone_number = phone_number;
		this.email_id = email_id;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.room = room;
	}
	
	
	/**
	 * gets the user_id
	 * @return user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	
	
	/**
	 * sets the user_id
	 * @param user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	/**
	 * gets the user_name
	 * @return user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	
	
	/**
	 * sets the user_name
	 * @param user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	/**
	 * gets the address
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}
	
	
	/**
	 * sets the address
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	/**
	 * gets the phone_number
	 * @return phone_number
	 */
	public long getPhone_number() {
		return phone_number;
	}
	
	
	/**
	 * sets the phone_number
	 * @param phone_number
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	
	/**
	 * gets the email_id
	 * @return email_id
	 */
	public String getEmail_id() {
		return email_id;
	}
	
	
	/**
	 * sets the email_id
	 * @param email_id
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	/**
	 * gets the password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	
	/**
	 * sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * gets the gender
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	
	
	/**
	 * sets the gender
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	/**
	 * gets the date_of_birth
	 * @return date_of_birth
	 */
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	
	
	/**
	 * gets the date_of_birth
	 * @param date_of_birth
	 */
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	
	/**
	 * gets the room
	 * @return room
	 */
	public Room getRoom() {
		return room;
	}
	
	
	/**
	 * sets the room
	 * @param room
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id+ ", user_name=" + user_name + ", address=" + address + ", phone_number="
				+ phone_number + ", email_id=" + email_id + ", password=" + password + ", gender=" + gender
				+ ", date_of_birth=" + date_of_birth + ", room=" + room + "]";
	}

	
	/*public static Comparator<User> NameComparator = new Comparator<User>(){
		@Override public int compare(User u1,User u2) {
			return u1.getUser_name().compareTo(u2.getUser_name());
		}
	};

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
