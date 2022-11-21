package okulyonetimi;

import java.util.Scanner;


public class OkulAnasayfa {
    public static final String kirmizi = "\u001B[31m";
    public static final String yesil = "\u001B[32m";
    public static final String sari = "\u001B[33m";
    public static final String mavi = "\u001B[34m";
    public static final String mor = "\u001B[35m";
    static Scanner input = new Scanner(System.in);

    public static void okulAnaSayfasi() {
        System.out.println(kirmizi+"---------------# OKUL ANASAYFASİ #-------------------------");

        System.out.println(sari+"1. Ogrenci Islemleri\n" +
                "2. Ogretmen Islemleri\n" +
                "Q. Cikis\n" );

        System.out.println(mor+"Yapmak istediginiz islemi seciniz.");

        String secim = input.next().toUpperCase();

        boolean scm = true;
        do {
            switch (secim) {
                case "1":
                    Ogrenci.ogrenciMenu();
                    scm = false;
                    break;
                case "2":
                    Ogretmen.ogretmenMenu();
                    scm = false;
                    break;
                case "Q":
                    System.out.println(yesil+"Okul Sayfamizi ziyaret ettiginiz icin tesekkur ederiz\n" +
                            "Iyi Gunler Dileriz :)");
                    scm = false;
                    break;
                default:
                    System.out.println(mavi+"Yanlis bir secim yaptiniz. Tekrar giris yapiniz");
                    secim = input.next().toUpperCase();
            }
        } while (scm);


    }
}
