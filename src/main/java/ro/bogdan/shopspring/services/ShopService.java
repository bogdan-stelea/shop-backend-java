package ro.bogdan.shopspring.services;

import ro.bogdan.shopspring.dao.MockDB;
import ro.bogdan.shopspring.models.Product;

import java.util.List;

public class ShopService {

    private MockDB mockDB;

    public ShopService() {
        mockDB = new MockDB();
    }

    public List<Product> getProducts() {
        return mockDB.getProductList();
    }

    public Product getProduct(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            return null;
        }
        return mockDB.getProduct(productId);
    }

    public String addProduct(Product product) {
        if (product == null) {
            return "Invalid product";
        }
        String productValidation = validateProduct(product);
        if (!productValidation.equals("ok")) {
            return productValidation;
        }
        // We assume that the DB handles "Existing product validation"
        if (!mockDB.addProduct(product)) {
            return "Product already exists";
        }
        return "Product successfully added";
    }

    public String removeProduct(int index) {
        if (index < 0) {
            return "Invalid input";
        }
        // We assume that the DB handles "Array out of bounds validation"
        if (!mockDB.removeProduct(index)) {
            return "Index out of bounds";
        }
        return "Item removed successfully";
    }

    public String removeProduct(String productCode) {
        if (productCode == null || productCode.trim().isEmpty()) {
            return "Invalid product code";
        }
        // We assume that the DB handles "Nonexistent product"
        if (!mockDB.removeProduct(productCode)) {
            return "Item not found";
        }
        return "Item removed successfully";
    }

    private String validateProduct(Product product) {
        if (product.getProductCode() == null || product.getProductCode().trim().isEmpty()) {
            return "Product code invalid";
        }
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            return "Product name invalid";
        }
        if (product.getDescription() == null || product.getDescription().trim().isEmpty()) {
            return "Description invalid";
        }
        if (product.getPrice() <= 0) {
            return "Product price invalid";
        }
        if (product.getStock() < 0) {
            return "Stock invalid";
        }
        return "ok";
    }
}
