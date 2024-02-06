package LAB6_P;

public class Filtr {

    Pralka pralka;
    boolean stan;

    Filtr(Pralka _pralka){
        this.pralka = _pralka;
    }

    void set_stan(boolean _stan){
        this.stan = _stan;
    }

    @Override
    public  String toString(){
        return "Filtr wody: < jest włączony: " + this.stan + " >";
    }

    public void zmien_stan(boolean stan){
        this.stan = stan;
    }

    public void wlacz(){
        this.zmien_stan(true);
    }

    public void wylacz(){
        this.zmien_stan(false);
    }

}
