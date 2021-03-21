package ro.bogdan.shopspring.dao;

import ro.bogdan.shopspring.models.Client;
import ro.bogdan.shopspring.models.PaymentMethod;
import ro.bogdan.shopspring.models.Product;
import ro.bogdan.shopspring.models.Transaction;

import java.util.*;

public class MockDB {
    private Map<String, Product> productMap;
    private Map<String, Transaction> transactionMap;
    private Map<String, Client> clientMap;
    private Stack<String> transactionCodeStack;


    public MockDB() {
        productMap = new HashMap<>();
        transactionMap = new HashMap<>();
        clientMap = new HashMap<>();
        transactionCodeStack = new Stack<>();
        init();
    }

    public void init() {
        productMap.put("5B3raA", new Product("5B3raA", "Cui", "AREWQWEqeq", 5, 10, "https://us.123rf.com/450wm/coprid/coprid1903/coprid190300005/118914375-top-view-of-metal-open-end-wrench-isolated-on-white.jpg?ver=6"));
        productMap.put("1234AB", new Product("1234AB", "Cuw", "asdfQWET", 24, 25, "https://image.shutterstock.com/image-vector/pickaxe-illustration-symbol-money-graphic-260nw-1109559692.jpg"));
        productMap.put("123has", new Product("123has", "Cuw", "asdfQWET", 24, 25, "https://image.shutterstock.com/image-vector/pickaxe-illustration-symbol-money-graphic-260nw-1109559692.jpg"));
        productMap.put("8472SA", new Product("8472SA", "Cuw", "asdfQWET", 24, 25, "https://image.shutterstock.com/image-vector/pickaxe-illustration-symbol-money-graphic-260nw-1109559692.jpg"));

        clientMap.put("1234", new Client(new Client.PersonalData("IOBN", "GION", "5325123")));
        clientMap.put("2345", new Client(new Client.PersonalData("ter", "teaw", "1423467")));
        clientMap.put("3456", new Client(new Client.PersonalData("tsgdsa", "dgawer", "041241234")));

        for (int i = 10000; i > 0; i--) {
            transactionCodeStack.push(String.valueOf(i));
        }
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public Map<String, Client> getClientMap() {
        return clientMap;
    }

    public Product getProduct(String productId) {

        if (productMap.containsKey(productId)) {
            return productMap.get(productId);
        }

        return null;
    }

    public boolean addProduct(String productCode, Product product) {
        // We test if the product is already in the list

        if (productMap.containsKey(productCode)) {
            return false;
        }
        productMap.put(productCode, product);
        return true;
    }

    public boolean removeProduct(String productCode) {
        // We test if there is a product with the assigned code

        if (!productMap.containsKey(productCode)) {
            return false;
        }
        productMap.remove(productCode);
        return true;

    }

    public Map<String, Transaction> getTransactionMap() {
        return transactionMap;
    }

    public Transaction getTransaction(String transactionCode) {
        if (!transactionMap.containsKey(transactionCode)) {
            return null;
        }
        return transactionMap.get(transactionCode);
    }

    public boolean addTransaction(String productCode, String clientCode, int productQuantity, String paymentMethod) {
        Transaction transaction = new Transaction();
        // We test if there is a transaction with same code
        if (transactionCodeStack.isEmpty()) {
            return false;
        }
        transaction.setCode(transactionCodeStack.pop());
        transaction.setClientCode(clientCode);
        transaction.setProductCode(productCode);
        transaction.setProductPrice(productMap.get(productCode).getPrice());
        transaction.setProductQuantity(productQuantity);
        transaction.setValue(productQuantity * transaction.getProductPrice());
        transaction.setPaymentMethod(PaymentMethod.valueOf(paymentMethod));
        transactionMap.put(transaction.getCode(), transaction);
        return true;
    }
}
