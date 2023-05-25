package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public Order(Date moment, OrderStatus status, List<OrderItem> items) {
        this.moment = moment;
        this.status = status;
        items = new ArrayList<>();
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItem() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }
}
