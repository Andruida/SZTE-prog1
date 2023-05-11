package prog1.gyakorlo.cats.solution.places.implementations;

import java.util.ArrayList;
import java.util.List;

import prog1.gyakorlo.cats.solution.Human;
import prog1.gyakorlo.cats.solution.animals.DomesticCat;
import prog1.gyakorlo.cats.solution.exceptions.NotEnoughMoneyException;
import prog1.gyakorlo.cats.solution.places.Garden;

public class CountrysideGarden implements Garden {
    
    /**
     * A kert tulajdonosa.
     */
    private Human owner;
    /** 
     * A kertben tartott macskák listája.
     */
    private List<DomesticCat> cats;

    /**
     * A kert alapértelmezett konstruktora.
     */
    public CountrysideGarden() {
        this.cats = new ArrayList<DomesticCat>();
    }

    @Override
    public Human ownerOfGarden() {
        return owner;
    }

    @Override
    public void buyGarden(Human newOwner, int cost) {
        if (newOwner.hasEnoughMoney(cost)) {
            newOwner.spendMoney(cost);
            if (owner != null)
                owner.spendMoney(-cost);
            owner = newOwner;
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    @Override
    public void newCat(String name, float weight, int age) {
        cats.add(new DomesticCat(name, weight, age));
    }

    @Override
    public DomesticCat[] catsOfGarden() {
        return cats.toArray(new DomesticCat[cats.size()]);
    }

    @Override
    public int numberOfCats() {
        return cats.size();
    }

    @Override
    public float catPercentage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'catPercentage'");
    }

}
