import java.util.HashMap;
import java.util.Map;

public class BestPriceFinder {
    private Map<String, String> bestBuys;

    public BestPriceFinder() {
        bestBuys = new HashMap<>();
    }

    public void addProduct(Product product, String shop) {
        bestBuys.put(product.getName(), shop);
    }

    public String getShopFor(String product) {
        return bestBuys.get(product);
    }

    public void printBestBuys() {
        for (String product : bestBuys.keySet()) {
            System.out.println("Buy " + product + "at " + bestBuys.get(product));
        }
    }

    public int deleteShop(String shop) {
        int count = 0;
        for (String product : bestBuys.keySet()) {
            if (bestBuys.get(product).equals(shop)) {
                bestBuys.remove(product);
                count++;
            }
        }
        return count;
    }
}
