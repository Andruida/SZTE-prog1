package prog1.kotprog.dontstarve.solution.character.actions;

import prog1.kotprog.dontstarve.solution.character.MutableCharacter;
import prog1.kotprog.dontstarve.solution.inventory.BaseInventory;
import prog1.kotprog.dontstarve.solution.inventory.items.AbstractItem;
import prog1.kotprog.dontstarve.solution.inventory.items.CookableItem;
import prog1.kotprog.dontstarve.solution.inventory.items.EdibleItem;

/**
 * A főzés akció leírására szolgáló osztály: egy item megfőzése.
 */
public class ActionCook extends Action {
    /**
     * A megfőzni kívánt tárgy pozíciója az inventory-ban.
     */
    private final int index;

    /**
     * Az akció létrehozására szolgáló konstruktor.
     *
     * @param index a megfőzni kívánt tárgy pozíciója az inventory-ban
     */
    public ActionCook(int index) {
        super(ActionType.COOK);
        this.index = index;
    }

    /**
     * Az index gettere.
     * 
     * @return a megfőzni kívánt tárgy pozíciója az inventory-ban
     */
    public int getIndex() {
        return index;
    }

    @Override
    public void execute(MutableCharacter executor) {
        BaseInventory inventory = executor.getInventory();
        AbstractItem item = inventory.getItem(index);
        if (item == null || !(item instanceof CookableItem)) {
            super.execute(executor);
            return;
        }
        inventory.cookItem(index);
        EdibleItem cookedItem = ((CookableItem)item).cook();
        cookedItem.setAmount(1);
        inventory.addItem(cookedItem);
        super.execute(executor);
    }
}
