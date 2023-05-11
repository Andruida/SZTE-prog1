package prog1.kotprog.dontstarve.solution.inventory.items;

/**
 * A főtt bogyó item leírására szolgáló osztály.
 */
public class ItemCookedBerry extends EdibleItem {
    /**
     * Konstruktor, amellyel a tárgy létrehozható.
     *
     * @param amount az item mennyisége
     */
    public ItemCookedBerry(int amount) {
        super(ItemType.COOKED_BERRY, amount);
    }

    @Override
    public int getMaxStackAmount() {
        return 10;
    }

    @Override
    public ItemCookedBerry clone() {
        return new ItemCookedBerry(getAmount());
    }
}
