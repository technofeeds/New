package com.example.test.model;

public class Story {
	
	private String title;
	private String body;
	private String coverImagePath;
	
	public Story(String title, String body, String coverImagePath) {
		super();
		this.title = title;
		this.body = body;
		this.coverImagePath = coverImagePath;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCoverImagePath() {
		return coverImagePath;
	}
	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}
	
}
