package com.mindtree.xml.model;

public class Singer {

	private int singerId;
	private String singerName;
	private String singerGender;
	public Singer() {
		super();
	}
	public Singer(int singerId, String singerName, String singerGender) {
		super();
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerGender = singerGender;
	}
	public int getSingerId() {
		return singerId;
	}
	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getSingerGender() {
		return singerGender;
	}
	public void setSingerGender(String singerGender) {
		this.singerGender = singerGender;
	}
	@Override
	public String toString() {
		return "Singer [singerId=" + singerId + ", singerName=" + singerName + ", singerGender=" + singerGender + "]";
	}
	
	
}
