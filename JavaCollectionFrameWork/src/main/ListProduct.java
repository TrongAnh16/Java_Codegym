package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ListProduct {
    private ArrayList<Product> list;

    public ListProduct() {
        this.list = new ArrayList<Product>();
    }

    public ListProduct(ArrayList<Product> list) {
        this.list = list;
    }

    //1. Add product.
    public void addProduct(Product product) {
        this.list.add(product);
    }

    //2. Change information product by id.
    public boolean changeInformation( String id) {
        for (Product product :
                list) {
            if (product.getIdProduct().equals(id)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter name:");
                String name = sc.nextLine();
                System.out.println("Enter price");
                float price = sc.nextFloat();
                product.setNameProduct(name);
                product.setPrice(price);
                System.out.println(list);
                return true;
            }
        }
        return false;
    }

    //3. Delete product by id.
    public boolean deleteProduct(String id) {
        for (Product product :
                list) {
            if (product.getIdProduct().equals(id)) {
                list.remove(product);
                return true;
            }
        }
        return false;
    }

    //4. Show list product.
    public void showListProduct() {
        for (Product product : list) {
            System.out.println(product);
        }
    }

    //5. Search product by name product.
    public void searchProduct(String nameProduct) {
        for (Product product:list) {
            if (product.getNameProduct().indexOf(nameProduct)>=0) {
                System.out.println(product);
            }
        }
    }

    //6. Sort product ascending, descending by price.
    public void sortProductDescending() {
        Collections.sort(this.list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                }else if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
    }
}
