package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Interface.RaumSchiff;

public class SpielSystemMain {
    public static void main(String[] args) {

        // Spieler 1 Spielfeld erstellt
        Feld Feld1 = new Feld(10, 10);

        //Spieler 2 Spielfeld erstellt
        Feld Feld2 = new Feld(10, 10);

        // Jäger erstellen 1 Lebenspunkt
        RaumSchiff Jaeger1 = SchiffFactory.getRaumschiff("1");

        // Fregatte Erstellen 2 Lebenspunkte
        RaumSchiff Fregatte1 = SchiffFactory.getRaumschiff("2");

        // Kreuzer erstellen 4 Lebenspunkte
        RaumSchiff Kreuzer1 = SchiffFactory.getRaumschiff("4");

        // Zerstörer erstellen 5 Lebenspunkte
        RaumSchiff Zerstörer1 = SchiffFactory.getRaumschiff("5");


        System.out.println(Feld1.toString());

        // TODO: 20.04.2018 Versuchen die 2. Map zu zeigen mit einem Fog of War




       /*for (int i = 0; i < 99; i++) {
            Feld1.zielenZumSchiessen();
            System.out.println("\n");
            System.out.println(Feld1.toString());

        }
        */
        // zweites Feld bla bla

        Feld2.zielenZumSchiessen();

        System.out.println("\n");
        System.out.println(Feld2.toString());


    }
}
