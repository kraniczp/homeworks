package com.peterkranicz.limitedincorp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        int cnumber = 0;
        
        do{
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Choose what you want to do!");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Create new Ltd.: 0 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Add new worker: 1 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Add new boss: 2 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Fire people: 3 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Fire boss: 4 ");
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Exit: 9 ");
        
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                cnumber = Integer.parseInt(br.readLine());
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
            if(cnumber == 9){
                System.exit(0);
            }
        }while((cnumber != 1) || (cnumber != 2) || (cnumber != 3) || (cnumber != 0));
        
        if( cnumber == 0 ){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Ltd name:");
                String name = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Ltd location:");
                String location = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter specialize:");
                String specialise = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter property:");
                int property = Integer.parseInt(br.readLine());
                
                Ltd.getInstance(name,location,specialise,property);

            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        if( (cnumber == 1 || cnumber == 2 ) && Ltd.isExist() ){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Type:");
                int id = Integer.parseInt(br.readLine());
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Book_ID:");
                String name = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Title:");
                String birthdate = br.readLine();
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Author:");
                int salary = Integer.parseInt(br.readLine());
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter Type:");
                int property = Integer.parseInt(br.readLine());
                
                if(cnumber == 1){
                    Worker worker = new Worker(id, name, birthdate,salary,property);
                    Ltd.getWorkerList().add(worker);
                }
                
                if(cnumber == 2){
                    Boss boss = new Boss(id, name, birthdate,salary,property);
                    Ltd.getBossesList().add(boss);
                }
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Not exist a Ltd:");
        }
        
        if( (cnumber == 3 || cnumber == 4 ) && Ltd.isExist() ){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Enter people'ID:");
                int ID = Integer.parseInt(br.readLine());
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "From where bosses(3) or worker(4) ?:");
                int fromList = Integer.parseInt(br.readLine());
                
                if(cnumber == 3 && ! Ltd.getWorkerList().isEmpty()){
                    Boss.doFire(ID, fromList);
                }
                
                if(cnumber == 3 && ! (Ltd.getBossesList().isEmpty())){
                    Ltd.doFire(ID, fromList);
                }
            }catch(IOException e){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
