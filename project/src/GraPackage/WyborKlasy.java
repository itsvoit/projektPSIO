package GraPackage;

import Bron.Bron;
import Bron.Lowcy.BronLowcy;
import Bron.Lowcy.Luk;
import Bron.Maga.BronMaga;
import Bron.Maga.Rozdzka;
import Bron.Woja.BronWoja;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.BronZabojcy;
import Bron.Zabojcy.Sztylet;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;

import java.util.Random;
import java.util.Scanner;

public abstract class WyborKlasy {
    private static String[] listaKlas = {"Wojownik", "Zabojca", "Lowca", "Mag"};
    private static String[] listaBroniLowcy = {"Luk"};
    private static String[] listaBroniZabojcy = {"Sztylet"};
    private static String[] listaBroniMaga = {"Rozdzka"};
    private static String[] listaBroniWojownika = {"Miecz", "Mlot"};
    private static String[] listaBroni;
    private static String[] listaImionBota = {"Ziemowit Bździągwa", "Koszmar Dziekana", "Java Senior Developer",
            "Java Garbage Collector",
            "Kolokwium z Analizy", "PANDA_3"};
    static Random random = new Random();

    public static String generujKlasaBot() {
        Random generator = new Random();

        return listaKlas[generator.nextInt(listaKlas.length)];
    }

    public static String generujBronBot(String klasaBot) {

        switch (klasaBot) {
            case "Wojownik":
                listaBroni = listaBroniWojownika;
                break;
            case "Zabojca":
                listaBroni = listaBroniZabojcy;
                break;
            case "Lowca":
                listaBroni = listaBroniLowcy;
                break;
            case "Mag":
                listaBroni = listaBroniMaga;
                break;
        }
        return listaBroni[random.nextInt(listaBroni.length)];
    }

    public static String wybierzImie() {

        String imie;
        System.out.print("Podaj imie:");
        Scanner czytnik = new Scanner(System.in);
        imie = czytnik.nextLine();
        return imie;
    }

    public static String wybierzPostac() {

        boolean postacZostalaWybrana = false;
        int wyborPostaci = 1;

        while (!postacZostalaWybrana) {
            try {
                System.out.println("Wybierz klase:");
                for (int i = 0; i < listaKlas.length; i++) {
                    System.out.println((i + 1) + "." + listaKlas[i]);
                }
                postacZostalaWybrana=true;
                Scanner czytnik = new Scanner(System.in);
                wyborPostaci = czytnik.nextInt();

                if(wyborPostaci> listaKlas.length || wyborPostaci<1){
                    throw new RuntimeException();
                }
            } catch (Exception e){
                System.out.println("Błędny znak!");
                postacZostalaWybrana=false;
            }
        }

        if (wyborPostaci < listaKlas.length + 1 && wyborPostaci > 0) return listaKlas[wyborPostaci - 1];
        else return "Wojownik";

    }

    public static String wybierzBron(String wyborGracza) {

        boolean bronZostalaWybrana = false;
        int wybranaBron = 1;

        switch (wyborGracza) {
            case "Wojownik":
                listaBroni = listaBroniWojownika;
                break;
            case "Zabojca":
                listaBroni = listaBroniZabojcy;
                break;
            case "Lowca":
                listaBroni = listaBroniLowcy;
                break;
            case "Mag":
                listaBroni = listaBroniMaga;
                break;
            default:
                break;
        }

        while (!bronZostalaWybrana) {
            try {
                System.out.println("Wybierz bron:");
                for (int i = 0; i < listaBroni.length; i++) {
                    System.out.println((i + 1) + "." + listaBroni[i]);
                }
                bronZostalaWybrana=true;
                Scanner czytnik = new Scanner(System.in);
                wybranaBron = czytnik.nextInt();
                if(wybranaBron>listaBroni.length || wybranaBron<1){
                    throw new RuntimeException();
                }
            } catch (Exception e){
                System.out.println("Błędny znak!");
                bronZostalaWybrana=false;
            }
        }


        return listaBroni[wybranaBron - 1];
    }

    public static Postac stworzPostac(String wybranaPostac, String imie, String bron) {
        switch (wybranaPostac) {
            case "Wojownik":
                return new Wojownik(imie, (BronWoja) WyborKlasy.stringNaBron(bron));
            case "Lowca":
                return new Lowca(imie, (BronLowcy) WyborKlasy.stringNaBron(bron));
            case "Zabojca":
                return new Zabojca(imie, (BronZabojcy) WyborKlasy.stringNaBron(bron));
            case "Mag":
                return new Mag(imie, (BronMaga) WyborKlasy.stringNaBron(bron));
        }
        return new Wojownik("BLAD", new Miecz());
    }

    private static Bron stringNaBron(String bron) {
        Bron wynik;
        switch (bron) {
            case "Miecz":
                wynik = new Miecz();
                break;
            case "Mlot":
                wynik = new Mlot();
                break;
            case "Luk":
                wynik = new Luk();
                break;
            case "Rozdzka":
                wynik = new Rozdzka();
                break;
            case "Sztylet":
                wynik = new Sztylet();
                break;
            default:
                wynik = new Miecz();
        }
        return wynik;
    }

    public static String generujImieBota() {
        return listaImionBota[random.nextInt(listaImionBota.length)];
    }
}
