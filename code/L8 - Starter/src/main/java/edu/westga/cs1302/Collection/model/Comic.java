package edu.westga.cs1302.Collection.model;

/**
 * Represents a comic with a title and issue number.
 */
public class Comic {

    private String comicName;
    private int issueNum;
    
    /**
     * Creates a new Comic with the given name and issue number.
     * 
     * @param comicName the title of the comic
     * @param issueNum the issue number of the comic
     */
    public Comic(String comicName, int issueNum) {
        this.comicName = comicName;
        this.issueNum = issueNum;
    }
    
    /**
     * Gets the comic's name.
     * 
     * @return the comic name
     */
    public String getComicName() {
        return this.comicName;
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
     * Sets the comic's name.
     * 
     * @param comicName the new comic name
     */
    public void setName(String comicName) {
        this.comicName = comicName;
    }
    
    /**
     * Returns a string representation of the comic.
     * 
     * @return the comic name and issue number
     */
    @Override
    public String toString() {
        return this.comicName + " (Issue #: " + this.issueNum + ")";
    }
}