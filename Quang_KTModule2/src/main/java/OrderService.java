import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private String pathOrder = "D:\\Java_Codegym\\Quang_KTModule2\\src\\main\\java\\order.txt";
    private FileService fileService;
    private OrderItemService orderItemService;

    public OrderService() {
        fileService = new FileService();
        orderItemService = new OrderItemService();
    }

    public void createOrder(Order order) {
        List<Order> orders = getAllOrders();

    }

    private List<Order> getAllOrders() {
        List<String> orderLines = fileService.readData(pathOrder);
        List<Order> orders = new ArrayList<>();
        for (String line : orderLines) {
            String[] items = line.split(",");
            Order order = new Order();
            order.setId(Long.parseLong(items[0]));
            order.setCreateAt(DateUtils.convertStringToDate(items[1]));
            order.setTotal(Double.parseDouble(items[2]));
            List<OrderItem> orderItems = orderItemService.findOrderItemsByOrderId(order.getId());
            order.setOrderItems(orderItems);
            order.add(order);
        }
        return orders;
    }
}
