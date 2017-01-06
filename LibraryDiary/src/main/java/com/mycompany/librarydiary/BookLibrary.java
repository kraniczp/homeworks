package com.mycompany.librarydiary;

public class BookLibrary{
    private String rentTicket;
    private String bookID;
    
    public BookLibrary(String rentTicket, String bookID){
        this.rentTicket = rentTicket;
        this.bookID = bookID;
    }

    public String getrentTicket() {
        return rentTicket;
    }

    public void setrentTicket(String rentTicket) {
        this.rentTicket = rentTicket;
    }

    public String getbookID() {
        return bookID;
    }
}
