package LAB6_P;

public class Beben {

    Pralka pralka;

    boolean stan, stan_2;

    Beben(Pralka _pralka){
        this.pralka = _pralka;
    }
    void setStan(boolean _stan, boolean _stan_2){
        this.stan = _stan;
        this.stan_2 = _stan_2;
    }

    @Override
    public String toString(){
        return "Bęben: < jest otwarty: " + this.stan + "," + " jest pełny: " + this.stan_2 + " >";
    }

    public void  zmien_stan(boolean stan){
        this.stan = stan;
    }
    public void  zmien_stan2(boolean stan_2){
        this.stan_2 = stan_2;
    }

    public void otworz(){
        this.zmien_stan(true);
    }

    public void zamknij(){
        this.zmien_stan(false);
    }

    public  void pusty(){
        this.zmien_stan2(false);
    }

    public  void pelny(){
        this.zmien_stan2(true);
    }

}
