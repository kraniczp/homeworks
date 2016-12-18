package com.mycompany.librarydiary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Main instance;
    private static Map<String, Books> catalog;
    
    private Main(){
        catalog = new HashMap<>();
    }
    
    public static Main getInstance(){
        if(instance == null){
            instance = new Main();
        }
        return instance;    
    }
    
    public static void addBooks(String Book_ID, String title ,String author, String type){
        catalog.put(Book_ID, new Books(title, author, type) );
    }

    public static Map<String, Books> getCatalog() {
        return catalog;
    }

    public static void main(String[] args) throws IOException {
        Main.getInstance();
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
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Book_ID:");
                String Book_ID = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Title:");
                String title = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Author:");
                String author = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Type:");
                String type = br.readLine();
                Main.addBooks(Book_ID, title ,author, type);
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        if(cnumber == 2){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Person_ID:");
                String Person_ID = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Book_ID:");
                String Book_ID = br.readLine();
                LibraryDiary.addBookRent(Person_ID, Book_ID);
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        if(cnumber == 3){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Person_ID:");
                String Person_ID = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Book_ID:");
                String Book_ID = br.readLine();
                LibraryDiary.removeBookRent(Person_ID, Book_ID);
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
