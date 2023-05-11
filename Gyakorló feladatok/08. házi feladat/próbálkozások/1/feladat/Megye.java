import java.util.ArrayList;
import java.util.List;

public class Megye {
    private String nev;
    private String web;
    private List<Telepules> telepulesek;

    public Megye(String nev) {
        this.nev = nev;
        telepulesek = new ArrayList<>();
        web = "";
    }

    public boolean ujTelepules(String telepulesSzoveg) {
        String[] adatok = telepulesSzoveg.split(":");
        if (adatok.length != 3) {
            return false;
        }
        try {
            String telepules = adatok[0];
            double terulet = Double.parseDouble(adatok[1]);
            String email = adatok[2];
            Telepules ujTelepules = new Telepules(telepules, terulet);
            ujTelepules.emailFrissitese(email);
            telepulesek.add(ujTelepules);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (TelepuleskezeloException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return nev+  " megye (" + web + ")";
    }

    public void ujLakok(int meelyikVaros, String kerulet, int lakokDb) {
        try {
            telepulesek.get(meelyikVaros).ujLakok(kerulet, lakokDb);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Nem letezik a megadott indexu varos!");
        } catch (TelepuleskezeloException e) {
            throw new IllegalArgumentException(e.getOkozo().getNev() + "varosban nem letezik a megadott kerulet!", e);
        }

    }

    public void webcimFrissites(String web) {
        String web_ = web.toLowerCase();
        if (!web_.contains(nev.toLowerCase())) {
            throw new IllegalArgumentException("Hibas webcim: "+web);
        }
        this.web = web;
    }

    public int keres(String mire) {
        int hits = 0;
        for (Telepules telepules : telepulesek) {
            if (telepules.getNev().toLowerCase().contains(mire.toLowerCase())) {
                hits++;
            }
        }
        return hits;
    }

    public int lakossag() {
        int sum = 0;
        for (Telepules telepules : telepulesek) {
            sum += telepules.getLakosokSzama();
        }
        return sum;
    }




}
