import java.util.Random;

public class RandomNamer implements Namer {
    private int length;
    private Random rnd;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    public RandomNamer(Random rnd, int length) {
        this.length = length;
        this.rnd = rnd;
    }

    public void rename(FileSystemEntry entry) {
        String newName = "";
        for (int i = 0; i < length; i++) {
            newName += ALPHABET.charAt(rnd.nextInt(ALPHABET.length()));
        }
        entry.setName(newName);
    }
}
