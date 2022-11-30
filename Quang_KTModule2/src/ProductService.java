import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product findProductById(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct(long id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.updateProduct(product);
            }
        }
    }

    public void removeProduct(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                break;
            }
        }
    }

    public void init() {
        products = new ArrayList<>();
        Product product1 = new Product(System.currentTimeMillis()/(10000*((long)(Math.random()*10))), "Iphone 11", 1000, 10, 1);
        Product product2 = new Product(System.currentTimeMillis()/(10000*((long)(Math.random()*10))), "Mac", 1200, 12, 1);
        Product product3 = new Product(System.currentTimeMillis()/(10000*((long)(Math.random()*10))), "ipod", 1300, 30, 2);
        Product product4 = new Product(System.currentTimeMillis()/(10000*((long)(Math.random()*10))), "OS", 1900, 110, 1);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }

    public ArrayList<Product> searchByName(String name) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}
