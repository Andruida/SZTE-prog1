public class HangzasiKivetel extends RuntimeException {
    public static int hibaSzam = 0;

    public HangzasiKivetel(String uzenet, int feltetel) {
        super((feltetel == 0) ? "NULLIDOS LEJATSZAS" : uzenet );
        hibaSzam++;
    }
}
