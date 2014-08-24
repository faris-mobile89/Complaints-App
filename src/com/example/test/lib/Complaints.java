package com.example.test.lib;

public class Complaints {

	private int id;
	private String text;
	private String date;
	private String imgUrl;
	private String phone;

	public Complaints() {

	}

	public Complaints(int id, String text, String date, String imgUrl,
			String phone) {
		this.id = id;
		this.text = text;
		this.date = date;
		this.imgUrl = imgUrl;
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
