package ro.bogdan.shopspring.models;

public class Product {
    private String code;
    private String name;
    private String description;
    private int stock;
    private double price;
    private String imageURL;

    public Product() {

    }

    public Product(String code, int stock, String name, String description, double price, String imageURL) {
        this.code = code;
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
    }

    public String getCode() {
        return code;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + code + '\'' +
                ", stock=" + stock +
                ", productName='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

