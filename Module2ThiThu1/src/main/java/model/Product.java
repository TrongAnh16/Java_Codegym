package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int quantity;
    private String describe;

    public Product() {
    }

    public Product(int id, String name, float price, int quantity, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public static Product parse(String item){
        String[] line = item.split(",");
        int productId = Integer.parseInt(line[0]);
        String nameProduct = line[1];
        float price = Float.parseFloat(line[2]);
        int quantity = Integer.parseInt(line[3]);
        String describe = line[4];
        return new Product(productId, nameProduct, price, quantity, describe);
    }

    @Override
    public String toString() {
        //423,Kẹo,32333.0,3,Kẹo ngọt
        return String.format("%s,%s,%s,%s,%s", id, name, price, quantity, describe);
    }
}
