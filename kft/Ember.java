
package kft;


public class Ember {
    
    protected String nev;
    protected String szul_datum;
    String munka;
    protected int vagyon;
    protected int ber;
    
    public Ember(){}
    
    public Ember (String nev, String szul_datum, int vagyon, int ber){
        this.nev = nev;
        this.szul_datum = szul_datum;
        this.vagyon = vagyon;
        this.ber = ber;
    }
    
    public String getNev(){
        return nev;
    }
    
    public String getSzul_datum(){
        return szul_datum;
    }
    
    public int getVagyon(){
        return vagyon;
    }
    
    public int getBer(){
        return ber;
    }
    
    public void setFizetestKap(int fizetes){
        this.ber = fizetes;
    }
    
    public void MunkatVegez(String munka){
        this.munka = munka;
    }
    
    public void Felmond(){
    
    }
}
