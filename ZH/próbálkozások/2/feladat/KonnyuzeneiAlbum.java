public class KonnyuzeneiAlbum extends Album {
    public int[] szamokHossza;

    public KonnyuzeneiAlbum() {
        super(0, "nincs kiado");
        szamokHossza = new int[24];
    }

    public KonnyuzeneiAlbum(float bevetel, String kiado, int[] szamokHossza) {
        super(Math.max(szamokHossza.length*8, bevetel), kiado);
        this.szamokHossza = new int[szamokHossza.length];
        for (int i = 0; i < szamokHossza.length; i++) {
            this.szamokHossza[i] = szamokHossza[i];
        }
    }

    public int[] getSzamokHossza() {
        return szamokHossza;
    }

    public void setSzamokHossza(int[] szamokHossza) {
        this.szamokHossza = szamokHossza;
    }

    public int legrovidebbSzam() {
        int legrovidebb = Integer.MAX_VALUE;
        for (int hossz : szamokHossza) {
            if (legrovidebb > hossz) {
                legrovidebb = hossz;
            }
        }
        return legrovidebb;
    }

    public void szponzorKereses() {
        if (bevetel > 1000) {
            System.out.println(getKiado()+" szponzort keres egy kivalo albumhoz.");
        } else {
            System.err.println(getKiado()+" nem tud szponzort talalni.");
        }
    }

    @Override
    public String toString() {
        if (bevetel > 0) {
            return "A "+getKiado()+" kiado altal kiadott sikeres album.";
        } else {
            return "A "+getKiado()+" kiado altal kiadott mersekelten sikeres album.";
        }
    }


    
}
