package com.mycompany.librarydiary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Map<String, Books> catalog;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    public Main(){
        catalog = new HashMap<>();
    }
    
    public static void addBooks(String bookID, String title ,String author, String type){
        catalog.put(bookID, new Books(title, author, type) );
    }

    public static Map<String, Books> getCatalog() {
        return catalog;
    }

    public static void main(String[] args) throws IOException {
        int menuSelectNumber = 0;
        
        do{
            LOGGER.log(Level.INFO, "Choose what you want to do!");
            LOGGER.log(Level.INFO, "Add new book: 1 ");
            LOGGER.log(Level.INFO, "Rent a book: 2 ");
            LOGGER.log(Level.INFO, "Back a book: 3 ");
            LOGGER.log(Level.INFO, "Exit: 4 ");
        
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                menuSelectNumber = Integer.parseInt(br.readLine());
            }catch(IOException e){
                LOGGER.log(Level.SEVERE, null, e);
            }
            if(menuSelectNumber == 4){
                System.exit(0);
            }
        }while((menuSelectNumber != 1) || (menuSelectNumber != 2) || (menuSelectNumber != 3));
        
        if(menuSelectNumber == 1){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                LOGGER.log(Level.INFO, "Enter bookID:");
                String bookID = br.readLine();
                LOGGER.log(Level.INFO, "Enter Title:");
                String title = br.readLine();
                LOGGER.log(Level.INFO, "Enter Author:");
                String author = br.readLine();
                LOGGER.log(Level.INFO, "Enter Type:");
                String type = br.readLine();
                Main.addBooks(bookID, title ,author, type);
            }catch(IOException e){
                LOGGER.log(Level.SEVERE, null, e);
            }
        }
        
        if(menuSelectNumber == 2){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                LOGGER.log(Level.INFO, "Enter rentTicket:");
                String rentTicket = br.readLine();
                LOGGER.log(Level.INFO, "Enter bookID:");
                String bookID = br.readLine();
                LibraryDiary.addBookRent(rentTicket, bookID);
            }catch(IOException e){
                LOGGER.log(Level.SEVERE, null, e);
            }
        }
        
        if(menuSelectNumber == 3){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                LOGGER.log(Level.INFO, "Enter rentTicket:");
                String rentTicket = br.readLine();
                LOGGER.log(Level.INFO, "Enter bookID:");
                String bookID = br.readLine();
                LibraryDiary.removeBookRent(rentTicket, bookID);
            }catch(IOException e){
                LOGGER.log(Level.SEVERE, null, e);
            }
        }
    }
}
