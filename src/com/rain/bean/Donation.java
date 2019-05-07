package com.rain.bean;

public class Donation {
	private int did;
	private String donater_name;
	private String donater_phone;
	private String donater_bookname;
	private int donater_booknumber;
	
	public void setDid(int did) {
		this.did=did;
	}
	
	public int getDid() {
		return this.did;
	}
	
	public void setName(String name)
	{
		this.donater_name=name;
	}
	
	public void setPhone(String phone)
	{
		this.donater_phone=phone;
	}

	public void setBookname(String bookname)
	{
		this.donater_bookname=bookname;
	}
	
	public void setBooknumber(int booknumber)
	{
		this.donater_booknumber=booknumber;
	}
	
	public String getName()
	{
		return this.donater_name;
	}
	
	public String getPhone()
	{
		return this.donater_phone;
	}
	
	public String getBookname()
	{
		return this.donater_bookname;
	}
	
	public int getBooknumber()
	{
		return this.donater_booknumber;
	}
}
