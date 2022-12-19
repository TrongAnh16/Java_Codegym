package view;

import common.FileUtils;
import de.vandermeer.asciitable.AsciiTable;
import model.Product;
import service.ComparatorByPriceASC;
import service.ComparatorByPriceDSC;
import service.ProductService;

import java.util.*;

public class ProductView {
    ProductService productService;

    public ProductView() {
        productService = new ProductService();
    }

    private Scanner sc = new Scanner(System.in);

    public void addProduct() {
        do {
            int productId = inputInt("mã sản phẩm");
            String nameProduct = inputString("sản phẩm");
            float price = inputFloat("giá sản phẩm");
            int quantity = inputInt("số lượng sản phẩm");
            String description = inputString("mô tả sản phẩm");
            System.out.println("Nhập thông tin thành công!");
            productTableView(productId, nameProduct, price, quantity, description);
            productService.addProduct(new Product(productId, nameProduct, price, quantity, description));
            if (!confirmContinue()) break;
        } while (true);
    }

    public void removeProductView() {
        List<Product> listProductData = productService.getAllInfoProducts();
        int removeProduct = inputInt("Id sản phẩm muốn xóa");
        int index = -1;
        for (int i = 1; i < listProductData.size(); i++) {
            if (listProductData.get(i).getId() == removeProduct) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm phù hợp");
            return;
        }
        System.out.println("Sản phẩm bạn muốn xóa là: ");
        productTableView(listProductData.get(index).getId(),
                listProductData.get(index).getName(),
                listProductData.get(index).getPrice(),
                listProductData.get(index).getQuantity(),
                listProductData.get(index).getDescribe());
        System.out.println("Bạn có muốn xóa sản phẩm không?");
        System.out.println("Nhập 1 để tiếp tục.");
        System.out.println("Nhập bất kỳ để thoát. ");
        int select = Integer.parseInt(sc.nextLine());
        switch (select) {
            case 1:
                listProductData.remove(listProductData.get(index));
                FileUtils.writeData(productService.PATH, listProductData,false);
                System.out.println("Danh sách sau khi xóa: ");
                List<Product> listProductDataNew = listProductData;
                showListProduct(listProductDataNew);
                break;
            case 2:
                return;
        }
    }

    public void showListProduct(List<Product> listProductData) {
        AsciiTable tableAll = new AsciiTable();
        tableAll.addRule();
        tableAll.addRow("ID", "Tên sản phẩm", "Giá", "Số lượng", "Mô tả");
        tableAll.addRule();
        for (Product product : listProductData) {
            tableAll.addRow(product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getDescribe()
            );
            tableAll.addRule();
        }
        System.out.println(tableAll.render(100));
    }

