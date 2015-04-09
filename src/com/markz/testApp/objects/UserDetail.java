package com.markz.testApp.objects;

import java.io.Serializable;

public class UserDetail implements Serializable{
	/**
	 * @author zuberkhan
	 * 
	 */
	private static final long serialVersionUID = -5544587108521136382L;
	private int id;
	private String name;
	private String userId;
	private int age;
	private int zip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
