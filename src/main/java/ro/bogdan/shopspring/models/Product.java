package ro.bogdan.shopspring.models;

public class Product {
    private String productCode;
    private int stock;
    private String productName;
    private String description;
    private int price;

    public Product() {

    }

    public Product(String productCode, int stock, String productName, String description, int price) {
        this.productCode = productCode;
        this.stock = stock;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getStock() {
        return stock;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", stock=" + stock +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

