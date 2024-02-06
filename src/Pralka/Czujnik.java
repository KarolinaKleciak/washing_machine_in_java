package LAB6_P;

import java.util.Hashtable;
public class Czujnik {

    Pralka pralka;

    boolean stan;

    Hashtable<String, Object> komponenty = new Hashtable<String, Object>();

    Czujnik(Pralka _pralka, Hashtable<String, Object> _komponenty){
        this.pralka = _pralka;
        this.komponenty = _komponenty;
        this.stan = false;
    }

    @Override
    public String toString(){
        return ("Czujnik : < włączony: " + this.stan);
    }

    public void setStan(boolean _stan){
        this.stan = _stan;
    }

    public void zmien_stan(boolean stan){
        this.stan = stan;
    }

    public void wlacz(){
        this.zmien_stan(true);
    }

}
