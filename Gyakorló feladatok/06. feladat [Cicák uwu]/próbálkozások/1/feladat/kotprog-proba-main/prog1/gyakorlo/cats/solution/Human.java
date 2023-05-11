package prog1.gyakorlo.cats.solution;

import prog1.gyakorlo.cats.solution.exceptions.NotImplementedException;
import prog1.gyakorlo.cats.solution.places.Supermarket;


/**
 * Egy embert leíró osztály.
 */
public class Human {
    /**
     * Az ember neve.
     */
    private String name;
    /**
     * Az ember pénze.
     */
    private int money;
    /**
     * Az ember kedvenc boltja.
     */
    private Supermarket favouriteSupermarket;

    /**
     * Az ember által birtokolt macskaeledel mennyisége
     */
    private float catFoodAmount;

    /**
     * Az ember konstruktora.
     * @param name az ember neve
     * @param money az ember pénze
     * @param favouriteSupermarket az ember kedvenc boltja
     */
    public Human(String name, int money, Supermarket favouriteSupermarket) {
        this.name = name;
        this.money = money;
        this.favouriteSupermarket = favouriteSupermarket;
    }

    /**
     * Az ember nevének lekérdezésére szolgáló metódus.
     * @return az ember neve
     */
    public String getName() {
        return name;
    }

    /**
     * Az ember pénzének lekérdezésére szolgáló metódus.
     * @return az ember pénze
     */
    public int remainingMoney() {
        return money;
    }

    /**
     * Az ember pénzének ellenőrzésére szolgáló metódus.
     * @param amount az ellenőrizni kívánt összeg
     * @return igaz, ha van elég elkölthető pénze; hamis különben
     */
    public boolean hasEnoughMoney(int amount) {
        return money >= amount;
    }

    /**
     * Az ember pénzének költésére szolgáló metódus.
     * @param amount az elkölteni kívánt összeg
     * @return igaz, ha ez elköltendő összeg rendelkezésre állt; hamis különben
     */
    public boolean spendMoney(int amount) {
        if (!hasEnoughMoney(amount)) {
            return false;
        }
        money -= amount;
        return true;
    }

    /**
     * Azt a folyamatot jelképezi, hogy az ember macskaeledelt vásárol a kedvenc boltjában.
     * A boltban a macskaeledelt "Cat food"-nak hívják, tehát ebből szeretnénk megfelelő mennyiségnyit vásárolni.
     * Nyilván csak egész mennyiségű macskaeledel vásárolható.
     * Amennyiben nem lehetséges a teljes mennyiséget beszerezni (valamilyen oknál fogva), akkor nem veszünk semmit.
     * @param amount a vásárolni kívánt macskaeledel mennyisége
     * @return igaz, ha sikeres volt a vásárlás; hamis különben
     */
    public boolean buyFood(int amount) {
        if (favouriteSupermarket.getAmount("Cat food") < amount) {
            return false;
        }
        if (favouriteSupermarket.getPrice("Cat food") * amount < money) {
            return false;
        }
        favouriteSupermarket.sellProduct("Cat food", amount, this);
        catFoodAmount += amount;
        return true;
    }

    /**
     * Azt a folyamatot jelképezi, hogy az ember a saját kertjeiben megeteti a macskáit.
     * Az ember folyamatosan járja be a kertjeit (megvásárlásuk sorrendjében). A hamarabb megvásárolt kertben lévő
     * macskákat hamarabb eteti meg.
     * A macskák etetése a kertbe való csatlakozásuk sorrendjében történik, tehát a legrégebben a kertben lévő
     * macska etetése történik meg leghamarabb.
     * Amennyiben nincs elegendő macskaeledelünk egy macska megetetéséhez, akkor megpróbáljuk a boltban beszerezni a szükséges
     * mennyiséget (ne többet). Egy etetés alkalmával többször is el tud menni a boltba.
     * Természetesen a korábbi etetésekkor vásárolt macskaeledel is használható, illetve egy dobozból több macska is
     * megetethető.
     * Ha nem sikerül, akkor a macska etetése sikertelen. Ilyenkor a többi macska etetésével kell folytatnunk.
     */
    public void feedCats() {
        throw new NotImplementedException();
    }
}
