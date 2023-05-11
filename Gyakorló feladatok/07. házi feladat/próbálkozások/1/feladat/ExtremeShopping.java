import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtremeShopping {
    private Map<String, List<Product>> extremeList;

    public ExtremeShopping() {
        extremeList = new HashMap<>();
    }

    public void addShoppingList(String shop, List<Product> productList) {
        extremeList.put(shop, productList);
    }

    public void printShoppingLists() {
        for (String shop : extremeList.keySet()) {
            System.out.println(shop);
            String prefix = "";
            for (Product product : extremeList.get(shop)) {
                System.out.print(prefix + product);
                prefix = " ";
            }
            System.out.println();
        }
    }
}
