public class HangzasiKivetel extends Exception {
    public static int hibaSzam = 0;

    public HangzasiKivetel(String uzenet, int feltetel) {
        super((feltetel == 0) ? "NULLIDOS LEJATSZAS" : uzenet );
        hibaSzam++;
    }
}