    public void productTableView(int productId, String nameProduct, float price, int quantity, String description) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID", "Tên sản phẩm", "Giá", "Số lượng", "Mô tả");
        table.addRule();
        table.addRow(productId, nameProduct, price, quantity, description);
        table.addRule();
        System.out.println(table.render(100));
    }

    public void searchInfoProductMaxPriceView() {
        List<Product> listProductData = productService.getAllInfoProducts();
        float max = 0;
        int maxIndex = 0;
        System.out.println("Sản phẩm có giá cao nhất: ");
        for (int i = 1; i < listProductData.size(); i++) {
            max = listProductData.get(0).getPrice();
            if (listProductData.get(i).getPrice() > max) {
                max = listProductData.get(i).getPrice();
                maxIndex = i;
                break;
            }
        }
        productTableView(listProductData.get(maxIndex).getId(),
                listProductData.get(maxIndex).getName(),
                listProductData.get(maxIndex).getPrice(),
                listProductData.get(maxIndex).getQuantity(),
                listProductData.get(maxIndex).getDescribe());
    }

    private float inputFloat(String name) {
        do {
            System.out.printf("Nhập %s: ", name);
            try {
                return Float.parseFloat(sc.nextLine());
            } catch (Exception e) {
                ShowError.syntax(name);
            }
        } while (true);
    }

    private String inputString(String name) {
        System.out.printf("Nhập tên %s: ", name);
        String nameProduct = sc.nextLine();
        return nameProduct;
    }

    private int inputInt(String name) {
        do {
            System.out.println("Nhập " + name + " :");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                ShowError.syntax(name);
            }
        } while (true);
    }

    public boolean confirmContinue() {
        System.out.println("Nhấn Y để tiếp tục nhập. Nhấn bất kỳ để thoát!");
        String input = sc.nextLine();
        char opt = input.charAt(0);
        switch (opt) {
            case 'Y':
                return true;
            default:
                return false;
        }
    }

    public void showAllProducts() {
        showListProduct(productService.getAllInfoProducts());
    }

    public void updateInfoProduct() {
        int id = inputInt("ID sản phẩm");
        Product product = productService.findProductById(id);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        showListProduct(productList);
        updateMenu();
        int option = inputInt("lựa chọn");
        switch (option) {
            case 1:
                updateProductIdView(product);
                break;
            case 2:
                updateProductNameView(id);
                break;
            case 3:
                updateProductPriceView(id);
                break;
            case 4:
                updateProductQuantityView(id);
                break;
            case 5:
                updateProductDiscription(id);
                break;
        }
    }

    private void updateProductDiscription(int id) {
        Product newProduct = new Product();
        String discription = inputString("mô tả");
        newProduct.setDescribe(discription);
        newProduct.setId(id);
        productService.updateInfoProduct(newProduct);
    }

    private void updateProductQuantityView(int id) {
        Product newProduct = new Product();
        int quantity = inputInt("số lượng");
        newProduct.setQuantity(quantity);
        newProduct.setId(id);
        productService.updateInfoProduct(newProduct);
    }

    private void updateProductPriceView(int id) {
        Product newProduct = new Product();
        float price = inputFloat("giá sản phẩm");
        newProduct.setPrice(price);
        newProduct.setId(id);
        productService.updateInfoProduct(newProduct);
    }

    private void updateProductNameView(int id) {
        Product newProuct = new Product();
        String name = inputString("tên sản phẩm");
        newProuct.setName(name);
        newProuct.setId(id);
        productService.updateInfoProduct(newProuct);
    }

    private void updateProductIdView(Product product) {
        int newId = inputInt("Id mới");
        productService.updateProductId(product, newId);
    }

    private void updateMenu() {
        System.out.println("1. Sửa id sản phẩm: ");
        System.out.println("2. Sửa tên sản phẩm: ");
        System.out.println("3. Sửa giá sản phẩm: ");
        System.out.println("4. Sửa số lượng sản phẩm: ");
        System.out.println("5. Sửa mô tả sản phẩm: ");
    }

    private void sortMenu() {
        System.out.println("Bạn muốn sắp xếp:");
        System.out.println("1. Sắp xếp giá tăng dần");
        System.out.println("2. Sắp xếp giá giảm dần");
        System.out.println("3. Quay về màn hình chính");
    }

    public void sortPriceProductView() {
        boolean menuAction = false;
        do {
            sortMenu();
            int actionMenu = Integer.parseInt(sc.nextLine());
            switch (actionMenu) {
                case 1:
                    sortProductByPriceASCView();
                    break;
                case 2:
                    sortProductByPriceDSCView();
                    break;
                case 3:
                    return;
            }
        } while (menuAction);
    }

    private void sortProductByPriceDSCView() {
        List<Product> listProductData = productService.getAllInfoProducts();
        ComparatorByPriceDSC comparatorByPriceDSC = new ComparatorByPriceDSC();
        Collections.sort(listProductData, comparatorByPriceDSC);
        List<Product> listProductDataNew = listProductData;
        showListProduct(listProductDataNew);
    }

    private void sortProductByPriceASCView() {
        List<Product> listProductData = productService.getAllInfoProducts();
        ComparatorByPriceASC comparatorByPriceASC = new ComparatorByPriceASC();
        Collections.sort(listProductData, comparatorByPriceASC);
        List<Product> listProductDataNew = listProductData;
        showListProduct(listProductDataNew);
    }

    public void showAllProductsWithPage() {
        List<Product> listProductData = productService.getAllInfoProducts();
        int perPage = 5;
        int pages =(int) Math.ceil(listProductData.size()/perPage);
        for (int i = 0; i <= pages; i++) {

            if (i==pages){
                showListProduct(listProductData.subList(i*perPage,listProductData.size()));
                sc.nextLine();
                break;
            }
            showListProduct(listProductData.subList(i*perPage,i*perPage+perPage));
            sc.nextLine();
        }
    }
}
