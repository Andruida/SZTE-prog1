package prog1.gyakorlo.cats.solution.places.implementations;

import java.util.HashMap;
import java.util.Map;

import prog1.gyakorlo.cats.solution.Human;
import prog1.gyakorlo.cats.solution.exceptions.NotEnoughMoneyException;
import prog1.gyakorlo.cats.solution.exceptions.ProductNotAvailableException;
import prog1.gyakorlo.cats.solution.places.Supermarket;

/**
 * Egy lehetséges supermarket implementáció
 */
public class Spar implements Supermarket {
    /**
     * A Spar termékeinek tárolására szolgáló Map.
     * Kulcs: a termék neve
     * Érték: egy int tömb, amelynek első eleme a termék ára, a második eleme a mennyiség.
     */
    private Map<String, int[]> products;

    /**
     * A Spar alapértelmezett konstruktora.
     */
    public Spar() {
        products = new HashMap<String, int[]>();
    }

    @Override
    public void newProduct(String name, int amount) {
        if (!isProductAvailable(name)) {
            products.put(name, new int[] { 0, amount });
        } else {
            setAmount(name, getAmount(name) + amount);
        }
    }

    @Override
    public void sellProduct(String name, int amount, Human buyer) {
        if (!isProductAvailable(name)) {
            throw new ProductNotAvailableException();
        }
        
        int priceToPay = getPrice(name) * amount;

        if (getAmount(name) < amount) {
            throw new ProductNotAvailableException();
        }

        if (!buyer.hasEnoughMoney(priceToPay)) {
            throw new NotEnoughMoneyException();
        }

        setAmount(name, getAmount(name) - amount);;
        buyer.spendMoney(priceToPay);
            
    }

    @Override
    public void setPrice(String name, int price) {
        if (!isProductAvailable(name)) {
            throw new ProductNotAvailableException();
        }
        products.get(name)[0] = price;
    }

    @Override
    public boolean isProductAvailable(String name) {
        return products.containsKey(name);
    }

    @Override
    public int getPrice(String name) {
        if (!isProductAvailable(name)) {
            return 0;
        }
        return products.get(name)[0];
    }

    @Override
    public int getAmount(String name) {
        if (!isProductAvailable(name)) {
            return 0;
        }
        return products.get(name)[1];
    }

    /**
     * Beállítja egy adott termék mennyiségét.
     * @param name a termék neve
     * @param amount a termék új mennyisége
     */
    private void setAmount(String name, int amount) {
        if (!isProductAvailable(name)) {
            throw new ProductNotAvailableException();
        }
        products.get(name)[1] = amount;
    }

}
