package kft;


public class Fonok extends Ember{
    
    public Fonok(String nev, String szul_datum, int vagyon, int ber){
        super(nev, szul_datum, vagyon, ber);
    }
    
    public void Kirugat(int i){
        Kft kft = new Kft();
        kft.munkas.remove(i);
    }
}
