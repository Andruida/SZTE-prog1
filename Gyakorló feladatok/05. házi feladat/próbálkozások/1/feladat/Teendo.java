public class Teendo {
    private String nev;
    private String ido;
    private int prioritas;
    private boolean teljesitettuk;

    public Teendo() {
        this("Nincs megadva", "Nincs megadva", 0);
    }
    
    public Teendo(String nev, String ido, int prioritas) {
        setNev(nev);
        setIdo(ido);
        setPrioritas(prioritas);
        this.teljesitettuk = false;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getIdo() {
        return ido;
    }

    public void setIdo(String ido) {
        this.ido = ido;
    }

    public int getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(int prioritas) {
        if (prioritas < 1 || prioritas > 5) {
            this.prioritas = 5;
            System.err.println("Hibas prioritas, 5-re allitva");
        } else {
            this.prioritas = prioritas;
        }
    }

    public boolean isTeljesitettuk() {
        return teljesitettuk;
    }

    public void atvalt() {
        this.teljesitettuk = !this.teljesitettuk;
    }

    @Override
    public String toString() {
        return "Teendo neve: "+nev+", ideje: "+ido+", prioritasa: "+prioritas+", teljesitettuk: " + (teljesitettuk ? "igen":"nem");
    }

    public Teendo legfontosabb(Teendo[] teendok) {
        if (teendok.length == 0) {
            return null;
        }
        Teendo legfontosabb = teendok[0];
        for (int i = 1; i < teendok.length; i++) {
            if (teendok[i].getPrioritas() == 1) {
                return teendok[i];
            }
            if (teendok[i].getPrioritas() < legfontosabb.getPrioritas()) {
                legfontosabb = teendok[i];
            }
        }
        return legfontosabb;
    }
}