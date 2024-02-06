package LAB6_P;

public class GrzalkaDoWody {

    Pralka pralka;
    boolean stan;

    GrzalkaDoWody(Pralka _pralka){
        this.pralka = _pralka;
    }

    void setStan(boolean _stan){
        this.stan = _stan;
    }

    @Override
    public String toString(){
        return "Grzałka do wody: < jest włączoan: " + this.stan + " >";
    }

    public void  zmien_stan(boolean stan){
        this.stan = stan;
    }

    public void wlacz(){
        this.zmien_stan(true);
    }

    public void wylacz(){
        this.zmien_stan(false);
    }

}
