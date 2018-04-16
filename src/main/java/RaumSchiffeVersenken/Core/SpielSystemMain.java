package RaumSchiffeVersenken.Core;

public class SpielSystemMain {
    public static void main(String[] args) {
        Feld Feld1 = new Feld(10, 10);
        System.out.println(Feld1.toString());
        System.out.println("Test");

       /*for (int i = 0; i < 99; i++) {
            Feld1.zielenZumSchiessen();
            System.out.println("\n");
            System.out.println(Feld1.toString());

        }
        */


        // zweites Feld bla bla
        Feld Feld2 = new Feld(10, 10);

        Feld2.zielenZumSchiessen();

        System.out.println("\n");
        System.out.println(Feld2.toString());
    }
}
