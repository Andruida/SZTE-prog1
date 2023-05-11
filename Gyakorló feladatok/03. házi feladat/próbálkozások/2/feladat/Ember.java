public class Ember {
    protected String nev;
    protected int EletEro;

    public Ember(String nev, int eletEro) {
        this.nev = nev;
        this.EletEro = eletEro >= 0 ? eletEro : -eletEro;
    }

    public Ember() {
        this.nev = "ismeretlen";
        setEletEro(10);
    }

    public String getNev() {
        return nev;
    }

    public int getEletEro() {
        return EletEro;
    }

    public void setEletEro(int ujEletEro) {
        if (ujEletEro < 0) {
            ujEletEro = 0;
        }
        this.EletEro = ujEletEro;
    }

    public boolean vajonElMeg() {
        return EletEro > 0;
    }

    public void gyogyul(int mennyivel) {
        if (EletEro == 0) {
            System.err.println("Sajnalom, elkestetek.\n");
        } else {
            EletEro += mennyivel;
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