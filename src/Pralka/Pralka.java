package LAB6_P;

import java.util.Hashtable;
import java.util.Scanner;

public class Pralka {

    Hashtable<String, Object> ElementyMechaniczne = new Hashtable<>();
    Hashtable<String, Object> ElementyWykonawcze = new Hashtable<>();

    Hashtable<String, Object> Czujniki = new Hashtable<>();
    Hashtable<String, Object> Akcje = new Hashtable<>();
    Hashtable<String, Object> Tryby = new Hashtable<>();

    Tryb aktualnie_wybrany_tryb;

    Pralka() {
        ElementyMechaniczne.put("grzalka_do_wody", new GrzalkaDoWody(this));
        ElementyMechaniczne.put("beben", new Beben(this));
        ElementyMechaniczne.put("pojemnik na detergenty", new PojemnikNaDetergenty(this));
        ElementyMechaniczne.put("filtr wody", new Filtr(this));
        ElementyWykonawcze.put("pompa do wody", new PompaDoWody(this));
        ElementyWykonawcze.put("elektrozawory wodne", new ElektroZaworyWodne(this));
        ElementyWykonawcze.put("silnik inwerterowy", new SilnikInwerterowy(this));
        ElementyWykonawcze.put("sterownik regulujacy predkosc obrotowa", new SterownikRegulujacyPredkosciaObrotowa(this));
        ElementyWykonawcze.put("panel przedni on/off", new PanelPrzedniPosiadajacyWlacznik(this));
        Hashtable<String, Object> kompononenty = new Hashtable<String, Object>();
        kompononenty.put("pompa do wody", this.ElementyWykonawcze.get("pompa do wody"));
        Czujniki.put("cisnienie wody", new Czujnik(this, kompononenty));
        Hashtable<String, Object> kompononenty_2 = new Hashtable<String, Object>();
        kompononenty_2.put("grzałka do wody", this.ElementyMechaniczne.get("grzalka_do_wody"));
        Czujniki.put("temperatura wody",new Czujnik(this, kompononenty_2));
        Hashtable<String, Object> kompononenty_3 = new Hashtable<String, Object>();
        kompononenty_3.put("pompa do wody", this.ElementyWykonawcze.get("pompa do wody"));
        kompononenty_3.put("elektrozawory wodne", this.ElementyWykonawcze.get("elektrozawory wodne"));
        Czujniki.put("poziom wody", new Czujnik(this, kompononenty_3));
        Hashtable<String, Object> kompononenty_4 = new Hashtable<String, Object>();
        kompononenty_4.put("beben", this.ElementyMechaniczne.get("beben"));
        Czujniki.put("zabezpieczajacy przed zalaniem", new Czujnik(this, kompononenty_4));
        Hashtable<String, Object> kompononenty_5 = new Hashtable<String, Object>();
        kompononenty_5.put("beben", this.ElementyMechaniczne.get("beben"));
        Czujniki.put("wagi zawartosci bebna", new Czujnik(this, kompononenty_5));
        Hashtable<String, Object> kompononenty_6 = new Hashtable<String, Object>();
        kompononenty_6.put("filtr wody", this.ElementyMechaniczne.get("filtr wody"));
        Czujniki.put("droznosc fitra wody", new Czujnik(this, kompononenty_6));
        Akcje.put("pompowanie wody", "jestem akcja pompowania wody");
        Akcje.put("podgrzewanie wody", "jestem akcja podgrzewania wody");
        Akcje.put("wywazanie zawartosci bebna", "jestem akcja wywazania zawartosci bebna");
        Akcje.put("sprawdzanie droznosci filtra", "......");

        Tryby.put("pranie szybkie", new Tryb(this, 30, 5, 30, false, 1200));
        Tryby.put("pranie wstepne", new Tryb(this, 25, 8, 0, true, 800 ));
        Tryby.put("pranie w zimnej wodzie" ,new Tryb(this, 20, 8, 45, true, 1000));
        Tryby.put("ciemne ubrania", new Tryb(this,40, 10, 60, false, 1400 ));
        Tryby.put("plukanie", new Tryb(this, 25, 5, 15, false, 800));

        this.aktualnie_wybrany_tryb = null;
    }

