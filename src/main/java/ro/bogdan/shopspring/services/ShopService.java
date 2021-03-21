package ro.bogdan.shopspring.services;

import ro.bogdan.shopspring.dao.MockDB;
import ro.bogdan.shopspring.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopService {

    private final MockDB mockDB;

    public ShopService() {
        mockDB = new MockDB();
    }

    public Map<String, Product> getProducts() {
        return mockDB.getProductMap();
    }

    public List<Product> getProductsList() {
        return new ArrayList<>(mockDB.getProductMap().values());
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
        if (!mockDB.addProduct(product.getCode(), product)) {
            return "Product already exists";
        }
        return "Product successfully added";
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

    public String addTransaction(TransactionRequest transactionRequest) {
        String transactionValidation = validateTransactionRequest(transactionRequest);
        if (!transactionValidation.equals("ok")) {
            return transactionValidation;
        }
        mockDB.addTransaction(transactionRequest.getProductCode(), transactionRequest.getClientCode(), transactionRequest.getProductQuantity(), transactionRequest.getPaymentMethod());
        mockDB.getProduct(transactionRequest.getProductCode()).setStock(mockDB.getProduct(transactionRequest.getProductCode()).getStock() - transactionRequest.getProductQuantity());
        return "Successful transaction";
    }

    private String validateProduct(Product product) {
        if (product.getCode() == null || product.getCode().trim().isEmpty()) {
            return "Product code invalid";
        }
        if (product.getName() == null || product.getName().trim().isEmpty()) {
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

    private String validateTransactionRequest(TransactionRequest transactionRequest) {
        if (transactionRequest.getProductCode() == null || transactionRequest.getProductCode().trim().isEmpty() || transactionRequest.getClientCode() == null != transactionRequest.getClientCode().trim().isEmpty()) {
            return "Invalid transaction parameters";
        }
        if (transactionRequest.getProductQuantity() <= 0) {
            return "Invalid product quantity";
        }
        if (!transactionRequest.getPaymentMethod().equals(PaymentMethod.CARD.toString()) && !transactionRequest.getPaymentMethod().equals(PaymentMethod.CASH.toString())) {
            return "Invalid payment method";
        }
        if (!mockDB.getProductMap().containsKey(transactionRequest.getProductCode())) {
            return "Invalid product code";
        }
        if (!mockDB.getClientMap().containsKey(transactionRequest.getClientCode())) {
            return "Invalid client code";
        }
        if (mockDB.getProduct(transactionRequest.getProductCode()).getStock() < transactionRequest.getProductQuantity()) {
            return "Out of stock";
        }
        return "ok";
    }
}
