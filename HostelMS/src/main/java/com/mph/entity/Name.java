package com.mph.entity;

public class Name {
	public String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws IllegalAccessException {
        if (name.length() > 25) {
            throw new IllegalArgumentException("Username is too000000 lonnnnnng");
        }
        this.name = name;
    }
}
