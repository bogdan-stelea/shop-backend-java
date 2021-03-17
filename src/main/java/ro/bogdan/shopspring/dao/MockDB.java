package ro.bogdan.shopspring.dao;

import ro.bogdan.shopspring.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockDB {

    private List<Product> productList;

    public MockDB() {
        productList = new ArrayList<>();
        init();
    }

    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product("5B3raA", 5, "Cui", "AREWQWEqeq", 10),
                new Product("1234AB", 24, "Cuw", "asdfQWET", 25)
        ));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(String productId) {
        for (Product product : productList) {
            if (product.getProductCode().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    public void removeProduct(String productCode) {
        productList.removeIf(product -> product.getProductCode().equals(productCode));
    }
}