    void setAktualnie_wybrany_tryb(Tryb _aktualnie_wybrany_tryb){
        this.aktualnie_wybrany_tryb = _aktualnie_wybrany_tryb;
    }

        public int menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("MENU: \n1.Przygotowanie Urządzenia\n2.Wybór Programu\n3.Uzupełnienie detergentów\n4.Wyświetl stan\n5.Uruchom program");
        int wybor = scan.nextInt();
        return wybor;
        }

    public void krok1(){
        this.otworz_beben();
        this.pusty_beben();
        System.out.println(this.zwroc_beben());
        System.out.println("Użytkownik otworzył bęben i umiescił ciuchy w bębnie.");
        this.zamknij_beben();
        this.pelny_beben();
        System.out.println(this.zwroc_beben());
        System.out.println("Użytkownik zamknął zapełniony ciuchami bęben.");
    }

    public void krok2(){
        Scanner scan = new Scanner(System.in);
        System.out.println(" WYBÓR TRYBÓW:\n1.PRANIE SZYBKIE\n2.PRANIE WSTĘPNE\n3.PRANIE W ZIMNEJ WODZIE\n4.CIEMNE UBRANIA\n5.PŁUKANIE\n6.WŁASNY: ");
        int wybor = scan.nextInt();
        Tryb tryb = null;

        if(wybor == 1){
            tryb = (Tryb)this.Tryby.get("pranie szybkie");
        }else if(wybor == 2){
            tryb = (Tryb) this.Tryby.get("pranie wstepne");
        }else if(wybor == 3){
            tryb = (Tryb) this.Tryby.get("pranie w zimnej wodzie");
        }else if(wybor == 4){
            tryb = (Tryb) this.Tryby.get("ciemne ubrania");
        }else if(wybor == 5){
            tryb = (Tryb) this.Tryby.get("płukanie");
        }else{
           tryb =  ustawWlasyTryb();
        }
        System.out.println(tryb.toString());
        this.setAktualnie_wybrany_tryb(tryb);
    }
    public void krok3(){
        this.otworz_pojemnik();
        this.pusty_pojemnik();
        System.out.println(this.zwroc_pojemnik());
        System.out.println("Użytkownik otworzył pojemnik na detergenty i uzupełnił pojemnik.");
        this.zamknij_pojemnik();
        this.pelny_pojemnik();
        System.out.println(this.zwroc_pojemnik());
        System.out.println("Użytkownik zamknął zapełniony pojemnik na detergenty.");
    }

    public void krok5(){

        if( this.aktualnie_wybrany_tryb!= null){

           this.wlacz_grzalke();
            System.out.println(this.zwroc_grzalka());

            this.wlacz_filtr();
            System.out.println(this.zwroc_filtr());

            this.wlacz_pompe();
            System.out.println(this.zwroc_pompa_do_wody());

            Czujnik czujnik = (Czujnik) Czujniki.get("cisnienie wody");
            System.out.println("Czujnik ciśnienia woda: " + czujnik.toString());
            czujnik.wlacz();
            System.out.println("Pralka włączyłą czujnik: " + czujnik.toString());

            Czujnik czujnik1 = (Czujnik) Czujniki.get("temperatura wody");
            System.out.println("Czujnik temperatury wody: " + czujnik1.toString());
            czujnik1.wlacz();
            System.out.println("Pralka włączyłą czujnik: " + czujnik.toString());

            Czujnik czujnik2 = (Czujnik) Czujniki.get("poziom wody");
            System.out.println("Czujnik poziomu wody: " + czujnik2.toString());
            czujnik2.wlacz();
            System.out.println("Pralka włączyłą czujnik: " + czujnik.toString());

            Czujnik czujnik3 = (Czujnik) Czujniki.get("zabezpieczajacy przed zalaniem");
            System.out.println("Czujnik zabezpieczający przed zalaniem: " +  czujnik3.toString());
            czujnik3.wlacz();
            System.out.println("Pralka włączyłą czujnik: " + czujnik.toString());

            Czujnik czujnik4 = (Czujnik) Czujniki.get("wagi zawartosci bebna");
            System.out.println("Czujnik wagi zawartości bębna: " + czujnik4.toString());
            czujnik4.wlacz();
            System.out.println("Pralka włączyłą czujnik: " + czujnik.toString());

            Czujnik czujnik5 = (Czujnik) Czujniki.get("droznosc fitra wody");
            System.out.println("Czujnik drożności filtra wody: " + czujnik5.toString());
            czujnik5.wlacz();
            System.out.println("Pralka włączyłą czujnik: " + czujnik.toString());

            this.otworz_zawory();
            System.out.println(this.zwroc_elektro_zawory());

            this.wlacz_silnik();
            System.out.println(this.zwroc_silnik());

            this.wlacz_sterownik();
            System.out.println(this.zwroc_sterwonik());

        }
    }

        public GrzalkaDoWody zwroc_grzalka() {
        return (GrzalkaDoWody) this.ElementyMechaniczne.get("grzalka_do_wody");
        }

        public void wlacz_grzalke(){
        this.zwroc_grzalka().wlacz();
        }

        public void wylacz_grzalke(){
        this.zwroc_grzalka().wylacz();
        }

        public Beben zwroc_beben(){
        return (Beben)this.ElementyMechaniczne.get("beben");
        }

        public void otworz_beben(){
        this.zwroc_beben().otworz();
        }

        public void zamknij_beben(){
        this.zwroc_beben().zamknij();
        }

        public void pusty_beben(){
        this.zwroc_beben().pusty();
        }

        public void pelny_beben(){
        this.zwroc_beben().pelny();
        }

        public PojemnikNaDetergenty zwroc_pojemnik(){
            return (PojemnikNaDetergenty) this.ElementyMechaniczne.get("pojemnik na detergenty");
        }

        public void otworz_pojemnik(){
        this.zwroc_pojemnik().otworz();
        }

        public void zamknij_pojemnik(){
        this.zwroc_pojemnik().zamknij();
        }

        public void pusty_pojemnik(){
        this.zwroc_pojemnik().pusty();
        }

        public void pelny_pojemnik(){
        this.zwroc_pojemnik().pelny();
        }

        public Filtr zwroc_filtr(){
        return (Filtr) this.ElementyMechaniczne.get("filtr wody");
        }

        public void wlacz_filtr(){
        this.zwroc_filtr().wlacz();
        }

        public void wylacz_filtr(){
        this.zwroc_filtr().wylacz();
        }

        public PompaDoWody zwroc_pompa_do_wody(){
        return (PompaDoWody) this.ElementyWykonawcze.get("pompa do wody");
        }

        public void wlacz_pompe(){
        this.zwroc_pompa_do_wody().wlacz();
        }

        public void wylacz_pompe(){
        this.zwroc_pompa_do_wody().wylacz();
        }

        public ElektroZaworyWodne zwroc_elektro_zawory(){
           return (ElektroZaworyWodne) this.ElementyWykonawcze.get("elektrozawory wodne");
        }

        public void otworz_zawory(){
        this.zwroc_elektro_zawory().otworz();
        }

        public void zamknij_zawory(){
        this.zwroc_elektro_zawory().zamknij();
        }

        public SilnikInwerterowy zwroc_silnik(){
        return (SilnikInwerterowy) ElementyWykonawcze.get("silnik inwerterowy");
        }

        public void wlacz_silnik(){
        this.zwroc_silnik().wlacz();
        }

        public void wylacz_silnik(){
        this.zwroc_silnik().wylacz();
        }

        public SterownikRegulujacyPredkosciaObrotowa zwroc_sterwonik(){
        return (SterownikRegulujacyPredkosciaObrotowa) ElementyWykonawcze.get("sterownik regulujacy predkosc obrotowa");
        }

        public void wlacz_sterownik(){
        this.zwroc_sterwonik().wlacz();
        }

        public void wylacz_sterownik(){
        this.zwroc_sterwonik().wylacz();
        }

        public PanelPrzedniPosiadajacyWlacznik zwroc_panel_przedni(){
        return (PanelPrzedniPosiadajacyWlacznik) ElementyWykonawcze.get("panel przedni on/off");
        }

        public void wlacz_panel(){
        this.zwroc_panel_przedni().wlacz();
        }

        public void wylacz_panel(){
        this.zwroc_panel_przedni().wylacz();
        }

        public Tryb ustawWlasyTryb(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj temperaturę wody dla tryby: ");
            int temp_wody = scan.nextInt();
            System.out.println("Podaj czas prania wstepnego: ");
            int czas_prania_wstepnego = scan.nextInt();
            System.out.println("Podaj czas prania zasadniczego: ");
            int czas_prania_zasadniczego = scan.nextInt();
            System.out.println("Czy chcesz dodatkowe płukanie? Jeśli tak wpisz [T]: ");
            char letter  = scan.next().charAt(0);
            boolean dodatkowe_plukanie;
            if((letter != 't') && (letter != 'T')) dodatkowe_plukanie = false;
            else dodatkowe_plukanie = true;
            System.out.println("Podaj prędkość obrotową wirowania: ");
            int predkosc_obrotowa = scan.nextInt();

            Tryb wlasny_tryb = new Tryb(this,temp_wody, czas_prania_wstepnego, czas_prania_zasadniczego,dodatkowe_plukanie ,predkosc_obrotowa);

            this.Tryby.put("wlasny_tryb", wlasny_tryb);
            return wlasny_tryb;
        }

        public void stan_4(){
            GrzalkaDoWody grzalka = (GrzalkaDoWody) ElementyMechaniczne.get("grzalka_do_wody");
            System.out.println(grzalka.toString());

            Beben beben =(Beben) ElementyMechaniczne.get("beben");
            System.out.println(beben.toString());

            PojemnikNaDetergenty pojemnikNaDetergenty = (PojemnikNaDetergenty) ElementyMechaniczne.get("pojemnik na detergenty");
            System.out.println(pojemnikNaDetergenty.toString());

            Filtr filtr = (Filtr) ElementyMechaniczne.get("filtr wody");
            System.out.println(filtr.toString());

            PompaDoWody pompaDoWody = (PompaDoWody) ElementyWykonawcze.get("pompa do wody");
            System.out.println(pompaDoWody.toString());

            Czujnik czujnik = (Czujnik) Czujniki.get("cisnienie wody");
            System.out.println("Czujnik ciśnienia wody: " + czujnik.toString());

            Czujnik czujnik1 = (Czujnik) Czujniki.get("temperatura wody");
            System.out.println("Czujnik temperatury wody: " + czujnik1.toString());

            Czujnik czujnik2 = (Czujnik) Czujniki.get("poziom wody");
            System.out.println("Czujnik poziomu wody: " + czujnik2.toString());

            Czujnik czujnik3 = (Czujnik) Czujniki.get("zabezpieczajacy przed zalaniem");
            System.out.println("Czujnik zabezpieczający przed zalaniem: " +  czujnik3.toString());

            Czujnik czujnik4 = (Czujnik) Czujniki.get("wagi zawartosci bebna");
            System.out.println("Czujnik wagi zawartości bębna: " + czujnik4.toString());

            Czujnik czujnik5 = (Czujnik) Czujniki.get("droznosc fitra wody");
            System.out.println("Czujnik drożności filtra wody: " + czujnik5.toString());

            ElektroZaworyWodne elektroZaworyWodne = (ElektroZaworyWodne) ElementyWykonawcze.get("elektrozawory wodne");
            System.out.println(elektroZaworyWodne.toString());

            SilnikInwerterowy silnikInwerterowy = (SilnikInwerterowy) ElementyWykonawcze.get("silnik inwerterowy");
            System.out.println(silnikInwerterowy.toString());

            SterownikRegulujacyPredkosciaObrotowa sterownikRegulujacyPredkosciaObrotowa = (SterownikRegulujacyPredkosciaObrotowa) ElementyWykonawcze.get("sterownik regulujacy predkosc obrotowa");
            System.out.println(sterownikRegulujacyPredkosciaObrotowa.toString());

        }
}
