package org.acme.sample.bean;

public class Event {
	private String title;
	private String start;
	private String end;
	private Integer id;
	public Event(String title, String start, String end, Integer id) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.id=id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
