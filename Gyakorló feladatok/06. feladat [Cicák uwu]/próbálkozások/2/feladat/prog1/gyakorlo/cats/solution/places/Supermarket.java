package prog1.gyakorlo.cats.solution.places;

import prog1.gyakorlo.cats.solution.Human;

/**
 * Egy boltot leíró interface.
 */
public interface Supermarket {
    /**
     * Ezen metódus jelképezi egy adott termék beszerzését. Hatására a megadott nevű termékből adott mennyiségnyi kerül a bolt polcaira.
     * Ha a termék még korábban SOHA nem szerepelt a bolt kínálatában,
     * akkor az ára 0 és nem vásárolható egészen addig, amíg egy pozitív árat nem adnak neki a bolt dolgozói.
     * @param name a termék neve
     * @param amount a termék mennyisége
     */
    void newProduct(String name, int amount);

    /**
     * Ezen metódus jelképezi egy adott termék (vásárló számára történő) eladását.
     * Hatására a termékből megadott mennyiségnyi eltűnik a bolt polcairól, amelynek árát nyilván a vásárló fizeti ki.
     * A metódus egy saját típusú kivételt dob a "PRODUCT NOT AVAILABLE" hibaüzenettel, amennyiben a termékből nincs elegendő mennyiség a boltban.
     * A metódus egy saját típusú kivételt dob a "NOT ENOUGH MONEY" hibaüzenettel,
     * amennyiben a vásárlónak nincs elég pénze a megadott mennyiségű termék megvásárlásához.
     * @param name a termék neve
     * @param amount a termék mennyisége
     * @param buyer a terméket megvásárolni kívánó vevő
     */
    void sellProduct(String name, int amount, Human buyer);

    /**
     * Egy termék árának módosítása a paraméterben érkező értékre.
     * @param name a termék neve
     * @param price a termék új ára
     */
    void setPrice(String name, int price);

    /**
     * Ezen metódus segítségével lekérdezhető, hogy egy adott termékből van-e a raktáron (legalább 1 db).
     * @param name a termék neve
     * @return igaz, amennyiben a boltban van a megadott termék raktáron; hamis egyébként
     */
    boolean isProductAvailable(String name);

    /**
     * Ezen metódus segítségével lekérdezhető, hogy egy adott terméknek az ára.
     * @param name a termék neve
     * @return a termék egységára. Ha nem árulnak ilyen terméket a boltban, akkor 0.
     */
    int getPrice(String name);

    /**
     * Ezen metódus segítségével lekérdezhető, hogy egy adott termékből hány darab áll rendelkezésre a boltban.
     * @param name a termék neve
     * @return a termékből raktáron lévő mennyiség. Ha nem árulnak ilyen terméket a boltban, akkor 0.
     */
    int getAmount(String name);
}
