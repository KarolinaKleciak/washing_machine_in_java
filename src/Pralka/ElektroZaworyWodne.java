package LAB6_P;

public class ElektroZaworyWodne {

    Pralka pralka;

    boolean stan;

    ElektroZaworyWodne(Pralka _pralka){
        this.pralka = _pralka;
    }

    public void setStan(boolean _stan){
        this.stan = _stan;
    }

    @Override
    public String toString(){
        return "Elektro zawory wodne: < są otwarte: " + this.stan + " >";
    }

    public void zmien_stan(boolean stan){
        this.stan = stan;
    }

    public void otworz(){
        this.zmien_stan(true);
    }

    public void zamknij(){
        this.zmien_stan(false);
    }
}
