public class Bevasarlas extends Teendo {
    private String miket;
    private int maxOsszeg;

    public Bevasarlas(String ido, String miket, int maxOsszeg) {
        super("Bevasarlas", ido, 3);
        super.setPrioritas(3);
        this.miket = miket;
        this.maxOsszeg = maxOsszeg;
    }

    public String getMiket() {
        return miket;
    }

    public void setMiket(String miket) {
        this.miket = miket;
    }

    public int getMaxOsszeg() {
        return maxOsszeg;
    }

    public void setMaxOsszeg(int maxOsszeg) {
        this.maxOsszeg = maxOsszeg;
    }

    public void frissit(String miket) {
        if (miket == "<torol>") {
            this.miket = "";
            this.maxOsszeg = 0;
            return;
        }
        this.miket += ", "+miket;
        this.maxOsszeg += 1000;
    }

    @Override
    public String toString() {
        return "Bevasarlas. Termekek: "+miket+", tervezett osszeg: "+maxOsszeg+" Ft";
    }

    @Override
    public void setPrioritas(int prioritas) {
        // this.prioritas = prioritas;
    }
}
