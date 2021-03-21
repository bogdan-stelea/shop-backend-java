package ro.bogdan.shopspring.models;

public class TransactionRequest {
    private String productCode;
    private String clientCode;
    private int productQuantity;
    private String paymentMethod;

    TransactionRequest() {
    }

    TransactionRequest(String productCode, String clientCode, int productQuantity, String paymentMethod) {
        this.productCode = productCode;
        this.clientCode = clientCode;
        this.productQuantity = productQuantity;
        this.paymentMethod = paymentMethod;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "productCode='" + productCode + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", productQuantity=" + productQuantity +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
