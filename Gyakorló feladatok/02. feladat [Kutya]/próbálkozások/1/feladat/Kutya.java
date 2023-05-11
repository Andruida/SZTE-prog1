import java.util.Arrays;

public class Kutya {
    public String nev;
    private String[] kedvencEtelek;
    private short ehseg;
    private long jokedv;

    public Kutya(String nev, String... kedvencEtelek) {
        this.nev = nev;
        this.kedvencEtelek = kedvencEtelek;
        ehseg = 0;
        jokedv = 0;
    }

    public Kutya(String nev) {
        this.nev = nev;
        this.kedvencEtelek = new String[]{"csirke", "sajt", "lazac"};
        ehseg = 0;
        jokedv = 0;
    }

    public static Kutya kutyaEtetes(Kutya elso, Kutya masodik, String etel) {

        boolean elsoSzereti = elso.szereti(etel);
        boolean masodikSzereti = masodik.szereti(etel);

        if (elsoSzereti && !masodikSzereti) {
            return elso;
        } else if (!elsoSzereti && masodikSzereti) { 
            return masodik;
        } else if (elsoSzereti && masodikSzereti) {
            double elsoKE = Math.sqrt((elso.ehseg / 2.0) * (elso.jokedv / 3.0));
            double masodikKE = Math.sqrt((masodik.ehseg / 2.0) * (masodik.jokedv / 3.0));
            return (elsoKE >= masodikKE) ? elso : masodik;
        } else {
            return null;
        }
    }

    public boolean szereti(String etel) {
        return Arrays.asList(kedvencEtelek).contains(etel.toLowerCase());
    }

    public void eszik(String etel) {
        if (szereti(etel)) {
            ehseg--;
            if (ehseg <= 0) {
                ehseg = 0;
                farokCsovalas();
            }
        } else {
            ehesenNez();
        }
    }

    public void ehesenNez() {
        ehseg++;
        System.out.println("Vau!");
    }

    public Kutya farokCsovalas() {
        jokedv++;
        return this;
    }

    public boolean odajon(String nev) {
        if (this.nev.equals(nev)) return true;
        if (this.nev.length() != nev.length()) return false;
        char[] kutyaNeve = this.nev.toCharArray();
        char[] hivoNeve = nev.toCharArray();

        int elteresek = 0;
        for (int i = 0; i < kutyaNeve.length; i++) {
            if (kutyaNeve[i] != hivoNeve[i]) {
                elteresek++;
            }
        }
        return elteresek <= 2;
    }
}
