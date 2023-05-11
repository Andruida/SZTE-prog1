package prog1.gyakorlo.cats.solution.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A tesztelendő osztályok megjelölésére használható annotáció.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Testable {
}
