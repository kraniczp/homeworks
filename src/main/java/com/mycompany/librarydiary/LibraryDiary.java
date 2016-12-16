package com.mycompany.librarydiary;


import java.util.logging.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;


public class LibraryDiary{
    
    private static LibraryDiary INSTANCE;
    private static Map<String, BookLibrary> books;
    private static Set<String> setBookRented;
    
    private LibraryDiary(){
        books = new HashMap<>();
        setBookRented = new HashSet<>();
    }
    
    public static LibraryDiary getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LibraryDiary();
        }
        return INSTANCE;    
    }

    public static void AddBookRent(String Person_ID, String Book_ID) 
                                    throws IllegalArgumentException {
        // arraylist hogy tobb konyvet is tudjon kivenni
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
    
    public static void RemoveBookRent(String Person_ID, String Book_ID) 
                                    throws NullPointerException {
        // arraylist hogy tobb konyvet is tudjon kivenni
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
    
    public void FullWriteOut(){
    
        for(Map.Entry<String, BookLibrary> bl : books.entrySet()){
            Logger.getLogger(LibraryDiary.class.getName()).log(Level.INFO, bl.getKey());
            Logger.getLogger(LibraryDiary.class.getName()).log(Level.INFO, bl.getValue().getBook_ID());
        }
    }
}
