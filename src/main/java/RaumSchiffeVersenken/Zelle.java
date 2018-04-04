package RaumSchiffeVersenken;

public class Zelle {
    private boolean raumschiff = false;
    private int Status = 0;


    /**
     * @return Den Status
     */
    public int getStatus() {
        return Status;
    }

    public Zelle(boolean raumschiff, int status) {
        this.raumschiff = raumschiff;
        this.Status = status;
    }


    public boolean isRaumschiff() {
        return raumschiff;
    }

    public void setRaumschiff(boolean raumschiff) {
        this.raumschiff = raumschiff;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
