public class Ember {
    protected String nev;
    protected int eletEro;

    public Ember(String nev, int eletEro) {
        this.nev = nev;
        this.eletEro = eletEro >= 0 ? eletEro : -eletEro;
    }

    public Ember() {
        this.nev = "ismeretlen";
        setEletEro(10);
    }

    public String getNev() {
        return nev;
    }

    public int getEletEro() {
        return eletEro;
    }

    public void setEletEro(int ujEletEro) {
        if (ujEletEro < 0) {
            ujEletEro = 0;
        }
        this.eletEro = ujEletEro;
    }

    public boolean vajonElMeg() {
        return eletEro > 0;
    }

    public void gyogyul(int mennyivel) {
        if (eletEro == 0) {
            System.err.println("Sajnalom, elkestetek.");
        } else {
            eletEro += mennyivel;
        }
    }    

    @Override
    public String toString() {
        String allapot = vajonElMeg() ? 
            this.getEletEro() > 10 ? 
                "majd kicsattan az egeszsegtol" : 
                "atlagos az allapota" :
            "halott";
        return "Emberunk neve " + nev + ", es jelenleg " + allapot + ".";
    }

}