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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userseq")
	@SequenceGenerator(name = "userseq", sequenceName = "userseq", initialValue = 1000, allocationSize = 100)
	private int user_id;

	private String user_name;

	@Embedded
	private Address address;

	@Size(min = 10, max = 10)
	private long phone_number;

	@NotNull(message = "Email Id cannot be Null")
	private String email_id;

	@NotNull(message = "Password cannot be Null")
	private String password;

	private String gender;

	private Date date_of_birth;

	@ManyToOne
	@JoinColumn(name = "room_no", referencedColumnName = "ROOM_NO")
	private Room room;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Room getRoom() {
		return room;
	}

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
