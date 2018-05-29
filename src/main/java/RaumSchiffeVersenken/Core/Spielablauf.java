package RaumSchiffeVersenken.Core;


import RaumSchiffeVersenken.Interface.RaumSchiff;


import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class Spielablauf {

    private int DerzeitigeSchiffslänge = 0;
    public static Feld Feld_Spieler1 = new Feld(10, 10);
    public static Feld Feld_Spieler2 = new Feld(10, 10);


    public String start() {
        System.out.println("Los gehts!");
        System.out.println("Spieler 1 beginnt:\n");

        Feld_Spieler1.toString();

        System.out.println("\n");

        Feld_Spieler2.toString();

        System.out.println("\nSetze jetzt deine Schiffe im oberen Feld.");

        System.out.println("Schiffe zu setzen:\n" + "5 Jäger mit der Länge 1\n" + "4 Bomber mit der Länge 2\n" +
                "2 Fregatten mit der Länge 4\n" + "1 Zerstörer mit der Länge 5\n");

        return "Start";
    }

    /**
     *
     */
    public void SchiffeSetzenAblauf() {

        HashMap<Integer, RaumSchiff> SchiffsMap = new HashMap<>();

        // Jaeger erstellen mit 1 Lebenspunkt
        SchiffsMap.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(5, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));

        //Bomber erstellen mit 2 Lebenspunkten
        SchiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));

        //Fregatte erstellen mit 4 Lebenspunkten
        SchiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));
        SchiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));

        //Zerstörer erstellen mit 5 Lebenspunkten
        SchiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5")));

        spieler1SchiffeSetzenAblauf(SchiffsMap);

        spiler2SchiffeSetzenAblauf(SchiffsMap);

    }



    /**
     *
     */
    public void SchiessenAblauf() {


        for (int i = 0; i <= 99; i++) {
            Feld Kopie_Feld_Spieler1 = new Feld(Feld_Spieler1);
            Feld Kopie_Feld_Spieler2 = new Feld(Feld_Spieler2);
            Kopie_Feld_Spieler1.kriegsnebel();
            Kopie_Feld_Spieler2.kriegsnebel();


            // Spieler 1 Schießablauf
            System.out.println("Dein Feld:\n");
            Feld_Spieler1.toString();
            System.out.println("\nDas Gegnerfeld:\n");
            Kopie_Feld_Spieler2.toString();
            System.out.println("\nSpieler 1 ist dran mit Schiessen\n");
            Feld_Spieler2.zielenZumSchiessen();

            Feld_Spieler1.BereitAbfrage(Kopie_Feld_Spieler2);


            // Spieler 2 Schießablauf
            System.out.println("Dein Feld:\n");
            Feld_Spieler2.toString();
            System.out.println("\nDas Gegnerfeld:\n");
            Kopie_Feld_Spieler1.toString();
            System.out.println("\nSpieler 2 ist dran mit Schiessen\n");
            Feld_Spieler1.zielenZumSchiessen();


            Feld_Spieler2.BereitAbfrage(Kopie_Feld_Spieler1);


            Feld_Spieler2.TrefferZaehler(Feld_Spieler2, 2);
            Feld_Spieler1.TrefferZaehler(Feld_Spieler1, 1);
        }
    }

    // --------------------------------------------------------------------------------


    /**
     * @param i
     * @param map
     * @return
     */
    public String derzeitigerSchiffSetzer(int i, HashMap map) {
        RaumSchiff schiff = (RaumSchiff) map.get(i);
        DerzeitigeSchiffslänge = schiff.getLaenge();
        String DerzeitigerSchiffsName = "";

        if (DerzeitigeSchiffslänge == 1) {
            DerzeitigerSchiffsName = "Jäger";
        } else if (DerzeitigeSchiffslänge == 2) {
            DerzeitigerSchiffsName = "Bomber";
        } else if (DerzeitigeSchiffslänge == 4) {
            DerzeitigerSchiffsName = "Fregatte";
        } else if (DerzeitigeSchiffslänge == 5) {
            DerzeitigerSchiffsName = "Zertörer";
        }

        System.out.println("\nDerzeitiger Schiffstyp: " + DerzeitigerSchiffsName + "\n" +
                "Es hat die Länge: " + DerzeitigeSchiffslänge + "\n");

        return "";
    }


    // ----------------------------------------------------------------------------------

    public boolean randomSchiffeSetzen(Feld feld, int SchiffTypsLaenge) {


        int randomX = ThreadLocalRandom.current().nextInt(10);
        int randomY = ThreadLocalRandom.current().nextInt(10);
        int randomRichtung = ThreadLocalRandom.current().nextInt(2) + 1;

        /*
        Random randomGenerator = new Random();
        int randomX = randomGenerator.nextInt(10);
        int randomY = randomGenerator.nextInt(10);
        int randomRichtung = randomGenerator.nextInt(2) + 1;
         */


        return feld.schiffSetzenAutomatisch(randomY, randomX, randomRichtung, SchiffTypsLaenge);
    }


    // ------------------------------------------------------------------------------------


    public String spieler1SchiffeSetzenAblauf(HashMap SchiffsMap) {


        System.out.println("Möchten sie ihre Schiffe Random per AI gesetzt haben oder Manuel?\n" +
                "Random: 1\n" +
                "Manuel: 2\n" +
                "Hier: ");
        Scanner RMentscheidung = new Scanner(System.in);
        String rmString = RMentscheidung.nextLine();
        int rmInt = Integer.parseInt(rmString);


        if (rmInt == 1) {

            try {
                for (int i = 1; i <= 12; i++) {
                    RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                    DerzeitigeSchiffslänge = schiff.getLaenge();
                    boolean stand = randomSchiffeSetzen(Feld_Spieler1, DerzeitigeSchiffslänge);

                    if (!stand) {
                        i -= 1;
                    }
                }
                Feld_Spieler1.toString();
            } catch (Exception ex) {
                throw ex;
            }

        } else {
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                DerzeitigeSchiffslänge = schiff.getLaenge();
                derzeitigerSchiffSetzer(i, SchiffsMap);
                Feld_Spieler1.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
                Feld_Spieler1.toString();
            }
        }

        Feld_Spieler1.BereitAbfrage(Feld_Spieler1);


        return "";
    }

    public String spiler2SchiffeSetzenAblauf(HashMap SchiffsMap) {

        System.out.println("Möchten sie ihre Schiffe Random per AI gesetzt haben oder Manuel?\n" +
                "Random: 1\n" +
                "Manuel: 2\n" +
                "Hier: ");
        Scanner RMentscheidung2 = new Scanner(System.in);
        String rmString2 = RMentscheidung2.nextLine();
        int rmInt2 = Integer.parseInt(rmString2);

        if (rmInt2 == 1) {
            try {
                for (int i = 1; i <= 12; i++) {
                    RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                    DerzeitigeSchiffslänge = schiff.getLaenge();
                    boolean stand = randomSchiffeSetzen(Feld_Spieler2, DerzeitigeSchiffslänge);

                    if (!stand) {
                        i -= 1;
                    }
                }
                Feld_Spieler2.toString();
            } catch (Exception ex) {
                throw ex;
            }


        } else {
            Feld_Spieler2.toString();
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                DerzeitigeSchiffslänge = schiff.getLaenge();
                derzeitigerSchiffSetzer(i, SchiffsMap);
                Feld_Spieler2.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
                Feld_Spieler2.toString();
            }
        }
        Feld_Spieler2.BereitAbfrage(Feld_Spieler2);

        return "";
    }
}
