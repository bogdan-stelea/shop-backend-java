package ro.bogdan.shopspring.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionCode;
    private String clientCode;
    private String productCode;
    private int productPrice;
    private int productQuantity;
    private int value;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    Transaction(String transactionCode, String clientCode, String productCode, int value, PaymentMethod paymentMethod) {
        this.transactionCode = transactionCode;
        this.clientCode = clientCode;
        this.productCode = productCode;
        this.value = value;
        this.paymentMethod = paymentMethod;
        this.date = LocalDateTime.now();
    }

    Transaction() {
        this.date = LocalDateTime.now();
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDateAsString() {
        return date.format(format);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionCode='" + transactionCode + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", value=" + value +
                ", paymentMethod=" + paymentMethod +
                ", date=" + getDateAsString() +
                '}';
    }
}
