import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private Date createAt;
    private double total;
    private List<OrderItem> orderItems;

    public void addOderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public Order(long id, Date createAt, double total, List<OrderItem> orderItems) {
        this.id = id;
        this.createAt = createAt;
        this.total = total;
        this.orderItems = orderItems;
    }

    public Order() {
        orderItems = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
