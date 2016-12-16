package com.mycompany.librarydiary;


public class BookLibrary{
    
    private String Person_ID;
    private String Book_ID;
    
    public BookLibrary(String Person_ID, String Book_ID){
        
        this.Person_ID = Person_ID;
        this.Book_ID = Book_ID;
    }

    public String getPerson_ID() {
        return Person_ID;
    }

    public void setPerson_ID(String Person_ID) {
        this.Person_ID = Person_ID;
    }

    public String getBook_ID() {
        return Book_ID;
    }
}
