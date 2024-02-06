package LAB6_P;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        Pralka pralka = new Pralka();

        System.out.println("Witamy w programie SYMULATOR PRALKI firmy BOSH!\nJetseś w łazience co chcesz zrobić:\n1.Chcę zrobić pranie\n2 Wyjdż");
        int wybor = scan.nextInt();
        boolean wyjdz = false;
        if(wybor == 1) {

           while (true) {

                int wybor_2 =  pralka.menu();

                switch (wybor_2) {

                    case 1:
                        pralka.krok1();
                        break;
                    case 2:
                        pralka.krok2();
                        break;
                    case 3:
                        pralka.krok3();
                        break;
                    case 4:
                        pralka.stan_4();
                        break;
                    case 5:
                        pralka.krok5();
                        wyjdz = true;
                        break;
                }
                if (wyjdz) break;
            }
        }else if (wybor == 2){
            System.out.println("Koniec programu!");
        }
    }
}
