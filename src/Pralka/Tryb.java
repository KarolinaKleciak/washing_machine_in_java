package LAB6_P;

public class Tryb {

    Pralka pralka;

    //stopnie celcjusza
    int temp_wody;

    //minuty
    int czas_prania_wstepnego;

    //minuty
    int czas_prania_zasadniczego;

    //wartosc logiczna
    boolean dodatkowe_plukanie;

    //obroty na minute
    int predkosc_obrotowa_wirowania;


    Tryb(Pralka _pralka, int _temp_wody, int _czas_prania_wstepnego, int _czas_prania_zasadniczego, boolean _dodatkowe_plukanie, int _predkosc_obrotowa_wirowania){
        this.pralka = _pralka;
        this.temp_wody = _temp_wody;
        this.czas_prania_wstepnego = _czas_prania_wstepnego;
        this.czas_prania_zasadniczego = _czas_prania_zasadniczego;
        this.dodatkowe_plukanie = _dodatkowe_plukanie;
        this.predkosc_obrotowa_wirowania = _predkosc_obrotowa_wirowania;
    }

    @Override
    public String toString(){
        return "Tryb: Temperatura wody: " + this.temp_wody + "°C, Czas prania wstepnego: " + this.czas_prania_wstepnego + "min, Czas prania zasadniczego: " + this.czas_prania_zasadniczego + "min, Dodatkowe płukanie: " + this.dodatkowe_plukanie + " Prędkość obrotowa wirowania: " + this.predkosc_obrotowa_wirowania + "PM";
    }

    void setPralka(Pralka _pralka){
        this.pralka = _pralka;
    }

    void setTemp_wody(int _temp_wody){
        this.temp_wody = _temp_wody;
    }

    void setCzas_prania_wstepnego(int _czas_prania_wstepnego){
        this.temp_wody = _czas_prania_wstepnego;
    }

    void setCzas_prania_zasadniczego(int _czas_prania_zasadniczego){
        this.temp_wody = _czas_prania_zasadniczego;
    }

    void setDodatkowe_plukanie(boolean _dodatkowe_plukanie){
        this.dodatkowe_plukanie = _dodatkowe_plukanie;
    }

    void setPredkosc_obrotowa_wirowania(int _predkosc_obrotowa_wirowania){
        this.predkosc_obrotowa_wirowania = _predkosc_obrotowa_wirowania;
    }

    int getTemp_wody(){return this.temp_wody;}

    int getCzas_prania_wstepnego(){return this.czas_prania_wstepnego;}
    int getCzas_prania_zasadniczego(){return this.czas_prania_zasadniczego;}

    boolean getDodatkowe_plukanie(){return  this.dodatkowe_plukanie;}

    int getPredkosc_obrotowa_wirowania(){return this.predkosc_obrotowa_wirowania;}

}
