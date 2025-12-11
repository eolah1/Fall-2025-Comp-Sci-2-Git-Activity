package edu.westga.cs1302.Collection.model;

/**
 * Represents a comic with a title and issue number.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Comic {

    private String title;
    private int issueNum;
    
    /**
     * Creates a new Comic with the given name and issue number.
     * 
     * @param title the title of the comic
     * @param issueNum the issue number of the comic
     */
    public Comic(String title, int issueNum) {
    	if (title == null || title.isEmpty()) {
    		throw new IllegalArgumentException("Comic name cannot be null or blank.");
    	}
    	if (issueNum < 0) {
    		throw new IllegalArgumentException("Issue Number must be a non negative integer.");
    	}
        this.title = title;
        this.issueNum = issueNum;
    }
    
    /**
     * Gets the comic's name.
     * 
     * @return the comic name
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Gets the comic's issue number.
     * 
     * @return the issue number
     */
    public int getIssueNum() {
        return this.issueNum;
    }
    
    /**
     * Returns a string representation of the comic.
     * 
     * @return the comic name and issue number
     */
    @Override
    public String toString() {
        return this.title + " (Issue #: " + this.issueNum + ")";
    }
}