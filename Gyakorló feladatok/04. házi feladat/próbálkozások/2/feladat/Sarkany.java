public class Sarkany {
    private int eletero;
    private boolean ehes;

    public Sarkany() {
        eletero = 100;
        ehes = true;
    }

    public Sarkany(int eletero, boolean ehes) {
        setEletero(eletero);
        setEhes(ehes);
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        if (eletero < 0)
            this.eletero = 0;
        else
            this.eletero = eletero;
    }

    public boolean isEhes() {
        return ehes;
    }

    public void setEhes(boolean ehes) {
        if (eletero < 50) {
            this.ehes = true;
            return;
        }
        this.ehes = ehes;
    }

    @Override
    public String toString() {
        return "A sarkany eletereje "+
                eletero+
                ", es jelenleg "+
                (ehes ? "rettenetesen" : "veletlenul nem")+
                " ehes.";
    }

    public boolean vajonElMeg() {
        return eletero > 0;
    }

    public void eszik(int etel) {
        if (etel <= 0) {
            System.err.println("en a helyedben nem eheztetnek egy sarkanyt");
            return;
        }
        eletero += etel;

    }

    public int harcol(int[] ellenfelek) {
        if (!ehes) return 0;
        int legyozve = 0;
        for (int e:
             ellenfelek) {
            this.eletero -= e / 2;
            if (this.vajonElMeg()) {
                legyozve++;
            } else {
                break;
            }
        }
        return legyozve;
    }
}