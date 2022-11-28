package main;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private String idProduct;
    private String nameProduct;
    private float price;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, float price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public Product(String idProduct) {
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct.equals(product.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.idProduct.compareTo(o.idProduct);
    }
}

