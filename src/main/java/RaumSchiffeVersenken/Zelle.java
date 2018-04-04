package RaumSchiffeVersenken;

public class Zelle {
    private int Status = 0;
/**
 * 0 = Wasser
 * 1 = MissTreffer
 * 2 = Schiff
 * 3 = Treffer
 *
 * Schiff setzen auf eine Zelle ist +2
 * und Angriff ist +1
 */

    /**
     * @return Den Status
     */
    public int getStatus() {
        return Status;
    }


    public Zelle(int status) {
        this.Status = status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
