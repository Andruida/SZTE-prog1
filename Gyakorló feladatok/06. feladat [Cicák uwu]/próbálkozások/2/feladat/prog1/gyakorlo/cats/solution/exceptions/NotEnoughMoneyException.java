package prog1.gyakorlo.cats.solution.exceptions;

/**
 * Kivétel osztály, amelyet nem elegendő pénz esetén dobunk.
 */
public class NotEnoughMoneyException extends RuntimeException {
    /** 
     * Default konstruktor, mellyel az objektum létrehozható.
     */
    public NotEnoughMoneyException() {
        super("NOT ENOUGH MONEY");
    }
}
