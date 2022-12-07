
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppMain {
    public static final int ACTIONADD = 1;
    public static final int ACTIONEDIT = 2;

    private CategoryService categoryService;
    private ProductService productService;

    public AppMain() {
        productService = new ProductService();
        productService.init();
        categoryService = new CategoryService();
        categoryService.init();
    }

    private static Scanner sc = new Scanner(System.in);

    public void addProductView() {
        System.out.println("Nhap ten: ");
        String name = sc.nextLine();

        System.out.println("Nhap gia: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.println("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap ID cua danh muc: ");
        for (int i = 0; i < categoryService.getCategories().size(); i++) {
            System.out.println(categoryService.getCategories().get(i));
        }
        int idCategory = Integer.parseInt(sc.nextLine());

        Product product = new Product();
        product.setId(System.currentTimeMillis() / (long) (10000*Math.random()*10));
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setIdCategory(idCategory);

        productService.addProduct(product);
        showProductsView(productService.getProducts());
    }

    public double inputPrice(ActionInput type) {
        double price = 0.0;
        boolean checkInputPrice = false;
        do {
            switch (type) {
                case ADD:
                    System.out.println("Nhap gia ban muon them: ");
                    break;
                case EDIT:
                    System.out.println("Nhap gia ban muon sua: ");
                    break;
            }
            price = Double.parseDouble(sc.nextLine());
            checkInputPrice = false;
            if (price < 0 || price > 10000000) {
                System.out.println("Gia phai lon hon 0 va nho hon 10000000");
                checkInputPrice = true;
            }
        } while (checkInputPrice);
        return price;
    }

    public String inputName(ActionInput type) {
        String name = "";
        boolean checkInputName = false;
        do {
            switch (type) {
                case ADD:
                    System.out.println("Nhap ten ban muon them: ");
                    break;
                case EDIT:
                    System.out.println("Nhap ten ban muon sua: ");
                    break;
            }
            name = sc.nextLine();
        } while (checkInputName);
        return name;
    }

    public int inputQuantity(ActionInput type) {
        int quantity = 0;
        boolean checkInputQuantity = false;
        do {
            switch (type) {
                case ADD:
                    System.out.println("Nhap so luong ban muon them: ");
                    break;
                case EDIT:
                    System.out.println("Nhap so luong ban muon sua: ");
                    break;
            }
            quantity = Integer.parseInt(sc.nextLine());
            checkInputQuantity = false;
            if (quantity < 0 || quantity > 1000) {
                checkInputQuantity = true;
            }
        } while (checkInputQuantity);
        return quantity;
    }

    public void editProductView() {
        System.out.println("Nhap ID san pham: ");
        long id = Long.parseLong(sc.nextLine());
        Product result = productService.findProductById(id);
        if (result==null) {
            System.out.println("ID sai");
            return;
        }
        boolean checkEditMenu = false;
        do {
            System.out.println("Ban muon sua: ");
            System.out.println("1. Sua ten");
            System.out.println("2. Sua gia");
            System.out.println("3. Sua so luong");
            int menuEdit = Integer.parseInt(sc.nextLine());
            switch (menuEdit) {
                case 1:
                    String name = inputName(ActionInput.EDIT);
                    result.setName(name);
                    showProductsView(productService.getProducts());
                    break;
                case 2:
                    double price = inputPrice(ActionInput.EDIT);
                    for (Product p : productService.getProducts()) {
                        if (p.getId() == id) {
                            p.setPrice(price);
                        }
                    }
                    showProductsView(productService.getProducts());
                    break;
                case 3:
                    int quantity = inputQuantity(ActionInput.EDIT);
                    result.setQuantity(quantity);
                    showProductsView(productService.getProducts());
                    break;
            }
        } while (checkEditMenu);
    }

    public void removeProductView() {
        System.out.println("Nhap ID ban muon xoa: ");
        long id = Long.parseLong(sc.nextLine());
        productService.removeProduct(id);
    }

    public void showProductsView(List<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private void sortProductView() {
        boolean menuAction = false;
        do {
            System.out.println("Ban sap xep theo:");
            System.out.println("1. Sap xep theo gia");
            System.out.println("2. Sap xep theo ten");
            System.out.println("3. Sap xep theo so luong");
            int actionMenu = Integer.parseInt(sc.nextLine());
            switch (actionMenu) {
                case 1:
                    sortProductViewByPrice();
                    break;
                case 2:
                    sortProductViewByName();
                    break;
                case 3:
                    sortProductViewByQuantity();
                    break;
            }
        } while (menuAction);
    }

    private void sortProductViewByQuantity() {
        int select = 0;
        boolean actionSort = false;
        do {
            System.out.println("Sap xep theo so luong: ");
            System.out.println("1. Sap xep tang dan: ");
            System.out.println("2. Sap xep giam dan: ");
            actionSort = false;
            select = Integer.parseInt(sc.nextLine());
            switch (select) {
                case 1:
                    ComparatorByQuantityASC comparatorByQuantityASC = new ComparatorByQuantityASC();
                    Collections.sort(productService.getProducts(), comparatorByQuantityASC);
                    break;
                case 2:
                    ComparatorByQuantityDSC comparatorByQuantityDSC = new ComparatorByQuantityDSC();
                    Collections.sort(productService.getProducts(), comparatorByQuantityDSC);
                    break;
                default:
                    System.out.println("Nhap sai lua chon. Vui long nhap lai");
                    actionSort = true;
            }
        } while (actionSort);
    }

    private void sortProductViewByName() {
        int select = 0;
        boolean actionSort = false;
        do {
            System.out.println("Sap xep theo ten: ");
            System.out.println("1. Sap xep theo A den Z: ");
            System.out.println("2. Sap xep theo Z den A: ");
            actionSort = false;
            select = Integer.parseInt(sc.nextLine());
            switch (select) {
                case 1:
                    ComparatorByNameAtoZ comparatorByNameAtoZ = new ComparatorByNameAtoZ();
                    Collections.sort(productService.getProducts(), comparatorByNameAtoZ);
                    break;
                case 2:
                    ComparatorByNameZtoA comparatorByNameZtoA = new ComparatorByNameZtoA();
                    Collections.sort(productService.getProducts(), comparatorByNameZtoA);
                    break;
                default:
                    System.out.println("Nhap lua chon sai. Vui long nhap lai");
                    actionSort = true;
            }
        } while (actionSort);
    }

    private void sortProductViewByPrice() {
        int select = 0;
        boolean actionSort = false;
        do {
            System.out.println("Sap xep theo gia: ");
            System.out.println("1. Sap xep tang dan");
            System.out.println("2. Sap xep giam dan");
            actionSort = false;
            select = Integer.parseInt(sc.nextLine());
            switch (select) {
                case 1:
                    ComparatorByPriceASC comparatorByPriceASC = new ComparatorByPriceASC();
                    Collections.sort(productService.getProducts(), comparatorByPriceASC);
                    break;
                case 2:
                    ComparatorByPriceDSC comparatorByPriceDSC = new ComparatorByPriceDSC();
                    Collections.sort(productService.getProducts(), comparatorByPriceDSC);
                    break;
                default:
                    System.out.println("Nhap lua chon sai. Vui long nhap lai");
                    actionSort = true;
            }
        } while (actionSort);
    }

    private ArrayList<Product> searchViewByName() {
        System.out.println("Nhap ten can tim:");
        String name = sc.nextLine();
        ArrayList<Product> result = productService.searchByName(name);
        return result;

    }

    public boolean checkContinueAction() {
        System.out.println("Ban co muon tiep tuc khong?");
        System.out.println("Nhap Y de tiep tuc");
        System.out.println("Nhap bat ky de thoat");
        String continueAction = sc.nextLine();
        switch (continueAction) {
            case "Y":
                return true;
            case "N":
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        AppMain appMain = new AppMain();
        boolean checkMenuAction = false;
        do {
            System.out.println("Ban hay chon chuc nang: ");
            System.out.println("1. Them san pham");
            System.out.println("2. Sua san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Xem danh sach san pham");
            System.out.println("5. Sap xep san pham");
            System.out.println("6. Tim kiem san pham");
            int menuAction = Integer.parseInt(sc.nextLine());
            switch (menuAction) {
                case 1:
                    appMain.addProductView();
                    break;
                case 2:
                    appMain.showProductsView(appMain.productService.getProducts());
                    appMain.editProductView();
                    break;
                case 3:
                    appMain.showProductsView(appMain.productService.getProducts());
                    appMain.removeProductView();
                    break;
                case 4:
                    appMain.showProductsView(appMain.productService.getProducts());
                    break;
                case 5:
                    appMain.sortProductView();
                    appMain.showProductsView(appMain.productService.getProducts());
                    break;
                case 6:
                    appMain.showProductsView(appMain.searchViewByName());
                    break;
            }
            checkMenuAction = appMain.checkContinueAction();
        } while (checkMenuAction);
    }
}