import java.util.ArrayList;
import java.util.List;

public class Telepules {
    public class Kerulet {
        private int lakosokSzama;
        private final String nev;

        private Kerulet(String nev, int lakokSzama) {
            this.nev = nev;
            this.lakosokSzama = lakokSzama;
        }

        @Override
        public String toString() {
            return nev + " (" + Telepules.this.nev+")";
        }

        public double lakokAranya() {
            return (double) lakosokSzama / getLakosokSzama();
        }

        public int getLakosokSzama() {
            return lakosokSzama;
        }

        public String getNev() {
            return nev;
        }

        public void setLakosokSzama(int ujErtek) {
            lakosokSzama = ujErtek;
        }
    }

    private String nev;
    private String email;
    private List<Kerulet> keruletek;
    private double terulet;
    
    public Telepules(String nev, double terulet) {
        Character firstChar = nev.charAt(0);
        if (Character.toUpperCase(firstChar) != firstChar) {
            throw new IllegalArgumentException("Hibas varosnev: "+nev);
        }
        this.nev = nev;
        setTerulet(terulet);
        keruletek = new ArrayList<>();
    }

    public String getNev() {
        return nev;
    }

    public double getTerulet() {
        return terulet;
    }

    public String getEmail() {
        return email;
    }

    public void setTerulet(double terulet) {
        if (terulet <= 0) {
            this.terulet = 1;
            return;
        }
        this.terulet = terulet;
    }

    public void emailFrissitese(String ujEmail) {
        int atCount = 0;
        for (int i = 0; i < ujEmail.length(); i++) {
            if (ujEmail.charAt(i) == '@') {
                atCount++;
            }
        }
        if (atCount != 1 || !ujEmail.startsWith("info") || !ujEmail.endsWith(".hu")) {
            throw new TelepuleskezeloException(this, "Hibas e-mail cim: "+ujEmail);
        }
        this.email = ujEmail;
    }

    public void ujKerulet(String nev, int lakosokSzama) {
        keruletek.add(new Kerulet(nev, lakosokSzama));
    }

    public void ujLakok(String kerulet, int lakokDb) {
        for (Kerulet k : keruletek) {
            if (k.getNev().toLowerCase().equals(kerulet.toLowerCase())) {
                k.setLakosokSzama(k.getLakosokSzama() + lakokDb);
                return;
            }
        }
        throw new TelepuleskezeloException(this, "Nem talalhato a megadott kerulet: "+kerulet);
    }

    public int getLakosokSzama() {
        int lakosokSzama = 0;
        for (Kerulet kerulet : keruletek) {
            lakosokSzama += kerulet.getLakosokSzama();
        }
        return lakosokSzama;
    }

    public double nepsuruseg() {
        return getLakosokSzama() / terulet;
    }
}
