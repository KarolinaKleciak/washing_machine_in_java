package LAB6_P;

public class SterownikRegulujacyPredkosciaObrotowa {

    Pralka pralka;

    boolean stan;

    SterownikRegulujacyPredkosciaObrotowa(Pralka _pralka){
        this.pralka = _pralka;
    }

    void setStan(boolean _stan){
        this.stan = _stan;
    }

    @Override
    public String toString(){
        return "Sterownik regulujący prędkością obrotową: < jest włączony: " + this.stan + " >";
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
