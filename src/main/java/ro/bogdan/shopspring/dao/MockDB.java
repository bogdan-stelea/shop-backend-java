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

    public boolean addProduct(Product product) {
        // We test if the product is already in the list
        for (Product product1 : productList) {
            if (product1.getProductCode().equals(product.getProductCode())) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(int index) {
        if (index >= productList.size()) {
            return false;
        }
        productList.remove(index);
        return true;
    }

    public boolean removeProduct(String productCode) {
        // We test if there is a product with the assigned code
        for (int i = 0; i < productList.size(); i++) {
            if (productCode.equals(productList.get(i).getProductCode())) {
                productList.remove(i);
                return true;
            }
        }
        return false;
        //productList.removeIf(product -> product.getProductCode().equals(productCode));
    }
}
