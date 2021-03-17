package ro.bogdan.shopspring.models;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private Map<String, Product> products;
    private Map<String, Client> clients;
    private Map<String, Transaction> transactions;

    Shop() {
        this.products = new HashMap<>();
        this.clients = new HashMap<>();
        this.transactions = new HashMap<>();
    }

    public Map<String, Product> getProductList() {
        return products;
    }

    public Map<String, Client> getClientsList() {
        return clients;
    }

    public Map<String, Transaction> getTransactions() {
        return transactions;
    }

    public void addClient(Client client) {
        if (!clients.containsKey(client.getClientCode())) {
            this.clients.put(client.getClientCode(), client);
        } else {
            System.out.println("Client already exists");
        }
    }

    public void addProduct(Product product) {
        if (!products.containsKey(product.getProductCode())) {
            this.products.put(product.getProductCode(), product);
        } else {
            System.out.println("Product already exists");
        }
    }

    public void addTransaction(Transaction transaction) {
        if (!transactions.containsKey(transaction)) {
            this.transactions.put(transaction.getTransactionCode(), transaction);
        }
    }

    public void displayProducts() {
        for (Product product : this.getProductList().values()) {
            System.out.println(product);
        }
    }

    public void displayClients() {
        for (Client client : this.getClientsList().values()) {
            System.out.println(client);
        }
    }

    public void displayTransactions() {
        for (Transaction transaction : this.getTransactions().values()) {
            System.out.println(transaction);
        }
    }
}
