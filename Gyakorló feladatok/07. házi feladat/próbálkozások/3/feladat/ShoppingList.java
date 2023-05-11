import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<Product> items;

    public ShoppingList() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public int countProducts() {
        return items.size();
    }

    public Product getProduct(int index) {
        if (index < 0 || index >= items.size()) {
            return null;
        }
        return items.get(index);
    }

    public void delete(Product product) {
        items.remove(product);
    }

    public void printProducts() {
        for (Product product : items) {
            System.out.println(product.getName());
        }
    }

    public int deleteUnimportant() {
        int count = 0;
        for (int i = items.size()- 1; i >= 0; i--) {
            if (!items.get(i).isImportant()) {
                items.remove(i);
                count++;
            }
        }
        return count;
    }
}
