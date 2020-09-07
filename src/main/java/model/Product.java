package model;

public class Product {
    private int id;
    private int code;
    private String name;
    private String productType;
    private long price;
    private String description;
    private String imageUrl;
    private int amount;

    public Product(int id, int code, String name, String productType, long price, String description, String imageUrl, int amount) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.amount = amount;
    }

    public Product(int code, String name, String productType, long price, String description, String imageUrl, int amount) {
        this.code = code;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.amount = amount;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
