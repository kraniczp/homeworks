package com.mycompany.librarydiary;


public class Books {
    
    private String title;
    private String author;
    private String type;
    
    public Books(String title ,String author, String type){
        
        this.title = title;
        this.author = author;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
