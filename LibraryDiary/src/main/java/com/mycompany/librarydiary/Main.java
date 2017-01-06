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
        int cnumber = 0;
        
        do{
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Choose what you want to do!");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Add new book: 1 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Rent a book: 2 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Back a book: 3 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Exit: 4 ");
        
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                cnumber = Integer.parseInt(br.readLine());
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
            if(cnumber == 4){
                System.exit(0);
            }
        }while((cnumber != 1) || (cnumber != 2) || (cnumber != 3));
        
        if(cnumber == 1){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter bookID:");
                String bookID = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Title:");
                String title = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Author:");
                String author = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Type:");
                String type = br.readLine();
                Main.addBooks(bookID, title ,author, type);
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        if(cnumber == 2){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter rentTicket:");
                String rentTicket = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter bookID:");
                String bookID = br.readLine();
                LibraryDiary.addBookRent(rentTicket, bookID);
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        if(cnumber == 3){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter rentTicket:");
                String rentTicket = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter bookID:");
                String bookID = br.readLine();
                LibraryDiary.removeBookRent(rentTicket, bookID);
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
