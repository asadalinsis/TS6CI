package com.zin;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "User", namespace = "com.zin.User")
@XmlRootElement(name = "User")
public class User {
	private String firstName;
	private String lastName;
	
	public User() {
	}
	
	@XmlElement(name = "FirstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement(name = "LastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isSame = false;
        if (obj != null && obj instanceof User){
        	isSame = this.getFirstName().equals(((User)obj).getFirstName()) && this.getLastName().equals(((User)obj).getLastName());
        }

        return isSame;
	}
	@Override
	public String toString() {
		return "{\"FirstName\":"+firstName+",\"LastName\":"+lastName+"}";
	}
}
