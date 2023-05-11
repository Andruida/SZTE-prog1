import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LemezBolt {
    public Map<String, KonnyuzeneiAlbum> albumok;
    
    public LemezBolt(Map<String, KonnyuzeneiAlbum> albumok) {
        this.albumok = albumok;
    }

    public int lejatszas(int ido, KonnyuzeneiAlbum album) throws HangzasiKivetel {
        if (ido < album.getSzamokHossza().length) {
            throw new HangzasiKivetel("nem lejatszhato", ido);
        } else {
            return ido - album.getSzamokHossza().length;
        }
    }

    public int ujAlbumokFelvetele(List<Entry<String, KonnyuzeneiAlbum>> albumok) {
        int hozzaadva = 0;
        for (Entry<String,KonnyuzeneiAlbum> entry : albumok) {
            if (entry.getValue() == null) {
                continue;
            }
            if (this.albumok.containsKey(entry.getKey())) {
                continue;
            }
            this.albumok.put(entry.getKey(), entry.getValue());
            hozzaadva++;
        }
        return hozzaadva;
    }

    public boolean ujAlbum(String azonosito, KonnyuzeneiAlbum album) {
        if (this.albumok.containsKey(azonosito) &&
            this.albumok.get(azonosito) != album) {
                this.albumok.put(azonosito, album);
                return true;
        }
        return false;
    }

    public int legrovidebbSzamok() {
        int sum = 0;
        for (Entry<String, KonnyuzeneiAlbum> album : this.albumok.entrySet()) {
            sum += album.getValue().legrovidebbSzam();
        }
        return sum;
    }

    public void osszesKiado() {
        try (FileWriter fwr = new FileWriter("adat.txt")) {
            for (Entry<String, KonnyuzeneiAlbum> album : this.albumok.entrySet()) {
                fwr.write(album.getValue().getKiado()+";");
            }
        } catch (Exception e) {
        }
    }
}
