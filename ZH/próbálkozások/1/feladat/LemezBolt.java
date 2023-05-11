import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LemezBolt {
    public Map<String, KonnyuzeneiAlbum> albumok;
    
    public LemezBolt(Map<String, KonnyuzeneiAlbum> albumok) {
        this.albumok = albumok;
    }

    public int lejatszas(int ido, KonnyuzeneiAlbum album) {
        return 0;
    }

    public int ujAlbumokFelvetele(List<Entry<String, KonnyuzeneiAlbum>> albumok) {
        return 0;
    }

    public boolean ujAlbum(String azonosito, KonnyuzeneiAlbum album) {
        return false;
    }

    public int legrovidebbSzamok() {
        return 0;
    }

    public void osszesKiado() {
        
    }
}
