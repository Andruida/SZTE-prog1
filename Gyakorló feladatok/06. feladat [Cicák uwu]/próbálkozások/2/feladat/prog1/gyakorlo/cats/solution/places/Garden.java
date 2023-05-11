package prog1.gyakorlo.cats.solution.places;

import prog1.gyakorlo.cats.solution.Human;
import prog1.gyakorlo.cats.solution.animals.DomesticCat;

/**
 * Egy kertet leíró interface.
 */
public interface Garden {
    /**
     * Ezen metódus segítségével lekérdezhető a kert tulajdonosa.
     * Egy kertnek mindig legfeljebb egy tulajdonosa van.
     * @return a kert tulajdonosa (ha van), különben null
     */
    Human ownerOfGarden();

    /**
     * Ezen metódus azt az eseményt írja le, amikor egy ember megvásárolja a kertet a korábbi tulajdonostól.
     * Ha a kertnek nem volt korábban tulajdonosa, akkor az állam jelképezi az eladót.
     * A paraméterben kapott ember lesz a kert új tulajdonosa.
     * @param newOwner a kert új tulajdonosa
     * @param cost a kert ára, amit a vásárló kifizet az eladó számára
     */
    void buyGarden(Human newOwner, int cost);

    /**
     * Egy új macska érkezése a kertbe. Mostantól kezdve ez a macska is a kertben fog lakni.
     * @param name a macska neve
     * @param weight a macska tömege (kg)
     * @param age a macska életkora (év)
     */
    void newCat(String name, float weight, int age);

    /**
     * Ezen metódus segítségével lekérdezhetőek a kertben lévő macskák.
     * @return egy tömb, amely a kertben lévő macskákat tartalmazza, érkezés szerinti sorrendben
     * (hamarabb érkező van elölrébb a tömbben)
     */
    DomesticCat[] catsOfGarden();

    /**
     * Ezen metódus segítségével lekérdezhető, hogy hány macska van a kertben.
     * @return a kertben lévő macskák darabszáma
     */
    int numberOfCats();

    /**
     * A metódus visszaadja, hogy a kert tulajdonosának összes macskája közül hány macska található az aktuális kertben.
     * @return a kiszámított érték (százalékban)
     */
    float catPercentage();
}
