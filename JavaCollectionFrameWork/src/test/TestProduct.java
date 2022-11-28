package test;

import main.ListProduct;
import main.Product;

import java.util.Scanner;

public class TestProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListProduct listProduct = new ListProduct();
        initialize(listProduct);
        int select = 0;
        do {
            System.out.println("-----MENU-----");
            System.out.println("Please enter your choice: ");
            System.out.println(
                    "1. Add product.\n" +
                    "2. Change information product by id.\n" +
                    "3. Delete product by id.\n" +
                    "4. Show list product.\n" +
                    "5. Search product by name product.\n" +
                    "6. Sort product ascending, descending by price.\n" +
                    "0. Exit.\n"
            );
            select = sc.nextInt();
            sc.nextLine();
            if (select == 1) {
                //1. Add product.
                System.out.println("Enter an idProduct: ");
                String idProduct = sc.nextLine();
                System.out.println("Enter a nameProduct: ");
                String nameProduct = sc.nextLine();
                System.out.println("Enter a price: ");
                float price = sc.nextFloat();
                Product product = new Product(idProduct, nameProduct, price);
                listProduct.addProduct(product);
            } else if (select == 2) {
                //2. Change information product by id.
                System.out.println("Change information product by id:");
                String idProduct = sc.nextLine();
                boolean status = listProduct.changeInformation(idProduct);
                System.out.println(status?"Product is changed successfully":"Product is not found");
            } else if (select == 3) {
                //3. Delete product by id.
                System.out.println("Enter an idProduct: ");
                String idProduct = sc.next();
                System.out.println("Delete a product in list: "+listProduct.deleteProduct(idProduct));
            } else if (select == 4) {
                //4. Show list product.
                listProduct.showListProduct();
            } else if (select == 5) {
                //5. Search product by name product.
                System.out.println("Enter a nameProduct: ");
                String nameProduct = sc.nextLine();
                System.out.println("Search result: ");
                listProduct.searchProduct(nameProduct);
            } else if (select == 6) {
                //6. Sort product ascending, descending by price.
                listProduct.sortProductDescending();
                listProduct.showListProduct();
            }
        } while (select != 0);
    }

    private static void initialize(ListProduct listProduct) {
        listProduct.addProduct(new Product("001", "pen", 10000));
        listProduct.addProduct(new Product("002", "pencil", 20000));
        listProduct.addProduct(new Product("003", "notebook", 30000));
        listProduct.addProduct(new Product("004", "book", 50000));
        listProduct.addProduct(new Product("005", "ruler", 5000));
    }
}
