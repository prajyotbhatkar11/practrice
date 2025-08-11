package practice.java8.vo;

public class Product {
    private String productName;
    private String category;
    private int price;

    public Product(String productName, String category, int price) {
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
