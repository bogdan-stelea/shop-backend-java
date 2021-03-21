package ro.bogdan.shopspring.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Transaction {
    private String code;
    private String clientCode;
    private String productCode;
    private double productPrice;
    private int productQuantity;
    private double value;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Transaction(String transactionCode, String clientCode, String productCode, double value, PaymentMethod paymentMethod) {
        this.code = transactionCode;
        this.clientCode = clientCode;
        this.productCode = productCode;
        this.value = value;
        this.paymentMethod = paymentMethod;
        this.date = LocalDateTime.now();
    }

    public Transaction() {
        this.date = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
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
                "transactionCode='" + code + '\'' +
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
