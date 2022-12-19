package view;

public class ShowError {
    public static void syntax(String name){
        System.out.printf("Nhập %s sai định dạng, vui lòng nhập lại.\n", name);
    }

    public static void outOfRange(String name) {
        System.out.printf("Nhập %s ngoài phạm vi cho phép, vui lòng nhập lại.\n");
    }
}
