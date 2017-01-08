package com.mycompany.librarydiary;

import java.util.logging.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class LibraryDiary{
    private static LibraryDiary instance;
    private static Map<String, BookLibrary> books;
    private static Set<String> setBookRented;
    private static final Logger LOGGER = Logger.getLogger(LibraryDiary.class.getName());
    
    private LibraryDiary(){
        books = new HashMap<>();
        setBookRented = new HashSet<>();
    }
    
    public static LibraryDiary getInstance(){
        if(instance == null){
            instance = new LibraryDiary();
        }
        return instance;    
    }

    public static void addBookRent(String rentTicket, String bookID) 
                                    throws IllegalArgumentException {
        try{
            if( ! setBookRented.add(bookID) ){
                throw new IllegalArgumentException ();
            }else{
                BookLibrary booklibrary = new BookLibrary(rentTicket, bookID);
                books.put(rentTicket, booklibrary);
            }
        }catch(IllegalArgumentException e){
            LOGGER.log(Level.SEVERE, null, e);
        }
    }
    
    public static void removeBookRent(String rentTicket, String bookID) 
                                    throws NullPointerException {
        try{
            if( setBookRented.remove(bookID) ){
                throw new NullPointerException();
            }
            if( ! books.remove(rentTicket, bookID) ){
                throw new NullPointerException();
            }
        }catch(NullPointerException e){
            LOGGER.log(Level.SEVERE, null, e);
        }
    }
    
    public void fullWriteOut(){
        for(Map.Entry<String, BookLibrary> bl : books.entrySet()){
            LOGGER.log(Level.INFO, bl.getKey());
            LOGGER.log(Level.INFO, bl.getValue().getbookID());
        }
    }
}

