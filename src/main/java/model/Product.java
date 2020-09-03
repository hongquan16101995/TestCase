package model;

public class Product {
    private int id;
    private String name;
    private String productType;
    private long price;
    private String description;
    private String imageUrl;

    public Product(int id, String name, String productType, long price, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Product(String name, String productType, long price, String description, String imageUrl) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
}
