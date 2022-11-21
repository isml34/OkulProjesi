package okulyonetimi;

import java.util.*;

public class Ogrenci {
    public static final String kirmizi = "\u001B[31m";
    public static final String yesil = "\u001B[32m";
    public static final String sari = "\u001B[33m";
    public static final String mavi = "\u001B[34m";
    public static final String mor = "\u001B[35m";

    public static final String beyaz = "\u001B[37m";

    static Scanner input = new Scanner(System.in);
    static Map<String, OgrenciPojo> ogrenciListesi = new HashMap<>();//map<key(tc), value(OgrenciPojo)>--->
    static Set<Map.Entry<String, OgrenciPojo>> ogrenciListeSet = ogrenciListesi.entrySet();

    static Set<String> kimlikNumaralariSet1 = ogrenciListesi.keySet();


    public static void ogrenciMenu() {
        System.out.println(yesil + "--------------# OGRENCİ SAYFASİ #-----------");
        System.out.println(mavi + "1. Ekleme\n" +
                "2. Arama\n" +
                "3. Listeleme\n" +
                "4. Silme\n" +
                "5. Anasayfa\n" +
                "Q. Cikis\n");
        System.out.println(mor + "Yapmak istediginiz islemi seciniz.");
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
                    System.out.println(yesil + "Okul Sayfamizi ziyaret ettiginiz icin tesekkur ederiz\n" +
                                               "Iyi Gunler Dileriz :)");
                    scm = false;
                    break;
                default:
                    System.out.println(mavi + "Yanlis bir secim yaptiniz. Tekrar giris yapiniz");//8-4
                    secim = input.next().toUpperCase();
            }
        } while (scm);

    }


    public static void ekleme() {
        System.out.println(kirmizi + "---------------------------# OGRENCİ EKLEME SAYFASİ #---------------------------------");
        System.out.println(sari + "Eklemek istediginiz ogrencinin kimlik numrasini 6 haneli olarak giriniz.");
        String kimlikNumarasi = input.next();

        if (kimlikNumarasi.matches("[0-9]{6}")) {//kimlik numrasi sadece rakam icerebilir. ve 6 haneli olmalidir.
            System.out.println(sari + "Eklemek istediginiz ogrencinin adi giriniz");
            String ad = input.next();
            System.out.println(sari + "Eklemek istediginiz ogrencinin soyadi giriniz");
            String soyad = input.next();
            System.out.println(sari + "Eklemek istediginiz ogrencinin yasini giriniz");
            int yas = input.nextInt();
            int okulNo = (int) (Math.random() * 300);
            int sinif = 9;

            boolean secim1 = true;

            do {
                switch (yas) {
                    case 15:
                        sinif = 9;
                        secim1 = false;
                        break;
                    case 16:
                        sinif = 10;
                        secim1 = false;
                        break;
                    case 17:
                        sinif = 11;
                        secim1 = false;
                        break;
                    case 18:
                        sinif = 12;
                        secim1 = false;
                        break;
                    default:
                        System.out.println(mavi + "Okulumuz yabanci dille egitim veren bir kurumdur. \n" +
                                                  "Okulumuz bir lisedir bu yuzden sadece 15-18 yas arasi ogrenci kabul eder\n" +
                                                  "Ogreniz bu aralikta degildir. Tekrar yas giriniz.");
                        yas = input.nextInt();
                }
            } while (secim1);

            OgrenciPojo ogrenciObje = new OgrenciPojo(kimlikNumarasi, ad, soyad, yas, okulNo, sinif);

            ogrenciListesi.put(kimlikNumarasi, ogrenciObje);

            System.out.println(mor + "Ogrenci basariyla eklenmistir.\n"+
                                     "Ogrenci eklemeye devam etmek icin 1'e basiniz\n" +
                                     "Ogrenci sayfasina donmek icin 2'ye basiniz\n" +
                                     "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                ekleme();
            } else if (sss.equals("2")) {
                ogrenciMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }

        } else {
            System.out.println(mavi + "Yanlis kimlik numarasi girdiniz girdiniz");
            ekleme();
        }


    }


    public static void arama() {
        System.out.println(kirmizi + "---------------------------# OGRENCİ ARAMA SAYFASİ #---------------------------------");
        System.out.println(yesil + "Aramak istediginiz ogrencinin kimlik numarasini giriniz: ");
        String kmlik = input.next();
        System.out.println(sari + "Kimlik No          Ad               Soyad            Yas              OkulNo        Sinif" +
                "\n-----------------------------------------------------------------------------------------------------------");

        if (kimlikNumaralariSet1.contains(kmlik)) {
            OgrenciPojo ogrenci = ogrenciListesi.get(kmlik);
            System.out.println(ogrenci);
            System.out.println(mor + "Ogrenci aramaya devam etmek icin 1'e basiniz.\n " +
                                     "Ogrenci menusune donmek icin 2'ye basiniz\n" +
                                     "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                arama();
            } else if (sss.equals("2")) {
                ogrenciMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }

        } else {
            System.out.println(mavi + "Yanlis kimlik numarasi girdiniz.");

            System.out.println(mor + "Ogrenci aramaya devam etmek icin 1'e basiniz.\n " +
                                     "Ogrenci menusune donmek icin 2'ye basiniz\n" +
                                     "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                arama();
            } else if (sss.equals("2")) {
                ogrenciMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }


        }


    }


    public static void listeleme() {

        System.out.println(kirmizi + "---------------------------# OGRENCİ LİSTESİ #--------------------------------------------------------");
        System.out.println(sari + "Kimlik No           Ad                 Soyad              Yas                OgrenciNo          Sinif" +
                "\n-----------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, OgrenciPojo> w : ogrenciListeSet) {
            String key = w.getKey();

            System.out.printf("%-20s %-19s %-19s %-19s %-19s %-15s\n", key, ogrenciListesi.get(key).getAd(),
                    ogrenciListesi.get(key).getSoyad(), ogrenciListesi.get(key).getYas(), ogrenciListesi.get(key).getOkulNo(),
                    ogrenciListesi.get(key).getSinif());
        }

        System.out.println(mor + "Ogrenci menusune donmek icin 1'ye basiniz\n" +
                                 "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

        String sss = input.next();

        if (sss.equals("1")) {
            ogrenciMenu();
        } else {
            OkulAnasayfa.okulAnaSayfasi();
        }


    }


    public static void silme() {
        System.out.println(kirmizi + "---------------------------# OGRENCİ SILME SAYFASİ #--------------------------------------------------------");
        System.out.println(sari + "Silmek istediginiz ogrencinin Kimlik Numarasini giriniz");
        String ogrenciSilmeSecim = input.next();


        if (kimlikNumaralariSet1.contains(ogrenciSilmeSecim)) {
            System.out.println(kirmizi + "Silinecek ogrenci bilgilerli: ");
            System.out.println(sari + "Kimlik No          Ad           Soyad         Yas          OgrenciNo       Sinif" +
                    "\n-------------------------------------------------------------------------------------------------");
            System.out.println(ogrenciListesi.get(ogrenciSilmeSecim));

            ogrenciListesi.remove(ogrenciSilmeSecim);


            System.out.println(kirmizi + "Ogrenci basariyla silindi.\n");
            System.out.println( mor+     "Ogrenci silmeye devam etmek icin 1'e basiniz.\n " +
                                         "Ogrenci menusune donmek icin 2'ye basiniz\n" +
                    "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                silme();
            } else if (sss.equals("2")) {
                ogrenciMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }

        } else {
            System.out.println(mavi + "Yanlis kimlik numarasi girdiniz.");

            System.out.println(mor + "Ogrenci silmeye devam etmek icin 1'e basiniz.\n " +
                                     "Ogrenci menusune donmek icin 2'ye basiniz\n" +
                                     "Anasayfaya donmek icin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                silme();
            } else if (sss.equals("2")) {
                ogrenciMenu();
            } else {
                OkulAnasayfa.okulAnaSayfasi();
            }


        }


    }


}