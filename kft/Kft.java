package kft;

import java.util.ArrayList;
import java.util.Scanner;


public class Kft {

    private String nev;
    private String szekhely;
    private String tevekenysegikor;
    private int vagyon;
    private int nlogic;
    ArrayList<Munkas> munkas = new ArrayList<>();
    ArrayList<Fonok> fonok = new ArrayList<>();
    
    public String getNev(){
        return nev;
    }
    
    public String getSzekhely(){
        return szekhely;
    }
    
    public String getTevekenysegikor(){
        return tevekenysegikor;
    }
    
    public int getVagyon(){
        return vagyon;
    }
    
    public int getDolgozoi(){
        return munkas.size();
    }
    
    public int getFonokei(){
        return fonok.size();
    }
    
    public void FizetestAd(){
        Ember e = new Ember();
        Scanner in = new Scanner(System.in);
        int fizu = in.nextInt();
        e.setFizetestKap(fizu);
    }
    
    public void Kirug(int i){
        if(nlogic == 1){
            munkas.remove(i);
        }
        
        if(nlogic == 2){
            fonok.remove(i);
        }
    }
    
    public void Felvesz(int c){
        
        String line = null;
        if ((line = System.console().readLine()) != null){
                
            String[] temp = line.split(";");
                
            if(c == 1  && temp.length == 4){
                Munkas m = new Munkas(temp[0],temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3]));
                munkas.add(m);
            }
            
            if(c == 2  && temp.length == 4){
                Fonok f = new Fonok(temp[0],temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3]));
                fonok.add(f);
            }
        }
        
    }
    
    public static void main(String[] args) {

        int n=1;
        
        do{
            System.out.println("1. munkas adatai");
            System.out.println("2. fonok adatai");
            try{
                Scanner in = new Scanner(System.in);
                n = in.nextInt();
            }catch(Exception ex){
                System.out.println("Not a number !");
            }
        }while( n<1 || n>2 );
        
        Kft k = new Kft(){};
        k.nlogic = n;
        
        if(n==1 || n==2){
            k.Felvesz(n);
        }
    }
    
}
