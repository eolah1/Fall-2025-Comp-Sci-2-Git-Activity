package edu.westga.cs1302.Collection.model;

public class Comic {

	private String comicName;
	private int issueNum;
	
	public Comic(String comicName, int issueNum) {
		this.comicName = comicName;
		this.issueNum = issueNum;
	}
	
	public String getComicName() {
		return this.comicName;
	}
	
	public int getIssueNum() {
		return this.issueNum;
	}
	
	public void setName(String comicName) {
		this.comicName = comicName;
	}
	
	public String toString() {
		return this.comicName + " (Issue #: " + this.issueNum + ")";
	}
}
