package prog1.gyakorlo.cats.solution.animals;

import prog1.gyakorlo.cats.solution.exceptions.NotImplementedException;
import prog1.gyakorlo.cats.solution.places.Garden;

/**
 * Egy macskát leíró osztály.
 */
public class DomesticCat {
    private String name;
    private float weight;
    private int age;
    private Garden garden;

    /**
     * Az osztály 3 paraméteres konstruktora.
     * @param name a macska neve
     * @param weight a macska tömege (kg)
     * @param age a macska életkora (év)
     */
    public DomesticCat(String name, float weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;        
    }

    /**
     * Az osztály 4 paraméteres konstruktora.
     * @param name a macska neve
     * @param weight a macska tömege (kg)
     * @param age a macska életkora (év)
     * @param garden a macska otthonát képző kert (vagy null, ha az utcán lakik)
     */
    public DomesticCat(String name, float weight, int age, Garden garden) {
        this(name, weight, age);
        this.garden = garden;
    }

    /**
     * Megadja, hogy a macskának naponta mennyi ételre van szüksége.
     * A macska ételszükségletét úgy kapjuk meg, hogy a tömegének gyökét és a korának gyökét összeszorozzuk egymással,
     * majd ezt az egészet elosztjuk 12-vel.
     * @return a macskának szükséges étel mennyisége
     */
    public float foodRequirement() {
        return (float)(Math.sqrt(weight) * Math.sqrt(age) / 12);
    }

    /**
     * Megadja, hogy a macska boldog-e.
     * Egy macska akkor válik boldogtalanná, ha legalább annyi egymást követő alkalommal nem kapott enni, ahány éves.
     * @return igaz, ha a macska boldog; hamis egyébként
     */
    public boolean isHappy() {
        throw new NotImplementedException();
    }

    /**
     * A macskák szaporodását jelképező függvény, amely hatására egy új macska születik.
     * Két macskától csak akkor születhet új macska, ha az életkoruk megegyezik, illetve ugyanabban a kertben laknak.
     * Az újszülött kiscica neve úgy alakul ki, hogy a két macska nevét kötőjellel elválasztjuk (pl. Anita és Sanyi --> Anita-Sanyi).
     * Ha az egyik macska nevében kötőjel van, akkor csak a kötőjel előtti részt vesszük figyelembe
     * (pl. Anita-Sanyi és Gábor-Evelin --> Anita-Gábor).
     * Mindig az aktuális macska adja a kiscica nevének első részét.
     * A kiscica tömege a szülei tömegének összegének nyolcada lesz.
     * A kiscica lakhelye (kert) megegyezik a szülei lakhelyével.
     * @param with a másik macska, akitől a kiscica születik
     * @return a most született kiscica (vagy null)
     */
    public DomesticCat makeKitten(DomesticCat with) {
        if (this.age != with.age || this.garden != with.garden) {
            return null;
        }
        String newName = this.name.split("-")[0] + "-" + with.name.split("-")[0];
        return new DomesticCat(newName, (this.weight + with.weight)/8, 0, garden);
    }

    /**
     * toString metódus, amelynek segítségével a macska objektum szöveggé alakítható.
     * @return az objektum stringgé konvertálva: a macska neve, tömege és életkora egy-egy pontosvesszővel elválasztva (pl. "Sanyi;4.2;3")
     */
    @Override
    public String toString() {
        return name + ";" + weight + ";" + age;
    }
}

