package okulyonetimi;

import java.util.*;

public class Ogretmen {
    public static final String kirmizi = "\u001B[31m";
    public static final String yesil = "\u001B[32m";
    public static final String sari = "\u001B[33m";
    public static final String mavi = "\u001B[34m";
    public static final String mor = "\u001B[35m";
    public static final String beyaz = "\u001B[37m";
    static Scanner input = new Scanner(System.in);
    static Map<String, OgretmenPojo> ogretmenListesi = new HashMap<>();
    static Set<Map.Entry<String, OgretmenPojo>> ogretmenListeSet = ogretmenListesi.entrySet();
    static Set<String> kimlikNumaralariSet = ogretmenListesi.keySet();


    public static void ogretmenMenu() {
        System.out.println(yesil+"-------------------# OGRETMEN SAYFASİ #---------------------");

        System.out.println(mavi+"1. Ekleme\n" +
                "2. Arama\n" +
                "3. Listeleme\n" +
                "4. Silme\n" +
                "5. Anasayfa\n" +
                "Q. Cikis\n" );
        System.out.println(mor+ "Yapmak istediginiz islemi seciniz.");

        String secim = input.next().toUpperCase();

        boolean scm = true;
        do {
            switch (secim) {
                case "1":
                    ekleme();
                    scm = false;
                    break;
                case "2":
                    arama();
                    scm = false;
                    break;
                case "3":
                    listeleme();
                    scm = false;
                    break;
                case "4":
                    silme();
                    scm = false;
                    break;
                case "5":
                    OkulAnasayfa.okulAnaSayfasi();
                    scm = false;
                    break;
                case "Q":
                    System.out.println(yesil+ "Okul Sayfamizi ziyaret ettiginiz icin tesekkur ederiz\n" +
                                              "Iyi Gunler Dileriz :)");
                    scm = false;
                    break;
                default:
                    System.out.println(mavi+"Yanlis bir secim yaptiniz. Tekrar giris yapiniz");
                    secim = input.next().toUpperCase();
            }
        } while (scm);

    }


    public static void ekleme() {
        System.out.println(kirmizi+"---------------------------# OGRETMEN EKLEME SAYFASİ #---------------------------------");
        System.out.println();
        System.out.println(sari+"Eklemek istediginiz ogretmenin kimlik numrasini 6 haneli giriniz.");
        String kimlikNumarasi = input.next();

        if (kimlikNumarasi.matches("[0-9]{6}")) {
            System.out.println(sari+"Eklemek istediginiz ogretmenin adi giriniz");
            String ad = input.next();
            System.out.println(sari+"Eklemek istediginiz ogretmenin soyadi giriniz");
            String soyad = input.next();
            System.out.println(sari+"Eklemek istediginiz ogretmenin yasini giriniz");

            int yas = input.nextInt();
            System.out.println(sari+"Eklemek istediginiz ogretmenin bolumunu giriniz");
            String bolum = input.next();
            System.out.println(sari+"Eklemek istediginiz ogretmenin sicil numrasini giriniz");
            String sicilNumarasi = input.next();

            OgretmenPojo ogretmenObje = new OgretmenPojo(kimlikNumarasi, ad, soyad, yas, bolum, sicilNumarasi);

            ogretmenListesi.put(kimlikNumarasi, ogretmenObje);
            System.out.println(mor+ "Ogretmen eklemeye devam etmek icin 1'e basiniz\n" +
                                    "Ogretmen sayfasina donmek icin 2'ye basiniz\n" +
                                    "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                ekleme();
            } else if (sss.equals("2")) {
                ogretmenMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }

        }

    }


    public static void arama() {
        System.out.println(kirmizi+"---------------------------# OGRETMEN ARAMA SAYFASİ #---------------------------------");
        System.out.println(yesil+"Aramak istediginiz ogretmenin kimlik numarasini giriniz: ");
        String kmlik = input.next();
        System.out.println(sari+"Kimlik No          Ad                Soyad             Yas               Bolum         Sicil" +
                "\n--------------------------------------------------------------------------------------------------------------");

        if (kimlikNumaralariSet.contains(kmlik)) {
            OgretmenPojo ogretmen = ogretmenListesi.get(kmlik);
            System.out.println(ogretmen);
            System.out.println(mor+ "Ogretmen aramaya devam etmek icin 1'e basiniz.\n " +
                                    "Ogretmen menusune donmek icin 2'ye basiniz\n" +
                                    "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                arama();
            } else if (sss.equals("2")) {
                ogretmenMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }

        } else {
            System.out.println(kirmizi+"Yanlis kimlik numarasi girdiniz.");
            System.out.println();
            System.out.println(mor+ "Ogretmen aramaya devam etmek icin 1'e basiniz.\n " +
                                    "Ogretmen menusune donmek icin 2'ye basiniz\n" +
                                    "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                arama();
            } else if (sss.equals("2")) {
                ogretmenMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }


        }


    }

    public static void listeleme() {

        System.out.println(kirmizi+"---------------------------# OGRETMEN LİSTESİ #---------------------------------");
        System.out.println(sari+"Kimlik No            Ad                  Soyad               Yas                 Bolum           Sicil" +
                "\n-----------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, OgretmenPojo> w : ogretmenListeSet) {
            String key = w.getKey();

            System.out.printf("%-20s %-19s %-19s %-19s %-19s %-15s\n", key, ogretmenListesi.get(key).getAd(),
                    ogretmenListesi.get(key).getSoyad(), ogretmenListesi.get(key).getYas(), ogretmenListesi.get(key).getBolum(),
                    ogretmenListesi.get(key).getSicilNo());
        }

        System.out.println(mor+ "Ogretmen menusune donmek icin 1'ye basiniz\n" +
                                "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

        String sss = input.next();

        if (sss.equals("1")) {
            ogretmenMenu();
        } else {
            OkulAnasayfa.okulAnaSayfasi();
        }


    }


    public static void silme() {
        System.out.println(kirmizi+"---------------------------# OGRETMEN SILME SAYFASİ #--------------------------------------------------------");
        System.out.println(sari+"Silmek istediginiz ogretmenin Kimlik Numarasini giriniz");
        String ogrenciSilmeSecim = input.next();


        if (kimlikNumaralariSet.contains(ogrenciSilmeSecim)) {
            System.out.println(kirmizi+"Silinecek ogretmen bilgilerli: ");
            System.out.println(sari+"Kimlik No          Ad           Soyad         Yas         bolum      Sicil" +
                    "\n-------------------------------------------------------------------------------------------------");
            System.out.println(ogretmenListesi.get(ogrenciSilmeSecim));

            ogretmenListesi.remove(ogrenciSilmeSecim);


            System.out.println(kirmizi+ "Ogretmen basariyla silindi.\n" );
            System.out.println(mor +    "Ogretmen silmeye devam etmek icin 1'e basiniz.\n " +
                                        "Ogretmen menusune donmek icin 2'ye basiniz\n" +
                                        "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                silme();
            } else if (sss.equals("2")) {
                ogretmenMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }

        } else {
            System.out.println(mavi+"Yanlis kimlik numarasi girdiniz.");

            System.out.println(mor+ "Ogretmen silmeye devam etmek icin 1'e basiniz.\n " +
                                    "Ogretmen menusune donmek icin 2'ye basiniz\n" +
                                    "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                silme();
            } else if (sss.equals("2")) {
                ogretmenMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }


        }


    }


}
