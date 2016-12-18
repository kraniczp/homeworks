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

    public static void addBookRent(String Person_ID, String Book_ID) 
                                    throws IllegalArgumentException {
        try{
            if( ! setBookRented.add(Book_ID) ){
                throw new IllegalArgumentException ();
            }else{
                BookLibrary booklibrary = new BookLibrary(Person_ID, Book_ID);
                books.put(Person_ID, booklibrary);
            }
        }catch(IllegalArgumentException e){
            Logger.getLogger(LibraryDiary.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void removeBookRent(String Person_ID, String Book_ID) 
                                    throws NullPointerException {
        try{
            if( setBookRented.remove(Book_ID) ){
                throw new NullPointerException();
            }
            if( ! books.remove(Person_ID, Book_ID) ){
                throw new NullPointerException();
            }
        }catch(NullPointerException e){
            Logger.getLogger(LibraryDiary.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void fullWriteOut(){
        for(Map.Entry<String, BookLibrary> bl : books.entrySet()){
            Logger.getLogger(LibraryDiary.class.getName()).log(Level.INFO, bl.getKey());
            Logger.getLogger(LibraryDiary.class.getName()).log(Level.INFO, bl.getValue().getBook_ID());
        }
    }
}

