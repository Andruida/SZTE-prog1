import java.util.ArrayList;
import java.util.List;

public class BluesAlbum extends KonnyuzeneiAlbum {
    public List<String> eloadok;

    public BluesAlbum(float bevetel, String kiado, int[] szamokHossza, List<String> eloadok) {
        super(bevetel, kiado, szamokHossza);
        this.eloadok = new ArrayList<>();
        for (String ea : eloadok) {
            this.eloadok.add(ea);
        }
    }

    public boolean duplaSzam(String eloado) {
        if (eloadok.contains(eloado)) {
            eloadok.add(eloado+"(uj szam)");
            return true;
        }
        return false;
    }

    public void setBevetel(float bevetel) {
        if (bevetel < szamokHossza.length*20) {
            super.setBevetel(szamokHossza.length*20);
        } else {
            super.setBevetel(bevetel);
        }
        if (bevetel == 2001) {
            this.bevetel = 2000;
        }
    }

    public boolean eloadokFelvetele(String eloado) {
        if (eloadok.contains(eloado)) {
            return false;
        }
        eloadok.add(eloado);
        return true;
    }

    public void szponzorKereses() {
        if (bevetel > 2000) {
            bevetel = 2000;
        }
        super.szponzorKereses();
    }

}