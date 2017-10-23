package com.harryper.domain;

public class PersonInfo {
	private Integer user_id;
	private String user_name;
	private String gender;
	private Integer age;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PersonInfo [user_id=" + user_id + ", user_name=" + user_name + ", gender=" + gender + ", age=" + age
				+ "]";
	}
	
}
