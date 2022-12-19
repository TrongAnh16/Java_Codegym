package service;

import common.FileUtils;
import de.vandermeer.asciitable.AsciiTable;
import model.Product;
import view.ProductView;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public final String PATH = "data/products.txt";
    ArrayList<Product> productlist = new ArrayList<>();

    public void addProduct(Product newProduct) {
        List<Product> productList = getAllInfoProducts();
        productList.add(newProduct);
        FileUtils.writeData(PATH, productList, false);
    }

        public void removeProduct(int id) {
            List<String> productData = FileUtils.readData(PATH);
            List<Product> productList = getAllInfoProducts();
            for (Product p : productlist) {
                if (p.getId() == id) {
                    productlist.remove(p);
                    FileUtils.writeData(PATH, productList,false);
                    break;
                }
            }
        }

    public List<Product> getAllInfoProducts() {
        List<String> productData = FileUtils.readData(PATH);
        if (productData.get(0).equals("")) return new ArrayList<>();
        List<Product> listProductData = new ArrayList<>();
        for (String item : productData) {
            Product product = Product.parse(item);
            listProductData.add(product);
        }
        return listProductData;
    }


    public void searchInfoProductMaxPrice(ProductView productView) {
        productView.searchInfoProductMaxPriceView();
    }

    public void updateInfoProduct(Product newProduct) {
        List<Product> productList = getAllInfoProducts();
        for (Product p : productList) {
            if (p.getId() == newProduct.getId()) {
                if (newProduct.getName() != null) {
                    p.setName(newProduct.getName());
                }
                if (newProduct.getPrice() != 0) {
                    p.setPrice(newProduct.getPrice());
                }
                if (newProduct.getQuantity() != 0) {
                    p.setQuantity(newProduct.getQuantity());
                }
                if (newProduct.getDescribe() != null) {
                    p.setDescribe(newProduct.getDescribe());
                }
                FileUtils.writeData(PATH,productList,false);
                    break;
            }
        }
    }

    public Product findProductById(int id) {
        for (Product product : getAllInfoProducts()) {
            if (product.getId()== id) return product;
        }
        return null;
    }

    public void updateProductId(Product product, int newId) {
        List<Product> productList = getAllInfoProducts();
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                p.setId(newId);
                FileUtils.writeData(PATH,productList,false);
                return;
            }
        }
    }
}