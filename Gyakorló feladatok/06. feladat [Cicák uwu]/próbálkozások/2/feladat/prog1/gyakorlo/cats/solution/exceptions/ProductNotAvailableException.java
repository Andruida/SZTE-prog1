package prog1.gyakorlo.cats.solution.exceptions;

/**
 * Kivétel osztály, amelyet a készleten kívüli termékek esetén dobunk.
 */
public class ProductNotAvailableException extends RuntimeException {
    /**
     * Default konstruktor, mellyel az objektum létrehozható.
     */
    public ProductNotAvailableException() {
        super("PRODUCT_NOT_AVAILABLE");
    }
}
