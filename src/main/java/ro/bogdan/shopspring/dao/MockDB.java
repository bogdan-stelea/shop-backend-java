package ro.bogdan.shopspring.dao;

import ro.bogdan.shopspring.models.Client;
import ro.bogdan.shopspring.models.PaymentMethod;
import ro.bogdan.shopspring.models.Product;
import ro.bogdan.shopspring.models.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MockDB {
    private List<Product> productList;
    private List<Transaction> transactionList;
    private List<Client> clientList;


    public MockDB() {
        productList = new ArrayList<>();
        transactionList = new ArrayList<>();
        init();
    }

    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product("5B3raA", 5, "Cui", "AREWQWEqeq", 10, "https://us.123rf.com/450wm/coprid/coprid1903/coprid190300005/118914375-top-view-of-metal-open-end-wrench-isolated-on-white.jpg?ver=6"),
                new Product("1234AB", 24, "Cuw", "asdfQWET", 25, "https://image.shutterstock.com/image-vector/pickaxe-illustration-symbol-money-graphic-260nw-1109559692.jpg"),
                new Product("123has", 24, "Cuw", "asdfQWET", 25, "https://image.shutterstock.com/image-vector/pickaxe-illustration-symbol-money-graphic-260nw-1109559692.jpg"),
                new Product("8472SA", 24, "Cuw", "asdfQWET", 25, "https://image.shutterstock.com/image-vector/pickaxe-illustration-symbol-money-graphic-260nw-1109559692.jpg")
        ));
        clientList = new ArrayList<>(Arrays.asList(
                new Client("1234", new Client.PersonalData("IOBN", "GION", "5325123")),
                new Client("2345", new Client.PersonalData("ter", "teaw", "1423467")),
                new Client("3456", new Client.PersonalData("tsgdsa", "dgawer", "041241234"))
        ));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(String productId) {
        for (Product product : productList) {
            if (product.getCode().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public boolean addProduct(Product product) {
        // We test if the product is already in the list
        for (Product product1 : productList) {
            if (product1.getCode().equals(product.getCode())) {
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
            if (productCode.equals(productList.get(i).getCode())) {
                productList.remove(i);
                return true;
            }
        }
        return false;
        //productList.removeIf(product -> product.getProductCode().equals(productCode));
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public Transaction getTransaction(String transactionCode) {
        for (Transaction transaction : transactionList) {
            if (transaction.getCode().equals(transactionCode)) {
                return transaction;
            }
        }
        return null;
    }

    public boolean addTransaction(String productCode, String clientCode, int productQuantity, String paymentMethod) {
        boolean productCodeValidation = false;
        boolean clientCodeValidation = false;
        boolean productQuantityValidation = false;
        PaymentMethod paymentMethodChanged;
        Product chosenProduct = new Product();
        Client chosenClient = new Client();

        for (Product product : productList) {
            if (product.getCode().equals(productCode)) {
                if (product.getStock() >= productQuantity) {
                    productQuantityValidation = true;
                } else {
                    return false;
                }
                productCodeValidation = true;
                chosenProduct = product;
                break;
            }
        }

        if (!productCodeValidation) {
            return false;
        }

        for (Client client : clientList) {
            if (client.getClientCode().equals(clientCode)) {
                clientCodeValidation = true;
                chosenClient = client;
                break;
            }
        }

        if (!clientCodeValidation) {
            return false;
        }

        if (paymentMethod.equals("CARD")) {
            paymentMethodChanged = PaymentMethod.CARD;
        } else {
            paymentMethodChanged = PaymentMethod.CASH;
        }

        Transaction newTransaction = new Transaction(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)), chosenClient.getClientCode(), chosenProduct.getCode(), chosenProduct.getPrice() * productQuantity, paymentMethodChanged);
        transactionList.add(newTransaction);
        return true;
    }
}
