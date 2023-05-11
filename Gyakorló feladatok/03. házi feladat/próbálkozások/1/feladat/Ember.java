public class Ember {
    protected String nev;
    protected int eletero;

    public Ember(String nev, int eletEro) {
        this.nev = nev;
        this.eletero = eletEro >= 0 ? eletEro : -eletEro;
    }

    public Ember() {
        this.nev = "ismeretlen";
        setEletEro(10);
    }

    public String getNev() {
        return nev;
    }

    public int getEletEro() {
        return eletero;
    }

    public void setEletEro(int ujEletEro) {
        if (ujEletEro < 0) {
            ujEletEro = 0;
        }
        this.eletero = ujEletEro;
    }

    public boolean vajonElMeg() {
        return eletero > 0;
    }

    public void gyogyul(int mennyivel) {
        if (eletero == 0) {
            System.err.println("Sajnalom, elkestetek.\n");
        } else {
            eletero += mennyivel;
        }
    }    

    @Override
    public String toString() {
        String allapot = vajonElMeg() ? 
            this.getEletEro() > 10 ? 
                "majd kicsattan az egészségtől" : 
                "atlagos az allapota" :
            "halott";
        return "Emberunk neve " + nev + ", es jelenleg " + allapot + ".";
    }

}