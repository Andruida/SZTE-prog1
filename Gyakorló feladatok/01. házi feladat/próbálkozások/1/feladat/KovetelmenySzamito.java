public class KovetelmenySzamito {
    public static String teljesites(double zh1, double zh2, double zh3, double nagyzh, double kotprog, int hazi) {
        if (zh1+zh2+zh3 >= 10 && nagyzh >= 17 && kotprog >= 7 && hazi >= 6 && zh1+zh2+zh3+nagyzh+kotprog >= 50) {
            return "sikeres";
        } else if (zh1+zh2+zh3 >= 10 && kotprog >= 7 && hazi >= 6) {
            return "javito";
        } else {
            return "sikertelen";
        }
    }
}